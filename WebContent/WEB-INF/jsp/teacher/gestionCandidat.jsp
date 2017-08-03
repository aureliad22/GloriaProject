<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Candidat</title>
</head>
<body>

<div id="page">

	<div id="entete">
		<h1>TP QCM-Page de Candidat</h1>
	</div>

	<div id="contenu">
	
		<c:if test="${!empty erreur}">
			<script lang="javascript">
				alert("${erreur}");			
			</script>
		</c:if>
		${Arrayliste}
	
		<c:if test="${empty listeCandidats}">
			Pas de candidats
		</c:if>
		
		<table>
					   <tr>
					      <td>Nom</td>
					      <td>Prénom</td>
					      <td>Email</td>
					      <td>Login</td>
					      <td>Mot de passe</td>
					   </tr>
		<c:if test="${!empty listeCandidats}">
		<c:forEach items="${listeCandidats}" var="candidat">
		
			<form action="${pageContext.request.contextPath}/CandidateServlet" method="GET">
				<div class="bloc_candidat"> 
				
				
					   <tr>
					      <td>${candidat.firstName}</td>
					      <td>${candidat.lastName}</td>
					      <td>${candidat.email}</td>
					      <td>${candidat.login}</td>
					      <td> ${candidat.password}</td>
					   </tr>

			   	</div> 
	   		</form>
		   
		   	
		</c:forEach>
        </c:if>
        </table>  
                        <input type="submit" name="supprimer" value="Créer"/>
			 			<input type="submit" name="modifier" value="Modifier"/>
			 			<input type="submit" name="supprimer" value="Supprimer"/>
			 			<input type="submit" name="modifier" value="Inscrire"/>
			 			<input type="submit" name="supprimer" value="Quitter"/> </br>
			 			
        <a href="<%=request.getContextPath()%>/Welcome">Retour Menu Teacher</a> 
 	</div>
 	
</div>
</body>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
</html>