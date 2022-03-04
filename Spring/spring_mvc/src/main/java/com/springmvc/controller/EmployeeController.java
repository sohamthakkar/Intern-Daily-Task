package com.springmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.service.EmployeeService;
import com.springmvc.service.StateService;
import com.springmvc.vo.Employee;
import com.springmvc.vo.State;

//controller
@Controller
public class EmployeeController {

	@Autowired(required = true)
	private EmployeeService employeeService;

	@Autowired(required = true)
	private StateService stateService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView load() {

		List<State> state = stateService.doSearch();

		// Here, Make a new object and send value as an object.
		return new ModelAndView("register", "key", new Employee()).addObject("State", state);

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView doInsert(@ModelAttribute Employee employee, HttpServletResponse response) throws IOException {

		String emailPattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		String passwordPattern = "^(?=.*[0-9])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

		PrintWriter out = response.getWriter();

		if (employee.getFirstName().isEmpty()) {

			out.println("Enter Firstname...");

		} else if (employee.getLastName().isEmpty()) {

			out.println("Enter Lastname....");

		} else if (!(employee.getCred().getEmailAddress().matches(emailPattern))) {

			out.println("Enter valid emailAddress....");

		} else if (!(employee.getCred().getPassword().matches(passwordPattern))) {

			out.println("Enter valid password....");

		} else {

			this.employeeService.doInsert(employee);

			out.println("Data inserted successfully....");
		}

		return new ModelAndView("register", "key", new Employee());
	}

	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView doSearch() {

		//Get all employee.
		List<Employee> empList = employeeService.doSearch();

		System.out.println(empList);

		return new ModelAndView("display", "EmpList", empList);
	}

	//Delete Employee.
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView doDelete(@RequestParam(value = "id") Integer deleteId) {

		employeeService.doDelete(deleteId);
		List<Employee> empList = employeeService.doSearch();

		return new ModelAndView("display", "EmpList", empList);
	}

	//Edit Employee
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView getAll(@RequestParam(value = "id") Integer editId) {

		Optional<Employee> edit = employeeService.doEdit(editId);
		List<State> state = stateService.doSearch();
		return new ModelAndView("register", "key", edit).addObject("State", state);
	}

	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.POST) public
	 * ModelAndView doUpdate(@ModelAttribute Employee employee) {
	 * 
	 * this.employeeService.doUpdate(employee);
	 * 
	 * return new ModelAndView("updateEmployee", "key", new Employee()); }
	 */
}
