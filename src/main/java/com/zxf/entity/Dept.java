package com.zxf.entity;

import java.io.Serializable;

public class Dept implements Serializable {

    private String deptId;

    private String deptCode;

    private String deptName;

    public Dept() {
    }

    public Dept(String deptId, String deptCode, String deptName) {
        this.deptId = deptId;
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId='" + deptId + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
