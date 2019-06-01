package com.lky.one.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.lky.one.dao.DB_Book;
import com.lky.one.domain.Book;

/**
 * Session Bean implementation class SearchByStateless
 */
@Stateless
@LocalBean
public class SearchByStateless {

	/**
	 * Default constructor.
	 */
	public SearchByStateless() {
		// TODO Auto-generated constructor stub
	}

	public List<Book> findAllBooks() throws SQLException {

		DB_Book db_Book = new DB_Book();
		List<Book> allBooks = db_Book.findAllBooks();
		return allBooks;
	}

}
