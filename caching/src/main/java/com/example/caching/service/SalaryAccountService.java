package com.example.caching.service;

import com.example.caching.entity.Employee;
import com.example.caching.entity.SalaryAccount;

public interface SalaryAccountService {
    void createAccount(Employee employee);

    SalaryAccount incrementBalance(Long accountId);
}