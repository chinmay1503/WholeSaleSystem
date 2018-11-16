package com.wholesalesystem.controllers;

import com.wholesalesystem.data.Users;
import com.wholesalesystem.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LoginController.java - Handles all api requests related to Login */
@Controller
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/submitLoginForm", method = RequestMethod.POST)
    @ResponseBody
    public Users doLogin(@RequestParam(value = "username") String username,
                          @RequestParam(value = "password") String password , HttpServletResponse response)throws IOException {
        Users users = new Users();
        users.setUsername(username);
        users.setPassword(password);
        Users user = userService.getUserDetails(username,password);
        return user;

    }
}
