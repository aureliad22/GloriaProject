<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
<div class="bloc-question">
    <h3>${requestedTest.title}</h3>

    <form action="<%=request.getContextPath()%>/Candidate/SaveAnswer" method="post">
        <p class="enonce">Question : ${nextQuestion.question}</p>
        <input type="hidden" name="idQuestion" value="${nextQuestion.id}"/>
        <div class="bloc-reponses">
        <c:forEach items="${nextQuestion.answers}" var="a">
            <div class="ligne-reponse">
            <input type="checkbox" id="${a.id}" value="${a.id}" name="answer" />&nbsp;${a.answer}
            </div>
        </c:forEach>
        </div>
        <div class="bloc-marquage">
            <div class="marque">
                <input type="checkbox" name="marquer" value="1" > Marquer la question
            </div>
            <div>
                <input type="submit" name="chosenAnswer" class="validation-button btn btn-default" value="Valider et passer à la question suivante">
            </div>
            <c:if test="${authorizeSummary}">
                <div>
                    <input type="submit" name="chosenAnswer" class="validation-button btn btn-default" value="Valider et aller au récapitulatif">
                </div>
            </c:if>
        </div>
        
    </form>
</div>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>