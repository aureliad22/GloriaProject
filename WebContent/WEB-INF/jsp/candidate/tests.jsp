<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<h1>Tests disponibles : </h1>
<c:forEach items="${tests}" var="test">
    <div class="ligne_tests">
        <form action="/Candidate/TakeTest" method="POST">
            <label>${test.title}</label>
            <input type="hidden" value="${test.id}"/>
            <input type="submit" name="startTest" value="Commencer">
        </form>
    </div>
</c:forEach>


<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>