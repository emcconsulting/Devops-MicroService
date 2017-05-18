/**
 * 
 */
package com.emc.ps.appmod.tnt.utilities.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.emc.ps.appmod.tnt.domain.utilities.Book;
import com.emc.ps.appmod.tnt.domain.utilities.BookSearch;
import com.emc.ps.appmod.tnt.utilities.dao.BookDAO;
import com.emc.ps.appmod.tnt.utilities.entity.BookEntity;

/**
 * @author jawala
 *
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.emc.ps.appmod.tnt.utilities.service.BookService#getBookList()
	 */
	@Override
	public List<Book> getBookList() {
		Iterable<BookEntity> bookEntityList = bookDao.findAll();
		List<Book> bookList = convertToDomain(bookEntityList);
		return bookList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.ps.appmod.tnt.utilities.service.BookService#getBookDetail(java.
	 * lang.Integer)
	 */
	@Override
	public Book getBookDetail(Long bookId) {
		BookEntity bookEntity = bookDao.findOne(bookId);
		return convertToDomain(bookEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.ps.appmod.tnt.utilities.service.BookService#createBook(com.emc.ps
	 * .appmod.tnt.domain.utilities.Book)
	 */
	@Override
	public Book createBook(Book book) {
		BookEntity bookEntity = new BookEntity();
		Date today = new Date();
		bookEntity.setAuthor(book.getAuthor());
		// bookEntity.setDepartmentId(book.getDepartmentId());
		bookEntity.setIsbn(book.getISBN());
		bookEntity.setName(book.getName());
		// bookEntity.setOwnerId(book.getOwnerId());
		bookEntity.setPrice(book.getPrice());
		// bookEntity.setPurchaseDate(book.getPurchaseDate());
		bookEntity.setUpdateDate(today);
		bookEntity.setInsertDate(today);
		// bookEntity.setUrl(book.getURL());
		// bookEntity.setUserId(book.getLentToUserId());

		bookEntity = bookDao.save(bookEntity);
		return convertToDomain(bookEntity);
	}

	@Override
	public Book updateBook(Book book) {
		BookEntity bookEntity = bookDao.findOne(book.getId());
		Date today = new Date();
		bookEntity.setAuthor(book.getAuthor());
		// bookEntity.setDepartmentId(book.getDepartmentId());
		bookEntity.setIsbn(book.getISBN());
		bookEntity.setName(book.getName());
		// bookEntity.setOwnerId(book.getOwnerId());
		bookEntity.setPrice(book.getPrice());
		// bookEntity.setPurchaseDate(book.getPurchaseDate());
		bookEntity.setUpdateDate(today);
		// bookEntity.setUrl(book.getURL());
		// bookEntity.setUserId(book.getLentToUserId());

		bookEntity = bookDao.save(bookEntity);
		return convertToDomain(bookEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.emc.ps.appmod.tnt.utilities.service.BookService#deleteBook(java.lang.
	 * Integer)
	 */
	@Override
	public void deleteBook(Long bookId) {
		bookDao.delete(bookId);

	}

	@Override
	public List<Book> searchBook(BookSearch bookSearch) {
		List<BookEntity> res = bookDao.findAll(bookSearchSpecification(bookSearch));

		return convertToDomain(res);
	}

	private List<Book> convertToDomain(Iterable<BookEntity> bookEntityList) {
		List<Book> bookList = new ArrayList<Book>();
		Iterator<BookEntity> bookIterator = bookEntityList.iterator();
		while (bookIterator.hasNext()) {
			BookEntity bookEntity = bookIterator.next();
			Book book = convertToDomain(bookEntity);
			bookList.add(book);
		}
		return bookList;
	}

	private Book convertToDomain(BookEntity bookEntity) {
		Book book = new Book();
		book.setAuthor(bookEntity.getAuthor());
		// book.setDepartmentId(bookEntity.getDepartmentId());
		book.setId(bookEntity.getId());
		// book.setInsertDate(bookEntity.getInsertDate());
		book.setISBN(bookEntity.getIsbn());
		// book.setLentToUserId(bookEntity.getUserId());
		book.setName(bookEntity.getName());
		// book.setOwnerId(bookEntity.getOwnerId());
		book.setPrice(bookEntity.getPrice());
		// book.setPurchaseDate(bookEntity.getPurchaseDate());
		// book.setUpdateDate(bookEntity.getUpdateDate());
		// book.setURL(bookEntity.getUrl());
		return book;
	}

	private static Specification<BookEntity> bookSearchSpecification(final BookSearch bookSearch) {
		return new Specification<BookEntity>() {

			@Override
			public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<Predicate>();

				if (!StringUtils.isEmpty(bookSearch.getName())) {
					predicates.add(builder.equal(root.get("name"), bookSearch.getName()));
				}
				if (!StringUtils.isEmpty(bookSearch.getAuthor())) {
					predicates.add(builder.equal(root.get("author"), bookSearch.getAuthor()));
				}
				if (!StringUtils.isEmpty(bookSearch.getIsbn())) {
					predicates.add(builder.equal(root.get("isbn"), bookSearch.getIsbn()));
				}
				if (!StringUtils.isEmpty(bookSearch.getPrice())) {
					predicates.add(builder.equal(root.get("price"), bookSearch.getPrice()));
				}
				if (!StringUtils.isEmpty(bookSearch.getUrl())) {
					predicates.add(builder.equal(root.get("url"), bookSearch.getUrl()));
				}

				if (!StringUtils.isEmpty(bookSearch.getFromPurchaseDate())) {
					/*
					 * predicates.add(
					 * builder.greaterThanOrEqualTo(root.get("purchaseDate"),
					 * bookSearch.getFromPurchaseDate()));
					 * predicates.add(builder.lessThanOrEqualTo(root.get(
					 * "purchaseDate"), bookSearch.getToPurchaseDate()));
					 */
					predicates.add(builder.between(root.get("purchaseDate"), bookSearch.getFromPurchaseDate(),
							bookSearch.getToPurchaseDate()));
				}

				return builder.and(predicates.toArray(new Predicate[] {}));
			}

		};

	}

}
