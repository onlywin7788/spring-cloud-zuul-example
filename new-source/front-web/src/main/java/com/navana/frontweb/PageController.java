package com.navana.frontweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @GetMapping("/development/list")
    public String DevelopmentList(Model model){

        return "contents/pages/development/list";
    }
}
