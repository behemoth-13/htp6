package by.htp6.avtobase.command.impl.BrandsOfCar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.bean.BrandOfCar;
import by.htp6.avtobase.bean.constants.Roles;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.ParameterNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.BrandsOfCarService;
import by.htp6.avtobase.service.factory.ServiceName;

public class AddBrandOfCar extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		BrandsOfCarService service = (BrandsOfCarService) serviceFactory.getOperationService(ServiceName.BRANDS_OF_CAR_SERVICE);
		Integer role = (Integer) session.getAttribute(AttributeNames.ROLE);
		
		if (role != Roles.ADMIN.getCodeRole()) {
			request.setAttribute(AttributeNames.EXCEPTION, "Wrong Access level");
			return PageNames.EXCEPTION;
		}
		try {
			BrandOfCar brandOfCar = new BrandOfCar();
			brandOfCar.setName(request.getParameter(ParameterNames.BOC_NAME).trim());
			brandOfCar.setLoadingCapacity(Integer.parseInt(request.getParameter(ParameterNames.BOC_LOADING_CAPACITY).trim()));
			brandOfCar.setCapacity(Integer.parseInt(request.getParameter(ParameterNames.BOC_CAPACITY).trim()));
			brandOfCar.setCostPerKM(Integer.parseInt(request.getParameter(ParameterNames.BOC_COST_PER_KM).trim()));
			service.addBrandOfCar(brandOfCar);
			request.setAttribute(AttributeNames.MESSAGE, "Brand of car successfully added");
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