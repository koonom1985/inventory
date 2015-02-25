package mybiz.inventory.dao;

import java.util.List;

import mybiz.inventory.model.ItemIn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemDAOTest {
	private ItemDAO testClass;
	
	@Before
	public void before() {
		testClass = new ItemDAO();
		testClass.setSessionFactory(HibernateUtil.getSessionFactory());
	}
	
	@Test
	public void testFindAllItemIn() {
		List<ItemIn> results = testClass.findAllItemIn();
		Assert.assertEquals("should has size", results.size(), 0);
	}
}
