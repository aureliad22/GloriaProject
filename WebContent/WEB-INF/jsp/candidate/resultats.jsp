<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<h1>Résultats des tests complétés : </h1>

<div class="bloc-result">
	<c:set var="numTest" value="${0}"/>
	<c:forEach items="${resultats}" var="ligneResultat">
	    <div class="row">
	        <h4>${ligneResultat.title} :</h4>
	        <div class="status">${statusTest.get(numTest)}</div>
	    </div>
	    <c:set var="numTest" value="${numSection+1}"/>          
	</c:forEach>
</div>

<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>