package com.emc.ps.appmod.tnt.utilities.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.emc.ps.appmod.tnt.utilities.entity.BookEntity;

@Transactional
public interface BookDAO extends CrudRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {

}
