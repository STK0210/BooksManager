package com.lky.one.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("stringNotNullConverter")
public class StringNotNullConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// 去掉空格  
		String sourse = arg2.replace(" ", "");
		if (sourse.equals("")) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "输入有误", "输入数据不可为空");
			throw new ConverterException(message);
		}
		return sourse;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return (String) arg2;
	}

}
