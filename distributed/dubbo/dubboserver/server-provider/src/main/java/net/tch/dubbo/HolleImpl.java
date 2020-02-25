package net.tch.dubbo;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @auth tongchenghao
 * @date 2020/2/20
 */
@Service("holleImpl")
public class HolleImpl implements  Holle {
    @Override
    public String sayHolle(String msg) {
        System.out.println("holle "+msg);
        return "holle"+msg;
    }
}
