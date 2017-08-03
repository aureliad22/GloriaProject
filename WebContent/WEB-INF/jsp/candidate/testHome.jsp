<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
<div>
    <h2>${requestedTest.title}</h2>
    <p>Temps alloué : ${requestedTest.duration} minutes.</p>
    <form action="" method="post">
        <input type="submit" name="start" class="btn btn-default" value="Démarrer le test"/>
    </form>
</div>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
