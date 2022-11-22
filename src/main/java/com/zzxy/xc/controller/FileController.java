package com.zzxy.xc.controller;

import com.zzxy.common.util.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class FileController {

    @RequestMapping("uploadImage")
    public String upLoadimage(MultipartFile file){
        String upLoadPath = FileUtils.uploadImg(file);
        System.out.println(upLoadPath);
        return upLoadPath;
    }
}
