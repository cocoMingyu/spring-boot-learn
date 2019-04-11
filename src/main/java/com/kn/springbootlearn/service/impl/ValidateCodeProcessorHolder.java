
package com.kn.springbootlearn.service.impl;

import java.util.Map;

import com.kn.springbootlearn.entity.enums.ValidateCodeType;
import com.kn.springbootlearn.exception.ValidateException;
import com.kn.springbootlearn.service.ValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateCodeProcessorHolder {

	@Autowired
	private Map<String, ValidateCodeProcessor> validateCodeProcessors;

	public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
		return findValidateCodeProcessor(type.toString().toLowerCase());
	}

	public ValidateCodeProcessor findValidateCodeProcessor(String type) {
		String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
		ValidateCodeProcessor processor = validateCodeProcessors.get(name);
		if (processor == null) {
			throw new ValidateException("验证码处理器" + name + "不存在");
		}
		return processor;
	}

}
