package com.cms.app.controller;

import com.cms.app.model.Role;
import com.cms.app.model.User;
import com.cms.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller class to handle requests related user login
 *
 */
@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("userForm") User user,
                             BindingResult result, Model model, final RedirectAttributes redirectAttributes){

        logger.debug("saveOrUpdateUser() : {}", user);

        redirectAttributes.addFlashAttribute("css", "success");

        redirectAttributes.addFlashAttribute("msg", "User added successfully!");
        userService.save(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/user/suspend", method = RequestMethod.GET)
    public String updateUserEnabled(@ModelAttribute("userForm") User user, @RequestParam(value = "suspend") String suspend,
                             BindingResult result, Model model, final RedirectAttributes redirectAttributes){

        user.setUsername(suspend);
        logger.debug("saveOrUpdateUser() : {}", user);
        userService.updateUserEnabled(user);
        return "redirect:/admin";
    }

}
