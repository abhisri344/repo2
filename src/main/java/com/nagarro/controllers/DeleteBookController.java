package com.nagarro.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.models.Book;
import com.nagarro.services.BookApiService;

/**
 * DeleteBookController class is responsible for providingdelete functionality
 * 
 * @author abhisheksrivastava02
 *
 */
@Controller
public class DeleteBookController {

	final BookApiService api = new BookApiService();
	final ModelAndView view = new ModelAndView();

	/**
	 * deleteBook function is responsible deleting the book with the given id from
	 * the database using the API
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("delete/{id}")
	public ModelAndView deleteBook(@PathVariable int id) {
		api.deleteBook(id);

		ArrayList<Book> books = api.getBooks();
		view.addObject("books", books);
		view.addObject("username", LoginSignUpController.user_name);
		view.setViewName("../home.jsp");
		return view;

	}
}
