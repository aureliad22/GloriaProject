<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

<div class="bloc-result">
	<h3>Résultats au test ${requestedTest.title}</h3>

	<div class="bloc-score">
        <p>Vous avez obtenu ${score} % au test ${requestedTest.title}.</p>
        <p>Status du test : ${bilan} .</p>
	</div>

	<div class="bloc-score-section">
	   <c:set var="numSection" value="${0}"/>
		   <c:forEach items="${requestedTest.sections}" var="section">
		       <div class="ligne-score-section">
		           <h4> ${section.caption} :</h4> 
		           <p>${totalSection} bonne(s) réponse(s) soit ${scoreSection.get(numSection)} % de réussite.</p>
		       </div>
		      <c:set var="numSection" value="${numSection+1}"/>		     
		   </c:forEach>	   
	</div>
</div>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />