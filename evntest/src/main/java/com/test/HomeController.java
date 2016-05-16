package com.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.StandardServletEnvironment;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class HomeController{

	@RequestMapping(value = "/")
	public String home(ModelMap model) {
		return home(model,null,null);
	}
	@RequestMapping(value = "/home.htm")
	public String home(ModelMap model,
			@RequestParam(required = false) String account,HttpServletRequest request) {

		
		StandardServletEnvironment environment = new StandardServletEnvironment();
		environment.getSystemEnvironment();
		environment.getSystemProperties();

		String defaultRunEnvValue = "qa";


		String runEnvValue = environment.getProperty("test_wxf3");

		String runEnvValue1 = environment.getProperty("test_wxf1");
		String runEnvValue2 = environment.getProperty("test_wxf");


		String runEnvValueff = request.getServletContext().getInitParameter("test_wxf3");
		return "home";
	}

}
