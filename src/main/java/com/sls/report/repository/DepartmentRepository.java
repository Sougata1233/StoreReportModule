package com.sls.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.report.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
