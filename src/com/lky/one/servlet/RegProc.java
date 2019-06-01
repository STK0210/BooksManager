package com.lky.one.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lky.one.dao.DB_User;
import com.lky.one.domain.User;

/**
 * Servlet implementation class RegProc
 */
@WebServlet("/RegProc")
public class RegProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BooksManager");
		EntityManager manager = factory.createEntityManager();
		try {
			User user = new User();
			user.setUname("JPAName");
			user.setPassword("JPAPassword");

			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			transaction.commit();
		} finally {
			manager.close();
			factory.close();
		}
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		User tempuser = new User(uname, password);

		DB_User db_User = new DB_User();
		User user = null;
		String msg = "";
		try {
			user = db_User.findUserByUname(tempuser);
			if (user == null) {
				if (tempuser.passwordIsOk(password)) {
					db_User.userRegist(tempuser);
					msg = "用户唯一！已存入数据库！";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/jsp/register_success.jsp").forward(request, response);
				} else {
					msg = "密码不满足要求！无法注册！";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("/jsp/register_failure.jsp").forward(request, response);
				}
			} else {
				msg = "该用户名已经存在了！无法注册！";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/jsp/register_failure.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
