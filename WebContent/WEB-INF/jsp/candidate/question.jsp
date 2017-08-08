<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/jsp/includes/header.jsp"/>

<div class="bloc_question">

<h1> Créer une question :</h1>
<form action="<%=request.getContextPath()%>/Teacher/QuestionGestion" method="post">	

<div name="nouvelleQuestion">



			 
			  <p>Veuillez rentrer le texte de la questions:</p>
			  
			    <textarea class="form-control"  id="enonce" name="enonce"></textarea></br>
			    <p>Veuillez rentrer le poids de la question :</p>
			    <input type="number" name="poids" id="poids" value="1" /></br>	
			    
			    <p>Veuillez choisir un thème de la question :</p>
			    
			   					 <select name="theme">
				  						
										<c:forEach items="${listThemes}" var="theme">
											
											  <option value="${theme.id}" >${theme.libelle}</option>
											
										</c:forEach>
										
								</select> 			
			    
			    
			    		    
			    <p>Veuillez rentrer la(les) réponse(s):</p>
			    <div id="blocReponse" name="reponsesObligatoires">
					    <div id="rep_0" name="rep_0">
					    		<textarea class="form-control"  name="textReponse" id="reponse" placeholder="réponse 1"></textarea>							    
								   valider si bonne réponse <input type="checkbox" name="correct" value="1">
					    </div>
					    
						<div id="rep_1" name="rep_1">
							    <textarea class="form-control"  name="textReponse" id="reponse" placeholder="réponse 2"></textarea>
							      valider si bonne réponse <input type="checkbox" name="correct" value="1">
			    		</div>
			    </div>
			    
			    <a href="#" onclick="addResponse()">Ajouter une réponse</a></br>
			   <!-- <button onclick="addResponse()" value="Ajouter une réponse"/>Ajouter une réponse</button> --> 
			     <script type='text/javascript'>
				        function addResponse(){	
				        	var reponses = new Array();
				        	reponses.id ="reponses";			        	
				        	
				        	var nombreDeReponse = new Number(0);
				        	nombreDeReponse.id = "compteurReponse";
				            // Number of inputs to create
				            //var number = document.getElementById("uneReponse").value;
				            // Container <div> where dynamic content will be placed
				            var container = document.getElementById("blocReponse");
				            // Clear previous contents of the container
				            
				            nombreDeReponse = container.getElementsByTagName("div").length;
				            var numSuivant = nombreDeReponse+1;
				            
				            
				                // Append a node with a random text
				                //container.appendChild(document.createTextNode("Member " + (i+1)));
				                // Create an <input> element, set its type and name attributes
				                
				                //Création d'une div 
				                var divReponse = document.createElement("div");
				                divReponse.id = "uneReponse";
				                
				                
				                //Cr"ation textArea
				                var textArea = document.createElement("textarea");
				                textArea.name = "textReponse";
				                textArea.placeholder = "réponse" +" " +numSuivant;
				                
				                var text =document.createTextNode("valider si bonne réponse")
				                text.type="text"
				               	var checkbox  = document.createElement("input");
				                checkbox.type = "checkbox";
				                checkbox.name = "correct"
				                
				                //var text1 =document.createTextNode("Bonne")
				                //text1.type="text"
				                //var input1 = document.createElement("input");
				                //input1.type = "radio";
				                //input1.name="reponsesuivante"
				                
				               // var text2 =document.createTextNode("Mauvaise")
						        //text2.type="text"
				                //var input2 = document.createElement("input");
				                //input2.type = "radio";
				                //input2.name="reponsesuivante"
				                
				                divReponse.appendChild(textArea);
				                //divReponse.appendChild(input1);
				                //divReponse.appendChild(text1);
				                //divReponse.appendChild(input2);
				                //divReponse.appendChild(text2);
				                divReponse.appendChild(text);
				                divReponse.appendChild(checkbox);
				                //var input = document.createElement("input");
				                //input.type = "text";
				                //input.name = "reponse" + i;
				                container.appendChild(divReponse);
				                // Append a line break 
				                nombreDeReponse=nombreDeReponse+1;
				                
				                for ( var element in document.getElementsByTagName("textarea")) {
									reponses.push(element);
								}
				                alert(reponses.toString());
				                           
				            
				        }
   				 </script>
			    
			    
			    
			    
			    <input type="submit" name="poids" id="poids" value="enregistrer" /></br>
			    
			    </br>
</div>		
			    
</form>

    
</div>



<a href="<%=request.getContextPath()%>/TeacherGestionPage"> Retour Menu Teacher </a>


<jsp:include page="/WEB-INF/jsp/includes/footer.jsp"/>