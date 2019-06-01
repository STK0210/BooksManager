package com.lky.one.domain;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class User implements Serializable {

	private static final long serialVersionUID = 7770371154424375696L;

	private String uname;
	private String password;

	public User() {
	}

	public User(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", password=" + password + "]";
	}

	public boolean passwordIsOk(String password) {
		String pattern = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{6,8}$";
		boolean isMatch = Pattern.matches(pattern, password);
		return isMatch;
	}
}