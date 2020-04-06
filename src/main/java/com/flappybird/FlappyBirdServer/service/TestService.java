package com.flappybird.FlappyBirdServer.service;


import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;


@Service
public class TestService {



    public ResponseEntity hi(){
        return ResponseEntity.ok("Hi! Welcome to Flappy Bird Game");
    }

}
