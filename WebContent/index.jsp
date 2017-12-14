<%-- Een welkom pagina --%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@page import='java.time.LocalDateTime'%>
<%@page import='java.time.DayOfWeek'%>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang='nl'>
	<head><title>Frituur Frida</title></head>
	<body>
		<h1>
			<%
				DayOfWeek dag = LocalDateTime.now().getDayOfWeek();
				out.print(dag.equals(DayOfWeek.MONDAY) || dag.equals(DayOfWeek.THURSDAY) ? 
						"Vandaag zijn we gesloten" : "Vandaag zijn we open");
			%>
		</h1>
	</body>
</html>