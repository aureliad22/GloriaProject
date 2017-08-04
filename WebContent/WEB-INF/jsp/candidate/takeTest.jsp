<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<h1>Consignes</h1>

<p>Pellentesque eros nisl, tincidunt sit amet fermentum id, euismod non elit. Proin at porttitor velit. Etiam cursus dictum orci, vitae venenatis libero dignissim in. Nullam faucibus bibendum mauris, nec mollis magna imperdiet sed. Cras mollis maximus mi id bibendum. Cras et erat suscipit, ullamcorper erat id, mattis justo. Morbi id lacinia tortor. Sed sit amet hendrerit magna. Vivamus auctor erat ex, et semper ligula hendrerit volutpat. Proin in sem eget turpis dictum elementum sit amet nec ex. Donec felis ipsum, efficitur tincidunt sagittis et, lobortis sed risus. Duis tincidunt egestas nunc, ut ultricies augue mattis eu. Aenean faucibus dapibus tellus, sit amet cursus ante cursus vitae.</p>

<h1>Informations sur le test :</h1>
<div class="bloc-test-info">
    <h2>${requestedTest.title}</h2>
    <span>Temps alloué : ${requestedTest.duration} minutes.</span>
    <c:forEach items="${requestedTest.sections}" var="section">
         <div class="bloc-section">
           <h3>${section.caption}</h3>
           <p>Nombre de questions : ${section.questions.size()}</p>
         </div>
    </c:forEach>
	    
</div>

<form action="<%=request.getContextPath()%>/Candidate/RunTest" method="POST">
    <input class="btn btn-default action-test" type="submit" name="commencer" id="commencer" value="Commencer"/>
</form>


<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
