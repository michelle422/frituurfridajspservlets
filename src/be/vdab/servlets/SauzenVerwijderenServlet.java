package be.vdab.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.repositories.SausRepository;

/**
 * Servlet implementation class SauzenVerwijderenServlet
 */
@WebServlet("/saus/verwijderen.htm")
public class SauzenVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String VIEW = "/WEB-INF/JSP/saus.jsp";
	private static final String REDIRECT_URL = "/saus.htm";
	private final transient SausRepository sausRepository = new SausRepository();

	@Resource(name = SausRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		sausRepository.setDataSource(dataSource);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] idsAlsString = request.getParameterValues("id");
		if (idsAlsString != null) {
			sausRepository.delete(Arrays.stream(idsAlsString).map(id -> Long.parseLong(id))
							.collect(Collectors.toSet()));
		}
		response.sendRedirect(request.getContextPath() + REDIRECT_URL);
	}
}
