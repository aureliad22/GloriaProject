<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/bootstrap/css/bootstrap.css" >
	<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/bootstrap/css/bootstrap-theme.css" >
	<script type="text/javascript" src="<%=request.getContextPath()%>/styles/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/style.css" >
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/script.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    
    
    <title>GloriaQCM</title>
	</head>
	
    <body>
        <header>
           
    
    
     <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="<%=request.getContextPath()%>">Gloria Project</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          <c:if test="${profileType == 'candidate'}">
            <li class="active"><a href="<%=request.getContextPath()%>/Candidate">Home</a></li>
          </c:if>
          
          <c:if test="${profileType == 'teacher'}">
            <li class="active"><a href="<%=request.getContextPath()%>/Teacher">Home</a></li>
            <li class="active"><a href="<%=request.getContextPath()%>/Teacher/CandidateGestion">Gérer candidats</a></li>
            <li class="active"><a href="<%=request.getContextPath()%>/Teacher/QuestionGestion">Gérer Questions</a></li>
          </c:if>
          
          </ul>
          <ul class="nav navbar-nav navbar-right">
          <c:if test="${user !=  null}">
            <li><a href="<%=request.getContextPath()%>/Deconnexion">Deconnexion</a></li>
          </c:if>
          
          </ul>
        </div>
      </div>
    </nav>
    
        </header>
        
        <div class="container">
            <div class="wrapper col-sm-10 col-sm-push-1">
