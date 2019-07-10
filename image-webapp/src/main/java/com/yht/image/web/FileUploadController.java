package com.yht.image.web;

import com.yht.image.ICloud;
import com.yht.image.model.dto.ImageUploadDto;
import com.yht.image.model.vo.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequestMapping(value = "upload")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    private static final String IMAGE_URL = "http://image.hualihai.cn/blog/%s";

    @Autowired
    private ICloud cloud;


    @PostMapping(value = "cos", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Msg uploadCos(@ModelAttribute ImageUploadDto uploadDto) throws ServletException, IOException {
        // uniquely identify the file
//        final String path = request.getParameter("destination");
//        final String uuid = request.getParameter("qquuid");
//        final String fileName = request.getParameter("qqfilename");
//        final String totalFileSize = request.getParameter("qqtotalfilesize");
//        Part part = request.getPart("qqfile");
//        InputStream inputStream = part.getInputStream();
//        cloud.putObject(uuid, inputStream);
//        response.setHeader("Access-Control-Allow-Origin", "http://local.stage.com:8088");

        //return FineUploader.ok(String.format(IMAGE_URL, uuid));

        String name = uploadDto.getName();
        List<MultipartFile> multipartFiles = uploadDto.getFiles();

        return Msg.ok();
    }
}
