package com.yht.image.web;

import com.yht.image.ICloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "home")
public class PageController {

    @Autowired
    private ICloud cloud;

    @GetMapping
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("home");
        return view;
    }

    @GetMapping(value = "/put")
    public String index() throws FileNotFoundException {
        final String IMAGE_PATH = "/home/lionel/IdeaProjects/cloud-image-browser/image-tool/src/test/resources/images/logo.png";
        FileInputStream inputStream = new FileInputStream(IMAGE_PATH);

        String result = cloud.putObject("1haitao.jpg", inputStream);
        System.out.println(result);

        return "aaa";
    }
}
