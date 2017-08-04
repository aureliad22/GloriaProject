<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
<div>
    <h2>${requestedTest.title}</h2>
    <p>Temps alloué : ${requestedTest.duration} minutes.</p>
</div>

Coder ici le traitement de la question


<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
