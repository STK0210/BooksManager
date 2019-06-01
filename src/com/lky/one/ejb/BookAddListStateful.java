package com.lky.one.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import com.lky.one.domain.Book;

/**
 * Session Bean implementation class BookAddListStateful
 */
@Stateful
@LocalBean
public class BookAddListStateful {

	List<Book> bookAddList;

	public BookAddListStateful() {
		// ————————————————————————————————————————————————————————————————————————————————————————————————————————————————
		System.out.println(this + "有状态会话bean初始化");
		// ————————————————————————————————————————————————————————————————————————————————————————————————————————————————
		bookAddList = new ArrayList<Book>();
	}

	/**
	 * Default constructor.
	 */

	public void addBook(Book book) {
		// System.out.println("old存储的有状态会话bean中" + bookAddList);
		bookAddList.add(book);
		// System.out.println("new存储的有状态会话bean中" + bookAddList);
	}

	public List<Book> getBookAddList() {
		// System.out.println("获取的有状态会话bean" + bookAddList);
		return bookAddList;
	}

	public void clearBookList() {
		if (bookAddList != null) {
			bookAddList.clear();
		}
	}

	@Remove
	public void submitBookAddList() {
		if (bookAddList != null) {
			bookAddList.clear();
		}
		System.out.println("已重置添加列表");
	}

	@PreDestroy
	public void endEJB() {
		System.out.println("predestroy is called");
	}

}
