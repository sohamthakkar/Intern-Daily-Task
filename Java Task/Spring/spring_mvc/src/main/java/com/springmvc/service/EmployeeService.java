package com.springmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springmvc.vo.Employee;

@Service
public interface EmployeeService {

	public void doInsert(Employee employee);

	public List<Employee> doSearch();

	public void doDelete(Integer id);

	public Optional<Employee> doEdit(Integer editId);

/*	public void doUpdate(Employee employee);*/

}
