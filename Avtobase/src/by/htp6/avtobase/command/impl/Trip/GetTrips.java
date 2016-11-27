package by.htp6.avtobase.command.impl.Trip;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.bean.Trip;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.constants.Roles;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.TripService;
import by.htp6.avtobase.service.factory.ServiceName;

public class GetTrips extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		TripService service = (TripService) serviceFactory.getOperationService(ServiceName.TRIP_SERVICE);
        Integer role = (Integer) session.getAttribute(AttributeNames.ROLE);
		
		if ((role == Roles.BANNED_USER.getCodeRole()) || (role == Roles.GUEST.getCodeRole())) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		List<Trip> list = null;
		try {
			list = service.getTrips();
			request.setAttribute(AttributeNames.LIST_TRIPS, list);
		} catch (OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}
		return PageNames.SHOW_TRIPS;
	}
}