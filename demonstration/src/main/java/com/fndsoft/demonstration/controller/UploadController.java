package com.fndsoft.demonstration.controller;

import com.fndsoft.demonstration.util.SFTPUtil;
import com.fndsoft.demonstration.util.UploadUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @创建人 bob
 * @创建时间 2018/6/28
 * @描述：
 */
@CrossOrigin(origins = "*", maxAge = 3600)      //跨域
@RestController
public class UploadController {

    @RequestMapping(value = "/api/uploadimg", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFiles(@RequestParam("file") MultipartFile file) throws Exception {
        SFTPUtil sftpUtil = new SFTPUtil("root", "Chenbo123", "120.79.175.190", 22);
        sftpUtil.login();
        InputStream inputStream = file.getInputStream();
        String fileName = UploadUtils.generateRandonFileName(file.getOriginalFilename());
        sftpUtil.upload("/usr/local/nginx-static/file-nginx", "/images", fileName, inputStream);
        sftpUtil.logout();
        String imgpath = "http://120.79.175.190/images/" + fileName;
        return imgpath;
    }
}
