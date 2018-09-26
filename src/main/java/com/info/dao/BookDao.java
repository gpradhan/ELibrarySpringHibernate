package com.info.dao;

import java.util.List;

import com.info.model.Book;

public interface BookDao {
	void save(Book book);
	
	void deleteById(Integer id);

	Book getBookById(Integer id);

	void update(Book book);
	
	public List<Book> getListByQuery(String hql, Object... params);

	public Book getSingleResultByQuery(String hql, Object... params);
}