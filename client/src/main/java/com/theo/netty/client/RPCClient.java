package com.theo.netty.client;

import com.theo.netty.client_stub.ServiceProxy;
import com.theo.netty.service.HasArgsHelloService;
import com.theo.netty.service.NoArgsHelloService;

/**
 * 这个包中是依赖Service接口的一些类，
 * RPC服务的调用对于他们来说是透明的，
 * 他们仅通过client_stub中的ServiceProxy来获取服务实现类并调用服务。
 */
public class RPCClient {

    public static void invoke(){
        NoArgsHelloService noArgsHelloService = (NoArgsHelloService) ServiceProxy.create(NoArgsHelloService.class);
        System.out.println(noArgsHelloService.hello());

        HasArgsHelloService hasArgsHelloService = (HasArgsHelloService) ServiceProxy.create(HasArgsHelloService.class);
        System.out.println(hasArgsHelloService.hello("hello netty rpc"));
    }
}
