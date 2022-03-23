package com.nagarro.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.models.Book;
import com.nagarro.services.BookApiService;

/**
 * GoBackController is responsible for providing a back button functionality
 * 
 * @author abhisheksrivastava02
 *
 */
@Controller
public class GoBackController {

	final BookApiService api = new BookApiService();
	final ModelAndView view = new ModelAndView();

	/**
	 * goback function is responsible for redirecting to home page
	 * 
	 * @return
	 */
	@RequestMapping("/goback")
	public ModelAndView goback() {

		ArrayList<Book> books = api.getBooks();
		view.addObject("books", books);
		view.addObject("username", LoginSignUpController.user_name);
		view.setViewName("home.jsp");
		return view;
	}
}
