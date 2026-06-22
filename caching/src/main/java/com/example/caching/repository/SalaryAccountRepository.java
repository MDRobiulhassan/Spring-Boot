package com.example.caching.repository;

import com.example.caching.entity.SalaryAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SalaryAccountRepository extends CrudRepository<SalaryAccount, Long> {
    Optional<SalaryAccount> findById(Long id);
}