package com.lky.one.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("ISBNValidator")
public class ISBNValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		String sourse = (String) arg2;
		// 去掉所有横杠
		sourse = sourse.replace("-", "");
		int result = 10 - (Integer.parseInt(String.valueOf(sourse.charAt(0)))
				+ Integer.parseInt(String.valueOf(sourse.charAt(2)))
				+ Integer.parseInt(String.valueOf(sourse.charAt(4)))
				+ Integer.parseInt(String.valueOf(sourse.charAt(6)))
				+ Integer.parseInt(String.valueOf(sourse.charAt(8)))
				+ Integer.parseInt(String.valueOf(sourse.charAt(10)))
				+ 3 * (Integer.parseInt(String.valueOf(sourse.charAt(1)))
						+ Integer.parseInt(String.valueOf(sourse.charAt(3)))
						+ Integer.parseInt(String.valueOf(sourse.charAt(5)))
						+ Integer.parseInt(String.valueOf(sourse.charAt(7)))
						+ Integer.parseInt(String.valueOf(sourse.charAt(9)))
						+ Integer.parseInt(String.valueOf(sourse.charAt(11)))))
				% 10;
		int real = Integer.parseInt(String.valueOf(sourse.charAt(12)));
		if (result != real) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ISBN效验错误", "校验位错误，正确效验和应为：" + result);
			throw new ValidatorException(message);
		}
	}

}
