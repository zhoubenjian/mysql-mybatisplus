package com.benjamin.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 政党
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
@ApiModel(value="Party对象", description="政党")
public class Party implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "名称")
    private String party_name;

    @ApiModelProperty(value = "创始人（,隔开）")
    private String founder;

    @ApiModelProperty(value = "开始日期")
    private Date start_time;

    @ApiModelProperty(value = "结束日期")
    private Date end_time;

    @ApiModelProperty(value = "父级")
    private Integer parent_id;

    @ApiModelProperty(value = "至今存在, 0:不存在；1:存在")
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

    public String getParty_name() {
        return party_name;
    }

    public void setParty_name(String party_name) {
        this.party_name = party_name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
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

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
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
        return "Party{" +
        "id=" + id +
        ", party_name=" + party_name +
        ", founder=" + founder +
        ", start_time=" + start_time +
        ", end_time=" + end_time +
        ", parent_id=" + parent_id +
        ", status=" + status +
        ", create_time=" + create_time +
        ", update_time=" + update_time +
        "}";
    }
}
