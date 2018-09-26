package com.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.dao.AbstractDao;
import com.info.dao.UserDao;
import com.info.dao.UserDaoImpl;
import com.info.model.Book;
import com.info.model.MyUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AbstractDao<Integer, MyUser> userDao;

	@Transactional(readOnly = true)
	public MyUser findByUserAndPassword(MyUser user) {
		return ((UserDao) userDao).findByUserAndPassword(user);
	}

	@Transactional(readOnly = false)
	public void save(MyUser myUser) {
		userDao.persist(myUser);
	}

	@Transactional(readOnly = true)
	public List<MyUser> userList() {
		// TODO Auto-generated method stub
		return userDao.getListByQuery("from MyUser u", null);
	}

	@Transactional(readOnly = true)
	public MyUser findById(Integer id) {
		return userDao.getByKey(id);
	}

	@Transactional(readOnly = false)
	public void update(MyUser myUser) {
		userDao.update(myUser);
		
	}

	@Transactional(readOnly = false)
	public void delete(Integer id) {
		userDao.deleteById(id);
		
	}

}
