<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css" >
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-theme.css" >
	<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/styles/style.css" >
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/script.js"></script>
    <title>GloriaQCM</title>
	</head>
	
    <body>
        <header><h1><a href="<%=request.getContextPath()%>">GloriaProject</a></h1>
        <c:if test="${user != null}">
            <a href="<%=request.getContextPath()%>/Deconnexion">Deconnexion</a>
        </c:if></header>
        <div class="container">
        
            <div class="col-sm-10 col-sm-push-1">
