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
		
	<div class="container">
	
	   			
	   			 <form class="connexion" action="<%=request.getContextPath()%>/CreateCandidate" method="get">
	   			 <div class="row">
		   			</br>
		   			<div class="col-sm-1"> <input type="submit" class="btn btn-default" name="Creer" value="Créer un nouveau candidat"/> </div>
		   			
		   			</br>
					 
				</form> 
			
						  
				
				        </br>
				         <label for="sel2">Liste des candidats : </label>
				         
	<form action="${pageContext.request.contextPath}/Teacher/CandidateGestion" method="POST">
	
	 				
					 <input type="text" id="myInput"  name="filtrerListeCandidat" onkeyup="myFunction()" placeholder="Chercher un candidat" title="Type in a name">
					 
					 </br>
					 
					 
					 <script>
									function myFunction() {
									    // Declare variables
									    var input, filter, select, option, a, i;
									    input = document.getElementById('myInput');
									    filter = input.value.toUpperCase();
									    select = document.getElementById("mySelect");
									    option = select.getElementsByTagName('option');
									
									    // Loop through all list items, and hide those who don't match the search query
									    for (i = 0; i < option.length; i++) {
									    	nom = option[i].text;
									        //a = li[i].getElementsByTagName("option")[0];
									        if (nom.toUpperCase().indexOf(filter) > -1) {
									            option[i].style.display = "";
									        } else {
									        	option[i].style.display = "none";
									        }
									    }
									}
					</script>
					 
					 
					 
					 
					 
					 
					  </br>
	
					<select multiple class="form-control" id="mySelect">					        
						<c:if test="${!empty listeCandidats}">
							<c:forEach items="${listeCandidats}" var="candidat">
								    <option>${candidat.firstName} ${candidat.lastName}</option>	
							</c:forEach>
        				</c:if>
        			
					  </select>
					    </br>
					  
					        <input type="submit" class="btn btn-default" name="modifier" value="Modifier"/>
					     	<input type="submit" class="btn btn-default" name="supprimer" value="Supprimer"/> 
					     	<input type="submit" class="btn btn-default" name="Inscrire" value="Inscrire"/> 
	</form>      
			</br>
        					
        						
			   	</div> 


	</div>		 			
			 			
			 			
        <a href="<%=request.getContextPath()%>/TeacherGestionPage">Retour Menu Teacher</a> 
 	</div>
 	
</div>
</body>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
</html>