package com.lky.one.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("NullValidator")
public class NullValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		if (arg2 == null) {
			System.out.println("经过我" + arg1.toString());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "表单提交错误", "输入数据不能为空");
			throw new ValidatorException(message);
		}
	}

}
