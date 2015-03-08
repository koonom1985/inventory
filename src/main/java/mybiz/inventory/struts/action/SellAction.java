package mybiz.inventory.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybiz.inventory.model.ItemIn;
import mybiz.inventory.model.ItemSell;
import mybiz.inventory.service.ItemService;
import mybiz.inventory.struts.form.SellForm;

import org.apache.commons.lang3.StringUtils;
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
		if (isCancelled(request)) {
			return mapping.findForward("cancel");
		}
		
		logger.info("execute sell action");
		String itemInIdParam = request.getParameter("id");
		logger.info("itemidParam::"+itemInIdParam);
		
		SellForm sellForm = (SellForm)form;
		
		logger.info("getItemInId::"+sellForm.getItemInId());
		
		long itemid = -1;
		
		if (StringUtils.isNotBlank(itemInIdParam) && StringUtils.isNumeric(itemInIdParam)) {
			itemid = Long.valueOf(itemInIdParam);
		} else if (sellForm != null && sellForm.getItemInId() > 0) {
			itemid = sellForm.getItemInId();
		} else {
			logger.error("no itemid found");
			return mapping.findForward("cancel");
		}
		
		if (itemid > 0) {
			ItemIn itemIn = itemService.findItemInById(itemid).get(0);
			logger.info("found itemIn::"+itemIn.getItemInId());
			sellForm.setItemIn(itemIn);
			sellForm.setItemInId(itemIn.getItemInId());
			request.setAttribute("itemIn", itemIn);
			
		}
		
		if (isTokenValid(request) && sellForm.isForSell() && itemid > 0) {
			resetToken(request);
			sellForm.getItemSell().setItemIn(sellForm.getItemIn());
			itemService.saveItemSell(sellForm.getItemSell());
		}
		
		if (itemid > 0) {
			List<ItemSell> soldList = itemService.findAllItemSellByItemIn(sellForm.getItemIn());
			logger.info("soldList::size::"+soldList.size());
			request.setAttribute("slist", soldList);
		}
		
		saveToken(request);
		return mapping.findForward("sell");
	}
	
}
