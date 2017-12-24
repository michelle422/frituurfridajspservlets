package be.vdab.servlets;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.SausRepository;

/**
 * Servlet implementation class SausServlet
 */
@WebServlet("/saus.htm")
public class SausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/saus.jsp";
	private static final String SAUS_REQUESTS = "sausRequests";
	private final SausRepository sausRepository = new SausRepository();
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Saus> sauzen = Arrays.asList(
//				new Saus(1001, "cocktail", Arrays.asList("room", "ketchup", "paprikapoeder", "sherry", "cognac", "gembersiroop")), 
//				new Saus(1002, "mayonaise", Arrays.asList("eidooier", "olie", "azijn", "mosterd", "suiker", "kruiden", "peper", "zout")), 
//				new Saus(1002, "mosterd", Arrays.asList("mosterzaden", "water", "azijn", "suiker", "zout", "kruiden", "rozemarijn")), 
//				new Saus(1003, "tartare", Arrays.asList("mayonaise", "peterselie", "ei", "uitjes")), 
//				new Saus(1004, "vinaigrette", Arrays.asList("olijfolie", "wijnazijn", "zout", "peper", "kruiden")));
				
		((AtomicInteger) this.getServletContext().getAttribute(SAUS_REQUESTS)).incrementAndGet();
//		List<Saus> sauzen = new ArrayList<>();
//		sauzen.add(new Saus(11L, "cocktail", Arrays.asList("room", "ketchup", "paprikapoeder", "sherry", "cognac", "gembersiroop")));
//		sauzen.add(new Saus(12L, "mayonaise", Arrays.asList("eidooier", "olie", "azijn", "mosterd", "suiker", "kruiden", "peper", "zout")));
//		sauzen.add(new Saus(22L, "mosterd", Arrays.asList("mosterzaden", "water", "azijn", "suiker", "zout", "kruiden", "rozemarijn")));
//		sauzen.add(new Saus(13L, "tartare", Arrays.asList("mayonaise", "peterselie", "ei", "uitjes")));
//		sauzen.add(new Saus(14L, "vinaigrette", Arrays.asList("olijfolie", "wijnazijn", "zout", "peper", "kruiden")));
		request.setAttribute("sauzen", sausRepository.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute(SAUS_REQUESTS, new AtomicInteger());
	}
}
