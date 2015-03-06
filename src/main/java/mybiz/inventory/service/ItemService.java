package mybiz.inventory.service;

import java.util.List;

import mybiz.inventory.dao.ItemDAO;
import mybiz.inventory.model.ItemIn;
import mybiz.inventory.model.ItemSell;

public class ItemService {
	private ItemDAO itemDAO;
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	public void saveItemIn(ItemIn itemin) {
		itemDAO.save(itemin);
	}
	
	public void saveItemSell(ItemSell itemsell) {
		itemDAO.save(itemsell);
	}
	
	public void upadteItemIn(ItemIn itemin) {
		itemDAO.update(itemin);
	}
	
	public List<ItemIn> findAllItemIn() {
		return itemDAO.findAllItemIn();
	}
	
	public List<ItemSell> findAllItemSell() {
		return itemDAO.findAllItemSell();
	}
	
	public List<ItemIn> findItemInById(long id) {
		return itemDAO.findItemInById(id);
	}
	
	public void deleteItemIn(long id) {
		itemDAO.deleteItemItById(id);
	}
}
