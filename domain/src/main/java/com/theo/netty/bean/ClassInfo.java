package com.theo.netty.bean;


import lombok.Data;

import java.io.Serializable;

/**
 * 需要注意的是客户端在发送调用信息时会将该类对象序列化并发送给服务端，而服务的则需要反序列化回来，
 * 如果使用的是JDK的序列化技术则需要将此类实现Serializable接口
 */
@Data
public class ClassInfo implements Serializable {

    /**
     * 调用服务的接口名
     */
    private String className;
    /**
     * 调用服务的方法名
     */
    private String methodName;
    /**
     * 调用方法的参数列表类型
     */
    private Class[] paramTypes;
    /**
     * 调用服务传参
     */
    private Object[] params;

}
