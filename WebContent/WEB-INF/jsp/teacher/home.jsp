<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<h1>Bienvenue ${user.firstName}</h1>

<a href="<%=request.getContextPath()%>/Teacher">Page de connexion</a> </br>
</br></br></br>


<a href="<%=request.getContextPath()%>/Teacher/CandidateGestion"> Gérer les candidats</a></br>
<a href="<%=request.getContextPath()%>/Teacher/QuestionGestion"> Gérer les questions</a>


<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>