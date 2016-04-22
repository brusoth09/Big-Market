package com.atuts.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller class to handle requests related user login
 *
 */
@Controller
public class UserController {

    /**
     * Method to get handle get get request to login page.
     *
     * @param model interface that defines a holder for model attributes. encapsulates the application data. pre-populated model.
     * @return the view name need to be render.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        model.addAttribute("key","value");

        return "login";
    }
}
