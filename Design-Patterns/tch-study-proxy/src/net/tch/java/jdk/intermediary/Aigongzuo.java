package jdk.intermediary;

import jdk.candidates.Person;
import jdk.job.Job;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:"爱工作"中介公司
 * @auth tongchenghao
 * @date 2019/12/22
 */
public class Aigongzuo implements IntermediaryCompany, InvocationHandler {

    String name;

    //规模
    String scale;

    //工作资源仓库
    List<Job> resourceRepository;

    //本公司的服务对象，代理的人员
    Person target;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    @Override
    public List<Job> getResourceRepository() {
        return resourceRepository;
    }
    @Override
    public void setResourceRepository(List<Job> resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Person getTarget() {
        return target;
    }

    public void setTarget(Person target) {
        this.target = target;
    }

    public Aigongzuo(List<Job> resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    /**
     * 筛选工作
     * @return  筛选后的工作
     */
    @Override
    public List<Job> findJobs() {
        List<Job> returnJob = new ArrayList<>();

        Map<String, Object> targetIndicator = target.getIndicator();
        for (Job job :
                resourceRepository) {
            Map<String, Object> jobIndicator = job.getIndicator();

            //代理对象要求的薪资
            int targetRequestCompensation = (int)targetIndicator.get("compensation");
            if(targetRequestCompensation<=job.getCompensation()){
                //工作要求的工作年限
                int jobRequestWorkYears = (int)jobIndicator.get("workYears");
                if(target.getWorkYears()>jobRequestWorkYears){
                    returnJob.add(job);
                }
            }
        }
        return returnJob;
    }

    public Object getInstance(Person target){
        this.target = target;
        Class<? extends Person> clazz = target.getClass();
        Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return proxy;
    }

    /**
     * 代理对象之后，调用对象的任何方法其实都会执行这个代理对象的invoke方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始帮助"+target.getName()+"寻找工作");
        List<Job> jobs = findJobs();
        System.out.println("工作已经筛选好了，可以把工作交给"+target.getName()+"挑选想要去面试的工作了");
        System.out.println("--------------------------------");
        Object result;
        if(method.getName().equals("findWork")){
            result = method.invoke(this.target,jobs);
        }else{
            result = method.invoke(this.target,args);
        }
        System.out.println("--------------------------------");
        System.out.println(target.getName()+"已经挑选了工作去面试了，作为代理我的工作告一段落了");
        return result;
    }
}
