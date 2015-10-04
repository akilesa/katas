package com.akilesa_kata.spring_ws_kata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by akilesa on 04.10.15.
 */
@Controller
public class IndexController {

    @RequestMapping(name = "/")
    public String index() {
        return "index";
    }
}
