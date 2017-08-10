<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="menu">

    

    
    
    
    
    <c:if test="${user != null}">
            <a href="<%=request.getContextPath()%>/Deconnexion">Deconnexion</a>
    </c:if>
    
</div>