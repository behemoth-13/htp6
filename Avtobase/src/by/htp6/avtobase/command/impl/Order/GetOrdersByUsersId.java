package by.htp6.avtobase.command.impl.Order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.bean.Order;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.constants.Roles;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.OrderService;
import by.htp6.avtobase.service.factory.ServiceName;

public class GetOrdersByUsersId extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		OrderService service = (OrderService) serviceFactory.getOperationService(ServiceName.ORDER_SERVICE);
        int role = (int) session.getAttribute(AttributeNames.ROLE);
        
		if (role != Roles.USER.getCodeRole()) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		List<Order> list = null;
		int userId = (int) session.getAttribute(AttributeNames.USER_ID);
		try {
			list = service.getOrdersByUsersId(userId);
			request.setAttribute(AttributeNames.LIST_ORDERS, list);
		} catch (OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}
		return PageNames.SHOW_ORDERS_BY_USER_ID;
	}
}