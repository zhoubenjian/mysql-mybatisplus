package com.benjamin.controller;

import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SignRecordService;
import com.benjamin.vo.SignVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 签到记录表 前端控制器
 * </p>
 *
 * @author benjamin
 * @since 2022-12-05
 */
@RestController
@RequestMapping("/sign")
public class SignRecordController {

    @Autowired
    private SignRecordService signRecordService;



    /**
     * 签到/签退
     * @param presidentId
     * @return
     */
    @PostMapping("{presidentId}")
    @ApiOperation("签到/签退")
    public ResponseWithEntities<SignVo> sign(@PathVariable("presidentId") Long presidentId) {
        return signRecordService.sign(presidentId);
    }

    /**
     * 模糊匹配路由获取参数
     *
     * @param id
     * @param request
     * @return
     */
    @PostMapping("/{id}/**")
    public String getHttpRouteAndParams(@PathVariable("id") Long id,
                                        HttpServletRequest request) {

        String url = request.getRequestURL().toString();
//        String contentType = request.getContentType();
//
//        System.out.println(url);
//        System.out.println(contentType);

        // 返回参数
        Map<String, Object> params = new HashMap<>();

        // 获取内容格式
        String contentType = request.getContentType();
        if (contentType != null && !contentType.equals("")) {
            contentType = contentType.split(";")[0];
        }

        // form-data    表单形式可以从 ParameterMap中获取
        if (contentType.startsWith("multipart/form-data")) {
            // 获取参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap != null) {
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    params.put(entry.getKey(), entry.getValue()[0]);
                }
            }
        }

        // form表单格式     表单形式可以从 ParameterMap中获取
        if ("application/x-www-form-urlencoded".equalsIgnoreCase(contentType)) {
            // 获取参数
            Map<String, String[]> parameterMap = request.getParameterMap();
            if (parameterMap != null) {
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    params.put(entry.getKey(), entry.getValue()[0]);
                }
            }
        }

        System.out.println(url);
        for (Map.Entry<String, Object> m : params.entrySet()) {
            System.out.println(m);
        }
        return url;
    }
}

