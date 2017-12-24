package be.vdab.servlets;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Gemeente;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns="/index.htm", name="indexservlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private static final String INDEX_REQUESTS = "indexRequests";
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("helpDeskNummer", this.getServletContext().getInitParameter("helpDeskNummer"));
		((AtomicInteger) this.getServletContext().getAttribute(INDEX_REQUESTS)).incrementAndGet();
		LocalDate vandaag = LocalDate.now();
		DayOfWeek weekdag = vandaag.getDayOfWeek();
		request.setAttribute("openingsuren",
		weekdag == DayOfWeek.MONDAY || weekdag == DayOfWeek.THURSDAY ?
				"gesloten" : "open");
		request.setAttribute("adres", new Adres("Stationplein", "23", new Gemeente("Oudenaarde", 9700)));
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
		dispatcher.forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(INDEX_REQUESTS, new AtomicInteger());
	}
	
	
}
