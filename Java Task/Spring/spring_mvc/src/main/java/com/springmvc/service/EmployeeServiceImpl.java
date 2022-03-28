package com.springmvc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.EmployeeDao;
import com.springmvc.vo.Employee;

@Service

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired(required = true)
	private EmployeeDao employeeDao;

	@Transactional
	public void doInsert(Employee employee) {

		this.employeeDao.saveAndFlush(employee);

	}

	public List<Employee> doSearch() {

		List<Employee> empList = (List<Employee>) employeeDao.findAll();
		System.out.println(empList);
		return empList;

	}

	public void doDelete(Integer deleteId) {

		employeeDao.deleteById(deleteId);

	}

	public Optional<Employee> doEdit(Integer editId) {

		Optional<Employee> editEmployee = employeeDao.findById(editId);
		return editEmployee;
	}
	/*
	 * public void doUpdate(Employee employee) {
	 * 
	 * this.employeeDao.save(employee);
	 * 
	 * }
	 */
}
