package com.ljy.consumerservice.controller;

import com.ljy.consumerservice.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 消费者 Controller Demo
 *
 * @author jay
 * @date 2021/04/03
 */
@RestController
public class ConsumerController {

    @Autowired

    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient client;

    @GetMapping("/client0")
    public String client0() {

//        ServiceInstance instance = client.choose("provider");
        String url = "http://provider/getHi";
        String respStr = restTemplate.getForObject(url, String.class);
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);

        System.out.println("resp Entity: " + entity);

        return respStr + " reload!";
    }

    @GetMapping("/client1")
    public String client1() {
        String url = "http://provider/getMap";
        Map<String, String> respMap = restTemplate.getForObject(url, Map.class);

        return "resp map: " + respMap.toString();
    }

    @GetMapping("/client2")
    public String client2() {
        String url = "http://provider/getObject";

        Person respObject = restTemplate.getForObject(url, Person.class);

        return Optional.ofNullable(respObject).orElse(new Person()).toString();
    }

    @GetMapping("/client3")
    public String client3() {
        // 使用占位符 传递参数
//        String url = "http://provider/getObjParm?name={1}";
//        Person respObj = restTemplate.getForObject(url, Person.class, "aria");

        // 使用 Map 传递参数
        String url = "http://provider/getObjParm?name={name}";
        Map<String, String> reqMap = Collections.singletonMap("name", "mirei");
        Person respObj = restTemplate.getForObject(url, Person.class, reqMap);

        return Optional.ofNullable(respObj).orElse(new Person()).toString();
    }

    @GetMapping("/client4")
    public String client4() {
        String url = "http://provider/postParam";

        Map<String, String> map = Collections.singletonMap("name", "kanno");
        Person person = restTemplate.postForObject(url, map, Person.class);

        return Optional.ofNullable(person).orElse(new Person()).toString();
    }

    @GetMapping("/client5")
    public String client5() {
        String url = "http://provider/postParam2";

        Person req = new Person();
        req.setName("oto");
        Person person = restTemplate.postForObject(url, req, Person.class);

        return Optional.ofNullable(person).orElse(new Person()).toString();
    }

    @GetMapping("/client6")
    public void client6(HttpServletResponse response) throws IOException {
        String url = "http://provider/postLocation";

        Person person = new Person();
        person.setName("komori");
        URI location = restTemplate.postForLocation(url, person, Person.class);

        response.sendRedirect(location.toURL().toString());
    }
}
