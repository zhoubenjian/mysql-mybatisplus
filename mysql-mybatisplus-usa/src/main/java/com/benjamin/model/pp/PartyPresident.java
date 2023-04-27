package com.benjamin.model.pp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@ApiModel(value="PartyPresident对象", description="PartyPresident对象")
public class PartyPresident {

    @ApiModelProperty(value = "政党名称")
    private String partyName;

    @ApiModelProperty(value = "总统")
    private List<President> presidents;
}


