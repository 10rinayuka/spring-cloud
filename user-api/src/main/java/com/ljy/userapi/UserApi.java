package com.ljy.userapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This is Description
 *
 * @author jay
 * @date 2021/04/04
 */
//@RequestMapping("/user")
public interface UserApi {

    @GetMapping("/user/alive")
    String alive();

    /**
     * @param id
     * @return
     * @RequestParam 必须加上 给 Feign 看的
     * @GetMapping 是给 Feign 看的，解析组装 url 用的（被调用方的服务）
     */
    @GetMapping("/user/getById")
    String getById(@RequestParam("id") Integer id);
}
