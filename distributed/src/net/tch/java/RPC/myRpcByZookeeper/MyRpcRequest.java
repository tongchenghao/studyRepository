package net.tch.java.RPC.myRpcByZookeeper;

import java.io.Serializable;

/**
 * @description:请求数据类
 *      封装了用于请求服务器服务的相关数据
 * @auth tongchenghao
 * @date 2020/2/13
 */
public class MyRpcRequest implements Serializable {

    private static final long serialVersionUID = -6489190134892037425L;
    private String className;

    private String methodName;

    private String version;

    private Object[] arrgs;

    public MyRpcRequest() {
    }

    public MyRpcRequest(String className, String methodName, String version, Object[] arrgs) {
        this.className = className;
        this.methodName = methodName;
        this.version = version;
        this.arrgs = arrgs;
    }

    public MyRpcRequest(String className, String methodName, Object[] arrgs) {
        this.className = className;
        this.methodName = methodName;
        this.arrgs = arrgs;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArrgs() {
        return arrgs;
    }

    public void setArrgs(Object[] arrgs) {
        this.arrgs = arrgs;
    }
}
