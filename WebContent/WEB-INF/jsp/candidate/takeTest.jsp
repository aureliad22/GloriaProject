<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
<div>
    <h2>${requestedTest.title}</h2>
    <p>Temps alloué : ${requestedTest.duration} minutes.</p>
</div>

<c:forEach items="${requestedTest.questions}" var="q">
    <div class="bloc_question">
        ${q.question}
    </div>
    <div class="bloc_reponses">
    
        <c:forEach items="${q.answers}" var="a">
        <div class="bloc_reponse">
           <input type="checkbox" id="reponse" name="${a.id}"/><label>${a.answer}</label> 
        </div>
        </c:forEach>
        
        <input type="submit" name="chosenAnswer" value="Valider"/>
    </div>

</c:forEach>


<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
