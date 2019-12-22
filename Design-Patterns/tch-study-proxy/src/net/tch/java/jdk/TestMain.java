package jdk;

import jdk.intermediary.Aigongzuo;
import jdk.candidates.Person;
import jdk.candidates.Tongchenghao;
import jdk.job.Job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:测试主方法
 * @auth tongchenghao
 * @date 2019/12/22
 */
public class TestMain {
    public static void main(String[] args) {
        List<Job> jobsResposity = new ArrayList<>();
        Map<String,Object> map = null;

        map = new HashMap<>();
        map.put("workYears",10);
        Job job1 = new Job("百度","开发",15, map);
        jobsResposity.add(job1);

        map = new HashMap<>();
        map.put("workYears",5);
        Job job2 = new Job("阿里","美工",10, map);
        jobsResposity.add(job2);

        map = new HashMap<>();
        map.put("workYears",3);
        Job job3 = new Job("腾讯","测试",20, map);
        jobsResposity.add(job3);

        map = new HashMap<>();
        map.put("workYears",8);
        Job job4 = new Job("字节跳动","策划",12, map);
        jobsResposity.add(job4);

        map = new HashMap<>();
        map.put("workYears",9);
        Job job5 = new Job("新浪","运维",13, map);
        jobsResposity.add(job5);

        Aigongzuo aigongzuo = new Aigongzuo(jobsResposity);

        Tongchenghao tongchenghao = new Tongchenghao();
        Map<String, Object> myIndicator = new HashMap<>();
        myIndicator.put("compensation",14);
        tongchenghao.setIndicator(myIndicator);

        Person person = (Person) aigongzuo.getInstance(tongchenghao);
        person.findWork(null);


    }
}
