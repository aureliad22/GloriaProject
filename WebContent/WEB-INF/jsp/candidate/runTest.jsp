<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
TEST recup pour ecriture reponses_données : [idTest=${requestedTest.id}, idStagiaire=${user.id}, idSection=${requestedTest.sections.get(currentSectionIndex).id}, idQuestion=${nextQuestion.id}]
<div class="bloc-question">
    <form action="<%=request.getContextPath()%>/Candidate/SaveAnswer" method="post">
        <p>${nextQuestion.question}</p>
        <input type="hidden" name="idQuestion" value="${nextQuestion.id}"/>
        <c:forEach items="${nextQuestion.answers}" var="a">
            <input type="checkbox" id="${a.id}" value="${a.id}" name="answer" />&nbsp;${a.answer}
        </c:forEach>
        <input type="submit" name="chosenAnswer" value="Question suivante">
    </form>
</div>

<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>