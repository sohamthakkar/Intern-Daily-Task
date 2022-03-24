package com.example.SpringBootDemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootDemo.customexception.ResourceNotFound;
import com.example.SpringBootDemo.dao.UserDao;
import com.example.SpringBootDemo.model.UserModel;

@Service
public class UserServicesImp implements UserServices{

	
	@Autowired
	private UserDao userDao;

	@Override
	public UserModel saveEmployee(UserModel user) {
		UserModel userData = userDao.save(user);
		return userData;
	}		

	@Override
	public List<UserModel> userList() {
		return userDao.findAll();
	}

	@Override
	public UserModel userData(int id) {
		Optional<UserModel> user = userDao.findById(id);
		
		if(user.isPresent()) {
			return user.get();	
		}else {
			System.out.println("User Not Available");
		}
		return null;
		
	}

	@Override
	public UserModel updateUser(UserModel model, int id) {
		
		//if exist or not
		UserModel userModel = userDao.findById(id).orElseThrow(() -> new ResourceNotFound("User not found with id :"  + id));		
		userModel.setFname(model.getFname());
		userModel.setLname(model.getLname());
		userModel.setMobile(model.getMobile());
		model.setEmail(userModel.getEmail());
		
		//save exisiting employee in db
		return userDao.save(userModel);
		
		
//		return userModel;
	}

	@Override
	public void deletUser(int id) {
		
		userDao.findById(id).orElseThrow(() -> new ResourceNotFound("User not found with id :" + id));
		
		userDao.deleteById(id);
		
	}

	


	

}
