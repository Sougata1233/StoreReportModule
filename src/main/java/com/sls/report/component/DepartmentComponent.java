package com.sls.report.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sls.report.entity.Department;
import com.sls.report.repository.DepartmentRepository;

@Component
public class DepartmentComponent {

	@Autowired
	DepartmentRepository deptRepo;
	
	@Transactional
	public Department getDepartmentByDeptId(long deptId){
		return deptRepo.findOne(deptId);
	}
	
	@Transactional
	public List<Department> getAllDepartment(){
		return deptRepo.findAll();
	}
	
}
