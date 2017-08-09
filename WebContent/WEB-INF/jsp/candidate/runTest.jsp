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
                <c:if test="${nextQuestion.marked}"><input type="checkbox" name="marquer" value="1" checked="checked">&nbsp;<span class="glyphicon glyphicon-tag marquage"></span> Marquer la question</c:if>
                <c:if test="${!nextQuestion.marked}"><input type="checkbox" name="marquer" value="1">&nbsp;<span class="glyphicon glyphicon-tag marquage"></span> Marquer la question</c:if>
                
            </div>
            <c:if test="${!authorizeSummary}">
                <div>
                <input type="submit" name="nextQuestion" class="validation-button btn btn-default" value="Valider et passer à la question suivante">
            </div>
            </c:if>
            
            <c:if test="${authorizeSummary}">
                <div>
                    <input type="submit" name="goToRecap" class="validation-button btn btn-default" value="Valider et aller au récapitulatif">
                </div>
            </c:if>
        </div>
        
    </form>
</div>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>