package by.htp6.avtobase.command.impl.brandsOfCar;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.avtobase.bean.BrandOfCar;
import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.exception.OperationNotExecutedException;
import by.htp6.avtobase.service.BrandsOfCarService;
import by.htp6.avtobase.service.factory.ServiceName;

public class GetBrandsOfCars extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BrandsOfCarService service = (BrandsOfCarService) serviceFactory.getOperationService(ServiceName.BRANDS_OF_CAR_SERVICE);
		
		List<BrandOfCar> list = null;
		try {
			list = service.getBrandsOfCars();
		} catch (OperationNotExecutedException e) {
			request.setAttribute(AttributeNames.EXCEPTION, e.getMessage());
			return PageNames.EXCEPTION;
		}
		request.setAttribute(AttributeNames.LIST_BRANDS_OF_CARS, list);
		return PageNames.SHOW_BRANDS_OF_CARS;
	}
}