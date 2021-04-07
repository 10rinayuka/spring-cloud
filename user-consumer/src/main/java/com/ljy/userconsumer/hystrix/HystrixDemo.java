package com.ljy.userconsumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author riku
 * @Classname HystrixDemo
 * @Date 2021/4/8 0:36
 * @Description Hystrix Demo
 */
public class HystrixDemo extends HystrixCommand {

    protected HystrixDemo(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Object getFallback() {
        return "getFallbackgetFallback";
    }

    /**
     * 备用逻辑 - catch
     *
     * @return
     * @throws Exception
     */
    @Override
    protected Object run() throws Exception {
        System.out.println("执行逻辑 run");
//        int i = 1 / 0; 异常
        int i = 1 / 1;
        return "ok";
    }

    public static void main(String[] args) {

        /**
         * queue()：以异步非阻塞方式执行run()。以demo为例，
         * 	一调用queue()就直接返回一个Future对象，
         * 	同时hystrix创建一个新线程运行run()，
         * 	调用程序通过Future.get()拿到run()的返回结果，
         * 	而Future.get()是阻塞执行的
         */
        Future<String> futureResult = new HystrixDemo(HystrixCommandGroupKey.Factory.asKey("ext")).queue();
        String result = "";

        try {
            result = futureResult.get();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException!!!");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException!!!");
            e.printStackTrace();
        }

        System.out.println("程序结果: " + result);
    }
}
