var sessionID = localStorage.getItem("sessionID");
var userID = localStorage.getItem("userID");

window.onload =  function() {
	// checkSessionExistence(sessionID);

	document.getElementById("logoutnow").onclick = function() {
		endSession(sessionID);
	};
};

function endSession(sessionID) {
	if(sessionID == null) {
		window.location.href = "/HapaJohnLemuelViaje/";
	}
	else {
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = function() {
			if(rq.readyState == 4) {
				let data = JSON.parse(rq.responseText);
				if(data.message == "logout") {
					window.location.href = "/HapaJohnLemuelViaje/";
					localStorage.removeItem("sessionID");
					localStorage.removeItem("userID");
				}
			}
		};
		rq.open("GET", "/HapaJohnLemuelViaje/endsession?sessionID=" + sessionID, true);
		rq.send();
	}
};

function checkSessionExistence(sessionID) {
	if(sessionID == null) {
		window.location.href = "/HapaJohnLemuelViaje/";
	}
	else {
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = function() {
			if(rq.readyState == 4) {
				let data = rq.response;
				if(data == "zero") {
					window.location.href = "/HapaJohnLemuelViaje/";
				}
			}
		};
		rq.open("GET", "/HapaJohnLemuelViaje/checksessionexistence?sessionID=" + sessionID, true);
		rq.send();
	}
};