package com.info.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.info.model.IssueBook;
import com.info.service.BookService;

@Repository("issueBookDao")
public class IssueBookDaoImpl extends AbstractDao<Integer, IssueBook> implements IssueBookDao {

	// @Autowired
	// private SessionFactory sessionFactory;

	@Autowired
	private BookService bookService;

	public IssueBook getBookById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(IssueBook issueBook) {
		persist(issueBook);
	}

}