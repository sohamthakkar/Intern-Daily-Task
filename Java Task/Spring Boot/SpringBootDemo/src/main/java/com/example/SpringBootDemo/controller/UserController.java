package com.example.SpringBootDemo.controller;

import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.validation.Valid;

import com.example.SpringBootDemo.dao.UserDao;
import com.example.SpringBootDemo.services.UserServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.SpringBootDemo.model.UserModel;
import com.example.SpringBootDemo.services.UserServices;

@RestController
@RequestMapping("/demo")
public class UserController {
	
	@Autowired
	private UserServices userServices;

	@Autowired
	private UserDao userDao;
	
	@GetMapping("/normal/login")
	public String loginUser() {
		return "Welcome to Login PAge";
		
	}
	
	@GetMapping("/admin/login")
	public String loginAdmin() {
		return "Welcome to Admin Login PAge";
		
	}
	

	@PostMapping("/api/user")
	public UserModel saveEmployee(@Valid @RequestBody UserModel user){
//		UserServices userSer = new UserServicesImp();
//		userSer.saveEmployee(user);
		//userDao.save(user);
		return userServices.saveEmployee(user);
	}

	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/api/user")
	public List<UserModel> showUser(){
		return userServices.userList();
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	//using antotation without passing any bean config i removedthen bean wehere i assigned role in AuthConfig file
	@GetMapping("/api/user/{id}")
	public UserModel singleUser(@PathVariable("id") int userId ) {
		return userServices.userData(userId);
	}
	
	@PutMapping("/api/user/{id}")
	public  UserModel updateData(@PathVariable("id") int userId, @Valid @RequestBody UserModel model) {
		return userServices.updateUser(model, userId);
	}
	
	@DeleteMapping("/api/user/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		userServices.deletUser(id);
		return new ResponseEntity<String>("User deleted Successfully", HttpStatus.OK);
	}
}













