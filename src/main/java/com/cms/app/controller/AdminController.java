package com.cms.app.controller;

import com.cms.app.model.User;
import com.cms.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by burusothman on 8/30/16.
 */
@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String homePage(ModelMap modelMap){
        User user = new User();
        modelMap.addAttribute("userForm",user);

        List<User> userList = userService.getAllUsers();

        modelMap.addAttribute("userList", userList);
        return "admin";
    }


}
