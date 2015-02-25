package mybiz.inventory.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybiz.inventory.model.ItemIn;
import mybiz.inventory.service.ItemService;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

public class ListAction extends Action {
	private static final Logger logger = Logger.getLogger(ListAction.class);
	
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String pageParam = new ParamEncoder("itemdata").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
		logger.info("page param::" + pageParam);
		logger.info("page param value::" + request.getParameter(pageParam));
		
		List<ItemIn> iteminList = itemService.findAllItemIn();
		logger.info("itemService::find all size::" + iteminList.size());
		request.setAttribute("rlist", iteminList);
		saveToken(request);
		return mapping.findForward("list");
	}

}
