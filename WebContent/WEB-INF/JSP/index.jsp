<%-- Een welkom pagina --%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@page import='java.time.LocalDateTime'%>
<%@page import='java.time.DayOfWeek'%>
<%@page import='be.vdab.entities.Adres'%>
<%@page import='be.vdab.entities.Gemeente'%>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang='nl'>
	<head>
		<c:import url="/WEB-INF/JSP/head.jsp">
			<c:param name='title' value="Frituur" />
		</c:import>
	</head>
	<body>
		<h1>Frituur Frida</h1>
		<h2>Vandaag zijn we ${openingsuren}</h2>
		<h2>Adres:</h2>
		<dl>
			<dd>${adres.straat} ${adres.huisNr}<br>
				${adres.gemeente.naam} ${adres.gemeente.postCode}</dd>
		</dl>
		<img src='images/${openingsuren}.png' alt='${openingsuren}'>
		<br>
		<div>HelpDesk:
			<a href='tel:${helpDeskNummer}'>${helpDeskNummer}</a></div>
	</body>
</html>