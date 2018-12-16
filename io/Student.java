package io;

import java.io.Serializable;

public class Student implements Serializable {
    private String stuno;
    private String stuname;
    private int stuage;

    public Student(String stuno,String stuname,int stuage) {
        super();
        this.stuno = stuno;
        this.stuname=stuname;
        this.stuage=stuage;
    }

    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                '}';
    }

    public String getStuno() {
        return stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }
}
