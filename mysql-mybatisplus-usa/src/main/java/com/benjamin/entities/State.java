package com.benjamin.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 州
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
@ApiModel(value="State对象", description="州")
public class State implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "州名")
    private String state_name;

    @ApiModelProperty(value = "首府")
    private String state_capital;

    @ApiModelProperty(value = "州长")
    private String governor;

    @ApiModelProperty(value = "党派，0：摇摆州")
    private Long party_id;

    @ApiModelProperty(value = "缩写")
    private String abbreviation;

    @ApiModelProperty(value = "经济排名")
    private Integer rank;

    @ApiModelProperty(value = "开始日期")
    private Date start_time;

    @ApiModelProperty(value = "结束日期")
    private Date end_time;

    @ApiModelProperty(value = "独立倾向, 0:不独立；1:独立")
    private Integer status;

    @ApiModelProperty(value = "代表人数")
    private Integer number_of_reps;

    @ApiModelProperty(value = "创建时间")
    private Date create_time;

    @ApiModelProperty(value = "修改时间")
    private Date update_time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_capital() {
        return state_capital;
    }

    public void setState_capital(String state_capital) {
        this.state_capital = state_capital;
    }

    public String getGovernor() {
        return governor;
    }

    public void setGovernor(String governor) {
        this.governor = governor;
    }

    public Long getParty_id() {
        return party_id;
    }

    public void setParty_id(Long party_id) {
        this.party_id = party_id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNumber_of_reps() {
        return number_of_reps;
    }

    public void setNumber_of_reps(Integer number_of_reps) {
        this.number_of_reps = number_of_reps;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "State{" +
        "id=" + id +
        ", state_name=" + state_name +
        ", state_capital=" + state_capital +
        ", governor=" + governor +
        ", party_id=" + party_id +
        ", abbreviation=" + abbreviation +
        ", rank=" + rank +
        ", start_time=" + start_time +
        ", end_time=" + end_time +
        ", status=" + status +
        ", number_of_reps=" + number_of_reps +
        ", create_time=" + create_time +
        ", update_time=" + update_time +
        "}";
    }
}
