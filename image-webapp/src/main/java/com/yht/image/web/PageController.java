package com.yht.image.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "home")
public class PageController {

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("upload");
    }

}
