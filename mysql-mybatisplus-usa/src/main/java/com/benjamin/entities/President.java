package com.benjamin.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 总统
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
@ApiModel(value="President对象", description="总统")
public class President implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String president_name;

    @ApiModelProperty(value = "性别,0:女；1:男")
    private Integer gender;

    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "出生地")
    private String birth_place;

    @ApiModelProperty(value = "逝世日期")
    private Date deathday;

    @ApiModelProperty(value = "逝世地")
    private String location_of_death;

    @ApiModelProperty(value = "是否在世, 0:去世；1:在世")
    private Integer is_alive;

    @ApiModelProperty(value = "届数")
    private String term_of_office;

    @ApiModelProperty(value = "任期开始日期")
    private Date term_start_time;

    @ApiModelProperty(value = "任期结束日期")
    private Date term_end_time;

    @ApiModelProperty(value = "是否跳跃任期, 0:无；1:有")
    private Integer is_skip_term;

    @ApiModelProperty(value = "二次任期开始日期")
    private Date other_term_start_time;

    @ApiModelProperty(value = "二次任期结束日期")
    private Date other_term_end_time;

    @ApiModelProperty(value = "如何结束，-1:其他，0:辞职，1:正常卸任，2:卒于任上")
    private Integer type;

    @ApiModelProperty(value = "党派")
    private Long party_id;

    @ApiModelProperty(value = "州名")
    private Long state_id;

    @ApiModelProperty(value = "是否在任, 0:卸任；1:在任")
    private Integer status;

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

    public String getPresident_name() {
        return president_name;
    }

    public void setPresident_name(String president_name) {
        this.president_name = president_name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public Date getDeathday() {
        return deathday;
    }

    public void setDeathday(Date deathday) {
        this.deathday = deathday;
    }

    public String getLocation_of_death() {
        return location_of_death;
    }

    public void setLocation_of_death(String location_of_death) {
        this.location_of_death = location_of_death;
    }

    public Integer getIs_alive() {
        return is_alive;
    }

    public void setIs_alive(Integer is_alive) {
        this.is_alive = is_alive;
    }

    public String getTerm_of_office() {
        return term_of_office;
    }

    public void setTerm_of_office(String term_of_office) {
        this.term_of_office = term_of_office;
    }

    public Date getTerm_start_time() {
        return term_start_time;
    }

    public void setTerm_start_time(Date term_start_time) {
        this.term_start_time = term_start_time;
    }

    public Date getTerm_end_time() {
        return term_end_time;
    }

    public void setTerm_end_time(Date term_end_time) {
        this.term_end_time = term_end_time;
    }

    public Integer getIs_skip_term() {
        return is_skip_term;
    }

    public void setIs_skip_term(Integer is_skip_term) {
        this.is_skip_term = is_skip_term;
    }

    public Date getOther_term_start_time() {
        return other_term_start_time;
    }

    public void setOther_term_start_time(Date other_term_start_time) {
        this.other_term_start_time = other_term_start_time;
    }

    public Date getOther_term_end_time() {
        return other_term_end_time;
    }

    public void setOther_term_end_time(Date other_term_end_time) {
        this.other_term_end_time = other_term_end_time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getParty_id() {
        return party_id;
    }

    public void setParty_id(Long party_id) {
        this.party_id = party_id;
    }

    public Long getState_id() {
        return state_id;
    }

    public void setState_id(Long state_id) {
        this.state_id = state_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "President{" +
        "id=" + id +
        ", president_name=" + president_name +
        ", gender=" + gender +
        ", birthday=" + birthday +
        ", birth_place=" + birth_place +
        ", deathday=" + deathday +
        ", location_of_death=" + location_of_death +
        ", is_alive=" + is_alive +
        ", term_of_office=" + term_of_office +
        ", term_start_time=" + term_start_time +
        ", term_end_time=" + term_end_time +
        ", is_skip_term=" + is_skip_term +
        ", other_term_start_time=" + other_term_start_time +
        ", other_term_end_time=" + other_term_end_time +
        ", type=" + type +
        ", party_id=" + party_id +
        ", state_id=" + state_id +
        ", status=" + status +
        ", create_time=" + create_time +
        ", update_time=" + update_time +
        "}";
    }
}
