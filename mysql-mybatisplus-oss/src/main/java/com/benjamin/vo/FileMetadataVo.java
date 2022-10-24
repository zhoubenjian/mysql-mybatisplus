package com.benjamin.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
public class FileMetadataVo {
    @ApiModelProperty("文件上传成功后返回的下载路径")
    private String downloadUrl;

    @ApiModelProperty("文件大小, 字节")
    private long fileSize;

    @ApiModelProperty("文件媒体类型")
    private String mediaType;

    @ApiModelProperty("是否成功完成存储标记")
    private boolean stored;
}
