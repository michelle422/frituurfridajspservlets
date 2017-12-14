package be.vdab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
//@WebServlet("/index.htm")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html lang='nl'><head>");
		out.println("<title>Frituur Frida</title></head>");
		out.println("<body><h1>");
		DayOfWeek dag = LocalDateTime.now().getDayOfWeek();
		out.print(dag.equals(DayOfWeek.MONDAY) || dag.equals(DayOfWeek.THURSDAY) ? 
				"Vandaag zijn we gesloten" : "Vandaag zijn we open");
		out.println("</h1></body></html>");
	}

}
