package com.zenca.zencaconfigurationclient;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RefreshScope
public class MainController {

    @Value("${conn.host}")
    private String host;

    @Value("${conn.port}")
    private String port;

    @GetMapping("/config")
    public String config() {
        return "CONFIG : " + host + " / " + port;
    }

    @GetMapping("/test/member")
    public String testMember() {
        return "member";
    }

    @GetMapping("/test/contents")
    public String testContents() {
        return "contents";
    }

}