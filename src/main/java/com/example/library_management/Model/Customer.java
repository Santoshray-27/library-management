package com.example.library_management.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer1234")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int cid;
    String cname;
    String cbook;
    String cphone;

    public Customer() {
    }

    public Customer(int cid, String cname, String cbook, String cphone) {
        this.cid = cid;
        this.cname = cname;
        this.cbook = cbook;
        this.cphone = cphone;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCbook() {
        return cbook;
    }

    public void setCbook(String cbook) {
        this.cbook = cbook;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    @Override
    public String toString() {
        return "Customer [cid=" + cid + ", cname=" + cname + ", cbook=" + cbook + ", cphone=" + cphone + "]";
    }
}
