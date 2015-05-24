package mybiz.inventory.struts.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mybiz.inventory.model.ItemIn;
import mybiz.inventory.model.ItemSell;
import mybiz.inventory.vo.ItemInView;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

public class SellMutipleForm extends ActionForm {
	private static final Logger logger = Logger.getLogger(SellMutipleForm.class);
	private static final long serialVersionUID = 1L;
	
	static {
		ConvertUtils.register(new mybiz.inventory.struts.others.DateConvert(), java.util.Date.class);
		ConvertUtils.register(new mybiz.inventory.struts.others.BigDecimalConvert(), java.math.BigDecimal.class);
	}
	
	private ItemIn itemIn;
	private Long itemInId;
	private ItemSell itemSell;
	private boolean forSell;
	private String token;
	
	private ItemInView itemInView;
	private String[] sellids;
	private ArrayList<ItemIn> itemIns = new ArrayList<ItemIn>();
	private ArrayList<ItemInView> itemInViews = new ArrayList<ItemInView>();
	private Map<Long, Long> itemInSoldSizesMap = new HashMap<Long, Long>();
	private Map<String, String[]> itemInSellSizesMap = null;
	private Map<String, String[]> itemInSellPricesMap = null;
	
	public ArrayList<ItemIn> getItemIns() {
		return itemIns;
	}

	public void setItemIns(ArrayList<ItemIn> itemIns) {
		this.itemIns = itemIns;
	}

	public String[] getSellids() {
		return sellids;
	}

	public void setSellids(String[] sellids) {
		this.sellids = sellids;
	}

	public SellMutipleForm() {
		super();
		this.itemSell = new ItemSell();
		this.itemIn = new ItemIn();
		this.itemInId = 0l;
	}

	public Long getItemInId() {
		return itemInId;
	}

	public void setItemInId(Long itemInId) {
		this.itemInId = itemInId;
	}

	public ItemIn getItemIn() {
		return itemIn;
	}

	public void setItemIn(ItemIn itemIn) {
		this.itemIn = itemIn;
	}

	public ItemSell getItemSell() {
		return itemSell;
	}

	public void setItemSell(ItemSell itemSell) {
		this.itemSell = itemSell;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isForSell() {
		return forSell;
	}

	public void setForSell(boolean forSell) {
		this.forSell = forSell;
	}

	public ItemInView getItemInView() {
		return itemInView;
	}

	public void setItemInView(ItemInView itemInView) {
		this.itemInView = itemInView;
	}

	public ArrayList<ItemInView> getItemInViews() {
		return itemInViews;
	}

	public void setItemInViews(ArrayList<ItemInView> itemInViews) {
		this.itemInViews = itemInViews;
	}

	public Map<Long, Long> getItemInSoldSizesMap() {
		return itemInSoldSizesMap;
	}

	public void setItemInSoldSizesMap(Map<Long, Long> itemInSoldSizesMap) {
		this.itemInSoldSizesMap = itemInSoldSizesMap;
	}

	public Map<String, String[]> getItemInSellSizesMap() {
		if (itemInSellSizesMap==null) {
			itemInSellSizesMap = new HashMap<String, String[]>();
		}
		return itemInSellSizesMap;
	}

	public void setItemInSellSizesMap(Map<String, String[]> itemInSellSizesMap) {
		this.itemInSellSizesMap = itemInSellSizesMap;
	}

	public Map<String, String[]> getItemInSellPricesMap() {
		if (itemInSellPricesMap==null) {
			itemInSellPricesMap = new HashMap<String, String[]>();
		}
		return itemInSellPricesMap;
	}

	public void setItemInSellPricesMap(Map<String, String[]> itemInSellPricesMap) {
		this.itemInSellPricesMap = itemInSellPricesMap;
	}

}
