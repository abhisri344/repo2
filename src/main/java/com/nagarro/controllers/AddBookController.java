package com.nagarro.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.models.Book;
import com.nagarro.services.BookApiService;

/**
 * AddBookController class is responsible for adding books to the library using
 * addBook functions and Rest Api
 * 
 * @author abhisheksrivastava02
 *
 */
@Controller
public class AddBookController {

	final BookApiService api = new BookApiService();
	final ModelAndView view = new ModelAndView();

	/**
	 * addBook function is responsible for redirecting to add.jsp page
	 * 
	 * @return
	 */
	@RequestMapping("/addBook")
	public ModelAndView addBook() {
		view.addObject("username", LoginSignUpController.user_name);
		view.setViewName("add.jsp");
		return view;
	}

	/**
	 * addBookDetails function is responsible for taking the details from the form
	 * and calling addBook method of BookApiService class
	 * 
	 * @param request  is used to retrieve incoming HTTP request headers and form
	 *                 data
	 * @param response is used to set the HTTP response headers (e.g., content-type)
	 *                 and the response message body
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView addBookDetails(HttpServletRequest request, HttpServletResponse response) {

		String name = request.getParameter("bookname");
		String author = request.getParameter("author");
		api.addBook(name, author);

		ArrayList<Book> books = api.getBooks();
		view.addObject("books", books);
		view.addObject("username", LoginSignUpController.user_name);
		view.setViewName("home.jsp");
		return view;
	}

}
