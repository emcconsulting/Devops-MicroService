package com.emc.ps.appmod.tnt.utilities.service;

import java.util.List;

import com.emc.ps.appmod.tnt.domain.utilities.Book;
import com.emc.ps.appmod.tnt.domain.utilities.BookSearch;

public interface BookService {

	public List<Book> getBookList();

	public Book getBookDetail(Long bookId);

	public Book createBook(Book book);

	public Book updateBook(Book book);

	public void deleteBook(Long bookId);

	public List<Book> searchBook(BookSearch booksearch);

}
