<%@ page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<head>
	<c:import url="head.jsp">
		<c:param name="title" value="Gastenboek"/>
	</c:import>
</head>
<body>
	<vdab:menu/>
	<h1>Gastenboek</h1>
	<c:if test='${not empty beheer}'>
		<form method='post'>
			<input type='submit' value='Uitloggen' name='uitloggen'>
		</form>
	</c:if>
	<c:choose>
		<c:when test="${empty param.toevoegen}">
			<a href="<c:url value='/gastenboek.htm?toevoegen=true'/>">Toevoegen</a>
		</c:when>
		<c:otherwise>
			<form method="post">
				<label>Naam:<span>${fouten.naam}</span>
					<input name='naam' autofocus required value='${param.naam}'>
				</label>
				<label>Bericht:<span>${fouten.bericht}</span>
					<textarea name="bericht" required rows="5" cols="80">${param.bericht}</textarea>
				</label>
				<input type="submit" value="Toevoegen">
			</form>
		</c:otherwise>
	</c:choose>
	<c:if test='${not empty gastenboek}'>
		<dl>
			<c:forEach var="entry" items="${gastenboek}">
				<fmt:parseDate value="${entry.datumTijd}" pattern="yyyy-MM-dd'T'HH:mm" 
					var="datumTijdAlsTimestamp" type="date"/>
				<dt><fmt:formatDate value="${datumTijdAlsTimestamp}" type="both" dateStyle="short" timeStyle="short"/>
					${entry.naam}
					<c:if test='${not empty beheer}'>
						<form method="post">
							<input type='checkbox' name='id' value='${entry.id}'>
						</form>
					</c:if>
				</dt>
				<dd>${entry.bericht}</dd>
			</c:forEach>
			<c:if test='${not empty beheer}'>
				<form method="post">
					<input type='submit' value='Verwijderen' name='verwijderen'>
				</form>
			</c:if>
		</dl>
	</c:if>
</body>
</html>