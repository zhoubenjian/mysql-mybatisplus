package com.benjamin.converter;

import com.benjamin.entities.Party;
import com.benjamin.entities.President;
import com.benjamin.entities.State;
import com.benjamin.vo.PartyVo;
import com.benjamin.vo.PresidentVo;
import com.benjamin.vo.StateVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ApiConverter {

    /**
     * State => StateVo
     * @param state
     * @return
     */
    @Mapping(target = "presidentVos", source = "state.presidents")
    StateVo stateToStateVo(State state);
    List<StateVo> stateListToStateVoList(List<State> list);


    /**
     * Party => PartyVo
     * @param party
     * @return
     */
    PartyVo partyToPartyVo(Party party);
    List<PartyVo> partyListToPartyVoList(List<Party> list);


    /**
     * President => PresidentVo
     * @param president
     * @return
     */
    @Mapping(target = "stateVo", source = "president.state")
    @Mapping(target = "age", ignore = true)
    PresidentVo president2PresidentVo(President president);
    List<PresidentVo> presidentList2PresidentVoList(List<President> list);
}
