package com.flappybird.FlappyBirdServer.controller;

import com.flappybird.FlappyBirdServer.domain.Greeting;
import com.flappybird.FlappyBirdServer.domain.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/game")
public class GameController {

    Runnable run1;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting ");
                for(int i=0;i<10;++i){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test("test : "+i);
                }
            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(run1);
//        run1.run();
//        Executors.callable(run1);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }


//    @RequestMapping(method = RequestMethod.GET, path = "/hi")
//    public ResponseEntity hi(){
//
//
//    }


    public void test(String s){
        System.out.println("sending : "+s);
        messagingTemplate.convertAndSend("/topic/greetings", new HelloMessage(s));
    }
}
