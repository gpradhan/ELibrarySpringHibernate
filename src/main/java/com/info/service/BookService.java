package com.info.service;

import java.util.List;

import com.info.model.Book;
import com.info.model.IssueBook;

public interface BookService {

	Book getBookById(Integer id);

	void save(Book book);

	List<Book> bookList();

	int delete(Integer id);

	int getIssued(int callno);

	boolean checkIssue(int callno);

	void issueBook(IssueBook issueBook);

	void returnBook(IssueBook issueBook);

	void update(Book book);
	
	void save(IssueBook issueBook);
	
	List<IssueBook> issueBookList();
	
	void update(IssueBook issueBook);

}
