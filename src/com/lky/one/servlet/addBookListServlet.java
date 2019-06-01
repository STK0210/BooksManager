package com.lky.one.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lky.one.control.BookCtrl;
import com.lky.one.dao.DB_Book;
import com.lky.one.domain.Book;

/**
 * Servlet implementation class addBookListServlet
 */
@WebServlet("/addBookListServlet")
public class addBookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addBookListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("addListServelt执行了！！！！！！");
			List<Book> bookList = (List<Book>) request.getSession().getAttribute("addList");
			if (bookList != null) {
				for (Book book : bookList) {
					DB_Book db_Book = new DB_Book();
					Book tempBook = db_Book.findBookByBnum(book);
					if (tempBook != null) {
						request.getSession().setAttribute("msg", "图书已经存在！请重新输入书号不重复的图书！");
						break;
					} else {
						db_Book.addBook(book);
						request.getSession().setAttribute("msg", "添加成功！");
					}
				}
			} else {
				request.getSession().setAttribute("msg", "没有图书在列表中，请添加图书后再提交！");
			}
			BookCtrl.clearBooks();
			response.sendRedirect("/BooksManager/jsp/msg.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getSession().setAttribute("msg", "出现了一点问题");
			response.sendRedirect("/BooksManager/jsp/msg.jsp");
		}
	}

}
