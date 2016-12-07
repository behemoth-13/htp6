package by.htp6.avtobase.command.impl.Car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.bean.constants.Roles;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.ParameterNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.CarService;
import by.htp6.avtobase.service.factory.ServiceName;

public class UpdateCountOfKM extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		CarService service = (CarService) serviceFactory.getOperationService(ServiceName.CAR_SERVICE);
		int role = (int) session.getAttribute(AttributeNames.ROLE);
		if (role != Roles.DRIVER.getCodeRole()) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		try {
			int driverId = (int) session.getAttribute(AttributeNames.USER_ID);
			int countOfKM = Integer.parseInt(request.getParameter(ParameterNames.C_COUNT_OF_KM));
			service.updateCountOfKM(driverId, countOfKM);
			request.setAttribute(AttributeNames.MESSAGE, "Count of KM successfully updated");
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