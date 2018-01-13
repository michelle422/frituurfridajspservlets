<%-- Een welkom pagina --%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<fmt:setBundle basename="resourceBundles.teksten"/>
<%@page import='java.time.LocalDateTime'%>
<%@page import='java.time.DayOfWeek'%>
<%@page import='be.vdab.entities.Adres'%>
<%@page import='be.vdab.entities.Gemeente'%>
<!doctype html>
<html lang='nl'>
	<head>
		<fmt:message key='frituurFrida' var='title'/>
		<c:import url="/WEB-INF/JSP/head.jsp">
			<c:param name='title' value='${title}' />
		</c:import>
	</head>
	<body>
		<vdab:menu/>
		<h1><fmt:message key='frituurFrida'/></h1>
		<h2><fmt:message key='vandaagZijnWe${openingsuren}'/></h2>
		<h2><fmt:message key='adres'/>:</h2>
		<dl>
			<dd>${adres.straat} ${adres.huisNr}<br>
				${adres.gemeente.naam} ${adres.gemeente.postCode}</dd>
		</dl>
		<fmt:message key='afbeelding${openingsuren}' var='afbeelding'/>
		<img src='<c:url value="/images/${afbeelding}.png"/>' alt="<fmt:message key='${openingsuren}'/>">
		<br>
		<div>HelpDesk:
			<a href='tel:${helpDeskNummer}'>${helpDeskNummer}</a></div>
	</body>
</html>