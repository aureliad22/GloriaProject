<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>




		<form class="connexion" action="<%=request.getContextPath()%>/Teacher" method="post">

			  <div class="form-group">
			    <label for="login">Login:</label>
			    <input type="login" class="form-control" id="login" name="login" placeholder="login">
			  </div>
			  <div class="form-group">
			    <label for="password">Password:</label>
			    <input type="password" class="form-control" id="password" name="password">
			  </div>
			  <div class="checkbox">
			    <label><input type="checkbox"> Remember me </label>
			  </div>
			  <button type="submit" id="seconnecter" value="Se connecter" class="btn btn-default">Submit</button>

		
		<c:if test="${!empty error }">
		
		<div class="alert alert-warning">
 				 <strong>${error}</strong> 
		</div>
		
			
		</c:if>			  
			  
		</form> 	
		
		
		<a href="<%=request.getContextPath()%>/">Welcome Page</a> </br>
		
		

 	</div> 	
</body>
<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>
</html>