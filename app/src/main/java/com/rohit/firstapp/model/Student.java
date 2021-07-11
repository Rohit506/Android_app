package com.rohit.firstapp.model;

public class Student {
    private String sname;
    private int roll;
    private String branch;
    private int age;
    private String imageurl;

    public Student()
    {

    }
    public Student(String sname, int roll, String branch, int age, String imageurl) {
        this.sname = sname;
        this.roll = roll;
        this.branch = branch;
        this.age = age;
        this.imageurl = imageurl;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
