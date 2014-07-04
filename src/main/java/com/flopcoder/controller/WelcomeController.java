package com.flopcoder.controller;

import com.flopcoder.model.User;
import com.flopcoder.service.IUserService;
import com.flopcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @Autowired
    IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {

        User user = userService.save(new User());
        model.addAttribute("user",userService.getUserById(user.getId()));
		model.addAttribute("message", "Welcome to learn spring Step By Step with Database access with hibernate. This is part 4.");
		return "hello";
	}
}