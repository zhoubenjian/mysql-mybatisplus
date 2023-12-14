package com.benjamin.controller;

import com.benjamin.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/import")
public class ImportController {

    @Autowired
    private ImportService importService;



    @PostMapping("")
    public void importExcelData(@RequestParam("file") MultipartFile file) {
        importService.importExcelData(file);
    }
}
