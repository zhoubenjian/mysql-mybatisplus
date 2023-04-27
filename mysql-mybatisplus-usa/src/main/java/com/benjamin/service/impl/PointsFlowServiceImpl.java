package com.benjamin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.dao.PointsFlowMapper;
import com.benjamin.dao.PresidentMapper;
import com.benjamin.dao.SignRecordMapper;
import com.benjamin.entities.PointsFlow;
import com.benjamin.entities.President;
import com.benjamin.entities.SignRecord;
import com.benjamin.service.PointsFlowService;
import com.benjamin.date.DateToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 积分流水表 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-12-05
 */
@Slf4j
@Service
public class PointsFlowServiceImpl extends ServiceImpl<PointsFlowMapper, PointsFlow> implements PointsFlowService {

    @Autowired
    private SignRecordMapper signRecordMapper;

    @Autowired
    private PointsFlowMapper pointsFlowMapper;

    @Autowired
    private PresidentMapper presidentMapper;



    /**
     * 昨日积分
     */
    @Override
    public void calculateYesterdayPoints() {

        // 昨天日期
        String yesterday = DateToolUtil.getYesterday();
        QueryWrapper<SignRecord> qw1 = new QueryWrapper<>();
        // 时间格式右模糊匹配
        qw1.eq("enable", 1).likeRight("create_time", yesterday);
        // 所有签到/签退记录
        List<SignRecord> signRecordList = Optional.of(signRecordMapper.selectList(qw1)).orElse(Collections.emptyList());

        // 签到List
        List<SignRecord> signInList = signRecordList.stream().filter(sr -> sr.getStatus().equals(1)).collect(Collectors.toList());
        // 签退List
        List<SignRecord> signOutList = signRecordList.stream().filter(sr -> sr.getStatus().equals(2)).collect(Collectors.toList());

        for (SignRecord in : signInList) {
            for (SignRecord out : signOutList) {
                if (in.getPresidentId().equals(out.getPresidentId())) {
                    // 签到分钟差
                    long minute = DateToolUtil.diffDate(in.getCreateTime(), out.getUpdateTime(), DateToolUtil.MINUTE);

                    // 查询所在政党，州信息
                    QueryWrapper<President> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("id", in.getPresidentId());
                    President president = presidentMapper.selectOne(queryWrapper);
                    PointsFlow pointsFlow = new PointsFlow()
                            .setPresidentId(president.getId())
                            .setPartyId(president.getPartyId())
                            .setStateId(president.getStateId())
                            .setPartyId(president.getPartyId())
                            .setPoints(minute)
                            .setType(1);

                    // 写入
                    pointsFlowMapper.insert(pointsFlow);
                    log.info("总统id：" + president.getId() + "，" + yesterday + "获取积分：" + minute);
                }
            }
        }
    }
}
