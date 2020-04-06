package com.flappybird.FlappyBirdServer.controller;

import com.flappybird.FlappyBirdServer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping(method = RequestMethod.GET, path = "/hi")
    public ResponseEntity hi(){
        return testService.hi();
    }
}
