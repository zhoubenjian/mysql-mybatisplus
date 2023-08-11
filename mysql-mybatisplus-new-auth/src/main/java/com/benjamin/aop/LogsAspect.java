package com.benjamin.aop;

import com.alibaba.fastjson.JSON;
import com.benjamin.annotation.Logs;
import com.benjamin.dao.SysLogMapper;
import com.benjamin.entities.SysLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 参考链接：https://blog.csdn.net/wujiangbo520/article/details/122057616
 */
@Aspect
@Component
public class LogsAspect {

    @Autowired
    private SysLogMapper sysLogMapper;



    /**
     * 注解处切入
     */
    @Pointcut("@annotation(com.benjamin.annotation.Logs)")
    public void logsPointCut() {
    }

    /**
     * 正常返回通知，拦截用户操作日志，连接点正常执行完成后执行， 如果连接点抛出异常，则不会执行
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "logsPointCut()", returning = "result")
    public void createLog(JoinPoint joinPoint, Object result) {

        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        try {

            SysLog sysLog = new SysLog();

            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            Logs logs = method.getAnnotation(Logs.class);
            if (logs != null)
                sysLog.setModuleName(logs.module());

            // 将入参转换成json
            String requestParams = argsArrayToString(joinPoint.getArgs());

            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName + "()";

            sysLog.setMethodName(methodName).setRequestMethod(request.getMethod())
                    .setRequestParam(requestParams).setIp(getIp(request))
                    .setIpLocation(null).setUserName(null);

            // 写入
            sysLogMapper.insert(sysLog);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 参数拼装
     *
     * @param paramsArray
     * @return
     */
    private String argsArrayToString(Object[] paramsArray)
    {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0)
        {
            for (Object o : paramsArray)
            {
                if (o != null)
                {
                    try
                    {
                        Object jsonObj = JSON.toJSON(o);
                        params += jsonObj.toString() + " ";
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        return params.trim();
    }

    /**
     * 根据HttpServletRequest获取访问者的IP地址
     *
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
