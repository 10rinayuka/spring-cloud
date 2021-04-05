package com.ljy.userconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 不结合 Eureka 自定义一个 client 名字
 * 用 url 属性指定 服务器列表 url = "http://ip:port/"
 *
 * @author jay
 * @date 2021/04/04
 */
@FeignClient(name = "test", url = "http://junyudembp:4441")
public interface ConsumerApi {

    /**
     * 远程请求服务的 方法名/资源名
     *
     * @return {@link String}
     */
    @GetMapping("/alive")
    String alive();
}
