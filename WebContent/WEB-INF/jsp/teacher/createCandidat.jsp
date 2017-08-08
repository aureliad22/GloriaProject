
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>



 		<form action="${pageContext.request.contextPath}/CreateCandidate" method="POST" >
				
				
				  <div class="input-group">
				    <span class="input-group-addon">Nom</span>
				    <input id="nom" type="text" class="form-control" name="nom" >
				  </div>
				   <div class="input-group">
				    <span class="input-group-addon">Prénom</span>
				    <input id="prenom" type="text" class="form-control" name="prenom" >
				  </div>
				   <div class="input-group">
				    <span class="input-group-addon">Email</span>
				    <input id="email" type="text" class="form-control" name="email" >
				  </div>
				   <div class="input-group">
				    <span class="input-group-addon">Login</span>
				    <input id="login" type="text" class="form-control" name="login" >
				  </div>
				   <div class="input-group">
				    <span class="input-group-addon">Mot de passe</span>
				    <input id="password" type="text" class="form-control" name="password" >
				  </div>
				  
				  				<select>
				  						
										<c:forEach items="${list}" var="promo">
											
											  <option value="promotion">${promo.title}</option>
											
										</c:forEach>
										
								</select> 						
									
				</br>
				
					   
    						
    						<input type="submit" id="valider"  name="connexion" class="btn btn-default"></input>
		
				
				  
		</form> 
		 <a href="<%=request.getContextPath()%>/Teacher/CandidateGestion">Retour page de gestion candidat</a> 


<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
				
