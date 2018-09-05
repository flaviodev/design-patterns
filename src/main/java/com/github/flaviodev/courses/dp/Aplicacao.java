package com.github.flaviodev.courses.dp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

public class Aplicacao {

	@Autowired
	private static ApplicationContext context;
	
	public static ApplicationContext getContext() {
		return context;
	}

	
}
