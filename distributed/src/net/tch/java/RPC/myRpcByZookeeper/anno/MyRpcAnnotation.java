package net.tch.java.RPC.myRpcByZookeeper.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @auth tongchenghao
 * @date 2020/2/18
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRpcAnnotation {
    /**
     * 对外发布的服务的接口地址
     * @return
     */
    Class<?> value();

    /**
     * 服务版本号
     * @return
     */
    String version() default "";
}
