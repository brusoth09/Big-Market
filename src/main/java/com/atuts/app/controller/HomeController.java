package com.atuts.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by brusoth on 5/4/16.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(ModelMap modelMap){

        return "home";
    }
}
