

//只获取浏览器
function identifyBrowser(){
			var cBrowser;
			if (window.navigator.userAgent.indexOf("Safari")>=0 && navigator.userAgent.toLowerCase().indexOf("version") >= 0)
			{
			cBrowser = "safari";
			} else if (window.navigator.userAgent.indexOf("Chrome")>=0) {
			cBrowser = "chrome";
			} else if (navigator.userAgent.toLowerCase().indexOf('msie')>=0) {
			cBrowser = "ie";
			} else if (navigator.userAgent.toLowerCase().indexOf('firefox')>=0) {
			cBrowser = "firefox"; 
			} else if (navigator.userAgent.toLowerCase().indexOf('opera')>=0) {
			cBrowser = "opera";
			} 
			return cBrowser;
}



   
