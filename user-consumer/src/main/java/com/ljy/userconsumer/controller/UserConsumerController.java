package com.ljy.userconsumer.controller;

import com.ljy.userapi.Person;
import com.ljy.userconsumer.service.ConsumerApi;
import com.ljy.userconsumer.service.RestService;
import com.ljy.userconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    RestService restService;

    @GetMapping("/alive")
    public String alive() {
        return consumerApi.alive();
    }

    @GetMapping("/alive2")
    public String alive2() {
        return userService.alive();
    }

    /**
     * RestTemplate 集合 Hystrix
     *
     * @return
     */
    @GetMapping("/alive3")
    public String alive3() {

        return restService.alive();
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

    @GetMapping("/map2")
    public Map<String, String> map2(Integer id, String name) {
        System.out.println("id: " + id + " name: " + name);
        return userService.getMap2(id, name);
    }

    @GetMapping("/map3")
    public Map<String, String> map3(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return userService.getMap3(map);
    }

    @GetMapping("/map4")
    public Map<String, String> map4(@RequestParam Map<String, Object> map) {
        System.out.println(map);
        return userService.postMap(map);
    }

    /**
     * @param person
     * @return
     */
    @PostMapping("/person")
    public Map<String, String> person(@RequestBody Person person) {
//        {
//            "id": 123,
//                "name": "lulu"
//        }
        System.out.println(person);
        return userService.postPerson(person);
    }

    /**
     * 降级
     * 1. 发起向服务方的请求
     *   1.1 判断超时 -> 这次请求 记录到服务里
     *   1.2 尝试向其他服务发起请求
     * 2. 还没有成功的话 catch 异常 友好的抛出异常
     * @return
     */
    /**
     * 限流
     * 1. 发起 Http 请求（每一个请求都需要消耗线程资源）
     * 1.1 map(URI, 线程数) 记录 每个服务请求开启的线程数
     * 1.2 线程池（线程数）
     * 2. 当前线程数达到限制，抛出异常
     *
     * @return
     */
}
