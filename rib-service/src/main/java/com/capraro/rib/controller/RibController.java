package com.capraro.rib.controller;

import com.capraro.model.Rib;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rcapraro on 23/12/14.
 */
@RestController
public class RibController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/ribs", method = RequestMethod.POST)
    public String createRib(@RequestBody Rib rib) {

        rabbitTemplate.convertAndSend("rib.created.queue", rib);
        return "Rib created: " + rib.toString();
    }
}
