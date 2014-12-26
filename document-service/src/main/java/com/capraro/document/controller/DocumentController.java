package com.capraro.document.controller;

import com.capraro.model.Rib;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rcapraro on 23/12/14.
 */
@RestController
public class DocumentController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RabbitListener(queues = "rib.created.queue")


    public void processRib(Rib rib) {
        System.out.println(rib);
    }
}
