var sessionid = "";
var userID = "";

window.onload = function() {
	checkIfTheresASessionId();

	document.getElementById("reg").onclick = function() {
		document.getElementById("form2").style.display = "none";
		document.getElementById("form1").style.display = "block";
	};

	document.getElementById("cancel").onclick = function() {
		document.getElementById("form2").style.display = "block";
		document.getElementById("form1").style.display = "none";
	};

	var firstname = document.getElementById("firstname");
	var lastname = document.getElementById("lastname");
	var email = document.getElementById("email");
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	var register = document.getElementById("register");

	register.onclick = function() {
		if((firstname.value && lastname.value && email.value && username.value && password.value) != "") {
			let rq = new XMLHttpRequest();
			rq.onreadystatechange = function() {
				if(rq.readyState == 4) {
					alert(rq.response);
					let inp = document.getElementsByClassName("inp");
					for(let detail of inp) {
						detail.value = "";
					}
				}
			};
			rq.open("POST", "/HapaJohnLemuelViaje/addUsers", true);
			rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			rq.send("firstname=" + firstname.value + "&lastname=" + lastname.value + "&email=" + email.value + "&username=" + username.value + "&password=" + password.value);
		}
		else {
			alert("Make sure all the fields are not empty before you register!");
		}
	};

	document.getElementById("login").onclick = function() {
		let uname = document.getElementById("uname");
		let upass = document.getElementById("upass");
		if((uname.value && upass.value) != "") {
			let rq = new XMLHttpRequest();
			rq.onreadystatechange = function() {
				if(rq.readyState == 4) {
					let data = JSON.parse(rq.responseText);
					if(data.reply != "failed") {
						sessionid = data.reply;
						userID = data.userid;
						localStorage.setItem("sessionID", sessionid);
						localStorage.setItem("userID", userID);
						window.location.href = "/HapaJohnLemuelViaje/pages/home.html";
					}
					else {
						alert("There is no such username and password!");
					}
					let inp = document.getElementsByClassName("inp");
					for(let detail of inp) {
						detail.value = "";
					}
				}
			};
			rq.open("GET", "/HapaJohnLemuelViaje/login?username=" + uname.value + "&password=" + upass.value, true);
			rq.send();
		}
		else {
			alert("Make sure all the fields are not empty!");
		}
	};
};

function checkIfTheresASessionId() {
	let rq = new XMLHttpRequest();
	rq.onreadystatechange = function() {
		if(rq.readyState == 4) {
			let data = rq.response;
			if(data != "zero") {
				window.location.href = "/HapaJohnLemuelViaje/pages/home.html";
			}
		}
	};
	rq.open("GET", "/HapaJohnLemuelViaje/checksessioncount", true);
	rq.send();
};
