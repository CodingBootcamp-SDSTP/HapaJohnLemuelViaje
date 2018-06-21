var sessionID = localStorage.getItem("sessionID");
var userID = localStorage.getItem("userID");

window.onload =  function() {
	checkSessionExistence(sessionID);
	var url = window.location.href;
	getUserProfileHeader(url);
	getUserProfilePosts(url);

	document.getElementById("logoutnow").onclick = function() {
		endSession(sessionID);
	};

	var searchbtn = document.getElementById("searchbtn");
	var search = document.getElementById("searchbox");

	search.addEventListener("keyup", (event) => {
		event.preventDefault();
		if(event.keyCode === 13) {
			searchbtn.click();
		}
	});

	searchbtn.onclick = function() {
		window.location.href = "/HapaJohnLemuelViaje/pages/users.html?name=" + search.value;
	};

	document.getElementById("follownow").onclick = function() {
		let fid = document.getElementById("fid").value;
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = function() {
			if(rq.readyState == 4) {
				if(rq.response == "ok") {
					addFollower(fid);
				}
			}
		};
		rq.open("POST", "/HapaJohnLemuelViaje/addFollowing", true);
		rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		rq.send("userid=" + userID + "&fid=" + fid);
	};
};

function addFollower(fid) {
	let rq = new XMLHttpRequest();
	rq.onreadystatechange = function() {
		if(rq.readyState == 4) {
			if(rq.response == "ok") {
				let follownow = document.getElementById("follownow");
				follownow.disabled = true;
				follownow.value = "Following ....";
			}
		}
	};
	rq.open("POST", "/HapaJohnLemuelViaje/addFollower", true);
	rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	rq.send("fid=" + fid + "&userid=" + userID);
};

function getUserProfileHeader(url) {
	let rq = new XMLHttpRequest();
	rq.onreadystatechange = function() {
		if(rq.readyState == 4) {
			let data = JSON.parse(rq.response);
			if(data != null) {
				let dp = document.getElementById("dp");
				let pname = document.getElementById("pname");
				let followers = document.getElementById("followers");
				let following = document.getElementById("following");
				let follownow = document.getElementById("follownow");
				let fid = document.getElementById("fid");
				dp.innerHTML = "";
				pname.innerHTML = "";
				followers.innerHTML = "";
				following.innerHTML = "";
				dp.innerHTML = "<img src='../images/" + data.image + "'/>";
				pname.innerHTML = data.fullname + " (" + data.username + ")";
				followers.innerHTML = data.followers + " followers";
				following.innerHTML = data.following + " following";
				if(data.relation == "notok") {
					follownow.disabled = false;
					follownow.style.visibility = "visible";
					follownow.value = "Follow Me?";
					fid.value = data.uid;
				}
				else if(data.relation == "ok"){
					follownow.style.visibility = "visible";
					follownow.disabled = true;
					follownow.value = "Following ....";
				}
				else if(data.relation == "me"){
					follownow.style.visibility = "hidden";
				}
			}
		}
	};
	getQueryString(url, (str) => {
		rq.open("GET", "/HapaJohnLemuelViaje/otherProfileHeader?name=" + str + "&userid=" + userID, true);
		rq.send();
	});
};

function getUserProfilePosts(url) {
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
	getQueryString(url, (str) => {
		rq.open("GET", "/HapaJohnLemuelViaje/otherProfilePosts?name=" + str, true);
		rq.send();
	});
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

function getQueryString(url, callback) {
	var query = url.split("?");
	var result = query[1].split("=");
	var name = result[1].replace("%20", " ");
	callback(name);
};
