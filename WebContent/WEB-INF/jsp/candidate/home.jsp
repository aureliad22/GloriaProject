<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<h1>Bienvenue ${user.firstName}</h1>

Veuillez choisir une action !
<form action="<%=request.getContextPath()%>/Tests" method="POST">
    <input type="submit" name="passer_test" id="passer_test" value="Passer un test"/>
</form>
<form action="<%=request.getContextPath()%>/Resultats" method="POST">
    <input type="submit" name="consulter_resultats" id="consulter_resultats" value="Consulter mes résultats"/>
</form>

<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>