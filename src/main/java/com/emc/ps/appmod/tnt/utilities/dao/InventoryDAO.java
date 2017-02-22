package com.emc.ps.appmod.tnt.utilities.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.emc.ps.appmod.tnt.utilities.entity.InventoryEntity;

@Transactional
public interface InventoryDAO extends CrudRepository<InventoryEntity, Long>, JpaSpecificationExecutor<InventoryEntity> {

}
