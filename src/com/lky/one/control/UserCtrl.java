package com.lky.one.control;

import java.sql.SQLException;
import java.util.Locale;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.lky.one.dao.DB_User;
import com.lky.one.domain.User;

@Named
@RequestScoped
public class UserCtrl {

	@Inject
	@Named("user")
	User user;

	@EJB
	private static com.lky.one.ejb.LoginTimesSingleton loginTimes;
	
	public String login() throws SQLException {
		System.out.println("执行登陆动作");
		String result = null;

		DB_User db_User = new DB_User();
		User tempuser = db_User.userLogin(user);

		if (tempuser != null) {
			loginTimes.loginSuccess();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("times",loginTimes.getLoginTimes() );
			result = "success";
		} else {
			FacesMessage msg = new FacesMessage("登陆失败", "用户名或密码错误");
			FacesContext.getCurrentInstance().addMessage("loginForm:login", msg);
		}

		return result;
	}
	
	public void changeLanguage(ValueChangeEvent e) {
		System.out.println("ValueChangeEvent:设置视图的Locale属性");
		FacesContext ctx = FacesContext.getCurrentInstance();
		String language = (String) e.getNewValue();
		if ("chinese".equals(language)) {
			ctx.getViewRoot().setLocale(Locale.CHINA);
		} else {
			ctx.getViewRoot().setLocale(Locale.US);
		}
		ctx.renderResponse();
		System.out.println("调用：renderResponse()改变界面语言");
	}

	public void changeIdCard(ValueChangeEvent e) {
		System.out.println("ValueChangeEvent:changeIdCard");

	}

	public void loginClick(ActionEvent e) {
		System.out.println("ActionEvent:loginClick");
	}

}
