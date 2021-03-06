package com.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.dao.BookDao;
import com.info.dao.IssueBookDao;
import com.info.model.Book;
import com.info.model.IssueBook;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private IssueBookDao issueBookDao;

	@Transactional(readOnly = true)
	public Book getBookById(Integer id) {
		return bookDao.getBookById(id);
	}

	@Transactional
	public void save(Book book) {
		bookDao.save(book);
	}

	@Transactional(readOnly = true)
	public List<Book> bookList() {
		// TODO Auto-generated method stub
		return bookDao.getListByQuery("from Book b", null);
	}

	@Transactional(readOnly = false)
	public int delete(Integer id) {
		bookDao.deleteById(id);
		return 0;
	}

	@Transactional(readOnly = true)
	public int getIssued(int callno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional(readOnly = true)
	public boolean checkIssue(int callno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional(readOnly = false)
	public void issueBook(IssueBook issueBook) {
		Object[] params = new Object[2];
		params[0] = issueBook.getBookNo();
		params[1] = issueBook.getStudentid();
		// find the issueBook record from DB
		IssueBook issueBook2 = issueBookDao
				.getSingleResultByQuery("from IssueBook b where b.bookId.id=? and b.studentid=?", params);
		Book book = bookDao.getBookById(issueBook.getBookNo());
		book.setQuantity(book.getQuantity() - 1);
		book.setIssued(book.getIssued() + 1);
		bookDao.update(book);
		if (issueBook2 == null) {
			issueBook.setBookId(book);
			issueBook.setIssued(1);
			issueBookDao.save(issueBook);
		} else {
			issueBook2.setBookId(book);
			issueBook2.setIssued(issueBook2.getIssued() + 1);
			issueBookDao.update(issueBook2);
		}
	}

	@Transactional(readOnly = false)
	public void returnBook(IssueBook issueBook) {
		Object[] params = new Object[2];
		params[0] = issueBook.getBookNo();
		params[1] = issueBook.getStudentid();
		// find the issueBook record from DB
		IssueBook issueBook2 = issueBookDao
				.getSingleResultByQuery("from IssueBook b where b.bookId.id=? and b.studentid=?", params);
		if (issueBook2 != null) {
			Book book = bookDao.getBookById(issueBook.getBookNo());
			book.setQuantity(book.getQuantity() + 1);
			book.setIssued(book.getIssued() - 1);
			bookDao.update(book);
			if (issueBook2.getReturned() != null)
				issueBook2.setReturned(issueBook2.getReturned() + 1);
			else
				issueBook2.setReturned(1);
			issueBookDao.save(issueBook2);
		}

	}

	@Transactional(readOnly = false)
	public void update(Book book) {
		bookDao.update(book);
	}

	@Transactional(readOnly = false)
	public void save(IssueBook issueBook) {
		// retrieve book information
		Book book = getBookById(issueBook.getBookNo());
		// only one book is issued per student
		book.setQuantity(book.getQuantity() - 1);
		book.setIssued(book.getIssued() + 1);
		update(book);
		issueBook.setBookId(book);
		issueBookDao.save(issueBook);
	}

	@Transactional(readOnly = true)
	public List<IssueBook> issueBookList() {
		return issueBookDao.getListByQuery("from IssueBook b", null);
	}

	@Transactional(readOnly = false)
	public void update(IssueBook issueBook) {
		// IssueBook issueBook2 = issueBookDao.getSingleResultByQuery("from IssueBook b
		// where b.book.id=? and b.studentid=?");
		Book book = bookDao.getBookById(issueBook.getBookId().getId());
		book.setQuantity(book.getQuantity() + 1);
		bookDao.update(book);
		issueBookDao.update(issueBook);
	}

}
