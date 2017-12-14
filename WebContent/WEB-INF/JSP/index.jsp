<%-- Een welkom pagina --%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@page import='java.time.LocalDateTime'%>
<%@page import='java.time.DayOfWeek'%>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang='nl'>
	<head>
		<title>Frituur Frida</title>
		<link rel='icon' href='images/favicon.ico'>
		<meta name='viewport' content='width=device-width,initial-scale=1'>
		<link rel='stylesheet' href='styles/default.css'>	
	</head>
	<body>
		<h1>Frituur Frida</h1>
		<h2>Vandaag zijn we ${openingsuren}</h2>
		<img src="images/${openGesloten}.png" alt="${openGesloten}">
	</body>
</html>