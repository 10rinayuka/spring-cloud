package com.ljy.userconsumer.hystrix;

import com.ljy.userapi.Person;
import com.ljy.userconsumer.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author riku
 * @Classname UserProviderBack
 * @Date 2021/4/8 1:28
 * @Description Hystrix 结合 Feign 的 Fallback 类 Demo
 */
@Component
public class UserProviderBack implements UserService {

    @Override
    public String alive() {
        return "alive 降级了";
    }

    @Override
    public String getById(Integer id) {
        return "getById 降级了";
    }

    @Override
    public Map<String, String> getMap(Integer id) {
        return null;
    }

    @Override
    public Map<String, String> getMap2(Integer id, String name) {
        return null;
    }

    @Override
    public Map<String, String> getMap3(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<String, String> postMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<String, String> postPerson(Person person) {
        return null;
    }
}
