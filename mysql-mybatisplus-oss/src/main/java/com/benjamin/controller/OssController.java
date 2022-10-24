package com.benjamin.controller;

import com.benjamin.response.BaseResponse;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.OssService;
import com.benjamin.vo.FileMetadataVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/oss")
public class OssController {

    @Autowired
    private OssService ossService;



    /**
     * 单个文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResponseWithEntities<FileMetadataVo> uploadFile2OSS(@RequestParam("file") MultipartFile file) {
        return ossService.uploadFile2OSS(file);
    }

    /**
     * 根据文件名删除OSS文件
     * @param fileName
     * @return
     */
    @PostMapping("/delete")
    public BaseResponse deleteFileFromOSS(@RequestParam("fileName") String fileName) {
        return ossService.deleteFileFromOSS(fileName);
    }
}
