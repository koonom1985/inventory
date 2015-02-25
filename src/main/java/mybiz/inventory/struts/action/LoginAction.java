package mybiz.inventory.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybiz.inventory.struts.form.LoginForm;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginForm loginForm = (LoginForm) form;
		if (loginForm.getUserName() == null || loginForm.getPassword() == null
                || !loginForm.getUserName().equalsIgnoreCase("Mukesh")
                || !loginForm.getPassword().equals("kumar")) {
			logger.info("execute::login fail");
            return mapping.findForward("failure");
        } else
        	logger.info("execute::login success");
            return mapping.findForward("success");
    }
}
