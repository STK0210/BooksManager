package com.lky.one.converter;

import java.util.Arrays;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("authorConverter")
public class AuthorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// 将String转为String[] arg2是获得的参数
		// 去掉空格  
		String sourse = arg2.replace(" ", "");
		if (sourse.equals("")) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入有误", "不可为空");
			arg0.addMessage("authors", message);
			throw new ConverterException(message);
		}

		String[] authors = sourse.split(",");
		return authors;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// 将String[]转为String
		String[] sourse = (String[]) arg2;
		return Arrays.toString(sourse).substring(1, Arrays.toString(sourse).length() - 1);
	}

	public static void main(String[] args) {
		String[] a = { "qwe", "sa", "123" };
		System.out.println(Arrays.toString(a).substring(1, Arrays.toString(a).length() - 1));
	}
}
