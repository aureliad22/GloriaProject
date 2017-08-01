<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<c:if test="${error != null}">
<jsp:include page="/WEB-INF/jsp/includes/error.jsp"/>
</c:if>

<form method="POST" action="<%=request.getContextPath()%>/Login">
    Login : <input type="text" name="login" id="login" placeholder="Adresse mail ou identifiant"/>
    Password : <input type="password" name="password" id="password"/> 
    <input type="submit" name="connexion" value="Connexion"/>
</form>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
