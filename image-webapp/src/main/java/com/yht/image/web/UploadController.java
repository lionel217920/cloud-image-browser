package com.yht.image.web;

import com.qcloud.cos.COS;
import com.yht.image.ICloud;
import com.yht.image.vo.FineUploader;
import com.yht.image.vo.Msg;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "upload")
public class UploadController {

    @Autowired
    private ICloud cloud;

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping(value = "cos")
    private FineUploader uploadCos(HttpServletRequest request) throws ServletException, IOException {
        // uniquely identify the file
        final String path = request.getParameter("destination");
        final String uuid = request.getParameter("qquuid");
        final String fileName = request.getParameter("qqfilename");
        final String totalFileSize = request.getParameter("qqtotalfilesize");
        Part part = request.getPart("qqfile");
        InputStream inputStream = part.getInputStream();
        //cloud.putObject(uuid, inputStream);

        return FineUploader.ok();
    }

    @GetMapping(value = "cos/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Msg upload() throws JSONException {
        return Msg.ok();
    }
}
