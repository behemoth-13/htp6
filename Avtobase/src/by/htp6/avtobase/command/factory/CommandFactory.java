package by.htp6.avtobase.command.factory;

import java.util.HashMap;
import java.util.Map;

import by.htp6.avtobase.SourceInit;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.command.impl.brandsOfCar.AddBrandOfCar;
import by.htp6.avtobase.command.impl.brandsOfCar.GetBrandsOfCars;
import by.htp6.avtobase.command.impl.car.AddCar;
import by.htp6.avtobase.command.impl.car.GetCars;
import by.htp6.avtobase.command.impl.car.UpdateCountOfKM;
import by.htp6.avtobase.command.impl.localization.Localization;
import by.htp6.avtobase.command.impl.order.AddOrder;
import by.htp6.avtobase.command.impl.order.GetOrders;
import by.htp6.avtobase.command.impl.order.GetOrdersByStatus;
import by.htp6.avtobase.command.impl.order.GetOrdersByUsersId;
import by.htp6.avtobase.command.impl.order.UpdateStatusOrderByID;
import by.htp6.avtobase.command.impl.trip.GetTrips;
import by.htp6.avtobase.command.impl.trip.UpdateStatusTripByID;
import by.htp6.avtobase.command.impl.user.BanUserById;
import by.htp6.avtobase.command.impl.user.Exit;
import by.htp6.avtobase.command.impl.user.GetUsers;
import by.htp6.avtobase.command.impl.user.Logination;
import by.htp6.avtobase.command.impl.user.RegisterUser;
import by.htp6.avtobase.exception.InitException;

public class CommandFactory implements SourceInit {

	private static CommandFactory instance = new CommandFactory();
	private static Map<String, Command> map = new HashMap<>();
	
	private CommandFactory(){}
	
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public Command getCommand(String commandName) {
		if (map.containsKey(commandName)) {
			return map.get(commandName);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public void init() throws InitException {
		map.put("ba", new AddBrandOfCar());
		map.put("bg", new GetBrandsOfCars());
		map.put("ca", new AddCar());
		map.put("cg", new GetCars());
		map.put("cu", new UpdateCountOfKM());
		map.put("oa", new AddOrder());
		map.put("og", new GetOrders());
		map.put("ob", new GetOrdersByStatus());
		map.put("ou", new GetOrdersByUsersId());
		map.put("os", new UpdateStatusOrderByID());
		map.put("tg", new GetTrips());
		map.put("tu", new UpdateStatusTripByID());
		map.put("ub", new BanUserById());
		map.put("ug", new GetUsers());
		map.put("ur", new RegisterUser());
		map.put("ul", new Logination());
		map.put("ue", new Exit());
		map.put("ll", new Localization());
	}

	@Override
	public void destroy() {
		map.clear();		
	}

}
