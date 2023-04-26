package com.benjamin.service;

import com.benjamin.entities.Party;
import com.baomidou.mybatisplus.extension.service.IService;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.PartyVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 政党 服务类
 * </p>
 *
 * @author benjamin
 * @since 2022-10-01
 */
public interface PartyService extends IService<Party> {

    /**
     * 现存政党
     *
     * @return
     */
    ResponseWithEntities<List<PartyVo>> queryExistParty();

    /**
     * 表单提交
     *
     * @param file
     * @param files
     * @return
     */
    boolean create(MultipartFile file, MultipartFile[] files);
}
