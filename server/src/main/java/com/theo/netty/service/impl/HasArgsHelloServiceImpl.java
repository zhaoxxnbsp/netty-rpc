package com.theo.netty.service.impl;

import com.theo.netty.service.HasArgsHelloService;

/**
 * < 服务实现类 >
 * 首先服务提供方有具体的服务实现类，
 * 然后它通过RPCServer建立Netty服务端24小时监听客户端的服务调用请求。
 * 请求将被RPCServerHandler处理，
 * 它根据请求中的调用信息通过反射找到实现类和服务方法并反射调用获取结果，并立即将结果发送给客户端。
 */
public class HasArgsHelloServiceImpl implements HasArgsHelloService {

    public String hello(String msg) {
        return msg;

    }
}