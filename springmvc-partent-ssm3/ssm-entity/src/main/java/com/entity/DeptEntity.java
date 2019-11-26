package com.entity;

public class DeptEntity {
    private Integer id;
    private String deptname;
    private String birthday;

    @Override
    public String toString() {
        return "DeptEntity{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public DeptEntity() {
    }

    public DeptEntity(String deptname, String birthday) {
        this.deptname = deptname;
        this.birthday = birthday;
    }
}
