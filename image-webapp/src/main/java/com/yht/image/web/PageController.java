package com.yht.image.web;

import com.yht.image.ICloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        final String IMAGE_PATH = "/home/lionel/IdeaProjects/cloud-image-browser/image-tool/src/test/resources/images/Selection_013.png";
        FileInputStream inputStream = new FileInputStream(IMAGE_PATH);

        String result = cloud.putObject("selection_014.png", inputStream);
        System.out.println(result);

        return "aaa";
    }

    @RequestMapping(value = "message", method = RequestMethod.GET)
    public ModelAndView message() {
        ModelAndView view = new ModelAndView("home");
        view.addObject("message", "hello");
        return view;
    }

    @RequestMapping(value = "uploads", method = RequestMethod.POST)
    public String upload(InputStream inputStream) throws IOException {
        int length = inputStream.available();
        if (length > 0) {
            inputStream.read();
        }


        return null;
    }
}
