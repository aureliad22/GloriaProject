<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
<h1>Récapitulatif du test : ${requestedTest.title}</h1>
<div>
   <c:forEach items="${questionList}" var="q">
    <div class="ligne-recap">
    <form action="<%=request.getContextPath()%>/Candidate/RunTest" method="POST">
       Question ${q.key} 
       <c:if test="${q.value.marked}"> - marked</c:if>
       <c:if test="${!hasGivenAnswers.get(q.value.id)}"> - Aucune réponse donnée</c:if>
        //Mettre ici des input hidden avec de quoi reconstruire l'acces à la question
        <input type="submit" value="Revoir" class="btn btn-default btn-recap-test"/>
       </form>
    </div>
   </c:forEach>
   
</div>

<form action ="<%=request.getContextPath()%>/Candidate/Result" method="post" id="endOfTest">
</form>
<button class="btn btn-default" onclick="confirmEndOfTest()">Terminer le test</button>

<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
