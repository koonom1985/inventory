package mybiz.inventory.struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybiz.inventory.service.ItemService;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.commons.lang3.StringUtils;

public class DeleteAction extends Action {
	private static final Logger logger = Logger.getLogger(DeleteAction.class);
	
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("execute delete action");
		String itemidParam = request.getParameter("id");
		logger.info("itemidParam::"+itemidParam);
		
		if (StringUtils.isNotBlank(itemidParam) && StringUtils.isNumeric(itemidParam)) {
			long itemid = Long.valueOf(itemidParam);
			itemService.deleteItemIn(itemid);
		} else {
			logger.error("parameter itemInId is blank or not number");
		}
		
		return mapping.findForward("list");
	}

}
