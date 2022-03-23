package com.nagarro.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.models.Book;
import com.nagarro.services.BookApiService;

/**
 * EditBookController class is responsible for updating the given book
 * 
 * @author abhisheksrivastava02
 *
 */
@Controller
public class EditBookController {

	final ModelAndView view = new ModelAndView();
	final BookApiService api = new BookApiService();

	/**
	 * editBook function is used to get book details of passed id from api and
	 * redirecting to edit page
	 * 
	 * @param id - the id of the book to be deleted
	 * @return
	 */
	@RequestMapping("/update/{id}")
	public ModelAndView editBook(@PathVariable("id") int id) {
		
		Book book= api.getBook(id);
		view.addObject("username", LoginSignUpController.user_name);
		view.addObject("book", book);
		view.setViewName("../edit.jsp");
		return view;

	}

	/**
	 * updateBook function takes the input from the form and passes it to updateBook Service method 
	 @param request  is used to retrieve incoming HTTP request headers and form
	 *                 data
	 * @param response is used to set the HTTP response headers (e.g., content-type)
	 *                 and the response message body
	 * @return
	 */
	@RequestMapping("/updateBook")
	public ModelAndView updateBook(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("bookid"));
		String name = request.getParameter("bookname");
		String author = request.getParameter("author");
		
		api.updateBook(id, name, author);

		ArrayList<Book> books = api.getBooks();
//		System.out.println(books);
		view.addObject("books", books);
		view.addObject("username", LoginSignUpController.user_name);
		view.setViewName("home.jsp");
		return view;
	}
}
