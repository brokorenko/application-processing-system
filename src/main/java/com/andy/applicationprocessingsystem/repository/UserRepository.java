package com.andy.applicationprocessingsystem.repository;

import com.andy.applicationprocessingsystem.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
