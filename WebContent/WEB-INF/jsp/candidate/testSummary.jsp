<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
<h1>Récapitulatif du test : ${requestedTest.title}</h1>

        <c:set var="numSection" value="${0}"/>
        <c:forEach items="${requestedTest.sections}" var="s">
            <c:set var="numSection" value="${numSection+1}"/>
            <h3 class="section-recap">Section ${numSection} : ${s.caption}</h3>
             <c:set var="numQuestionSection" value="${0}"/>
             <div class="row  ">
                <div class="col-sm-6 col-sm-push-2">
	              <div class="row ligne-recap">
	                  <div class="col-sm-6"></div>
	                  <div class="col-sm-2">Tags</div>
	                  <div class="col-sm-2">Alert</div>
	                  <div class="col-sm-2"></div>
	              </div>
	           </div>
	        </div>
	         <c:forEach items="${s.questions}" var="q">
	         <c:set var="numQuestionSection" value="${numQuestionSection+1}"/>
	         <div class="row ">
	            <form action="<%=request.getContextPath()%>/Candidate/RunTest" method="POST">
	                <div class="col-sm-6 col-sm-push-2">
		              <input type="hidden" name="QuestionIndex" value="${numQuestionSection-1}"/>
                      <input type="hidden" name="SectionIndex" value="${numSection-1}"/>
                        <div class="row ligne-recap">
		                  <div class="col-sm-6"> Question ${numQuestionSection}  </div>
		                  <div class="col-sm-2"><c:if test="${q.marked}">&nbsp;<span class="glyphicon glyphicon-tag marquage"></span></c:if></div>
		                  <div class="col-sm-2"><c:if test="${!q.hasGivenAnswers}"> <span class="glyphicon glyphicon-exclamation-sign sans-reponse"></span></c:if></div>
		                  <div class="col-sm-2"> <input type="submit" value="Revoir" class="btn btn-default btn-recap-test"/> </div>
                       </div>
	               </div>
                </form>
	        </div> 
	        </c:forEach>
        
        </c:forEach>
   
    
    

<form action ="<%=request.getContextPath()%>/Candidate/Result" method="post" id="endOfTest">
</form>
<button class="btn btn-default btn-validation" onclick="confirmEndOfTest()">Terminer le test</button>

<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
