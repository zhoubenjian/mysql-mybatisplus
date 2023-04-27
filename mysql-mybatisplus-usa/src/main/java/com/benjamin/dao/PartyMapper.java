package com.benjamin.dao;

import com.benjamin.entities.Party;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.benjamin.model.pp.PartyPresident;

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
     *
     * @return
     */
    List<Party> queryExistParty();

    /**
     * 政党对应总统（一对多）
     *
     * @return
     */
    List<PartyPresident> queryPartyWithPresident();
}
