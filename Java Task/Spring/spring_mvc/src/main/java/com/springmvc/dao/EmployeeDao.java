package com.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.springmvc.vo.Employee;

/*@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}*/

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
}