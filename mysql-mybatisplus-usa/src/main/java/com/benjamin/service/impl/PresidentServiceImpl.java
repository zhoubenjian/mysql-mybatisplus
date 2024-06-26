package com.benjamin.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.constant.RedisKeyConstant;
import com.benjamin.converter.UsaConverter;
import com.benjamin.dao.PresidentMapper;
import com.benjamin.entities.President;
import com.benjamin.entities.PresidentState;
import com.benjamin.office.excel.ExcelHeaderRegistry;
import com.benjamin.office.excel.ExcelOutputFactory;
import com.benjamin.office.excel.ExcelOutputService;
import com.benjamin.request.BasePageRequest;
import com.benjamin.response.ResponseWithCollection;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.PresidentService;
import com.benjamin.vo.PresidentStateVo;
import com.benjamin.vo.PresidentVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.*;

/**
 * <p>
 * 总统 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-06
 */
@Service
public class PresidentServiceImpl extends ServiceImpl<PresidentMapper, President> implements PresidentService {

    @Autowired
    private PresidentMapper presidentMapper;

    @Autowired
    private ExcelOutputFactory excelOutputFactory;

    @Autowired
    private ExcelHeaderRegistry excelHeaderRegistry;

    @Autowired
    private UsaConverter usaConverter;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;



    private static final String allPresidentKey = "allPresident";

    private static final String donaldTrumpKey = "donaldTrump";



    /**
     * 所有总统
     *
     * @return
     */
    @Override
    public ResponseWithEntities<List<PresidentVo>> queryAllPresident() {

        String key = RedisKeyConstant.getAllPresidentInfo(allPresidentKey);
        Boolean hasKey = redisTemplate.hasKey(key);
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        List<PresidentVo> presidentVoList = new ArrayList<>();
        if (hasKey != null && hasKey) {

            // redis读取
            presidentVoList = (List<PresidentVo>) opsForValue.get(key);

        } else {

            // 数据库查询
            List<President> presidentList = Optional.ofNullable(presidentMapper.selectList(null)).orElse(new ArrayList<>());
            // President => PresidentVo
            presidentVoList = usaConverter.presidentList2PresidentVoList(presidentList);

            // 计算年龄
            LocalDate now = LocalDate.now();
            presidentVoList.stream().forEach(p -> p.setAge(p.getBirthday().until(now).getYears()));

            // 写入redis
            opsForValue.set(key, presidentVoList);
            // 一天后过期
            redisTemplate.expireAt(key, DateUtils.addDays(new Date(), 1));
        }

        return new ResponseWithEntities<List<PresidentVo>>().setData(presidentVoList);
    }

    /**
     * Donald Trump
     *
     * @return
     */
    @Override
    public ResponseWithEntities<PresidentVo> queryOnePresident() {

        String key = RedisKeyConstant.getDonaldTrumpInfo(donaldTrumpKey);
        Boolean hasKey = redisTemplate.hasKey(key);
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();

        PresidentVo presidentVo = new PresidentVo();
        List<PresidentVo> tempList = new ArrayList<>();
        if (hasKey != null && hasKey) {

            // redis读取
            tempList = (List<PresidentVo>) opsForValue.get(key);
            /*** 解决java.util.LinkedHashMap cannot be cast to 的问题，解决方案：就是将list再次转为json串，然后由json串再转为list ***/
            String tempString = JSON.toJSONString(tempList);
            tempList = JSON.parseArray(tempString, PresidentVo.class);
            /*** 解决java.util.LinkedHashMap cannot be cast to 的问题，解决方案：就是将list再次转为json串，然后由json串再转为list ***/
            presidentVo = tempList.get(0);

        } else {

            // 数据库查询
            President result = presidentMapper.queryOnePresident("Donald Trump");
            if (result != null) {

                // President => PresidentVo
                presidentVo = usaConverter.president2PresidentVo(result);
                // 计算年龄
                LocalDate now = LocalDate.now();
                presidentVo.setAge(presidentVo.getBirthday().until(now).getYears());

                // 添加
                tempList.add(presidentVo);

                // 写入redis
                opsForValue.set(key, tempList);
                // 一小时后过期
                redisTemplate.expireAt(key, DateUtils.addHours(new Date(), 1));
            }
        }

        return new ResponseWithEntities<PresidentVo>().setData(presidentVo);
    }

    /**
     * 在世总统
     *
     * @return
     */
    @Override
    public ResponseWithEntities<List<PresidentVo>> queryAlivePresident() {
        List<President> presidentList = Optional.of(presidentMapper.queryAlivePresident()).orElse(Collections.EMPTY_LIST);

        // President => PresidentVo
        List<PresidentVo> presidentVoList = usaConverter.presidentList2PresidentVoList(presidentList);
        // 当前年份
        LocalDate now = LocalDate.now();
        // 计算年龄
        presidentVoList.stream().forEach(p -> p.setAge(p.getBirthday().until(now).getYears()));
        return new ResponseWithEntities<List<PresidentVo>>().setData(presidentVoList);
    }

    /**
     * 出生日期查询
     *
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public ResponseWithEntities<List<PresidentVo>>  queryPresidentByBirthDate(String startTime, String endTime) {
        List<President> presidentList = presidentMapper.queryPresidentByBirthDate(startTime, endTime);

        // President => PresidentVo
        List<PresidentVo> presidentVoList = usaConverter.presidentList2PresidentVoList(presidentList);
        // 当前年份
        LocalDate now = LocalDate.now();
        // 计算年龄
        presidentVoList.stream().forEach(p -> p.setAge(p.getBirthday().until(now).getYears()));
        return new ResponseWithEntities<List<PresidentVo>>().setData(presidentVoList);
    }

    /**
     * 总统对应的州(一对一)
     *
     * @param basePageRequest
     * @return
     */
    @Override
    public ResponseWithCollection<PresidentStateVo> queryPresidentWithState(BasePageRequest basePageRequest) {
        Page page = PageHelper.startPage((int) basePageRequest.getPage(), (int) basePageRequest.getPageSize());
        List<PresidentState> presidentStateList = Optional.ofNullable(presidentMapper.queryPresidentWithState())
                .orElse(Collections.EMPTY_LIST);

        // PresidentState => PresidentStateVo
        List<PresidentStateVo> presidentStateVoList = usaConverter.presidentState2PresidentStateVoList(presidentStateList);
        return ResponseWithCollection.buildResponse(basePageRequest, presidentStateVoList, page.getTotal());
    }

    /**
     * 导出总统（流式）
     *
     * @param key
     * @return
     */
    @Override
    public void exportPresidentBySteam(HttpServletResponse response, String key) {

        String sheetName = "president.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.addHeader("Content-Disposition", "attachment;filename=" + sheetName);

        try {

            ExcelOutputService service = excelOutputFactory.createOutput(response.getOutputStream());
            service.createSxSheetOutput(PresidentVo.class, p -> {
                presidentMapper.exportPresidentBySteam(key, (resultContext) -> {

                    President president = resultContext.getResultObject();
                    PresidentVo presidentVo = usaConverter.president2PresidentVo(president);
                    // 导出
                    p.provide(presidentVo);
                });
            });

            // 执行write时，上方回调真正开始执行
            service.write();

        } catch (Exception e) {
            log.error("导出错误", e);
        }
    }
}
