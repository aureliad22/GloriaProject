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
                        <div class="stats multicolor">
                            ${totalSection.get(numSection)} bonne(s) réponse(s).
                            <span class="percent v70">${scoreSection.get(numSection)}.</span>
				        </div>
				    </div>
				</div>
		      <c:set var="numSection" value="${numSection+1}"/>		     
		   </c:forEach>	   
	</div>
</div>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />