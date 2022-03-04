package com.example.SpringBootDemo.services;

import java.util.List;


import com.example.SpringBootDemo.model.UserModel;

public interface UserServices {

	UserModel saveEmployee(UserModel user);

	List<UserModel> userList();

	UserModel userData(int id);
	
	UserModel updateUser(UserModel model, int id);

	void deletUser(int id);

}
