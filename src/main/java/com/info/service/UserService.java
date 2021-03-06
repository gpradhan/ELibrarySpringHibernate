package com.info.service;

import java.util.List;

import com.info.model.MyUser;

public interface UserService {
	
	MyUser findByUserAndPassword(MyUser user);

	void save(MyUser myUser);
	
	public List<MyUser> userList();
	
	MyUser findById(Integer id);

	void update(MyUser myUser);

	void delete(Integer id);
	   
}
