package com.andy.applicationprocessingsystem.service;

import com.andy.applicationprocessingsystem.model.Application;
import com.andy.applicationprocessingsystem.model.Statistics;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ApplicationService {
    void registerApplication(Application application);
    String checkApplicationStatus(Long id);
    List<Application> getAllApplications();
    void changeApplicationStatus(Long id, String status);
    List<Statistics> getApplicationStatistics();
}
