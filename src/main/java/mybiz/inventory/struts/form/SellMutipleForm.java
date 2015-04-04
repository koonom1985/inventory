package mybiz.inventory.struts.form;

import java.util.ArrayList;

import mybiz.inventory.model.ItemIn;
import mybiz.inventory.model.ItemSell;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionForm;

public class SellMutipleForm extends ActionForm {

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
	
	private String[] sellids;
	private ArrayList<ItemIn> itemIns = new ArrayList<ItemIn>();
	
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
	
}
