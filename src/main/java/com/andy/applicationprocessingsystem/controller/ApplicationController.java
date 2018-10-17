package com.andy.applicationprocessingsystem.controller;

import com.andy.applicationprocessingsystem.model.Application;
import com.andy.applicationprocessingsystem.model.Statistics;
import com.andy.applicationprocessingsystem.service.ApplicationService;
import com.andy.applicationprocessingsystem.service.impl.ApplicationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    private ApplicationService applicationService;

    public ApplicationController(ApplicationServiceImpl applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping("/registerApplication")
    public void registerApplication(@RequestBody Application application) {
        applicationService.registerApplication(application);
    }

    @RequestMapping("/checkApplicationStatus/{id}")
    public String checkApplicationStatus(@PathVariable Long id){
        return applicationService.checkApplicationStatus(id);
    }

    @RequestMapping("/getApplications")
    public List<Application> getApplications(){
        return applicationService.getAllApplications();
    }

    @RequestMapping("/changeApplicationStatus/{id}/{status}")
    public void getApplications(@PathVariable Long id,@PathVariable String status){
        applicationService.changeApplicationStatus(id, status);
    }

    @RequestMapping("/getApplicationStatistics")
    public List<Statistics> getApplicationStatistics(){
        return applicationService.getApplicationStatistics();
    }
}
