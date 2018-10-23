package com.andy.applicationprocessingsystem.service.impl;

import com.andy.applicationprocessingsystem.model.Application;
import com.andy.applicationprocessingsystem.model.Statistics;
import com.andy.applicationprocessingsystem.repository.ApplicationRepository;
import com.andy.applicationprocessingsystem.repository.StatisticsRepository;
import com.andy.applicationprocessingsystem.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;
    private StatisticsRepository statisticsRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, StatisticsRepository statisticsRepository) {
        this.applicationRepository = applicationRepository;
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public void registerApplication(Application application) {
        applicationRepository.save(application);
        Integer uncheckedCount = getCountInStatistics(Application.UNCHECKED);
        setCountInStatistics(Application.UNCHECKED, ++uncheckedCount);
    }

    @Override
    public String checkApplicationStatus(Long id) {
        Optional<Application> application = applicationRepository.findById(id);
        String status = Application.UNCHECKED;
        if (application.isPresent()) {
            status = application.get().getStatus();
        }
        return status;
    }

    @Override
    public List<Application> getAllApplications() {
        List<Application> l = new ArrayList<>();
        Iterator i = applicationRepository.findAll().iterator();
        while (i.hasNext()) {
            l.add((Application) i.next());
        }
        return l;
    }

    @Override
    public void changeApplicationStatus(Long id, String status) {
        Optional<Application> application = applicationRepository.findById(id);
        if (application.isPresent()) {
            Application a = application.get();

            setCountInStatistics(a.getStatus(), getCountInStatistics(a.getStatus()) - 1);
            setCountInStatistics(status, getCountInStatistics(status) - 1);

            a.setStatus(status);
        }
    }

    @Override
    public List<Statistics> getApplicationStatistics() {
        Iterator<Statistics> statisticsIterator = statisticsRepository.findAll().iterator();
        List<Statistics> statistics = new ArrayList<>();

        while (statisticsIterator.hasNext()) {
            statistics.add(statisticsIterator.next());
        }

        return statistics;
    }

    private Integer getCountInStatistics(String status) {
        return statisticsRepository.findById(status).get().getApplicationNumber();
    }

    private void setCountInStatistics(String status, Integer newApplicationNumber) {
        statisticsRepository.save(new Statistics(status, newApplicationNumber));
    }
}
