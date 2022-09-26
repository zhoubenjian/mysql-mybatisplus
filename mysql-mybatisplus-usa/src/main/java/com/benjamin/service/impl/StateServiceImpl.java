package com.benjamin.service.impl;

import com.benjamin.converter.ApiConverter;
import com.benjamin.entities.State;
import com.benjamin.dao.StateMapper;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.StateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.benjamin.vo.StateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 州 服务实现类
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
@Service
public class StateServiceImpl extends ServiceImpl<StateMapper, State> implements StateService {

    @Autowired
    private StateMapper stateMapper;

    @Autowired
    private ApiConverter apiConverter;



    /**
     * 查询所有州（不分页）
     * @return
     */
    @Override
    public ResponseWithEntities<List<StateVo>> queryAllState() {
        List<State> stateList = stateMapper.selectList(null);
        // State => StateVo
        List<StateVo> list = apiConverter.stateListToStateVoList(stateList);
        return new ResponseWithEntities<List<StateVo>>().setData(list);
    }
}
