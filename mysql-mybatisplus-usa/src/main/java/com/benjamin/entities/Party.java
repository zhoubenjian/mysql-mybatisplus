package com.benjamin.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 政党
 * </p>
 *
 * @author benjamin
 * @since 2022-09-26
 */
@Data
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
}
