package com.lky.one.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lky.one.domain.Book;
import com.lky.one.domain.Book2;
import com.lky.one.domain.User;
import com.lky.one.utils.DB_Conn;

public class DB_Book {

	public void addBook(Book book) throws SQLException {
		// 添加图书
		String sql = "insert into books values( ? , ? , ? , ? , ? , ? , ? )";
		QueryRunner qr = new QueryRunner(DB_Conn.getDataSource());
		Object[] params = { book.getBname(), book.getBnum(),
				Arrays.toString(book.getAuthers()).substring(1, Arrays.toString(book.getAuthers()).length() - 1),
				book.getPubDate(), book.getPrice(), book.getKind(), book.getBid() };
		qr.update(sql, params);
	}

	public void deleteBookByBnum(User user) throws SQLException {
		// 删除图书
		String sql = "delete from users where uid = ?";
		QueryRunner qr = new QueryRunner(DB_Conn.getDataSource());
		Object[] params = { user.getUname() };
		qr.update(sql, params);
	}

	public List<Book> findAllBooks() throws SQLException {
		// 查找所有图书
		String sql = "select * from books";
		QueryRunner qr = new QueryRunner(DB_Conn.getDataSource());
		List<Book2> sourses = qr.query(sql, new BeanListHandler<Book2>(Book2.class));
		List<Book> result = new LinkedList<Book>();
		for (Book2 book2 : sourses) {
			Book tempbook = new Book(book2.getBname(), book2.getBnum(), book2.getAuthers(), book2.getPubDate(),
					book2.getPrice(), book2.getKind(), book2.getBid(), book2.getSubKind());
			result.add(tempbook);
		}
		return result;
	}

	public Book findBookByBnum(Book book) throws SQLException {
		// 查找图书
		String sql = "select * from books where bnum = ?";
		QueryRunner qr = new QueryRunner(DB_Conn.getDataSource());
		Book2 book2 = qr.query(sql, new BeanHandler<Book2>(Book2.class), book.getBnum());
		if (book2 != null) {
			Book result = new Book(book2.getBname(), book2.getBnum(), book2.getAuthers(), book2.getPubDate(),
					book2.getPrice(), book2.getKind(), book2.getBid(), book2.getSubKind());
			return result;
		} else {
			return null;
		}

	}

	public void updateBookByUnum(User user) throws SQLException {
		// 修改图书
		String sql = "update users set uname = ? , password = ? where uname = ?";
		QueryRunner qr = new QueryRunner(DB_Conn.getDataSource());
		Object[] params = { user.getUname(), user.getPassword(), user.getUname() };
		qr.update(sql, params);
	}
}
