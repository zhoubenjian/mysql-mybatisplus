package com.benjamin.service;

import com.benjamin.entities.SignRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.SignVo;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * 签到记录表 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-12-05
 */
public interface SignRecordService extends IService<SignRecord> {

    /**
     * 签到/签退
     * @param presidentId
     * @return
     */
    ResponseWithEntities<SignVo> sign(Long presidentId);
}
