package com.yht.image.web;

import com.yht.image.vo.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "upload")
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @PostMapping(value = "cos")
    private Msg uploadCos(HttpServletRequest request) {
        // uniquely identify the file
        String uuid = request.getParameter("qquuid");


        return Msg.ok();
    }
}
