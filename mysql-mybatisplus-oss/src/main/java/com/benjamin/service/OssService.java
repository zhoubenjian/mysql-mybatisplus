package com.benjamin.service;

import com.benjamin.response.BaseResponse;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.vo.FileMetadataVo;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {

    /**
     * 单个文件上传OSS
     * @param file
     * @return
     */
    ResponseWithEntities<FileMetadataVo> uploadFile2OSS(MultipartFile file);

    /**
     * 根据文件名删除OSS文件
     * @param fileName
     * @return
     */
    BaseResponse deleteFileFromOSS(String fileName);
}
