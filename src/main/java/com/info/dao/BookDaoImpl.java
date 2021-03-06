package com.info.dao;

import org.springframework.stereotype.Repository;

import com.info.model.Book;

@Repository("bookDao")
public class BookDaoImpl extends AbstractDao<Integer, Book> implements BookDao {

//	@Autowired
//	private SessionFactory sessionFactory;

//	public List<Book> getBooklist() {
////		@SuppressWarnings("unchecked")
////		TypedQuery<Book> query = getSession().createQuery("select b from Book b");
//		return getListByQuery("select b from Book b");
//	}

	public void save(Book book) {
		persist(book);
	}

	public void deleteById(Integer id) {
		try {
			Book book = getByKey(id);
			if (null != book) {
				delete(book);
			}
		} catch (Exception e) {
			// valid case do nothing
		}
	}

	public Book getBookById(Integer id) {
//		return (Book) getSession().get(Book.class, id);
		return getByKey(id);
	}
	
	public void update(Book book) {
		if(book.getId() !=null ) {
		Book book1 = getBookById(book.getId());
		book1.updateDataFromUI(book);
		super.update(book1);
		}
	}


}