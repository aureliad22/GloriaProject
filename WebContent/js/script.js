function confirmEndOfTest(){
	if (confirm("Voulez vous vraiment terminer ce test ?") == true) {
		document.forms["endOfTest"].submit();
	}
}

var gradiant;
function defineGradiant(scoreCandidate){
	if(scoreCandidate < 10){
		gradiant=v10;
	} else if (scoreCandidate <20) {
		gradiant=v20
	} else if (scoreCandidate <30) {
		gradiant=v30
	} else if (scoreCandidate <40) {
		gradiant=v40
	} else if (scoreCandidate <50) {
		gradiant=v50
	} else if (scoreCandidate <60) {
		gradiant=v60
	} else if (scoreCandidate <70) {
		gradiant=v70
	} else if (scoreCandidate <80) {
		gradiant=v80
	} else if (scoreCandidate <90) {
		gradiant=v90
	} else if (scoreCandidate <100) {
		gradiant=v100
	}
	return gradiant;
}
$(document).ready(function() {
	defineGradiant(scoreCandidate);
});