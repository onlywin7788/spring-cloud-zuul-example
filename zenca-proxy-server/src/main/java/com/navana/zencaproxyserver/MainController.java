package com.navana.zencaproxyserver;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;


class Endpoint{
    public String name;
    public String source;
    public String target;
}


@RestController
@Import(FeignClientsConfiguration.class)
@RequestMapping("/v1")
public class MainController {

    private final FeignRemoveService feignRemoveService;

    @Value("${proxy.endpoint}")
    private String endpint;

    public MainController(FeignRemoveService feignRemoveService) {
        this.feignRemoveService = feignRemoveService;
    }

    @GetMapping("/**")
    public String getRemoveResponse(HttpServletRequest request) {
        String requestInfo = (String) request.getAttribute(
                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

        Endpoint[] endpointList = convertPropToObject();


        for(int i=0; i< endpointList.length; i++) {

            Endpoint endpoint = endpointList[i];
            String source = endpoint.source;
            String target = endpoint.target;

            if (requestInfo.contains(source) == true) {
                requestInfo = requestInfo.replace(source, target);
            }
        }

        return getInfo(requestInfo);
    }

    private Endpoint[] convertPropToObject()
    {
        Gson gson = new Gson();
        return gson.fromJson(this.endpint, Endpoint[].class);
    }

    private String getInfo(String path){
        return feignRemoveService.getInfo(path);
    }


}