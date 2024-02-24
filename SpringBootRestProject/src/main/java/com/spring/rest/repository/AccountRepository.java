package com.spring.rest.repository;

import com.spring.rest.models.Account;
import jdk.jfr.Registered;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
