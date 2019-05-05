package com.jacob.video.controller;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

    @RequestMapping("test")
    public String test(){
        return "hello 222";
    }

    @RequestMapping("my")
    public String my(){
        return "my";
    }
}
