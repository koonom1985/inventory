package mybiz.inventory.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybiz.inventory.service.ItemService;
import mybiz.inventory.struts.form.SellForm;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SellAction extends Action {
	private static final Logger logger = Logger.getLogger(SellAction.class);
	
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.info("execute sell action");
		String itemInIdParam = request.getParameter("id");
		logger.info("itemidParam::"+itemInIdParam);
		
		SellForm sellForm = (SellForm)form;
		logger.info("sellForm::ItemSell::"+sellForm.getItemSell());
		if ( sellForm.getItemSell() != null ) {
			logger.info("sellForm::ItemSell::getItemSellId::"+sellForm.getItemSell().getItemSellId());
		}
		if (isTokenValid(request) && sellForm.isForSell()) {
			resetToken(request);
			itemService.saveItemSell(sellForm.getItemSell());
		}
		saveToken(request);
		return mapping.findForward("sell");
	}
	
}
