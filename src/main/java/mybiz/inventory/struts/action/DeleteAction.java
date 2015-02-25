package mybiz.inventory.struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DeleteAction extends Action {
	private static final Logger logger = Logger.getLogger(DeleteAction.class);
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("execute delete action");
		Map map = request.getParameterMap();
		for (Object key:map.keySet()) {
			logger.info(key+"::"+map.get(key));
		}
		return mapping.findForward("list");
	}

}
