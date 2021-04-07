package com.ljy.userprovider.controller;

import com.ljy.userapi.Person;
import com.ljy.userapi.UserApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This is Description
 *
 * @author jay
 * @date 2021/04/04
 */
@RestController
public class UserController implements UserApi {

    @Value("${server.port}")
    String port;

    private AtomicInteger count = new AtomicInteger();

    @Override
    public String alive() {
        try {
            System.out.println("准备睡");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = count.getAndIncrement();
        System.out.println("====好的第：" + i + "次调用");
        return "port:" + port;
    }

    @GetMapping("/getById")
    @Override
    public String getById(Integer id) {
        return String.valueOf(id);
    }

    @GetMapping("/getMap")
    public Map<Integer, String> getMap(Integer id) {
        // TODO Auto-generated method stub
        System.out.println(id);
        return Collections.singletonMap(id, "riku");
    }

    @GetMapping("/getMap2")
    public Map<Integer, String> getMap(Integer id, String name) {
        // TODO Auto-generated method stub
        System.out.println("id: " + id + " name: " + name);
        return Collections.singletonMap(id, name);
    }

    @GetMapping("/getMap3")
    public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }

    @PostMapping("/postMap")
    public Map<Integer, String> postMap(@RequestParam Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }

    @PostMapping("/postPerson")
    public Map<Integer, String> postMap(@RequestBody Person person) {
        // TODO Auto-generated method stub
        System.out.println(person);
        return Collections.singletonMap(person.getId(), person.getName());
    }


}
