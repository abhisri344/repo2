package com.nagarro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.models.Book;
import com.nagarro.services.BookApiService;
import com.nagarro.services.LoginSignupService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class LoginSignupController represents a controller which is called when
 * a user registers or login to website. It is having two methods one for login
 * and other for registration
 * 
 * @author abhisheksrivastava02
 *
 */
@Controller
public class LoginSignUpController {
	public static String user_name;
	final LoginSignupService service = new LoginSignupService();
	final BookApiService api = new BookApiService();
	final ModelAndView view = new ModelAndView();

	/**
	 * Method login is responsible for taking the data entered by user and
	 * validating it against the entries in database and redirecting him to search
	 * page
	 * 
	 * @param request  is used to retrieve incoming HTTP request headers and form
	 *                 data
	 * @param response is used to set the HTTP response headers (e.g., content-type)
	 *                 and the response message body
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {


		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		if (!isValid(username)) {
			view.setViewName("index.jsp");
			view.addObject("invalidUsername","Invalid Username");
		}
		else if (! isValid(password)) {
			view.clear();
			view.setViewName("index.jsp");
			view.addObject("invalidPassword","Invalid Password");
		}
		else {
			System.out.println("---");
			if (service.isUser(username, password)) {
				request.getSession().setAttribute("authorized", true);
				request.getSession().setAttribute("user", service.getUser(username));
				user_name = username;
	
				ArrayList<Book> books = api.getBooks();
				view.addObject("books", books);
	
				view.setViewName("home.jsp");
				view.addObject("username", username);
	
			} else {
				request.setAttribute("message", "Invalid login");
				view.setViewName("index.jsp");
			}
		}
		return view;

	}

	/**
	 * Method register is responsible for taking the data entered by user and adding
	 * it to the database
	 * 
	 * @param request  is used to retrieve incoming HTTP request headers and form
	 *                 data
	 * @param response is used to set the HTTP response headers (e.g., content-type)
	 *                 and the response message body
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView signup(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		if (!isValid(username)) {
			view.setViewName("registration.jsp");
			view.addObject("invalidUsername","Invalid Username");
		}
		else if (! isValid(password)) {
			view.clear();
			view.setViewName("registration.jsp");
			view.addObject("invalidPassword","Invalid Password");
		}
		else {
			boolean ans = service.addUser(username, password);
			if (ans) {
//				System.out.println("registered successfully");
				view.setViewName("index.jsp");
			} else {
//				System.out.println("not registered successfully");
				view.setViewName("registration.jsp");
			}
		}
		return view;

	}

	/**
	 * logout function is responsible for providing log out functionality
	 * 
	 * @param request  is used to retrieve incoming HTTP request headers and form
	 *                 data
	 * @param response is used to set the HTTP response headers (e.g., content-type)
	 *                 and the response message body
	 * @throws IOException
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response){
		try {
			service.logout(request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9][a-zA-Z0-9]*$";

	private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);

	public static boolean isValid(final String username) {
		Matcher matcher = pattern.matcher(username);
		return matcher.matches();
	}

}
