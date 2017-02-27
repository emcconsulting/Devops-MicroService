package com.emc.ps.appmod.tnt.domain.utilities;

public enum InventoryType {
	DESKTOP_PC("Desktop PC"), PORTABLE_PC("Portable PC"), BOOK_MAGAZINE("Book/Magazine"), KEY("Key"), CARD("Card"), CAR(
			"Car");

	private String inventoryType;

	private InventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public static InventoryType convert(String inventoryType) {
		for (InventoryType inventoryTypeEnum : InventoryType.values()) {
			if (inventoryType.equals(inventoryTypeEnum.getInventoryType())) {
				return inventoryTypeEnum;
			}
		}
		return null;
	}
}
