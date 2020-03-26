package com.flappybird.FlappyBirdServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Arrays;


@RestController
@RequestMapping("/testservice")
public class TestService {


    @RequestMapping(method = RequestMethod.GET, path = "/hi")
    public ResponseEntity hi(){
        return ResponseEntity.ok("Hi! Welcome to Flappy Bird Game");
    }

}
