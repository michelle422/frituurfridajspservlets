<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@page import='be.vdab.entities.Saus'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<c:import url='/WEB-INF/JSP/head.jsp'>
	 		<c:param name='title' value="Sauzen"/>
		</c:import>
	</head>
	<body>
		<h1>Sauzen
			<c:forEach begin='1' end='5'>
				&#42; <%-- de HTML code van een asterisk --%>
			</c:forEach>
		</h1>
		<form method='post' action="<c:url value='/saus/verwijderen.htm'/>">	
			<c:forEach var='saus' items='${sauzen}'>
				<h2>
					<label>
						<input type='checkbox' name='id' value='${saus.id}'> ${saus.naam}
					</label>
				</h2>
				<img src='<c:url value="images/${saus.naam}.png"/>' alt='${saus.naam}'>
				Ingredienten: 
				<c:forEach var='ingredient' items='${saus.ingredienten}' varStatus="status">
					${ingredient}<c:if test="${not status.last}">, </c:if>
				</c:forEach> 
			</c:forEach>
			<div><input type='submit' value='Aangevinkte sauzen verwijderen'></div>
		</form>
	</body>
</html>