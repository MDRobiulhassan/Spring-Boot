package com.springweb.SpringWeb.repository;

import com.springweb.SpringWeb.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}

