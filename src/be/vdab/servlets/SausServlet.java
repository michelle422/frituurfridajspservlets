package be.vdab.servlets;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.repositories.SausRepository;

/**
 * Servlet implementation class SausServlet
 */
@WebServlet("/saus.htm")
public class SausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/saus.jsp";
	private static final String SAUS_REQUESTS = "sausRequests";
	private final transient SausRepository sausRepository = new SausRepository();
       
	@Resource(name = SausRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		sausRepository.setDataSource(dataSource);
	}
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		((AtomicInteger) this.getServletContext().getAttribute(SAUS_REQUESTS)).incrementAndGet();
		request.setAttribute("sauzen", sausRepository.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(SAUS_REQUESTS, new AtomicInteger());
	}
}
