package by.htp6.avtobase.command.impl.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.command.AttributeNames;
import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.impl.Command;

public class Exit extends Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute(AttributeNames.USER_ID);
		
		if (userId == null) {
			request.setAttribute(AttributeNames.EXCEPTION, "No users in the session");
			return PageNames.EXCEPTION;
		} else {		
			session.setAttribute(AttributeNames.USER_ID, null);
			session.setAttribute(AttributeNames.NAME, null);
			session.setAttribute(AttributeNames.SURNAME, null);
			session.setAttribute(AttributeNames.LOGIN, null);
			session.setAttribute(AttributeNames.EMAIL, null);
			session.setAttribute(AttributeNames.PHONE, null);
			session.setAttribute(AttributeNames.ROLE, null);
			session.setAttribute(AttributeNames.USER_CREATION_DATE, null);
			return PageNames.START_PAGE;
		}
	}
}