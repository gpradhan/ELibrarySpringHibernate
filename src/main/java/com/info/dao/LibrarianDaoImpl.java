package com.info.dao;

import org.springframework.stereotype.Repository;

import com.info.model.Librarian;
import com.info.model.MyUser;

@Repository("librarianDao")
public class LibrarianDaoImpl extends AbstractDao<Integer, Librarian> implements LibrarianDao {

}
