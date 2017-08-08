<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
<h1>Récapitulatif du test : ${requestedTest.title}</h1>
<div>
   <c:forEach items="${questionList}" var="q">
    <div>
        //TODO mettre la liste des question du test en cours.
    </div>
   </c:forEach>
</div>

<form action ="/Candidate/Result" method="post" id="endOfTest">
</form>
<button class="btn btn-default" onclick="confirmEndOfTest()">Terminer le test</button>

<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>