package com.ljy.userprovider.controller;

import com.ljy.userapi.UserApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * This is Description
 *
 * @author jay
 * @date 2021/04/04
 */
@RestController
public class UserController implements UserApi {

    @GetMapping("/alive")
    @Override
    public String alive() {
        return "user provider ok";
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

}
