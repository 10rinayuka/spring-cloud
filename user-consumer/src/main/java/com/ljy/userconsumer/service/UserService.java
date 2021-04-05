package com.ljy.userconsumer.service;

import com.ljy.userapi.UserApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 结合 Eureka name = 被调用方服务名
 *
 * @author jay
 * @date 2021/04/04
 */
@FeignClient(name = "user-provider")
public interface UserService extends UserApi {

    @GetMapping("/getMap")
    Map<String, String> getMap(@RequestParam("id") Integer id);
}
