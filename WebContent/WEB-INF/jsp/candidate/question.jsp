<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<div class="bloc_question">

<h1> Créer une question :</h1>
<form action="<%=request.getContextPath()%>/Teacher/QuestionGestion" method="post">


			
			 
			  <p>Veuillez rentrer le texte de la questions:</p>
			  
			      <textarea class="form-control"  id="enonce"></textarea>
			    
			    <input type="number" name="poids" id="poids" />
			    </br>
			    
			    <input type="submit" name="poids" id="poids" value="enregistrer" />
			    </br>
			    <input type="submit" name="poids" id="poids" value="Relier une réponse" />
			    
			   
			  
			
			
			
			
			


</form>

    
</div>



<a href="<%=request.getContextPath()%>/TeacherGestionPage"> Retour Menu Teacher </a>


<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>