package mybiz.inventory.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybiz.inventory.model.ItemIn;
import mybiz.inventory.service.ItemService;
import mybiz.inventory.struts.form.UpdateForm;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UpdateAction extends Action {
	private static final Logger logger = Logger.getLogger(UpdateAction.class);
	
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isCancelled(request)) {
			return mapping.findForward("cancelled");
		}
		
		logger.info("execute update action");
		String itemidParam = request.getParameter("id");
		logger.info("itemidParam::"+itemidParam);
		
		UpdateForm updateForm = (UpdateForm)form;
		
		if (StringUtils.isNotBlank(itemidParam) && StringUtils.isNumeric(itemidParam)) {
			long itemid = Long.valueOf(itemidParam);
			ItemIn itemIn = itemService.findItemInById(itemid).get(0);
			logger.info("found itemIn::"+itemIn.getItemInId());
			updateForm.setItemIn(itemIn);
		} else if(updateForm.getItemIn() != null && updateForm.getItemIn().getItemInId() > 0) {
			logger.info("updateForm with ItemIn Id::"+updateForm.getItemIn().getItemInId());
		} else {
			logger.error("parameter itemInId is blank or not number");
			return mapping.findForward("cancelled");
		}
		
		if (isTokenValid(request) && updateForm.isForUpdate()) {
			resetToken(request);
			itemService.upadteItemIn(updateForm.getItemIn());
			logger.info("update success for::" + updateForm.getItemIn().getItemInId());
			ItemIn itemIn = itemService.findItemInById(updateForm.getItemIn().getItemInId()).get(0);
			updateForm.setItemIn(itemIn);
			this.setPromptMessage(request, "");
		}
		saveToken(request);
		return mapping.findForward("update");
	}
	
	private void setPromptMessage(HttpServletRequest request, String messageCode) {
		String message = "update success";
		request.setAttribute("prompt.message", message);
	}
}
