window.onload = function() {
	document.getElementById("reg").onclick = function() {
		document.getElementById("form2").style.display = "none";
		document.getElementById("form1").style.display = "block";
	};

	document.getElementById("cancel").onclick = function() {
		document.getElementById("form2").style.display = "block";
		document.getElementById("form1").style.display = "none";
	};
};
