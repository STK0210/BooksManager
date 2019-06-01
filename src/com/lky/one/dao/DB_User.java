package com.lky.one.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lky.one.domain.User;
import com.lky.one.utils.DB_Conn;

public class DB_User {

	public void userRegist(User user) throws SQLException {
		// 注册用户
		String sql = "insert into users values( ? , ? )";
		QueryRunner qr = new QueryRunner(DB_Conn.getDataSource());
		Object[] params = { user.getUname(), user.getPassword() };
		qr.update(sql, params);
	}

	public User userLogin(User tempuser) throws SQLException {
		// 查找用户
		String sql = "select * from users where uname = ? and password = ?";
		QueryRunner qr = new QueryRunner(DB_Conn.getDataSource());
		User user = qr.query(sql, new BeanHandler<User>(User.class), tempuser.getUname(), tempuser.getPassword());
		return user;
	}

	public void deleteUserByUname(User user) throws SQLException {
		// 删除用户
		String sql = "delete from users where uname = ?";
		QueryRunner qr = new QueryRunner(DB_Conn.getDataSource());
		Object[] params = { user.getUname() };
		qr.update(sql, params);
	}

	public User findUserByUname(User tempuser) throws SQLException {
		// 查找用户
		String sql = "select * from users where uname = ?";
		QueryRunner qr = new QueryRunner(DB_Conn.getDataSource());
		User user = qr.query(sql, new BeanHandler<User>(User.class), tempuser.getUname());
		return user;
	}

	public void updateUserByUname(User user) throws SQLException {
		// 更新用户
		String sql = "update users set uname = ? , password = ? where uname = ?";
		QueryRunner qr = new QueryRunner(DB_Conn.getDataSource());
		Object[] params = { user.getUname(), user.getPassword(), user.getUname() };
		qr.update(sql, params);
	}

}
