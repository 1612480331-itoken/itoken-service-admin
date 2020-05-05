package com.example.itokenserviceadmin.controller;

import com.example.itokenserviceadmin.utils.FileUtil;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadFileController {

    @PostMapping("/uploadFiles")
    public String uploadFile(MultipartFile[] files) throws IOException {

        if (files.length == 0) {
            return "请选择上传文件";
        }
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                return "上传失败";
            }
            byte[] fileBytes = file.getBytes();
            String filePath = "static";
            String originalFilename = file.getOriginalFilename();
            String name = file.getName();
            System.out.println(originalFilename + "!!!!" + name);
            String fileName = UUID.randomUUID() + "&" + originalFilename;
            System.out.println("fileName:" + fileName);
            FileUtil.uploadFile(fileBytes, filePath, fileName);
        }
        return "文件上传完毕";
    }
}
