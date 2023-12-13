package com.benjamin.service.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.benjamin.service.ImportService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class ImportServiceImpl implements ImportService {

    @Override
    public void importExcelData(MultipartFile file) {

        try {

            // 文件处理成io流
            InputStream inputStream = file.getInputStream();

            // ExcelReader获取io流
            ExcelReader reader = ExcelUtil.getReader(inputStream);

            List<List<Object>> read = reader.read();
            for (int i = 0; i < read.size(); i++) {

                List<Object> objects = read.get(i);
                for (Object object : objects)
                    System.out.println(object != null ? object.toString() : "无");
                System.out.println("*******************************************");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
