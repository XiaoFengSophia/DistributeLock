package com.zxf.entity;

import java.io.Serializable;

public class Emp implements Serializable {

    private String empId;
    private String empCode;
    private String empName;

    public Emp() {
    }

    public Emp(String empId, String empCode, String empName) {
        this.empId = empId;
        this.empCode = empCode;
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId='" + empId + '\'' +
                ", empCode='" + empCode + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
