package com.emc.ps.appmod.tnt.utilities;

import java.util.ArrayList;
import java.util.List;

import com.emc.ps.appmod.tnt.utilities.entity.BookEntity;

public abstract class BookTest {

	protected Iterable<BookEntity> getBookEntityList() {
		List<BookEntity> bookEntityList = new ArrayList<BookEntity>();
		BookEntity bookEntity = new BookEntity();
		bookEntity.setId(123L);
		bookEntity.setAuthor("Abhishek");
		bookEntity.setDepartmentId(1);
		bookEntity.setOwnerId(1);
		bookEntityList.add(bookEntity);
		return bookEntityList;
	}
}
