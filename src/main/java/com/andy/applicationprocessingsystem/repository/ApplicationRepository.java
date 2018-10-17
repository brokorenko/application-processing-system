package com.andy.applicationprocessingsystem.repository;

import com.andy.applicationprocessingsystem.model.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
