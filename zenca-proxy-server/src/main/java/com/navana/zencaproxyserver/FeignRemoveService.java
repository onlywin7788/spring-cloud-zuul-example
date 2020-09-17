package com.navana.zencaproxyserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name ="book-store-service")
public interface FeignRemoveService {

    @RequestMapping("{path}")
    String getInfo(@PathVariable("path") String id);
}
