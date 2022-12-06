package com.benjamin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.benjamin.constant.SignEnum;
import com.benjamin.dao.PresidentMapper;
import com.benjamin.entities.President;
import com.benjamin.entities.SignRecord;
import com.benjamin.dao.SignRecordMapper;
import com.benjamin.error.SystemErrors;
import com.benjamin.exception.WebException;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.SignRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.util.DateToolUtil;
import com.benjamin.vo.SignVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 签到记录表 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-12-05
 */
@Service
public class SignRecordServiceImpl extends ServiceImpl<SignRecordMapper, SignRecord> implements SignRecordService {

    @Autowired
    private PresidentMapper presidentMapper;

    @Autowired
    private SignRecordMapper signRecordMapper;



    /**
     * 签到/签退
     * @param presidentId
     * @return
     */
    @Override
    public ResponseWithEntities<SignVo> sign(Long presidentId) {

        // 总统是否健在
        QueryWrapper<President> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", presidentId).eq("is_alive", 1);
        President president = presidentMapper.selectOne(queryWrapper);
        if (president == null) {
            throw new WebException(SystemErrors.PRESIDENT_NOT_ALIVE);
        }

        // 当天日期
        String today = DateToolUtil.getDateStr(DateToolUtil.YYYY_MM_DD);
        QueryWrapper<SignRecord> qw1 = new QueryWrapper<>();
        qw1.eq("president_id", presidentId).eq("status", SignEnum.SIGN_IN.getCode())
                .eq("enable", 1).likeRight("create_time", today);
        SignRecord sg1 = signRecordMapper.selectOne(qw1);
        if (sg1 == null) {

            // 签到
            SignRecord signRecord = new SignRecord()
                    .setPresidentId(presidentId)
                    .setStatus(SignEnum.SIGN_IN.getCode());
            // 插入当天签到记录
            signRecordMapper.insert(signRecord);
            SignVo signVo = new SignVo().setPresidentId(presidentId).setDesc("签到成功");
            return new ResponseWithEntities<SignVo>().setData(signVo);
        }

        QueryWrapper<SignRecord> qw2 = new QueryWrapper<>();
        qw2.eq("president_id", presidentId).eq("status", SignEnum.SIGN_OUT.getCode())
                .eq("enable", 1).likeRight("create_time", today);
        SignRecord sg2 = signRecordMapper.selectOne(qw2);
        if (sg1 != null && sg2 == null) {

            // 签退
            SignRecord signRecord = new SignRecord()
                    .setPresidentId(presidentId)
                    .setStatus(SignEnum.SIGN_OUT.getCode());
            // 插入当天签到记录
            signRecordMapper.insert(signRecord);
            SignVo signVo = new SignVo().setPresidentId(presidentId).setDesc("签退成功");
            return new ResponseWithEntities<SignVo>().setData(signVo);

        } else {

            // 更新签退
            UpdateWrapper<SignRecord> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", sg2.getId());
            // 当前时间
            Date now = DateToolUtil.getDate();
            SignRecord signRecord = new SignRecord().setUpdateTime(now);
            // 更新当天签退记录
            signRecordMapper.update(signRecord, updateWrapper);
            SignVo signVo = new SignVo().setPresidentId(presidentId).setDesc("更新签退成功");
            return new ResponseWithEntities<SignVo>().setData(signVo);
        }
    }
}
