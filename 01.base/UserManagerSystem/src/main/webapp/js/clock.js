function disptime() {
	var today = new Date();
	var year = 1900 + today.getYear();
	var month = today.getMonth() + 1;
	var day = today.getDate();
	var hh = today.getHours();
	var mm = today.getMinutes();
	var ss = today.getSeconds();
	if (month < 10) {
		month = "0" + month;
	}
	if (day < 10) {
		day = "0" + day;
	}
	if (mm < 10) {
		mm = "0" + mm;
	}
	if (ss < 10) {
		ss = "0" + ss;
	}
	var dateTime = year + "-" + month + "-" + day + "    " + hh + ":" + mm + ":" + ss ;    
	
	if (ss % 2 == 0) {
		document.getElementById("myclock").innerHTML = "<font color='green'>" + dateTime + "</font>";
	} else {
		document.getElementById("myclock").innerHTML = "<font color='red'>" + dateTime + "</font>";
	}

}
var mytime = setInterval("disptime()", 1000);