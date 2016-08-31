package com.cms.app.controller;

import com.cms.app.model.Post;
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
        modelMap.addAttribute("post", new Post());
        return "home";
    }
}
