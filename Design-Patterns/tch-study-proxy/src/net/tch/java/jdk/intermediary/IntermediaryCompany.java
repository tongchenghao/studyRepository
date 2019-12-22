package jdk.intermediary;

import jdk.job.Job;

import java.util.List;

/**
 * @description:中介公司接口
 * @auth tongchenghao
 * @date 2019/12/22
 */
public interface IntermediaryCompany {

    public String getName();

    public void setName(String name);

    public String getScale();

    public void setScale(String scale);

    List<Job> getResourceRepository();

    void setResourceRepository(List<Job> resourceRepository);

    List<Job> findJobs();
}
