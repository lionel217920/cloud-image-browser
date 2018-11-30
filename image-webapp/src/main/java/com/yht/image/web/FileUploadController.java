package com.yht.image.web;

import com.yht.image.ICloud;
import com.yht.image.vo.FineUploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping(value = "upload")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    private static final String IMAGE_URL = "http://image.hualihai.cn/blog/%s";

    @Autowired
    private ICloud cloud;


    @PostMapping(value = "cos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private FineUploader uploadCos(HttpServletRequest request) throws ServletException, IOException {
        // uniquely identify the file
        final String path = request.getParameter("destination");
        final String uuid = request.getParameter("qquuid");
        final String fileName = request.getParameter("qqfilename");
        final String totalFileSize = request.getParameter("qqtotalfilesize");
        Part part = request.getPart("qqfile");
        InputStream inputStream = part.getInputStream();
        cloud.putObject(uuid, inputStream);

        return FineUploader.ok(String.format(IMAGE_URL, uuid));
    }
}
