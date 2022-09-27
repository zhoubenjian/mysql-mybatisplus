package com.benjamin.converter;

import com.benjamin.vo.StateVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ApiConverter {

    /**
     * State => StateVo
     * @param state
     * @return
     */
//    StateVo stateToStateVo(State state);
//    List<StateVo> stateListToStateVoList(List<State> list);
}
