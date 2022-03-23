package com.nagarro.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.models.Book;

/**
 * BookApi class responsible for defining various services of the api
 * 
 * @author abhisheksrivastava02
 *
 */
public class BookApiService {

	final RestTemplate restTemplate = new RestTemplate();
	final ObjectMapper objectMapper = new ObjectMapper();
	final private String baseUrl = "http://localhost:8090/";

	/**
	 * getBooks methods returns a list of currently available books in the database
	 * 
	 * @return list of books
	 */
	public ArrayList<Book> getBooks() {
		String url = baseUrl + "books";
		ArrayList<Book> books = null;
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

		HttpClient client = HttpClient.newBuilder().build();

		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());

			JSONArray jsonArray = new JSONArray(response.body());

//			System.out.println(jsonArray);
			books = new ArrayList<Book>();

			if (jsonArray != null) {

				for (int i = 0; i < jsonArray.length(); i++) {

					String obj = jsonArray.get(i).toString();
					Book book = objectMapper.readValue(obj, Book.class);
					books.add(book);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return books;

	}

	/**
	 * getBook method returns the book with given id
	 * 
	 * @param id - id of the book to search
	 * @return Book object representing the matching book
	 * 
	 */
	public Book getBook(int id) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", id);

		Book book = restTemplate.getForObject(baseUrl + "books/{id}", Book.class, param);
		return book;

	}

	/**
	 * addBook method adds the book with given name and author to database using api
	 * 
	 * @param name
	 * @param author
	 */
	public void addBook(String name, String author) {

		Book book = new Book(name, author);
		restTemplate.postForEntity(baseUrl + "books", book, Book.class);
	}

	/**
	 * deleteBook method deletes the book with given id from the database using api
	 * 
	 * @param id - id of book to delete
	 */
	public void deleteBook(int id) {

		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("id", id);
		restTemplate.delete(baseUrl + "books/{id}", param);

	}

	/**
	 * updateBook method updates the details of the books in the database using the
	 * api
	 * 
	 * @param id     - id of book to update
	 * @param name   - updated name
	 * @param author - updated author
	 */
	public void updateBook(int id, String name, String author) {

		Book book = new Book(id, name, author);
		System.out.println(book);
		restTemplate.put(baseUrl + "books", book);

	}
}
