package com.benjamin.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.VoidResult;
import com.benjamin.config.OssConfig;
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
    private OssConfig ossConfig;


    private OSS ossClient;



    /**
     * 单个文件上传
     * @param file
     * @return
     */
    @Override
    public ResponseWithEntities<FileMetadataVo> uploadFile2OSS(MultipartFile file) {
        String filename = file.getOriginalFilename();
        // 获取文件扩展名
        String extName = FileUtil.extName(filename);
        // 生成新的文件名
        String newName = UUID.randomUUID().toString() + "." + extName;
        try {
            InputStream inputStream = file.getInputStream();
            // 实例化OSS
            this.init();
            ossClient.putObject(ossConfig.getBucketName(), newName, inputStream);
            FileMetadataVo vo = FileMetadataVo.builder()
                    .fileSize(file.getSize())
                    .downloadUrl("https://"+ ossConfig.getBucketName() + "." + ossConfig.getOss().getEndpoint() + "/" + newName)
                    .mediaType(file.getContentType())
                    .stored(true).build();
            return new ResponseWithEntities<FileMetadataVo>()
                    .setData(vo);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new WebException(exception.getMessage(), -1L, "OSS文件上传失败", (long) HttpServletResponse.SC_NOT_ACCEPTABLE, exception);
        } finally {
            // 关闭oss
            ossClient.shutdown();
        }
    }

    /**
     * 根据文件名删除OSS文件
     * @param fileName
     * @return
     */
    @Override
    public BaseResponse deleteFileFromOSS(String fileName) {
        // 实例化OSS
        this.init();
        VoidResult voidResult = ossClient.deleteObject(ossConfig.getBucketName(), fileName);
        if (voidResult.getResponse().getStatusCode() == 204) {
            // 关闭OSSClient
            ossClient.shutdown();
            return new BaseResponse().setMessage(fileName + " 删除成功").setView(fileName + " 删除成功");
        }

        // 关闭OSSClient
        ossClient.shutdown();
        return new BaseResponse()
                .setCode(-1L)
                .setStatus(-1L)
                .setMessage(voidResult.getResponse().getErrorResponseAsString())
                .setView(voidResult.getResponse().getErrorResponseAsString());
    }



    /**
     * 实例化OSS
     */
    private void init() {
        // yourEndpoint填写自定义域名
        String endpoint = ossConfig.getOss().getEndpoint();
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ossConfig.getAccessKey();
        String accessKeySecret = ossConfig.getSecretKey();

        // 创建ClientConfiguration实例，您可以根据实际情况修改默认参数
        ClientBuilderConfiguration conf = new ClientBuilderConfiguration();
        // 设置是否支持CNAME。CNAME用于将自定义域名绑定到目标Bucket。
        conf.setSupportCname(true);

        // 创建OSSClient实例
        this.ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret, conf);
    }
}
