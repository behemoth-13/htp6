package by.htp6.avtobase.command.impl.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.bean.constants.Roles;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.ParameterNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.UserService;
import by.htp6.avtobase.service.factory.ServiceName;

public class BanUserById extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserService service = (UserService) serviceFactory.getOperationService(ServiceName.USER_SERVICE);
		int role = (int) session.getAttribute(AttributeNames.ROLE);
		if (role != Roles.ADMIN.getCodeRole()) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		try {
			int idBanUser = Integer.parseInt(request.getParameter(ParameterNames.U_ID_BAN_USER));
			service.banUserById(idBanUser);
			request.setAttribute(AttributeNames.MESSAGE, "User successfully banned");
		} catch (IllegalArgumentException | OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		} catch (Exception e) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong input");
			return PageNames.EXCEPTION;
		}
		return PageNames.SUCCESS;
	}
}