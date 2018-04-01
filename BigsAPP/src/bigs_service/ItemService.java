package bigs_service;

import java.util.List;

import bigs_dao.Item;
import bigs_dao.ItemDAO;

public class ItemService {

	ItemDAO dao;
	
	public ItemService() {
		dao = new ItemDAO();
	}
	
	public Item selectOne(int item_no){
		return dao.selectOne(item_no);
	}
	
	public List<String> selectCol(String colname){
		return dao.selectCol(colname);
	}
	
}
