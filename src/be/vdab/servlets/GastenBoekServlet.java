package be.vdab.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.GastenBoekEntry;
import be.vdab.repositories.GastenBoekRepository;

/**
 * Servlet implementation class GastenBoekServlet
 */
@WebServlet("/gastenboek.htm")
public class GastenBoekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/gastenboek.jsp";
	private static final String REDIRECT_URL = "/gastenboek.htm";
	private static final GastenBoekRepository gastenBoekRepository = 
			new GastenBoekRepository();
	@Resource(name = GastenBoekRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		gastenBoekRepository.setDataSource(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("gastenboek", gastenBoekRepository.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("toevoegen") != null) {
			toevoegen(request, response);
		} else if (request.getParameter("uitloggen") != null) {
			uitloggen(request, response);
		} else if (request.getParameter("verwijderen") != null) {
			verwijderen(request, response);
		}
	}
	
	private void toevoegen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> fouten = new HashMap<>();
		String naam = request.getParameter("naam");
		if (!GastenBoekEntry.isNaamValid(naam)) {
			fouten.put("naam", "verplicht");
		}
		String bericht = request.getParameter("bericht");
		if (!GastenBoekEntry.isBerichtValid(bericht)) {
			fouten.put("bericht", "verplicht");
		}
		if (fouten.isEmpty()) {
			gastenBoekRepository.create(new GastenBoekEntry(naam, bericht));
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + REDIRECT_URL));
		} else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

	private void uitloggen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("beheer");
		response.sendRedirect(response.encodeRedirectURL(
				 request.getContextPath() + REDIRECT_URL));
	}
	
	private void verwijderen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] idAlsString = request.getParameterValues("id");
		if (idAlsString != null) {
			gastenBoekRepository.delete(Arrays.stream(idAlsString)
									.map(id -> Long.parseLong(id))
									.collect(Collectors.toSet()));
		}
	}
}
