<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<div class="row">
<a href="<%=request.getContextPath()%>/Candidate">
    <div class="col-sm-6 col-sm-push-1 jumbotron bloc_profil">
        <h2>Candidat</h2>
    </div>
 </a>
</div>

<div class="row">
<a href="<%=request.getContextPath()%>/Teacher">
    <div class="col-sm-6 col-sm-push-1 jumbotron bloc_profil">
        <h2>Formateur</h2>
    </div>
 </a>
</div>



<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>