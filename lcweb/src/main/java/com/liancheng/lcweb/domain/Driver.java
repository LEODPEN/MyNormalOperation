package com.liancheng.lcweb.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Driver {

    //初步内容
    @Id
    private String id;

    @NotNull(message = "电话号码不能为空")
    private String dnum;

    @NotNull(message = "password 不为空")
    private String password;

    @NotNull(message = "车牌号")
    private String carNum;

    @NotNull(message = "选择所属路线")
    private String line;

    private String name;
    private Integer age;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDnum() {
        return dnum;
    }

    public void setDnum(String dnum) {
        this.dnum = dnum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", dnum='" + dnum + '\'' +
                ", password='" + password + '\'' +
                ", carNum='" + carNum + '\'' +
                ", line='" + line + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
