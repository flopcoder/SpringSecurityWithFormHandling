package com.flopcoder.controller;

import com.flopcoder.model.User;
import com.flopcoder.security.CustomUserDetailService;
import com.flopcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Flop Coder on 7/2/14.
 */
@Controller
public class SecurityController {

    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(User user) {
        ModelAndView ret = new ModelAndView();

        user.setName("default");
        user.setAddress("Dhaka");
        user.setMobile("default");
        user.setEmail("default");
        ret.setViewName("login");
        ret.addObject("user", user);
        return ret;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView processLogin(
            @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("login");
            modelAndView.addObject("user", user);
            return modelAndView;
        }

        UserDetails userDetails = customUserDetailService.loadUserByUsername(user.getUserName());
        if (userDetails == null || !user.getPassword().equals(userDetails.getPassword())) {
            modelAndView.setViewName("login");
            modelAndView.addObject("message", "Wrong credential");
            modelAndView.addObject("user", user);
            return modelAndView;
        }

        try {
            Authentication tokenResult = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(tokenResult);
            if (tokenResult != null) {
                modelAndView.addObject("user",userService.getUserByUsername(user.getUserName()));
                modelAndView.setViewName("hello");
            }
        } catch (NullPointerException ert) {
            modelAndView.setViewName("login");
            modelAndView.addObject("message", "No user found for any role.Please try again...");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        return modelAndView;
    }

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView("access_denied");
    }
}
