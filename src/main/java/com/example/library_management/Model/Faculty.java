package com.example.library_management.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty1234")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int fid;
    String fname;
    String femail;
    String fsalary;

    public Faculty() {
    }

    public Faculty(int fid, String fname, String femail, String fsalary) {
        this.fid = fid;
        this.fname = fname;
        this.femail = femail;
        this.fsalary = fsalary;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFemail() {
        return femail;
    }

    public void setFemail(String femail) {
        this.femail = femail;
    }

    public String getFsalary() {
        return fsalary;
    }

    public void setFsalary(String fsalary) {
        this.fsalary = fsalary;
    }

    @Override
    public String toString() {
        return "Faculty [fid=" + fid + ", fname=" + fname + ", femail=" + femail + ", fsalary=" + fsalary + "]";
    }

}
