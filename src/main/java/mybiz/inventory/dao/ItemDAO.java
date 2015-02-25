package mybiz.inventory.dao;

import java.util.List;

import mybiz.inventory.model.ItemIn;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ItemDAO extends HibernateDaoSupport {

	public void save(ItemIn item) {
		getHibernateTemplate().save(item);
	}
	
	public List<ItemIn> findAllItemIn() {
		return getHibernateTemplate().find("from ItemIn");
	}
	
	public List<ItemIn> findItemInByIndex(int start, int end) {
		return getHibernateTemplate().find(
			"from ItemIn t where t.itemInId=? and t.itemInId=?", 
			new Object[]{start, end});
	}
}
