package by.htp6.avtobase.command.impl.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.bean.User;
import by.htp6.avtobase.bean.constants.Roles;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.UserService;
import by.htp6.avtobase.service.factory.ServiceName;

public class GetUsers extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserService service = (UserService) serviceFactory.getOperationService(ServiceName.USER_SERVICE);
        Integer role = (Integer) session.getAttribute(AttributeNames.ROLE);
		
		if (role != Roles.ADMIN.getCodeRole()) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		List<User> list = null;
		try {
			list = service.getUsers();
			request.setAttribute(AttributeNames.LIST_USERS, list);
		} catch (OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}
		return PageNames.SHOW_USERS;
	}
}
