var sessionID = localStorage.getItem("sessionID");
var userID = localStorage.getItem("userID");

window.onload =  function() {
	checkSessionExistence(sessionID);
	appearNewsFeed();

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

function appearNewsFeed() {
	let rq = new XMLHttpRequest();
	rq.onreadystatechange = function() {
		if(rq.readyState == 4) {
			let data = JSON.parse(rq.response);
			let feed = document.getElementById("feed");
			for(var k in data) {
				feed.innerHTML = "<div class='frame'><div class'frameHeader'>" + data[k].address + ", " + data[k].location + "</div><img src='../images/" + data[k].image + "'><div class'frameCaption'>" + data[k].caption + "</div><div class'frameComment'>Feature underconstruction!</div></div>";
			}
		}
	};
	rq.open("GET", "/HapaJohnLemuelViaje/newsFeed?userid=" + userID, true);
	rq.send();
};
