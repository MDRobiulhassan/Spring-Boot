package com.example.caching.serviceimpl;

import com.example.caching.entity.Employee;
import com.example.caching.entity.SalaryAccount;
import com.example.caching.repository.SalaryAccountRepository;
import com.example.caching.service.SalaryAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class SalaryAccountServiceImpl implements SalaryAccountService {

    private final SalaryAccountRepository salaryAccountRepository;

    @Override
    public void createAccount(Employee employee) {

        SalaryAccount salaryAccount = SalaryAccount.builder()
                .balance(BigDecimal.ZERO)
                .build();

        salaryAccountRepository.save(salaryAccount);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public SalaryAccount incrementBalance(Long accountId) {
        SalaryAccount salaryAccount = salaryAccountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Salary account not found with id: " + accountId));

        BigDecimal prevBalance = salaryAccount.getBalance();
        BigDecimal newBalance = prevBalance.add(BigDecimal.valueOf(1L));

        salaryAccount.setBalance(newBalance);
        return salaryAccountRepository.save(salaryAccount);
    }
}