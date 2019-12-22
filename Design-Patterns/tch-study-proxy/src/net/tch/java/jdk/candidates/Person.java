package jdk.candidates;

import jdk.job.Job;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @auth tongchenghao
 * @date 2019/12/22
 */
public interface Person {


    String getName();

    void setName(String name);

    String getSex();

    void setSex(String sex);

    Map<String, Object> getIndicator();

    void setIndicator(Map<String, Object> indicator);

    int getWorkYears();

    void setWorkYears(int workYears);

    Job findWork(List<Job> jobs);
}
