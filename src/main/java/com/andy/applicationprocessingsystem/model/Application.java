package com.andy.applicationprocessingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Application {

    public static String UNCHECKED = "UNCHECKED";
    public static String REJECT = "REJECT";
    public static String DONE = "DONE";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String request;
    private Integer bid;
    private Date dueDate;
    private String status = UNCHECKED;

    public Application() {
    }

    public Application(String request, Integer bid, Date dueDate) {
        this.request = request;
        this.bid = bid;
        this.dueDate = dueDate;
    }

    public Application(String request, Integer bid, Date dueDate, String status) {
        this.request = request;
        this.bid = bid;
        this.dueDate = dueDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
