package com.atuts.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller class to handle requests related user login
 *
 */
@Controller
public class UserController {

    /**
     * Method to get handle get get request to login page.
     *
     * @param error
     * @return the view name need to be render.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model, @RequestParam(value = "error",required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout){
        model.addAttribute("error",error);
        if(logout != null) {
            model.addAttribute("logout", true);
        }
        return "login";
    }
}
