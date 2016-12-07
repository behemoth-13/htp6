package by.htp6.avtobase.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.ParameterNames;
import by.htp6.avtobase.command.factory.CommandFactory;
import by.htp6.avtobase.command.impl.Command;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 6574185461734484712L;

    public Controller() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		processRequest(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		processRequest(request, response);		
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		String page = null;
        CommandFactory factory = CommandFactory.getInstance();
        String commandParameter = request.getParameter(ParameterNames.COMMAND);
        Command command = factory.getCommand(commandParameter);
        page = command.execute(request, response);
        if(page == null) {
            page = PageNames.START_PAGE;
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			
		}
	}
}
