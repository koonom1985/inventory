package mybiz.inventory.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybiz.inventory.service.ItemService;
import mybiz.inventory.struts.form.AddForm;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AddAction extends Action {
	private static final Logger logger = Logger.getLogger(AddAction.class);
	
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isCancelled(request)) {
			return mapping.findForward("list");
		}
		AddForm addForm = (AddForm)form;
		logger.info("addForm::Itemin::"+addForm.getItemIn());
		if ( addForm.getItemIn() != null ) {
			logger.info("addForm::Itemin::Code::"+addForm.getItemIn().getCode());
			logger.info("addForm::Itemin::Name::"+addForm.getItemIn().getName());
			logger.info("addForm::Itemin::IsTrans::"+addForm.getItemIn().getIsTrans());
			logger.info("addForm::Itemin::Address::"+addForm.getItemIn().getAddress());
			logger.info("addForm::Itemin::PurchaseSize::"+addForm.getItemIn().getPurchaseSize());
			logger.info("addForm::Itemin::PurcahasPrice::"+addForm.getItemIn().getPurcahasPrice());
			logger.info("addForm::Itemin::PurchaseDatetime::"+addForm.getItemIn().getPurchaseDatetime());
		}
		if (isTokenValid(request)) {
			resetToken(request);
			itemService.saveItemIn(addForm.getItemIn());
		}
		saveToken(request);
		return mapping.findForward("list");
	}
	
}
