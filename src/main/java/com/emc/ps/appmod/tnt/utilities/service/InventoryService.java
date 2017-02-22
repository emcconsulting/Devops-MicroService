package com.emc.ps.appmod.tnt.utilities.service;

import java.util.List;

import com.emc.ps.appmod.tnt.domain.utilities.Inventory;
import com.emc.ps.appmod.tnt.domain.utilities.InventoryType;

public interface InventoryService {

	public List<String> getInventoryTypeList();
	
	public List<Inventory> getInventoryList();

	public Inventory getInventoryDetails(Long inventoryId);

	public Inventory createInventory(Inventory inventory);
	
	public Inventory updateInventory(Inventory inventory);

	public void deleteInventory(Long inventoryId);
	
	public List<Inventory> searchInventory();
}
