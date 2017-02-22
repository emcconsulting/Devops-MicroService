package com.emc.ps.appmod.tnt.utilities.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.ps.appmod.tnt.domain.response.ResponseObject;
import com.emc.ps.appmod.tnt.domain.utilities.Book;
import com.emc.ps.appmod.tnt.domain.utilities.BookSearch;
import com.emc.ps.appmod.tnt.utilities.common.CommonUtils;
import com.emc.ps.appmod.tnt.utilities.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/utilities/book")
public class BookController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;
	
	@ApiOperation("Info for book miroservice")
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ResponseObject bookInfo() {
		//return CommonUtils.buildSuccessResponse(message);
		return CommonUtils.buildSuccessResponse("New MS!!!");
	}

	@ApiOperation("Lists all the books")
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> bookList() {
		LOGGER.info("Retrieving list of books");
		List<Book> bookList = bookService.getBookList();
		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
		// return CommonUtils.buildSuccessResponse(bookList);
	}

	@ApiOperation("Gets the details of the book by book-id")
	@RequestMapping(value = "{bookId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> bookDetail(@PathVariable Long bookId) {
		LOGGER.info("Retrieving details of book with book ID {}", bookId);
		Book book = bookService.getBookDetail(bookId);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
		// return CommonUtils.buildSuccessResponse(book);
	}

	@ApiOperation("Creates a new book")
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		LOGGER.info("Creating a new book");
		Book bookResp = bookService.createBook(book);
		return new ResponseEntity<Book>(bookResp, HttpStatus.OK);
		// return CommonUtils.buildSuccessResponse(bookResp);
	}

	@ApiOperation("Updates the existing book")
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		LOGGER.info("Updating the book");
		Book bookResp = bookService.updateBook(book);
		return new ResponseEntity<Book>(bookResp, HttpStatus.OK);
		// return CommonUtils.buildSuccessResponse(bookResp);
	}

	@ApiOperation("Deletes the existing book")
	@RequestMapping(value = "{bookId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> deleteBook(@PathVariable Long bookId) {
		LOGGER.info("Deleting the book");
		bookService.deleteBook(bookId);
		return new ResponseEntity<Book>(HttpStatus.OK);
		// return CommonUtils.buildSuccessResponse(null);
	}

	@ApiOperation("Searches for books based on search condition")
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> searchBook(@RequestBody BookSearch bookSearch) {
		List<Book> searchRes = bookService.searchBook(bookSearch);
		return new ResponseEntity<List<Book>>(searchRes, HttpStatus.OK);
		// return CommonUtils.buildSuccessResponse(searchRes);
	}
}
