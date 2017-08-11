<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/jsp/includes/header.jsp" />

<div bloc_inscription>
	<div id="Session">

		<h1>Inscription du candidat : ${candidat.firstName}
			${candidat.lastName}</h1>



		<div class="test">
			<p>Choisir Test :</p>
			<select name="testliste" id="testChoisi">

				<c:forEach items="${listeTests}" var="testliste">

					<option value="${testliste.id}" id="optionCoisie">${testliste.title}</option>

				</c:forEach>

			</select> <input type="submit" class="btn btn-default" name="Ajouter"
				value="Ajouter" onclick="ajouterTest()" />


		</div>


		<p>Liste de tous les tests du candidats :</p>
		<select multiple class="form-control" id="listeTestsInscrits"
			name="listeTestsInscrits">
			<c:if test="${!empty listeTestsInscrits}">
				<c:forEach items="${listeTestsInscrits}" var="listeTestsInscrits">
					<option value="${listeTestsInscrits.id}">
						${listeTestsInscrits.title}</option>
				</c:forEach>
			</c:if>
		</select>

		<script type='text/javascript'>
			function ajouterTest() {
				var container = document.getElementById("listeTestsInscrits");
				var idtestChoisi = document.getElementById("testChoisi");
				var test = document.createElement("option")
				//test.id=idtestChoisi.value
				test.text = idtestChoisi.options[idtestChoisi.selectedIndex].text;
				/* for ( var element in document.getElementsByTagName("optionCoisie")) {
					if (element == test)  {
						
						
					} else {
				      //alert("Le test est déjà choisi !!!")
					}
					console.log(element);
				 
				} */
				container.add(test);

				//var listTestAvider = document.getElementsByName("testliste");	
				//listTestAvider.remove(test);

			}
		</script>


		<input type="submit" class="btn btn-default" name="Supprimer"
			value="Supprimer" /> </br>
		</br> <input type="submit" class="btn btn-default" name="Valider"
			value="Valider l'inscription" />

	</div>

</div>

<a href="<%=request.getContextPath()%>/Teacher/CandidateGestion">
	Retour Page Candidat </a>

<jsp:include page="/WEB-INF/jsp/includes/footer.jsp" />
