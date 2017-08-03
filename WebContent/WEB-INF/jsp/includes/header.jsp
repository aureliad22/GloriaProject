<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/style.css" >
	<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/bootstrap.css" >
	<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/bootstrap-theme.css" >
	   <title>GloriaQCM</title>
	</head>
	
    <body>
        <header><h1>GloriaProject</h1></header>
        <div class="container">
        <c:if test="${user} instanceof Candidate">
        <ul id=menu>
			<li><a href="#">Accueil</a>
			<li><a href="#">Tests</a>
			<li><a href="#">Resutats</a>
		</ul>
		</c:if>
            <div class="col-sm-10 col-sm-push-1">
