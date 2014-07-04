package com.flopcoder.controller;

import com.flopcoder.dao.UserDao;
import com.flopcoder.model.User;
import com.flopcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;

/**
 * Created by Flop Coder on 6/15/14.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping(value = "/registration/user",method = RequestMethod.GET)
    public ModelAndView register(User user)
    {
        ModelAndView ret = new ModelAndView();
        ret.setViewName("register");
        ret.addObject("user",user);
        return ret;
    }

    @RequestMapping(value = "/registration/user",method = RequestMethod.POST)
    public ModelAndView registerProcess(@ModelAttribute("user") User user)
    {
        ModelAndView ret = new ModelAndView();
        userService.save(user);
        ret.setViewName("register");
        ret.addObject("user",user);
        return ret;
    }

    @RequestMapping(value = "/view/user",method = RequestMethod.GET)
    public ModelAndView viewUser(User user)
    {
        ModelAndView ret = new ModelAndView();
        userService.save(user);
        ret.setViewName("welcome");
        ret.addObject("user",user);
        return ret;
    }
}
