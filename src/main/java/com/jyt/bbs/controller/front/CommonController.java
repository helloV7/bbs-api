package com.jyt.bbs.controller.front;

import com.jyt.bbs.model.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Api(value = "通用控制器")
@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${spring.servlet.multipart.location}")
    String filePath;
    @Value("${domain}")
    String domain;

    @ApiOperation(value = "文件上传",notes = "任意文件类型 返回文件地址")
    @RequestMapping(value = "/file",method = RequestMethod.POST)
    public R upload(@RequestParam("file") MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            //文件为空的时候返回错误
            return R.error();
        }

        String fileName = multipartFile.getOriginalFilename();
        //int size = (int) multipartFile.getSize();

        File file = new File(fileName);
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            //保存文件
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return R.error();
        }

        return R.ok().setData(domain+"/common/file/"+fileName);

    }

    @ApiOperation(value = "获取文件")
    @RequestMapping(value = "/file/{fileName:[a-zA-Z0-9\\.]+}",method = RequestMethod.GET)
    public void getFile(@PathVariable(name = "fileName") String fileName, HttpServletResponse response){
        File file = new File(filePath+File.separator+fileName);
        System.out.println(file);
        if (!file.exists()){
            throw new RuntimeException("文件不存在");
        }

        try {
            FileInputStream fileInputStream =new FileInputStream(file);

            ServletOutputStream outputStream = response.getOutputStream();

            byte[] temp = new byte[1024];
            while(fileInputStream.read(temp) >0){
                outputStream.write(temp);
            }

            fileInputStream.close();
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
