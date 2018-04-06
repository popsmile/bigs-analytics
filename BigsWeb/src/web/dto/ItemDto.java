package web.dto;

public class ItemDto {
	
	int itemNo;
	String itemName;
	String itemDesc;
	String itemDesc2;
	
	public ItemDto() {}
	
	public ItemDto(int itemNo, String itemName, String itemDesc, String itemDesc2) {
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemDesc2 = itemDesc2;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemDesc2() {
		return itemDesc2;
	}

	public void setItemDesc2(String itemDesc2) {
		this.itemDesc2 = itemDesc2;
	}

}
