package jdk.job;

import java.util.Map;

/**
 * @description:
 * @auth tongchenghao
 * @date 2019/12/22
 */
public class Job {

    String company;

    String position;

    //薪资
    int compensation;

    //要求指标
    Map<String ,Object> indicator;

    public Job() {
    }

    public Job(String company, String position, int compensation, Map<String, Object> indicator) {
        this.company = company;
        this.position = position;
        this.compensation = compensation;
        this.indicator = indicator;
    }

    public int getCompensation() {
        return compensation;
    }

    public void setCompensation(int compensation) {
        this.compensation = compensation;
    }

    public Map<String, Object> getIndicator() {
        return indicator;
    }

    public void setIndicator(Map<String, Object> indicator) {
        this.indicator = indicator;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
