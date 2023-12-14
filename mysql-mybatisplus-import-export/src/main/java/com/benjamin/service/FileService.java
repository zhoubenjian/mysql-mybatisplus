package com.benjamin.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 文件上传
     *
     * @param file
     */
    String upload(MultipartFile file);
}
