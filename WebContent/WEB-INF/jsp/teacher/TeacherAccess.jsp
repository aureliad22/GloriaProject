<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="contenu">
	
	
	
		<form class="connexion" action="<%=request.getContextPath()%>/Teacher" method="post">
		<div class="bloc_identifiant">
			<label for="identifiant">Identifiant</label>
			<input class="champtexte" type="text" id="login" name="login" placeholder="login"/>
		</div>
		<div class="bloc_motdepasse">
			<label for="motdepasse">Mot de passe</label>
			<input class="champtexte" type="password"  id="password" name="password" placeholder="password"/>
		</div>
		<div class="bloc_connexion">
			<input type="submit" id="seconnecter" value="Se connecter" />
		</div>
		</form>
		
		<a href="<%=request.getContextPath()%>/Welcome">Welcome Page</a> </br>
		
		

 	</div> 	
</body>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
</html>