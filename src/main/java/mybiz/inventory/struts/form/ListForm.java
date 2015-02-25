package mybiz.inventory.struts.form;

import mybiz.inventory.struts.others.Criteria;
import org.apache.struts.action.ActionForm;

public class ListForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	private Criteria criteria = new Criteria();
	public Criteria getCriteria() {
		return criteria;
	}
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
}
