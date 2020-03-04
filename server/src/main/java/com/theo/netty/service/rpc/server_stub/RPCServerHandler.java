package com.theo.netty.service.rpc.server_stub;

import com.theo.netty.bean.ClassInfo;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * server_stub.RPCServerHandler
 * 真正根据调用请求反射调用的业务处理类
 * reflections: 服务提供方根据调用信息反射获取实现类时需要
 */
public class RPCServerHandler extends ChannelHandlerAdapter {


    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取调用信息，寻找服务实现类
        ClassInfo classInfo = (ClassInfo) msg;
        String implName = getImplClassName(classInfo.getClassName());
        Class<?> clazz = Class.forName(implName);
        Method method = clazz.getMethod(classInfo.getMethodName(), classInfo.getParamTypes());
        Object result = method.invoke(clazz.newInstance(), classInfo.getParams());
        ctx.writeAndFlush(result);
    }

    private String getImplClassName(String interfaceName) throws ClassNotFoundException {
        Class interClass = Class.forName(interfaceName);
        String servicePath = "top.zhenganwen.rpc.server";
        Reflections reflections = new Reflections(servicePath);
        Set<Class> implClasses = reflections.getSubTypesOf(interClass);
        if (implClasses.isEmpty()) {
            System.err.println("impl class is not found!");
        } else if (implClasses.size() > 1) {
            System.err.println("there are many impl classes, not sure invoke which");
        } else {
            Class[] classes = implClasses.toArray(new Class[1]);
            return classes[0].getName();
        }
        return null;
    }
}
