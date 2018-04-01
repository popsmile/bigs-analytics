package bigs_dao;

public class Item {

	private int item_no;
	private String item_name;
	private String item_desc;
	private String item_desc2;
	
	public Item(int item_no, String item_name, String item_desc, String item_desc2) {
		this.item_no = item_no;
		this.item_name = item_name;
		this.item_desc = item_desc;
		this.item_desc2 = item_desc2;
	}
	
	public Item(){}

	public int getItem_no() {
		return item_no;
	}

	public void setItem_no(int item_no) {
		this.item_no = item_no;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_desc() {
		return item_desc;
	}

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}

	public String getItem_desc2() {
		return item_desc2;
	}

	public void setItem_desc2(String item_desc2) {
		this.item_desc2 = item_desc2;
	};
	
}
