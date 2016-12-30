package by.htp6.avtobase.command.impl.localization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp6.avtobase.command.PageNames;
import by.htp6.avtobase.command.impl.Command;

public class Localization  extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		String locale = request.getParameter("local");
		if (locale != null && (locale.equals("ru") || locale.equals("en"))){
			session.setAttribute("local", locale);
		}
		return PageNames.START_PAGE;
	}
}