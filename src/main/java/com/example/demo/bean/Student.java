package com.example.demo.bean;

public class Student {
    private String id;
    private String name;
    private String subject;
    private Integer result;


    public String getid() {
        return id;
    }

    public void setid(String Id) {
        id = Id;
    }

    public String getname() { return name; }

    public void setname(String Name) {
        name = Name;
    }

    public String getsubject() {
        return subject;
    }

    public void setsubject(String Subject) {
        subject = Subject;
    }

    public Integer getresult() {
        return result;
    }

    public void setresult(Integer Result) {
        result = Result;
    }


    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", subject=" + subject +
                ", result=" + result +
                ", name=" + name +
                "}";
    }


}
