package by.htp6.avtobase.command.impl.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.bean.constants.Roles;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.ParameterNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.OrderService;
import by.htp6.avtobase.service.factory.ServiceName;

public class UpdateStatusOrderByID extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		OrderService service = (OrderService) serviceFactory.getOperationService(ServiceName.ORDER_SERVICE);
		int role = (int) session.getAttribute(AttributeNames.ROLE);
		if ((role != Roles.DRIVER.getCodeRole()) && (role != Roles.MANAGER.getCodeRole())) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		try {
			int orderId = Integer.parseInt(request.getParameter(ParameterNames.O_ID));
			int status = Integer.parseInt(request.getParameter(ParameterNames.O_STATUS));
			service.updateStatusOrderByID(orderId, status);
			request.setAttribute(AttributeNames.MESSAGE, "Status successfully updated");
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