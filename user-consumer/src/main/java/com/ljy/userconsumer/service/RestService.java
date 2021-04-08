package com.ljy.userconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author riku
 * @Classname RestService
 * @Date 2021/4/8 2:38
 * @Description TODO
 */
@Service
public class RestService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "back")
    public String alive() {

        String url = "http://user-provider/user/alive";
        String ret = restTemplate.getForObject(url, String.class);
        return ret;
    }

    public String back() {
        return "RestService alive 降级";
    }
}
