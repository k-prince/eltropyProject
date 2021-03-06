package com.eltropy.bankingsystem.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bankingsystem")
public class CoreController
{
    @GetMapping("")
    public String loginPage(){
        return "login";
    }

}
