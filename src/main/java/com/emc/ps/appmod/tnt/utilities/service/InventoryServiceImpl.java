package com.emc.ps.appmod.tnt.utilities.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.emc.ps.appmod.tnt.domain.utilities.Inventory;
import com.emc.ps.appmod.tnt.domain.utilities.InventoryType;
import com.emc.ps.appmod.tnt.utilities.dao.InventoryDAO;
import com.emc.ps.appmod.tnt.utilities.entity.InventoryEntity;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImpl.class);

	@Autowired
	private InventoryDAO inventoryDao;
	
	//@Value("${country}")
	//private String country;
	

	@Override
	public List<String> getInventoryTypeList() {
		InventoryType[] inventoryTypeArray = InventoryType.values();
		List<InventoryType> inventories = new ArrayList<InventoryType>(Arrays.asList(inventoryTypeArray));
		List<String> inventoryTypes = new ArrayList<String>();
		for (InventoryType in : inventories) {
			inventoryTypes.add(in.name());
		}

		return inventoryTypes;
	}

	@Override
	public List<Inventory> getInventoryList() {
		Iterable<InventoryEntity> inventories = inventoryDao.findAll();
		List<Inventory> inventoryList = convertToDomain(inventories);
		return inventoryList;
	}

	@Override
	public Inventory getInventoryDetails(Long inventoryId) {
		InventoryEntity ie = inventoryDao.findOne(inventoryId);
		return convertToDomain(ie);
	}

	@Override
	public Inventory createInventory(Inventory inEn) {

		InventoryEntity in = new InventoryEntity();
		if (inEn.isAmortizable()) {
			in.setAmortizable(1);
		} else {
			in.setAmortizable(0);
		}

		in.setAsignedToId(inEn.getAssignedTo());
		in.setBuyDate(inEn.getBuyDate());
		in.setCost(inEn.getCost());
		in.setDepartmentId(inEn.getDepartmentId());
		in.setDescription(inEn.getDescription());
		in.setLocation(inEn.getLocation());
		in.setModel(inEn.getModel());
		in.setOwnerId(inEn.getOwnerId());
		in.setProvider(inEn.getProvider());
		in.setRam(inEn.getRam());
		in.setSerialNumber(inEn.getSerialNumber());
		in.setSpeed(inEn.getSpeed());
		in.setStorage(inEn.getStorage());

		if (null != inEn.getToRent()) {
			if (inEn.getToRent()) {
				in.setRenting(1);
			} else {
				in.setRenting(0);
			}
		} else {
			in.setRenting(0);
		}

		in.setTrademark(inEn.getTrademark());
		in.setType(inEn.getType());

		Date today = new Date();
		in.setBuyDate(today);
		in.setInsertDate(today);
		in.setUpdateDate(today);
		in.setOwnerId(inEn.getOwnerId());

		in = inventoryDao.save(in);

		return convertToDomain(in);

	}

	@Override
	public Inventory updateInventory(Inventory inEn) {
		InventoryEntity in = inventoryDao.findOne(inEn.getId());
		if (inEn.isAmortizable()) {
			in.setAmortizable(1);
		} else {
			in.setAmortizable(0);
		}

		in.setAsignedToId(inEn.getAssignedTo());
		in.setBuyDate(inEn.getBuyDate());
		in.setCost(inEn.getCost());
		in.setDepartmentId(inEn.getDepartmentId());
		in.setDescription(inEn.getDescription());
		in.setLocation(inEn.getLocation());
		in.setModel(inEn.getModel());
		in.setOwnerId(inEn.getOwnerId());
		in.setProvider(inEn.getProvider());
		in.setRam(inEn.getRam());
		in.setSerialNumber(inEn.getSerialNumber());
		in.setSpeed(inEn.getSpeed());
		in.setStorage(inEn.getStorage());

		if (null != inEn.getToRent()) {
			if (inEn.getToRent()) {
				in.setRenting(1);
			} else {
				in.setRenting(0);
			}
		}

		in.setTrademark(inEn.getTrademark());
		in.setType(inEn.getType());

		Date today = new Date();
		in.setBuyDate(today);
		in.setUpdateDate(today);
		in.setOwnerId(inEn.getOwnerId());

		in = inventoryDao.save(in);

		return convertToDomain(in);

	}

	@Override
	public void deleteInventory(Long inventoryId) {
		inventoryDao.delete(inventoryId);
		;

	}

	@Override
	public List<Inventory> searchInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Inventory> convertToDomain(Iterable<InventoryEntity> inventories) {
		Iterator<InventoryEntity> iterator = inventories.iterator();
		List<Inventory> inventoryList = new ArrayList<Inventory>();

		while (iterator.hasNext()) {
			InventoryEntity inEn = iterator.next();
			Inventory inventory = convertToDomain(inEn);
			inventoryList.add(inventory);
		}
		return inventoryList;
	}

	private Inventory convertToDomain(InventoryEntity inEn) {
		Inventory in = new Inventory();
		int am = inEn.getAmortizable();
		if (am == 0) {
			in.setAmortizable(false);
		} else {
			in.setAmortizable(true);
		}

		in.setId(inEn.getId());
		in.setAssignedTo(inEn.getAsignedToId());
		in.setBuyDate(inEn.getBuyDate());
		in.setCost(inEn.getCost());
		in.setDepartmentId(inEn.getDepartmentId());
		in.setDescription(inEn.getDescription());
		in.setLocation(inEn.getLocation());
		in.setModel(inEn.getModel());
		in.setOwnerId(inEn.getOwnerId());
		in.setProvider(inEn.getProvider());
		in.setRam(inEn.getRam());
		in.setSerialNumber(inEn.getSerialNumber());
		in.setSpeed(inEn.getSpeed());
		in.setStorage(inEn.getStorage());
		//in.setCountry(country);
		//LOGGER.info("country : "+ country);

		int rent = inEn.getRenting();
		if (rent == 0) {
			in.setToRent(false);
		} else {
			in.setToRent(true);
		}

		in.setTrademark(inEn.getTrademark());
		// in.setType(InventoryType.convert(inEn.getType()));
		// in.setType(InventoryType.valueOf(inEn.getType()));
		in.setType(inEn.getType());
		return in;
	}

	/*
	 * private static Specification<InventoryEntity>
	 * inventorySearchSpecification(final InventorySearch inventorySearch) {
	 * return new Specification<InventoryEntity>() {
	 * 
	 * @Override public Predicate toPredicate(Root<InventoryEntity> root,
	 * CriteriaQuery<?> query, CriteriaBuilder builder) { List<Predicate>
	 * predicates = new ArrayList<Predicate>();
	 * 
	 * if (!StringUtils.isEmpty(inventorySearch.getName())) {
	 * predicates.add(builder.equal(root.get("name"),
	 * inventorySearch.getName())); }
	 * 
	 * 
	 * return builder.and(predicates.toArray(new Predicate[] {})); }
	 * 
	 * };
	 * 
	 * }
	 */

}
