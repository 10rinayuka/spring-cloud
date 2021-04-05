package com.ljy.consumerservice.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * Rest 请求拦截器
 *
 * @author jay
 * @date 2021/04/03
 */
public class LoggingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        System.out.println("拦截啦!!!");
        System.out.println("req uri: " + request.getURI());

        ClientHttpResponse response = execution.execute(request, body);

        System.out.println("response: " + response.getHeaders());

        return response;
    }
}
