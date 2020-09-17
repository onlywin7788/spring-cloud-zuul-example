package com.navana.bookstoreservice;

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

        System.out.format("\nACCEPT :: SERVICE_TYPE=[BOOK], ID=[%d]", id);
        return "book id : " + id;
    }

    @GetMapping("/order/{id}")
    public String order(@PathVariable("id") int id, HttpServletRequest request) {

        System.out.format("\nACCEPT :: SERVICE_TYPE=[ORDER], ID=[%d]", id);
        return "order id : " + id;
    }

}