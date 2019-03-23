package com.bj.genealogy.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * 人员实体类
 */
@Entity
@Table(name = "templates/person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer categoryid;
    //姓名
    @Column(name = "name")
    private String name;
    //生日
    @Column(name = "birthday")
    private Date birthday;
    //性别
    @Column(name = "sex")
    private Integer sex;
    //父ID
    @Column(name = "pid")
    private Integer pid;
    //第几代
    @Column(name = "sequence")
    private Integer sequence;
    //备注
    @Column(name = "remarks")
    private String remarks;

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
