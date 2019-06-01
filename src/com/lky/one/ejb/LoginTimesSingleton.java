package com.lky.one.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class LoginTimesSingleton
 */
@Singleton
@LocalBean
public class LoginTimesSingleton {

	int loginTimes = 0;

	/**
	 * Default constructor.
	 */
	public LoginTimesSingleton() {
		// TODO Auto-generated constructor stub
	}

	@Lock(LockType.WRITE)
	public void loginSuccess() {
		loginTimes++;
	}

	@Lock(LockType.READ)
	public int getLoginTimes() {
		return loginTimes;
	}
}
