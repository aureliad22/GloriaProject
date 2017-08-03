<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<h1>Tests disponibles : </h1>
<c:forEach items="${tests}" var="test">

<div class="ligne-test row">
    <div class="col-sm-4">
        <span class="titre-test">${test.title}</span>
    </div>
    <div class="col-sm-4 temps-test">
    <p>Temps alloué : ${test.duration} minutes.</p>
    </div>
    <div class="col-sm-4 take-test">
    <form class="take-test" action="<%=request.getContextPath()%>/Candidate/TakeTest" method="post">
        <input type="hidden" name="idTest" value="${test.id}"/>
        <input type="submit" name="start" class="btn btn-default" value="Démarrer le test"/>
    </form>
    </div>
</div>


</c:forEach>


<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>