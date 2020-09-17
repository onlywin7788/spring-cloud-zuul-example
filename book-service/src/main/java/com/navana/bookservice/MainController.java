package com.navana.bookservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/service")
public class MainController {

    @GetMapping("/book/{id}")
    public String book(@PathVariable("id") int id, HttpServletRequest request) {
        return "book id : " + id;
    }

}