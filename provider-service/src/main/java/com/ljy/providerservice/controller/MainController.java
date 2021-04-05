package com.ljy.providerservice.controller;

import com.ljy.providerservice.entity.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * This is Description
 *
 * @author jay
 * @date 2021/04/03
 */
@RestController
public class MainController {

    @GetMapping("/getHi")
    public String getHi() {
        return "getHi!";
    }

    @GetMapping("/getMap")
    public Map<String, String> getMap() {
        HashMap<String, String> map = new HashMap<>(1);
        map.put("id", "100");
        map.put("name", "default name");
        return map;
    }

    @GetMapping("/getObject")
    public Object getObject() {
        Person person = new Person();
        person.setId("101");
        person.setName("riku");

        return person;
    }

    @GetMapping("/getObjParm")
    public Object getObjParm(String name) {
        Person person = new Person();
        person.setId("101");
        person.setName(name);
        return person;
    }

    @PostMapping("/postParam")
    public Person postParm(@RequestBody String name) {
        Person person = new Person();
        person.setId("102");
        person.setName(name);
        return person;
    }

    @PostMapping("/postParam2")
    public Person postParm2(@RequestBody Person person) {
        Person per = new Person();
        per.setId("102");
        per.setName(person.getName());
        return per;
    }

    @PostMapping("/postLocation")
    public URI postLocation(@RequestBody Person person, HttpServletResponse response) throws URISyntaxException {
        URI uri = new URI("http://www.baidu.com/s?wd=" + person.getName());
        // response.addHeader 必须加
        response.addHeader("Location", uri.toString());
        return uri;
    }

}
