package com.benjamin.dao;

import com.benjamin.entities.Party;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 政党 Mapper 接口
 * </p>
 *
 * @author benjamin
 * @since 2022-10-01
 */
public interface PartyMapper extends BaseMapper<Party> {

    /**
     * 现存政党
     * @return
     */
    List<Party> queryExistParty();
}
