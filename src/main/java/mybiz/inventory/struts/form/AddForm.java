package mybiz.inventory.struts.form;

import mybiz.inventory.model.ItemIn;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionForm;

public class AddForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	static {
		ConvertUtils.register(new mybiz.inventory.struts.others.DateConvert(), java.util.Date.class);
		ConvertUtils.register(new mybiz.inventory.struts.others.BigDecimalConvert(), java.math.BigDecimal.class);
	}
	
	private ItemIn itemIn;
	private String token;
	
	public AddForm() {
		super();
		this.itemIn = new ItemIn();
	}

	public ItemIn getItemIn() {
		return itemIn;
	}

	public void setItemIn(ItemIn itemIn) {
		this.itemIn = itemIn;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
