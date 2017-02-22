package com.emc.ps.appmod.tnt.utilities.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.emc.ps.appmod.tnt.domain.utilities.Book;
import com.emc.ps.appmod.tnt.utilities.service.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private BookService bookService;

	@Autowired
	private GenericApplicationContext context;

	@Before
	public void defineRequestScope() {
		context.getBeanFactory().registerScope(WebApplicationContext.SCOPE_REQUEST, new RequestScope());
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));
	}

	@Test
	public void testGetListController() throws Exception {
		given(this.bookService.getBookList()).willReturn(new ArrayList<Book>());
		this.mvc.perform(get("/api/utilities/book/list")).andExpect(status().isOk());
	}

}
