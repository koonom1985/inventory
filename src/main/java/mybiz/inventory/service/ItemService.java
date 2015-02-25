package mybiz.inventory.service;

import java.util.List;

import mybiz.inventory.dao.ItemDAO;
import mybiz.inventory.model.ItemIn;

public class ItemService {
	private ItemDAO itemDAO;
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	public void saveItemIn(ItemIn itemin) {
		itemDAO.save(itemin);
	}
	
	public List<ItemIn> findAllItemIn() {
		return itemDAO.findAllItemIn();
	}
}
