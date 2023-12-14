package com.benjamin.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImportService {

    void importExcelData(MultipartFile file);
}
