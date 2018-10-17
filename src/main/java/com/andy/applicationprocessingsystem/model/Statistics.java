package com.andy.applicationprocessingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Statistics {
    @Id
    private String status;
    private Integer applicationNumber;

    public Statistics() {
    }

    public Statistics(String status, Integer applicationNumber) {
        this.status = status;
        this.applicationNumber = applicationNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(Integer applicationNumber) {
        this.applicationNumber = applicationNumber;
    }
}
