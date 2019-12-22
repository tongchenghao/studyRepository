package jdk.candidates;

import jdk.job.Job;

import java.util.List;
import java.util.Map;

/**
 * @description:我叫童诚浩，我要找工作
 * @auth tongchenghao
 * @date 2019/12/22
 */
public class Tongchenghao implements Person {

    String name = "童诚浩";
    String sex = "男";

    //工作年限
    int workYears = 20;
    //要求指标
    Map<String, Object> indicator;

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getSex() {
        return sex;
    }
    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public Map<String, Object> getIndicator() {
        return indicator;
    }
    @Override
    public void setIndicator(Map<String, Object> indicator) {
        this.indicator = indicator;
    }
    @Override
    public int getWorkYears() {
        return workYears;
    }
    @Override
    public void setWorkYears(int workYears) {
        this.workYears = workYears;
    }

    @Override
    public Job findWork(List<Job> jobs){
        System.out.println("我叫"+name);
        System.out.println("我开始挑选工作了");
        System.out.println("我可以从以下工作中挑选：\n");

        int i = 0;
        for (Job job :
                jobs) {
            System.out.println("这是第"+(i+1)+"份工作");
            System.out.println("工作单位："+job.getCompany());
            System.out.println("工作名称："+job.getPosition());
            System.out.println();
            i++;
        }
        System.out.println("我浏览的所有的工作");

        int myJobIndex = (int) Math.floor(Math.random()*(jobs.size()));
        System.out.println("挑选了第"+(myJobIndex+1)+"份工作");

        return jobs.get(myJobIndex);
    }


}
