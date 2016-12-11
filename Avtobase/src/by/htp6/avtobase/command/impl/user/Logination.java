package by.htp6.avtobase.command.impl.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.bean.User;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.ParameterNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.UserService;
import by.htp6.avtobase.service.factory.ServiceName;

public class Logination extends Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserService service = (UserService) serviceFactory.getOperationService(ServiceName.USER_SERVICE);
		Integer role = (Integer) session.getAttribute(AttributeNames.ROLE);
		
		if (role != null) {
			request.setAttribute(AttributeNames.EXCEPTION, "you login already");
			return PageNames.EXCEPTION;
		}
		User user = new User();
		try {
			String login = request.getParameter(ParameterNames.U_LOGIN);
			String password = request.getParameter(ParameterNames.U_PASSWORD);
			
			user = service.getUser(login, password);
			session.setAttribute(AttributeNames.USER_ID, user.getId());
			session.setAttribute(AttributeNames.NAME, user.getName());
			session.setAttribute(AttributeNames.SURNAME, user.getSurname());
			session.setAttribute(AttributeNames.LOGIN, user.getLogin());
			session.setAttribute(AttributeNames.EMAIL, user.getEmail());
			session.setAttribute(AttributeNames.PHONE, user.getPhone());
			session.setAttribute(AttributeNames.ROLE, user.getRole());
			session.setAttribute(AttributeNames.USER_CREATION_DATE, user.getCreationDate());
		} catch (NullPointerException e) {
			request.setAttribute(AttributeNames.EXCEPTION, "User is not exist");
			return PageNames.EXCEPTION;
		} catch (OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}
		return PageNames.START_PAGE;
	}
}
