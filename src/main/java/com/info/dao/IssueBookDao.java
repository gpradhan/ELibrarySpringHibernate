package com.info.dao;

import java.util.List;

import com.info.model.IssueBook;

public interface IssueBookDao {
	
	void save(IssueBook issueBook);

	IssueBook getBookById(Integer id);

	void update(IssueBook book);
	
	public IssueBook getSingleResultByQuery(String hql, Object... params);
	
	public List<IssueBook> getListByQuery(String hql, Object... params);
}