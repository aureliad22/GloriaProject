<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<div class="row head">
    <span class="titre-accueil">Bienvenue ${user.firstName}</span>
    <p class="accueil">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum efficitur turpis velit, nec auctor tortor finibus et. Curabitur non augue sed velit varius ornare sit amet ac turpis. Nullam dignissim mauris lectus, lobortis ultricies dui consequat et. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce lacinia vehicula mollis. Fusce sollicitudin leo ut lorem ornare, at lacinia erat commodo. Proin felis est, finibus ut ipsum a, bibendum euismod lectus. Morbi vitae felis vitae leo feugiat fringilla. Quisque elementum facilisis congue. Integer posuere massa id lorem luctus, gravida tristique nisi ornare. Quisque vitae augue vel felis tempor tempor. Mauris ligula justo, varius eu nisl ac, pretium facilisis leo.
    </p>
</div>
<div class="row action">
    <div class="col-sm-10 col-sm-push-1">
        <form action="<%=request.getContextPath()%>/Candidate/Tests" method="POST">
            <input class="btn btn-default action" type="submit" name="passer_test" id="passer_test" value="Passer un test"/>
        </form>
    </div>
</div>

<div class="row action">
    <div class="col-sm-10 col-sm-push-1">
       <form action="<%=request.getContextPath()%>/Candidate/Results" method="POST">
             <input class="btn btn-default action" type="submit" name="consulter_resultats" id="consulter_resultats" value="Consulter mes résultats"/>
        </form>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>