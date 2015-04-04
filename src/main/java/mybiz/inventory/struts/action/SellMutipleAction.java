package mybiz.inventory.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybiz.inventory.model.ItemIn;
import mybiz.inventory.model.ItemSell;
import mybiz.inventory.service.ItemService;
import mybiz.inventory.struts.form.SellForm;
import mybiz.inventory.struts.form.SellMutipleForm;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SellMutipleAction extends Action {
	private static final Logger logger = Logger.getLogger(SellMutipleAction.class);
	
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isCancelled(request)) {
			return mapping.findForward("cancel");
		}
		
		logger.info("execute sell mutiple action");
		String[] itemInIdParams = request.getParameterValues("sellids");
		logger.info("itemidParam::"+itemInIdParams.length);
		
		SellMutipleForm sellMutipleForm = (SellMutipleForm)form;
		
		for (String idstr : itemInIdParams) {
			logger.info("id::"+idstr);
			Long id = Long.valueOf(idstr);
			ItemIn itemIn = itemService.findItemInById(id).get(0);
			sellMutipleForm.getItemIns().add(itemIn);
		}
		
		request.setAttribute("itemIns", sellMutipleForm.getItemIns());
		
		logger.info("getSellids::"+sellMutipleForm.getSellids().length);
		saveToken(request);
		return mapping.findForward("sellmutiple");
	}
	
}
