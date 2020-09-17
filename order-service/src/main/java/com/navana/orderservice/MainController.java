package com.navana.orderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/service")
public class MainController {

    @GetMapping("/order/{id}")
    public String book(@PathVariable("id") int id, HttpServletRequest request) {
        return "order id : " + id;
    }

}