package com.benjamin.converter;

import com.benjamin.entities.*;
import com.benjamin.vo.*;
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
    StateVo stateToStateVo(State state);
    List<StateVo> stateListToStateVoList(List<State> list);

    /**
     * StatePresident => StatePresidentVo
     * @param statePresident
     * @return
     */
    @Mapping(target = "presidentVos", source = "statePresident.presidents")
    StatePresidentVo statePresident2StatePresidentVo(StatePresident statePresident);
    List<StatePresidentVo> statePresidentList2StatePresidentVoList(List<StatePresident> list);



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
    @Mapping(target = "age", ignore = true)
    PresidentVo president2PresidentVo(President president);
    List<PresidentVo> presidentList2PresidentVoList(List<President> list);

    /**
     * PresidentState => PresidentStateVo
     * @param presidentState
     * @return
     */
    @Mapping(target = "stateVo", source = "presidentState.state")
    PresidentStateVo presidentState2PresidentStateVo(PresidentState presidentState);
    List<PresidentStateVo> presidentState2PresidentStateVoList(List<PresidentState> list);
}
