package com.emc.ps.appmod.tnt.utilities.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emc.ps.appmod.tnt.domain.utilities.Inventory;
import com.emc.ps.appmod.tnt.utilities.service.InventoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/utilities/inventory")
public class InventoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;
	
	@ApiOperation("Returns the types of Inventories")
	@RequestMapping(value = "/type", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> inventoryTypeList() {
		List<String> inventoryTypeList = inventoryService.getInventoryTypeList();
		return new  ResponseEntity<List<String>>(inventoryTypeList, HttpStatus.OK);
		//return CommonUtils.buildSuccessResponse(inventoryTypeList);
	}
	
	@ApiOperation("Lists all the inventories")
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Inventory>> inventoryList() {
		List<Inventory> inventoryList = inventoryService.getInventoryList();
		return new  ResponseEntity<List<Inventory>>(inventoryList, HttpStatus.OK);
		//return CommonUtils.buildSuccessResponse(inventoryList);
	}

	@ApiOperation("Returns the inventory details based on inventory-id")
	@RequestMapping(value = "{inventoryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Inventory> inventoryDetail(@PathVariable Long inventoryId) {
		Inventory inventory = inventoryService.getInventoryDetails(inventoryId);
		return new  ResponseEntity<Inventory>(inventory, HttpStatus.OK);
		//return CommonUtils.buildSuccessResponse(inventory);
	}

	@ApiOperation("Creates a new inventory")
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
		Inventory inventoryResp = inventoryService.createInventory(inventory);
		return new  ResponseEntity<Inventory>(inventoryResp, HttpStatus.OK);
		//return CommonUtils.buildSuccessResponse(inventoryResp);
	}
	
	@ApiOperation("Updates an existing inventory")
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory) {
		Inventory inventoryResp = inventoryService.updateInventory(inventory);
		return new  ResponseEntity<Inventory>(inventoryResp, HttpStatus.OK);
		//return CommonUtils.buildSuccessResponse(inventoryResp);
	}

	@ApiOperation("Deletes an existing inventory")
	@RequestMapping(value = "{inventoryId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Inventory> deleteInventory(@PathVariable Long inventoryId) {
		inventoryService.deleteInventory(inventoryId);
		return new  ResponseEntity<Inventory>(HttpStatus.OK);
		//return CommonUtils.buildSuccessResponse(null);
	}
	

}
