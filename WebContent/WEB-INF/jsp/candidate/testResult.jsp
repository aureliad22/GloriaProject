<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

<div class="bloc-result">
	<h1>Résultats au test ${requestedTest.title}</h1>

	<div class="bloc-score">
        <p>Vous avez obtenu ${score} % au test ${requestedTest.title}.</p>
        <p>Status du test : ${bilan} .</p>
	</div>

	<div class="bloc-score-section">
	   <c:set var="numSection" value="${0}"/>
		   <c:forEach items="${requestedTest.sections}" var="section">
		       <div class="ligne-score-section">
                    <h3 class="section-recap">${section.caption}</h3>
                    <div class="row">
                        <div class="stats gradiant_pic">                           
						        <div class="liste-sections">${totalSection.get(numSection)} bonne(s) réponse(s)&nbsp;: </div>
						        <div class="liste-sections">
						          <span class="percent v${gradient.get(numSection)}"></span>${scoreSection.get(numSection)}%
						        </div>						    
				        </div>
				    </div>
				</div>
		      <c:set var="numSection" value="${numSection+1}"/>		     
		   </c:forEach>	   
	</div>
</div>

<div>
    <a href="<%=request.getContextPath()%>/Candidate/EndTest" class="btn btn-default">Retour à l'accueil</a>
</div>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />