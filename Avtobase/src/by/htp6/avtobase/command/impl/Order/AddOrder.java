package by.htp6.avtobase.command.impl.Order;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.bean.Order;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.ParameterNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.constants.OrderStatus;
import by.htp6.avtobase.constants.Roles;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.OrderService;
import by.htp6.avtobase.service.factory.ServiceName;

public class AddOrder extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		OrderService service = (OrderService) serviceFactory.getOperationService(ServiceName.ORDER_SERVICE);
		int role = (int) session.getAttribute(AttributeNames.ROLE);
		
		if (role != Roles.USER.getCodeRole()) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		try {
			Order order = new Order();
			order.setUserId((int) session.getAttribute(AttributeNames.USER_ID));
			order.setWeight(Integer.parseInt(request.getParameter(ParameterNames.O_WEIGHT).trim()));
			order.setCapacity(Integer.parseInt(request.getParameter(ParameterNames.O_CAPACITY).trim()));
			order.setDistance(Integer.parseInt(request.getParameter(ParameterNames.O_DISTANCE).trim()));
			order.setStatusOrder(OrderStatus.HAS_COME.getOrderStatus());
			order.setTimeStatusOrder(new Date().toString());
			order.setCreationTime(new Date().toString());
			service.addOrder(order);
			request.setAttribute(AttributeNames.MESSAGE, "Order successfully added");
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