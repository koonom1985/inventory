package mybiz.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import mybiz.inventory.model.ItemIn;
import mybiz.inventory.model.ItemSell;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ItemDAO extends HibernateDaoSupport {

	public void save(ItemIn itemin) {
		getHibernateTemplate().save(itemin);
	}
	
	public void save(ItemSell itemsell) {
		getHibernateTemplate().save(itemsell);
	}
	
	public void update(ItemIn itemin) {
		getHibernateTemplate().update(itemin);
	}
	
	public List<ItemIn> findItemInById(long id) {
		ItemIn item = (ItemIn) getHibernateTemplate().get(ItemIn.class, id);
		List<ItemIn> list = new ArrayList<ItemIn>();
		list.add(item);
		return list;
	}
	
	public List<ItemSell> findItemSellById(long id) {
		ItemSell item = (ItemSell) getHibernateTemplate().get(ItemSell.class, id);
		List<ItemSell> list = new ArrayList<ItemSell>();
		list.add(item);
		return list;
	}
	
	public List<ItemIn> findAllItemIn() {
		return getHibernateTemplate().find("from ItemIn");
	}
	
	public List<ItemSell> findAllItemSell() {
		return getHibernateTemplate().find("from ItemSell");
	}
	
	public List<ItemSell> findAllItemSellByItemInId(ItemIn itemin) {
		return getHibernateTemplate().find(
			"from ItemSell t where t.itemIn=?", 
			new Object[]{itemin});
	}
	
	public List<ItemIn> findItemInByIndex(int start, int end) {
		return getHibernateTemplate().find(
			"from ItemIn t where t.itemInId=? and t.itemInId=?", 
			new Object[]{start, end});
	}
	
	public void deleteItemItById(long id) {
		ItemIn entity = (ItemIn) getHibernateTemplate().load(ItemIn.class, id);
		getHibernateTemplate().delete(entity);
	}
	
	public void deleteItemSellById(long id) {
		ItemSell entity = (ItemSell) getHibernateTemplate().load(ItemSell.class, id);
		getHibernateTemplate().delete(entity);
	}
}
