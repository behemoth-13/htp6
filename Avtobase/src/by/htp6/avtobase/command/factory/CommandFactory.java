package by.htp6.avtobase.command.factory;

import java.util.HashMap;
import java.util.Map;

import by.htp6.avtobase.SourceInit;
import by.htp6.avtobase.command.impl.Command;
import by.htp6.avtobase.exception.InitException;

public class CommandFactory implements SourceInit {

	private static CommandFactory instance = new CommandFactory();
	private static Map<String, Command> map = new HashMap<>();
	
	private CommandFactory(){}
	
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public static Command getCommand(String commandName) {
		return map.get(commandName);
	}
	
	@Override
	public void init() throws InitException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		map.clear();		
	}

}
