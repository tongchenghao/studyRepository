package jdk;

import jdk.TchPorxy.TClassLoader;
import jdk.TchPorxy.TPorxy;
import jdk.candidates.Tongchenghao;

/**
 * @description:自己实现的代理模式逻辑，虽然生成的代理对象的方法还没有完善，但是基本的代理模式的逻辑是如何实现的已经可以看到了
 * @auth tongchenghao
 * @date 2019/12/24
 */
public class TestMain2 {
    public static void main(String[] args) {
        TPorxy.newProxyInstance(new TClassLoader(), Tongchenghao.class.getInterfaces(),null);
    }
}
