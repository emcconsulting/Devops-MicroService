package com.emc.ps.appmod.tnt.utilities.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.emc.ps.appmod.tnt.domain.utilities.Book;
import com.emc.ps.appmod.tnt.utilities.BookTest;
import com.emc.ps.appmod.tnt.utilities.dao.BookDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest extends BookTest {

	@MockBean
	private BookDAO bookDao;

	@Autowired
	private BookService bookService;

	@Test
	public void bookListTest() {
		given(this.bookDao.findAll()).willReturn(getBookEntityList());
		List<Book> bookList = bookService.getBookList();
		assertThat(bookList).size().isEqualTo(1);
	}

}
