package bean;

import java.util.Arrays;

public class Diaos {
     String name;
     String school;
     boolean has_girlfriend;
     double age;
     Object car;
     Object house;
     String[] major;
     String comment;
     String birthday;

    public void setName(String name){
            this.name = name;
    }
    public void setAge(Double age){
        this.age = age;
    }
    public void setHas_girlfriend(boolean has_girlfriend){
        this.has_girlfriend=has_girlfriend;
    }
    public void setSchool(String school){
        this.school = school;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public void setMajor(String[] major){
        this.major=major;
        //System.arraycopy(major,0,this.major,0,major.length);
    }
        public void setCar(Object car){
        this.car = car;
    }
    public void setHouse(Object house){
        this.house = house;
    }
    public String getName(){
        return name;
    }
    public String getSchool(){
        return school;
    }
    public String getComment(){
        return comment;
    }
    public boolean isHas_girlfriend(){
        return has_girlfriend;
    }
    public String getBirthday(){
        return birthday;
    }
    public Object getHouse(){
        if (house==null) {
            return "null";
        }
        else {
            return house;
        }
    }
    public Object getCar(){
        if(car == null){
            return "null";
        }
        else{
            return car;
        }
    }
    public String toString() {

        return "People [name=" + name + ", major=" + Arrays.toString(major) + ", has_girlfriend=" + has_girlfriend

                + ", age=" + age + ", house=" + house + ", birthday=" + birthday + ", comment=" + comment + ", school="

                + school + "]";

    }
}
