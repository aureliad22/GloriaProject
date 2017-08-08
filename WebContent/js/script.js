function confirmEndOfTest(){
	if (confirm("Voulez vous vraiment terminer ce test ?") == true) {
		document.forms["endOfTest"].submit();
	}
}