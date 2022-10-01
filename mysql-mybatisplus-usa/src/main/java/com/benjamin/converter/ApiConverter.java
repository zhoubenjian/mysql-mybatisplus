package com.benjamin.converter;

import com.benjamin.entities.Party;
import com.benjamin.entities.State;
import com.benjamin.vo.PartyVo;
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
    StateVo stateToStateVo(State state);
    List<StateVo> stateListToStateVoList(List<State> list);


    /**
     * Party => PartyVo
     * @param party
     * @return
     */
    PartyVo PartyToPartyVo(Party party);
    List<PartyVo> PartyListToPartyVoList(List<Party> list);
}
