package com.ljy.userconsumer.controller;

import com.ljy.userconsumer.service.ConsumerApi;
import com.ljy.userconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * This is Description
 *
 * @author jay
 * @date 2021/04/04
 */
@RestController
public class UserConsumerController {

    @Autowired
    ConsumerApi consumerApi;

    @Autowired
    UserService userService;

    @GetMapping("/alive")
    public String alive() {
        return consumerApi.alive();
    }

    @GetMapping("/alive2")
    public String alive2() {
        return userService.alive();
    }

    @GetMapping("/getId")
    public String getId(Integer id) {
        System.out.println("id: " + id);
        return userService.getById(id);
    }

    @GetMapping("/map")
    public Map<String, String> map(Integer id) {
        System.out.println(id);
        return userService.getMap(id);
    }
}
