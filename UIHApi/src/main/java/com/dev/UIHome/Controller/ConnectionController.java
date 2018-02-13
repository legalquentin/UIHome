package com.dev.UIHome.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ConnectionController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String root() {
        return "Connect";
    }

}
