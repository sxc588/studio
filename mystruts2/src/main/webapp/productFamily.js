$(document).ready(function() {
	var a = new Object();
	a.firstScreenEnd = firstScreenEnd;
	a.system = "support-e";
	a.feature = "document";
	a.function0 = "新版文档中心产品族页面";
	a.function1 = "";
	a.function2 = "";
	_daq.push([ "_trackPerf", a ])
});

var productFamily = {
	param : {},
	forLogin : function() {
		window.location.href = ssoLoginOutURL
				+ encodeURIComponent(encodeURIComponent(location.href))
	},
	asyncHedex : function(d, f, e, b) {
		var a = d + "?docid=" + f + "&lang=" + e + "&idPath=" + b;
		$.ajax({
			type : "POST",
			url : "/enterprise/Counter!addCount.action",
			data : {
				contentId : f,
				contentType : "DOC"
			}
		});
		var c = window.open(a);
		c.opener = null
	},
	initListener : function() {
		var a = $("#i18n_more").val();
		var b = $("#i18n_close").val();
		$(".toggle-but").click(function() {
			var c = $(this).offsetParent(".toggle");
			c.toggleClass("open");
			if (c.hasClass("open")) {
				$(this).attr("content", b)
			} else {
				$(this).attr("content", a)
			}
		})
	},
	getLastestVideoHtml : function(g, n) {
		var i = $("#i18n_videofrom").val();
		var e = $("#i18n_videosource0").val();
		var c = $("#i18n_videosource1").val();
		var b = $("#i18n_videosource2").val();
		var d = $("#sessionLang").val();
		var k = "";
		if (n.isHedex == "0") {
			k = '<a href="/enterprise/' + d + "/doc/" + n.contentId + '">'
					+ n.name + "</a>"
		} else {
			var m = $("#sessionLang").val();
			var a = $("#hedexPath").val();
			if (n.viewStatus == "L") {
				k = '<a href="' + a + "?docid=" + n.contentId + "&lang=" + m
						+ "&idPath=" + n.idAbsPath + '">' + n.name + "</a>"
			} else {
				k = "<a href=\"javascript:productFamily.asyncHedex('" + a
						+ "','" + n.contentId + "','" + m + "','" + n.idAbsPath
						+ "')\">" + n.name + "</a>"
			}
		}
		var f = "";
		if (n.videoImageUUID != null && n.videoImageUUID != "") {
			f = "/enterprise/product/images/" + n.videoImageUUID
		} else {
			if (n.secondType == "SECONDTYPE9") {
				f = "/evideo/pages/mobile/css/images/video-img-mobile2.png"
			} else {
				f = "/evideo/pages/mobile/css/images/video-img-noneplayer.jpg"
			}
		}
		var l = "";
		if (n.videoSource == "1") {
			l = c
		} else {
			if (n.videoSource == "2") {
				l = b
			} else {
				l = e
			}
		}
		var j = "";
		if (n.viewStatus == "L") {
			j += '<span class="video-icon">';
			j += '<img src="/enterprise/images/transparent.gif" class="icon-img icon_lock"/>';
			j += "</span>"
		}
		var h = "";
		h += '<div class="col-sm-3 col-xs-6 ' + ((g > 3) ? "spte-mt20" : "")
				+ '">';
		h += '<p style="position: relative;"><span class="video-time">'
				+ (n.videoTime || "") + "</span>" + j + '<img src="' + f
				+ '" alt="" class="img-responsive"/></p>';
		h += '<h4 class="line-h-20 docNew-videoTilebtm h4-desc-hidden" style="margin-bottom:0;" title="'
				+ n.name + '" >' + k + "</h4>";
		h += '<ul class="font-s12 color999">';
		h += '<li class="fl-l">' + i + " " + l + "</li>";
		h += '<li class="fl-r">' + n.lastUpdateDay + "</li>";
		h += "</ul>";
		h += "</div>";
		return h
	},
	initLatestVideo : function() {
		var b = $("#pbiIdsJSON").val();
		var a = b && JSON.parse(b);
		if (!a.length) {
			return

		}
		var c = a.join();
		this.param = {
			pbiList : c,
			fromSize : "0",
			pageSize : 8,
			orderBy : "",
			requestType : "ajax.json"
		};
		$
				.ajax({
					type : "POST",
					url : "/enterprise/getVideoListActionByCondition!getVideoByCondition",
					data : this.param,
					dataType : "json",
					success : function(d) {
						try {
							if ("ssoLoginTimeOut" == d.ssoLoginFlag) {
								productFamily.forLogin()
							} else {
								if (d && d.totalCount <= 4) {
									productFamily.initHotVideo(3)
								} else {
									if (d && d.totalCount > 4) {
										productFamily.initHotVideo(7)
									}
								}
								var f = "";
								if (d && d.videoList && d.videoList.length > 0) {
									$.each(d.videoList, function(e, h) {
										f += productFamily.getLastestVideoHtml(
												e, h)
									});
									$("#latestVideoContent").empty();
									$("#latestVideoContent").append(f);
									$("#videoContent").show()
								}
							}
						} catch (g) {
						}
					},
					error : function() {
					}
				})
	},
	getHotVideoHtml : function(b, d) {
		var g = "";
		var f = $("#sessionLang").val();
		if (d.isHedex == "0") {
			g = '<a href="/enterprise/' + f + "/doc/" + d.contentId + '">'
					+ d.name + "</a>"
		} else {
			var a = $("#sessionLang").val();
			var e = $("#hedexPath").val();
			if (d.viewStatus == "L") {
				g = '<a href="' + e + "?docid=" + d.contentId + "&lang=" + a
						+ "&idPath=" + d.idAbsPath + '">' + d.name + "</a>"
			} else {
				g = "<a href=\"javascript:productFamily.asyncHedex('" + e
						+ "','" + d.contentId + "','" + a + "','" + d.idAbsPath
						+ "')\">" + d.name + "</a>"
			}
		}
		var c = '<li class="listTitle ellipsis" title="' + d.name + '" >' + g
				+ "</li>";
		return c
	},
	initHotVideo : function(c) {
		var b = $("#pbiIdsJSON").val();
		var a = b && JSON.parse(b);
		if (!a.length) {
			return

		}
		var d = a.join();
		this.param = {
			pbiList : d,
			fromSize : "0",
			pageSize : c,
			orderBy : "doc_browse desc,last_update_time desc",
			requestType : "ajax.json"
		};
		$
				.ajax({
					type : "POST",
					url : "/enterprise/getVideoListActionByCondition!getVideoByCondition",
					data : this.param,
					dataType : "json",
					success : function(f) {
						try {
							if ("ssoLoginTimeOut" == f.ssoLoginFlag) {
								productFamily.forLogin()
							} else {
								var g = "";
								if (f && f.videoList && f.videoList.length > 0) {
									$.each(f.videoList, function(e, i) {
										g += productFamily
												.getHotVideoHtml(e, i)
									});
									$("#hotVideoContent li").remove(
											".listTitle");
									$("#hotVideoContent").append(g)
								}
							}
						} catch (h) {
						}
					},
					error : function() {
					}
				})
	},
	getDocHtml : function(c, d) {
		var g = "";
		var b = "";
		var h = "";
		var f = $("#sessionLang").val();
		if (d.isHedex == "0") {
			h = '<a class="doc-title" id="' + d.contentId
					+ '" href="/enterprise/' + f + "/doc/" + d.contentId + '">'
					+ d.name + "</a>"
		} else {
			var a = $("#sessionLang").val();
			var e = $("#hedexPath").val();
			if (d.viewStatus == "L") {
				h = '<a class="doc-title" id="' + d.contentId + '" href="' + e
						+ "?docid=" + d.contentId + "&lang=" + a + "&idPath="
						+ d.pbiId + '">' + d.name + "</a>"
			} else {
				h = '<a class="doc-title" id="' + d.contentId
						+ '" href="javascript:productFamily.asyncHedex(\'' + e
						+ "','" + d.contentId + "','" + a + "','" + d.pbiId
						+ "')\">" + d.name + "</a>"
			}
		}
		if (d.isVideo == "1") {
			b += "<span><img src='/enterprise/images/transparent.gif' class='icon-img icon_video'/></span>"
		}
		if (d.viewStatus == "L") {
			b += '<span><img src="/enterprise/images/transparent.gif" class="icon-img icon_lock"/></span>'
		}
		g = '<li class="line-h-20" title="' + d.name + '" >' + h + b + "</li>";
		return g
	},
	initLatestDoc : function() {
		this.param = {
			pbiIds : $("#pbiIdsJSON").val(),
			limit : "5",
			type : "1",
			requestType : "ajax.json"
		};
		$.ajax({
			type : "POST",
			url : "/enterprise/product-family!getDoc",
			data : this.param,
			dataType : "json",
			success : function(a) {
				try {
					if ("ssoLoginTimeOut" == a.ssoLoginFlag) {
						productFamily.forLogin()
					} else {
						var b = "";
						if (a && a.length > 0) {
							$.each(a, function(d, e) {
								b += productFamily.getDocHtml(d, e)
							});
							$("#latestDocContent").empty();
							$("#latestDocContent").append(b)
						}
					}
				} catch (c) {
				}
			},
			error : function() {
			}
		})
	},
	initHdxDoc : function() {
		this.param = {
			pbiIds : $("#pbiIdsJSON").val(),
			limit : "5",
			type : "2",
			requestType : "ajax.json"
		};
		$.ajax({
			type : "POST",
			url : "/enterprise/product-family!getDoc",
			data : this.param,
			dataType : "json",
			success : function(a) {
				try {
					if ("ssoLoginTimeOut" == a.ssoLoginFlag) {
						productFamily.forLogin()
					} else {
						var b = "";
						if (a && a.length > 0) {
							$.each(a, function(d, e) {
								b += productFamily.getDocHtml(d, e)
							});
							$("#hdxDocContent").empty();
							$("#hdxDocContent").append(b)
						}
					}
				} catch (c) {
				}
			},
			error : function() {
			}
		})
	},
	initHotDoc : function() {
		this.param = {
			pbiIds : $("#pbiIdsJSON").val(),
			limit : "5",
			type : "3",
			requestType : "ajax.json"
		};
		$.ajax({
			type : "POST",
			url : "/enterprise/product-family!getDoc",
			data : this.param,
			dataType : "json",
			success : function(a) {
				try {
					if ("ssoLoginTimeOut" == a.ssoLoginFlag) {
						productFamily.forLogin()
					} else {
						var b = "";
						if (a && a.length > 0) {
							$.each(a, function(d, e) {
								b += productFamily.getDocHtml(d, e)
							});
							$("#hotDocContent").empty();
							$("#hotDocContent").append(b)
						}
					}
				} catch (c) {
				}
			},
			error : function() {
			}
		})
	},
	getProductHtml : function(c, d) {
		var h = "";
		if ("zh" == $("#sessionLang").val()) {
			h = d.pbiNameZH
		} else {
			h = d.pbiNameEn
		}
		var b = d.pbiNameEn;
		var f = $("#categoryName").val();
		var a = "";
		var g = $("#language").val();
		if (b) {
			b = b.toLowerCase().replace(/([ /&])/g, "-")
		}
		if (b && f) {
			a = "/enterprise/" + g + "/" + f + "/" + b + "-pid-" + d.pbiId
					+ "/"
		} else {
			a = "/enterprise/productNewOffering?pid=" + d.pbiId
					+ "&productname=" + encodeURIComponent(h)
		}
		var e = '<div class="col-xs-6 col-sm-3"><a href="'
				+ a
				+ '"><img src="/enterprise/images/transparent.gif" alt="" class="home_icon icon_disc_gray vertical_m"/>'
				+ h + "</a></div>";
		return e
	},
	initProduct : function() {
		this.param = {
			pbiIds : $("#pbiIdsJSON").val(),
			requestType : "ajax.json"
		};
		$.ajax({
			type : "POST",
			url : "/enterprise/product-family!getProductList",
			data : this.param,
			dataType : "json",
			success : function(a) {
				try {
					if ("ssoLoginTimeOut" == a.ssoLoginFlag) {
						productFamily.forLogin()
					} else {
						var d = "";
						var c = "";
						if (a && a.length > 0) {
							$.each(a, function(e, f) {
								if (e <= 19) {
									d += productFamily.getProductHtml(e, f)
								} else {
									if (e > 19) {
										c += productFamily.getProductHtml(e, f)
									}
								}
							});
							$("#hiddenProductsContent").empty();
							$("#productsContent").prepend(d);
							$("#hiddenProductsContent").append(c);
							if (c) {
								$("#productMore").show()
							}
						}
					}
				} catch (b) {
				}
			},
			error : function(b, c, a) {
				console && console.log(b + c + a)
			}
		})
	},
	initMySupport : function() {
		$.ajax({
			type : "post",
			url : "/enterprise/Main!getUserProfiles.action",
			dataType : "json",
			cache : true,
			async : false,
			success : function(a) {
				if (a && a.USER_INFO) {
					isLogin = true;
					$("#LoginOpen").css("display", "");
					$("#ms_applicantsCount").text(a.ms_applicantsCount);
					$("#ms_waitApprovedCount").text(a.ms_waitApprovedCount);
					$("#presentRole").empty();
					if (a.isShow == true) {
						$("#mySubscribe").show()
					}
					popedomLevel(a.popedomLevel);
					if (a.isHWE == 1) {
						$("#createFAQ_li").css("display", "block");
						$("#myToDo").css("display", "block")
					}
				} else {
					$("#noLoginOpen").css("display", "")
				}
			}
		});
		$("#mysupportButton").click(function() {
			$("#mysupport").toggleClass("open");
			return false
		});
		$(document).click(function(a) {
			if ($("#mysupport").hasClass("open")) {
				$("#mysupport").removeClass("open")
			}
		})
	},
	initSearch : function() {
		$("#spte-prd-inputbox").autocomplete({
			minLength : 0,
			source : function(b, a) {
			}
		})
	}
};
$(function() {
	productFamily.initProduct();
	productFamily.initListener();
	productFamily.initLatestDoc();
	productFamily.initHdxDoc();
	productFamily.initHotDoc();
	productFamily.initLatestVideo();
	productFamily.initMySupport()
});