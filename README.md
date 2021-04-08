# 工程简介
> 这是一个学习 Spring Cloud 组件的 Demo 项目

## eureka-service 模块

## user-api 模块
> Feign 的 接口模块

## user-consumer 模块
### Feign 相关
1. UserService - 继承 UserApi，提供 Feign 调用 接口方法

### Hystrix 相关
1. UserProviderBack - 结合 Feign 的 fallback 实现类
   1. 可以实现 **降级**
2. UserProviderBackFactory - 结合 Feign 的 fallbackFactory 实现类
3. RestService - 结合 RestTemplate 的 fallback 实现
   1. 结合 RestTemplate 需要在 启动类加上 **@RestController** 注解
   2. 结合 Feign 时，不需要加 **@RestController** 注解
4. 

## user-provider 模块
> 学习 Feign 的 服务提供者模块

# 延伸阅读

