package com.bj.genealogy.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * 人员实体类
 */
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    //姓名
    @Column(name = "name")
    private String name;
    //生日
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    //性别
    @Column(name = "sex")
    private Integer sex;
    //手机
    @Column(name = "phone")
    private String phone;
//    //国
//    @Column(name = "country")
//    private String country;
    //省
    @Column(name = "province")
    private String province;
    //市
    @Column(name = "city")
    private String city;
    //县
    @Column(name = "county")
    private String county;
    //父ID
    @Column(name = "pid")
    private Integer pid;
//    //母亲
//    @Column(name = "mid")
//    private Integer mid;
    //第几代
    @Column(name = "sequence")
    private Integer sequence;
    //备注
    @Column(name = "remarks")
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAge() {
        Date now = new Date();
        return now.getYear()-birthday.getYear();
    }

    public String getPhone() {
        if(phone==null){
            return phone;
        }else {
            return "";
        }
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getSex() {
        return sex;
    }
    public String getSexStr() {
        if(sex==0){
            return "男";
        }else{
            return "女";
        }

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
