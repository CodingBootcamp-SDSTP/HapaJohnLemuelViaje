var sessionID = localStorage.getItem("sessionID");
var userID = localStorage.getItem("userID");

window.onload =  function() {
	checkSessionExistence(sessionID);
	getUserProfileHeader();
	getUserProfilePosts();

	document.getElementById("logoutnow").onclick = function() {
		endSession(sessionID);
	};
};

function getUserProfileHeader() {
	let rq = new XMLHttpRequest();
	rq.onreadystatechange = function() {
		if(rq.readyState == 4) {
			let data = JSON.parse(rq.response);
			if(data != null) {
				let dp = document.getElementById("dp");
				dp.innerHTML = "<img src='../images/" + data.image + "'/>";
				let pname = document.getElementById("pname");
				let followers = document.getElementById("followers");
				let following = document.getElementById("following");
				pname.innerHTML = data.fullname + " (" + data.username + ")";
				followers.innerHTML = data.followers + " followers";
				following.innerHTML = data.following + " following";
			}
		}
	};
	rq.open("GET", "/HapaJohnLemuelViaje/userProfileHeader?userid=" + userID, true);
	rq.send();
};

function getUserProfilePosts() {
	let rq = new XMLHttpRequest();
	rq.onreadystatechange = function() {
		if(rq.readyState == 4) {
			let data = JSON.parse(rq.response);
			if(data != null) {
				let posts = document.getElementById("posts");
				for(var k in data) {
					posts.innerHTML += "<div class='photo'><img src='../images/" + data[k].image + "'/></div>";
				}
			}
		}
	};
	rq.open("GET", "/HapaJohnLemuelViaje/userProfilePosts?userid=" + userID, true);
	rq.send();
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