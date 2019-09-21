package com.nagarro.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.web.model.FlightSearch;
import com.nagarro.web.model.Login;
import com.nagarro.web.model.User;
import com.nagarro.web.service.UserService;

@Controller
@RequestMapping("/")
public class MainController {

	/**
	 * The @Autowired annotation provides more fine-grained control over where and
	 * how autowiring should be accomplished. The @Autowired annotation can be used
	 * to autowire bean on the setter method just like @Required annotation,
	 * constructor, a property or methods with arbitrary names and/or multiple
	 * arguments.
	 */

	@Autowired
	UserService userService;

	@Autowired
	MessageSource messageSource;

	/**
	 * ModelAndView is an object that holds both the model and view. The handler
	 * returns the ModelAndView object and DispatcherServlet resolves the view using
	 * View Resolvers and View.
	 *
	 * The View is an object which contains view name in the form of the String and
	 * model is a map to add multiple objects.
	 * 
	 * call through anchor tag -> than ModelAndView call -> make new object for
	 * login -> pass that object to jsp
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		User user = userService.validateUser(login);
		if (null != user) {
			mav = new ModelAndView("flightSearch");
			mav.addObject("firstname", user.getUname());
			mav.addObject("flightSearch", new FlightSearch());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

}
