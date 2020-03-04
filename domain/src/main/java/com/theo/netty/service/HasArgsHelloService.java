package com.theo.netty.service;

/**
 * 为了便于维护，服务接口通常会被独立出来到通用模块中，以jar包的形式被服务调用方和服务提供方依赖。
 * 有参服务
 */
public interface HasArgsHelloService {
    String hello(String msg);
}