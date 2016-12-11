package by.htp6.avtobase.command.impl.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.bean.User;
import by.htp6.avtobase.bean.constants.Roles;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.ParameterNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.UserService;
import by.htp6.avtobase.service.factory.ServiceName;

public class RegisterUser extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserService service = (UserService) serviceFactory.getOperationService(ServiceName.USER_SERVICE);

		Integer role = (Integer) session.getAttribute(AttributeNames.ROLE);
		if (role != null) {
			request.setAttribute(AttributeNames.EXCEPTION, "Already registered");
			return PageNames.EXCEPTION;
		}
		try {
			User user = new User();
			String password = request.getParameter(ParameterNames.U_PASSWORD);
            user.setName(request.getParameter(ParameterNames.U_NAME));
            user.setSurname(request.getParameter(ParameterNames.U_SURNAME));
            user.setLogin(request.getParameter(ParameterNames.U_LOGIN));
            user.setEmail(request.getParameter(ParameterNames.U_EMAIL));
            user.setPhone(request.getParameter(ParameterNames.U_PHONE));
            user.setRole(Roles.USER.getCodeRole());
            user.setCreationDate(new Date().toString());
			service.registerUser(user, password);
		} catch (OperationNotExecutedException | IllegalArgumentException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}
		return PageNames.SUCCESS;
	}
}