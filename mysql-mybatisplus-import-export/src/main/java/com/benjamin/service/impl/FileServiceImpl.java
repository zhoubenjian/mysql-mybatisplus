package com.benjamin.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.IdUtil;
import com.benjamin.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileServiceImpl implements FileService {

    // 获取配置文件中的端口
    @Value("${server.port}")
    private String port;

    @Value("${files.upload.path}")
    private String fileUploadPath;

    // 定义接口的ip
    private static final String ip = "http://localhost";



    /**
     * 文件上传
     *
     * @param file
     */
    @Override
    public String upload(MultipartFile file) {

        String path = fileUploadPath + "/";
        try {

            // 获取文件的名称
            String fileName = file.getOriginalFilename();
            // 获取文件后缀名
            String suffix = FileNameUtil.getSuffix(fileName);

            // 引入yaml文件配置的路径
            File uploadFile = new File(fileUploadPath);
            // 判断文件目录是否存在 如果不存在，就创建一个文件夹
            if(!uploadFile.exists())
                uploadFile.mkdirs();

            String uuid = IdUtil.fastSimpleUUID();

            // 获取文件路径，主路径+文件名
            path = fileUploadPath + File.separator + uuid + "." + suffix;
            // 使用Hutool工具包将我们接收到文件保存到path中
            FileUtil.writeBytes(file.getBytes(), path);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}
