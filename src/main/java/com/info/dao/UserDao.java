package com.info.dao;

import java.util.List;

import com.info.model.MyUser;

public interface UserDao { 

	MyUser findById(int id);
	
	MyUser findByUserAndPassword(MyUser user) ;

	void save(MyUser myUser);

	List<MyUser> getListByQuery(String string, Object... params);

	MyUser getSingleResultByQuery(String hql, Object... params);
	
}

