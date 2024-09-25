package com.example.library_management.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book1234")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int bid;
    String bname;
    String btype;
    String bprice;

    public Book() {
    }

    public Book(int bid, String bname, String btype, String bprice) {
        this.bid = bid;
        this.bname = bname;
        this.btype = btype;
        this.bprice = bprice;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getBprice() {
        return bprice;
    }

    public void setBprice(String bprice) {
        this.bprice = bprice;
    }

    @Override
    public String toString() {
        return "Book [bid=" + bid + ", bname=" + bname + ", btype=" + btype + ", bprice=" + bprice + "]";
    }

}
