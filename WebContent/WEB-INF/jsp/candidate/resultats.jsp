<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<h1>Résultats des tests : </h1>

    <c:if test="${resultats.size() > 0}">
		<div class="bloc-result">
			<c:set var="numTest" value="${0}"/>
			<c:forEach items="${resultats}" var="test">
			    <div class="row">
			        <h4>${test.title} :</h4>
			        <div class="status">${statusTest.get(numTest)}</div>
			    </div>
			    <c:set var="numTest" value="${numSection+1}"/>          
			</c:forEach>
		</div>
	</c:if>
    <c:if test="${resultats.size() < 1}">
        <div class="ligne-test">
            <span>Vous n'avez complété aucun test pour le moment.</span>
        </div>
    </c:if>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>