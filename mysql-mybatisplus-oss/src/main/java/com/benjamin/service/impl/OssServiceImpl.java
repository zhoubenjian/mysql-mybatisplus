package com.benjamin.service.impl;

import cn.hutool.core.lang.UUID;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyun.oss.model.VoidResult;
import com.benjamin.exception.WebException;
import com.benjamin.response.BaseResponse;
import com.benjamin.response.ResponseWithEntities;
import com.benjamin.service.OssService;
import com.benjamin.vo.FileMetadataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@Service
public class OssServiceImpl implements OssService {

    @Autowired
    private OSS ossClient;



    /**
     * 单个文件上传
     * @param file
     * @return
     */
    @Override
    public ResponseWithEntities<FileMetadataVo> uploadFile2OSS(MultipartFile file) {
        String filename = file.getOriginalFilename();
        // 获取.后的扩展名
        String newName = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
        try {
            InputStream inputStream = file.getInputStream();
            ossClient.putObject("xxx", newName, inputStream);
            ossClient.shutdown();
            FileMetadataVo vo = FileMetadataVo.builder()
                    .fileSize(file.getSize())
                    .downloadUrl("xxx" + newName)
                    .mediaType(file.getContentType())
                    .stored(true).build();
            return new ResponseWithEntities<FileMetadataVo>()
                    .setData(vo);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw  new WebException(exception.getMessage(), -1L, "OSS文件上传失败", (long) HttpServletResponse.SC_NOT_ACCEPTABLE, exception);
        }
    }

    /**
     * 根据文件名删除OSS文件
     * @param fileName
     * @return
     */
    @Override
    public BaseResponse deleteFileFromOSS(String fileName) {
        VoidResult voidResult = ossClient.deleteObject("xxx", fileName);
        if (voidResult.getResponse().getStatusCode() == 204) {
            return new BaseResponse()
                    .setCode(0L)
                    .setStatus(0L)
                    .setMessage(fileName + " 删除成功")
                    .setView(fileName + " 删除成功");
        }

        // 关闭OSSClient
        ossClient.shutdown();

        return new BaseResponse()
                .setCode(-1L)
                .setStatus(-1L)
                .setMessage(voidResult.getResponse().getErrorResponseAsString())
                .setView(voidResult.getResponse().getErrorResponseAsString());
    }
}
