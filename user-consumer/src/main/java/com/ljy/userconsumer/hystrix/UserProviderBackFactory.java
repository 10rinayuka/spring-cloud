package com.ljy.userconsumer.hystrix;

import com.ljy.userapi.Person;
import com.ljy.userconsumer.service.UserService;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author riku
 * @Classname UserProviderBackFactory
 * @Date 2021/4/8 2:13
 * @Description Feign 结合 Hystrix 的 fallbackFactory 实现类
 */
@Component
public class UserProviderBackFactory implements FallbackFactory<UserService> {
    /**
     * 可以更具 异常类型 对降级操作进行细粒度的划分
     *
     * @param throwable 本地或者远端异常
     * @return
     */
    @Override
    public UserService create(Throwable throwable) {
        // 返回一个 UserService 对象
        return new UserService() {
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

            @Override
            public String alive() {
                System.out.println(throwable);

                if (throwable instanceof FeignException.InternalServerError) {
                    // 抛出一个自定义异常 TODO
                    return "远程服务器 500" + throwable.getLocalizedMessage();
                }

//                throwable.printStackTrace();
                System.out.println(ToStringBuilder.reflectionToString(throwable));
                return "alive 降级";
            }

            @Override
            public String getById(Integer id) {
                return null;
            }
        };
    }
}
