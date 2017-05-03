// 定义全局变量
var hedexPath=$("#hedexPath").val();
var idAbsPath="";
var lang="";
var hasEos=false;
var docPreLink = "";
var docHelpLink = "";
var pid ="";
var productname="";
var isnotHedexLite = (navigator.userAgent.indexOf("MSIE") == -1 && navigator.userAgent.indexOf("Firefox") == -1 
		&& navigator.userAgent.indexOf("Trident") == -1 && navigator.userAgent.indexOf("Chrome") == -1) || navigator.userAgent.indexOf("Edge") != -1;

$(function(){
	var language = $("#language").val();
	var pid = getQueryString('pid');
	if('de' == language){
		$(".changeFontSize").css("font-size","16px");
	}
	if('jp' == language){
		$(".spte-main-tab li").css("width","13.599%");
	}
	
	if (pid != null || pid != "") {
		$("#pid").val(pid);
	}
	var from = $('#from').val();
	if(from == 'soft'){
		var isSoftVersion = $("#isSoftVersion").val();
		if ('zh' == language || 'en' == language) {
			if (isSoftVersion == "N") {
				$("#return").hide();
			} else {
				$("#return").show();
			}
		} else {
			$("#return").hide();
		}
	}else{
		var isVersion = $("#isVersion").val();
		if ('zh' == language || 'en' == language) {
			if (isVersion == "N") {
				$("#return").hide();
			} else {
				$("#return").show();
			}
		} else {
			$("#return").hide();
		}
	}
	
	
	
	if (language == "en") {
		$("#icon_version").removeClass("icon_version_zh"); 
		$("#icon_version").addClass("icon_version_en"); 
	} else {
		$("#icon_version").removeClass("icon_version_en"); 
		$("#icon_version").addClass("icon_version_zh"); 
	}

});

$(document).ready(function() {
	// 加载数据
	loadData();
	// 添加页面监听
	initListener();
	// 初始化页面UI
	initUI();
	// 初始化案例，软件，公告页签
	//initTabDisplay();
	initProductPic();
	
	initMySupportMenu();
	
	productZoomLeftRright();
});
/*-------------loadData-------------begin */


$(window).scroll(function(){ 		 
	 if((document.documentElement.scrollTop+document.body.scrollTop)!=0){	
		$("#return").css("bottom","90");
	 } else {
		$("#return").css("bottom","20");
	 }		
  });
  
  $("#return").click(function(){
	  pid = getQueryString('pid');
	  if (pid == null) {
		 var temp = idAbsPath.split("|");
		 pid = temp[temp.length-1]; 
	  }
	  if($("#from").val() == "soft"){
		  window.location.href= "/enterprise/softdownload.action?idAbsPath=fixnode01|" + idAbsPath + "&pid=" + pid + "&soft_set_version=softOldVersion"; //旧网页的地址	
	  }else{
		  window.location.href= "/enterprise/productsupport?idAbsPath=" + idAbsPath + "&pid=" + pid + "&set_version=version"; //旧网页的地址	
	  }
  }); 	

function initProductPic(){
	$(document).on("click", "#thumblist a", function (e) {
        $(this).parents("#thumblist").find(".zoomThumbActive").not(this).removeClass("zoomThumbActive").end().end().end().addClass("zoomThumbActive");
        $(".js_show_gallery img").attr("src", $(this).attr("pic_src")).attr("title", $(this).attr("title"));
        $(".js_product_mode_title").text($(this).attr("title"));
        return false;
    }).on("click", ".js_show_gallery", function (e) {
        if ($(window).width() < 768)
            return false;
        var i = $("#thumblist a.zoomThumbActive").parent().index();
        $("#js_thumblist_gallery_set li").eq(i).find("a").trigger("click");
        return false;
    });
}

// 加载页面数据
  function loadData() {
	  var from = $("#from").val();
		
		var lang=$("#language").val();
		if (from == 'soft') {
			$("#spte_doc_box").hide();
			$("#spte_software_box").show();
			/*$.post("/enterprise/pages/doc/js/product_software.js", function(){
				initSoftVr();
			}, 'script'); */
			initSoftVr();
			
		} 
		else if(from == 'case')
		{
			$("#spte_doc_box").hide();
			$("#spte_case_box").show();
			/*$.post("/enterprise/cbb/openSourceModified/pages/paging/js/jquery.pagination_modified.js", 'script');
			if (lang == 'zh') {
				$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_zh.js", 'script');
			} else {
				$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_en.js", 'script');
			}
			$.post("/enterprise/pages/doc/js/product_case.js", function(){
				getCaseCount();
			}, 'script'); */
			
			//初始化参数
			chooseScenario();
			
			getCaseCount();
		}
		/*------视频---------*/
		else if(from == 'video')
		{
			$("#spte_doc_box").hide();
			$("#spte_video_box").show();
			/*$.post("/enterprise/cbb/openSourceModified/pages/paging/js/jquery.pagination_modified.js", 'script');
			if (lang == 'zh') {
				$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_zh.js", 'script');
			} else {
				$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_en.js", 'script');
			}
			$.post("/enterprise/pages/doc/js/product_video.js"
			, 'script'); */
		}
		
		else if(from == 'tool')
		{
			$("#spte_doc_box").hide();
			$("#spte_tool_box").show();
			/*$.post("/enterprise/pages/doc/js/product_tool.js", function(){
				getToolCount();
			}, 'script');*/
			
			getToolCount();
		}
		else if(from == 'news')
		{
			$("#spte_doc_box").hide();
			$("#spte_bulletin_box").show();
			/*$.post("/enterprise/cbb/openSourceModified/pages/paging/js/jquery.pagination_modified.js", 'script');
			if (lang == 'zh') {
				$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_zh.js", 'script');
			} else {
				$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_en.js", 'script');
			}
			$.post("/enterprise/pages/doc/js/product_bulletin.js", function(){
				getNewsCount();
			}, 'script');  */
			
			//回退事件
			$("#itemNewsType").val("03");
			
			getNewsCount();
		}
		else if(from == 'community')
		{
			$("#spte_doc_box").hide();
			$("#spte_community_box").show();
			/*$.post("/enterprise/pages/doc/js/product_community.js", function(){
				getCommunityCount();
			}, 'script'); */
			
			getCommunityCount();
		}
		else {
			// 加载文档列表
			//obtainDocData();
			
			// 选择学习材料时不区分版块 
			if ($("#selectDocType").val() == 'DOCTYPE10') {
				getLearnMeterInnerDocs();
			} else {
				// 加载通用文档、R/C版块、技术指导等信息
				getSecondInnerDocs();
			}
			// 加载EOS的文档
			getEosDocs();
			
			//加载文档分类部分文档相关内容
			setOfferingFirstView();
			
			//加载性能打点数据
			setPerfmanceData();
		}
		// 加载快速链接、本产品其它资源、相关链接
		//linkhref();
	}

//加载文档列表
function obtainDocData() {
	// 选择学习材料时不区分版块 
	if ($("#selectDocType").val() == 'DOCTYPE10') {
		getLearnMeterInnerDocs();
	} else {
		// 加载通用文档、R/C版块、技术指导等信息
		getSecondInnerDocs();
	}
	// 加载热门文档、文档分类、产品版本
	getOfferingFirstView();
	// 加载EOS的文档
	getEosDocs();
}

function setUlHeight(){
	
	  //取到ul下面有多少级菜单，估算菜单的大致高度，当菜单的超过可视区高度设置滚动条
	  var ul_per_height = 33; //每行高
	  var tmp = $(window).height()-215; //可视区高
	  var total_ul=0;
	  $(".xbreadcrumbs LI UL").each(function(index, element) {
	    var total_li = 0;
		$(this).children().each(function(index, element) {
	        total_li =  total_li+1;		   
	    });
		total_ul=total_li*ul_per_height;
		if(total_ul>=tmp) {	  
			$(this).css("height",tmp);
			$(this).css("overflow-y","auto");
		} else {
			$(this).css("overflow-y","hidden");
		}	
	  });
}

//加载offering聚合页面文档打点
function setPerfmanceData(){
	
	if("undefined" != typeof(firstScreenEnd)){
		var o = new Object();
		o.firstScreenEnd = firstScreenEnd;
		o.system = "support-e";
		o.feature = "offering-doc";
		o.function0 = "offering聚合页面-文档";
		o.function1 = "";
		o.function2 = "";
		_daq.push(['_trackPerf', o]);
	}
	
}

function setOfferingFirstView(){
	
	
	// 显示文档类型
	$("#docTypeDiv").css("display", "block");
	
	// 官网需求，希望进入页面时能直接定位到文档分类处
	var position = getQueryString('position');
	if (position == 'docType') {
		$("html,body").animate({scrollTop:  $("#docTypeDiv").offset().top}, 200);
	}
	
	
	//默认选中类型分析
	var selectDocType = $("#selectDocType").val();
	
	if(null == selectDocType || "" == selectDocType)
	{
		return;
	}
	else{
		$("a[name='docTypeName']").removeClass("selected");
		var a = $("[value="+selectDocType+"]");
		a.addClass("selected");
	}
	
	
}

// 加载热门文档、文档分类
function getOfferingFirstView() {
	var selectDocType = $("#selectDocType").val();
	$.ajax({
		   type: "POST",
		   url: "/enterprise/DocNewOfferingAction!getOfferingFirstView.action",
		   data: {
				idAbsPath:idAbsPath, 
				requestType:"ajax.json"
			},
		   dataType: "json",
		   success: function(data) {
				try {
					if ("ssoLoginTimeOut"==data.ssoLoginFlag) {
						forLogin();
					}
				} catch (e) {
				}
				// 给语种赋值
				lang = $("#language").val();
				$("#hotDiv").html("");
				$.each(data, function(key1, item1) {
					// 返回值的KEY是hotDocList说明是热门文档集合
					if ("hotDocList" == key1) {
						if (null != item1 && item1.length > 0) {	
							var hotDocDiv = "";
							var seo_path = $("#idAbsPath").val();
							$.each(item1, function(key2, item2) {
								hotDocDiv = assemblageHotContent(key2, item2, hotDocDiv, seo_path);
							});
							if (hotDocDiv != "") {
								hotDocDiv += "<div class='spte-clearboth'></div>";
								$("#hotDiv").append(hotDocDiv);
							}
							$(".spte-hot").css("display", "block");
						} else {
							$(".spte-hot").css("display", "none");
						}
					}
					// 返回值的KEY是docTypeList说明是文档类型集合
					if ("docTypeList" == key1) {
					if (null != item1 && item1.length > 0) {	
						var allSelected = "";
						if(selectDocType == ''){
							allSelected = "class='selected'";
						}
//						var docTypeInnerType = "<span class='spte-filter-doctype' style='width:64px; display:inline-block; text-align:center;'><a href='javascript:void(0)' name='docTypeName' onclick='clickDocType(\"全部\");' value='' "+allSelected+">"+$("#i18n_doc_all").val()+"</a></span>";
//						$("#docTypeSpanAll").after(docTypeInnerType);
						var pre_url = "/enterprise/"+$("#language").val()+"/"+ $("#category_name").val() + "/" + $("#product_name").val() + "-pid-" + $("#pid_url").val() + "/";
						var docTypeInner = "<li><a name='docTypeName' href='"+pre_url+"' onclick='clickDocType(\"全部\");return false;' "+ allSelected +" value='' >" + $("#i18n_doc_all").val() + "</a></li>";
						
						$.each(item1, function(key2, item2) {
							var selected = "";
							if(selectDocType == item2.code){
								selected = "class='selected'";
							}
							docTypeInner += "<li><a name='docTypeName' href='"+pre_url+"?category="+escapeHtml(item2.nameUrl)+"' onclick='clickDocType(\""+ escapeHtml(item2.zhName) +"\");return false;' scen_name='"+escapeHtml(item2.nameUrl)+"' value="+item2.code+" "+selected+">"+escapeHtml(item2.displayName)+"</a></li>";
						});
						
						// 清空文档类型
						$("#docTypeInfo").html("");
						
						// 加载文档类型
						$("#docTypeInfo").append(docTypeInner);			
						
						setTimeout(function() {
							// 若有售前文档则加载

							if (docPreLink != "" && null != docPreLink) {
								$("#docTypeInfo").append("<li><a href='"+ docPreLink +"' target='_blank' >" + $('#i18n_doc_preLink').val() + "<img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_zc'/></a></li>");
							}
							// 若有如何选择产品文档链接则加载
							if (docHelpLink != "" && null != docHelpLink) {
								$("#docTypeInfo").find("li:last").append("<span class='spte-filter-desc' style='padding-left:18px;display:inline'><a href='" + docHelpLink + "' title='"+$('#i18n_doc_helpLink').val()+"' target='_blank'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_help'/></a></span>");
							}
						}, 300);
						
						// 显示文档类型
						$("#docTypeDiv").css("display", "block");
						
						// 官网需求，希望进入页面时能直接定位到文档分类处
						var position = getQueryString('position');
						if (position == 'docType') {
							$("html,body").animate({scrollTop:  $("#docTypeDiv").offset().top}, 200);
						}
					}else{
						//DTS2016010708434  与DTS2016031508235 
						// 如果节点下全都是eos文档时，发现getEosDocs方法会比getOfferingFirstView先执行完，此时hasEos=true
						if(hasEos){
							$("#docTypeDiv").parent().css("display", "none");
						}else{
							//节点下没有文档时，页面显示提示内容
							$("#docDiv").css("display","none");
							$("#docNotFound").css("display","block");
						}
					}
					}
				});
			}
		});
}

//加载通用文档、R/C版块、技术指导等信息
function getSecondInnerDocs() {
	// 加载数据前先清空
	$("#docContent").html("");
	// 获取文档路径
	idAbsPath = $("#idAbsPath").val();
	// 获取当前文档类型
	var selectDocType = $("#selectDocType").val();
	// 锁屏
	var lock_screen = new sui.cbb.blockUI();
	lock_screen.block(true);
	$.ajax({
		   type: "POST",
		   url: "/enterprise/DocNewOfferingAction!getSecondInnerDocs.action",
		   data: {
				idAbsPath:idAbsPath,
				docType:selectDocType,
				requestType:"ajax.json"
			},
		   dataType: "json",
		   success: function(data) {
				try {
					if ("ssoLoginTimeOut"==data.ssoLoginFlag) {
						forLogin();
					}
				} catch (e) {
				}
				// 解锁
				lock_screen.unBlock();
				// 给语种赋值
				lang = $("#language").val();
				var product_name = $("#product_name").val();
				var pid_url = $("#pid_url").val();
				var v_lang ="";
				if (lang == "zh") {
					v_lang = "zh";
				} else {
					v_lang = "en";
				}
				if (null != data && data.length > 0) {
					var seo_path = $("#idAbsPath").val();
					$.each(data, function(key1, item1) {
						// 如果版块标识为General，说明是通用文档
						if (item1.uniqueTag == 'General') {
							var docVersionInner = "<option value='General'>" + $("#i18n_general_doc").val() + "</option>";
							// 插入版块到版本快速定位下拉框中
							$("#docVersionInfo").prepend(docVersionInner, 'General');
							var innerDocs = item1.innerDocs;
							if (null != innerDocs && innerDocs.length > 0) {
								var generalDocDiv = "";
								
								$.each(innerDocs, function(key2, item2) {
									generalDocDiv = assemblageContent(key2, item2, generalDocDiv, innerDocs.length, item1.more, seo_path);
								});
								if (generalDocDiv != "") {
									var sectionId = item1.uniqueTag;									
									if(selectDocType!="")
										{
										var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId + '&docType=' + selectDocType;
										}
									else
										{
										var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId;
										}									
									var generalDocBlock = "<div class='spte-blk' id='General' curPage='1' secondTag='General'>";
									//标题开始
									generalDocBlock +="<div class='spte-blk-vision' onclick='toggleShow(this)'><div class='spte-blk-vn-title'>" + $("#i18n_general_doc").val();
									//通用不需要收起功能
									generalDocBlock +='<div class="spte-fl-right" ><img src="/enterprise/pages/main/images/transparent.gif" alt="" class="icon-img icon_dw"></div>';
									//标题结束 
									generalDocBlock +="</div></div>";
									//内容部分
									generalDocBlock +="<div class='sectionDiv'><p class='color666 margin-t10'>" + $("#i18nGeneral").val() +" <a target='_blank' href='"+href_+"' title='"+i18nProperty.batchDownload+"' ><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_batch_download'></a></p>";
									generalDocBlock +="<div class='spte-doc-show' id='generalDocContent'>" + generalDocDiv + "<div class='spte-clearboth'></div></div>";
									/*if (item1.more == '1') {
										generalDocBlock += "<div class='spte-blk-dw_"+ v_lang +"' onclick='showFixhidden(this,true);'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_arrow_down' />" + $("#i18n_spread").val() + "</div>";
									}*/
									generalDocBlock+="</div></div>";
									$("#docContent").append(generalDocBlock);
								}
							}
						}
						// 如果版块名称不为NULL，说明是R/C版块
						else if (item1.name != null) {
							var generalDocDiv = "";
							var itemId = item1.name;
							if (itemId.match(/c|C{1}\d{2}/g)) {
								itemId = itemId.substring(0,itemId.length-3);
							}
							var sectionId = item1.uniqueTag;							
							if(selectDocType!="")
							{
							//文档下载地址列表重写为静态URL
							var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId + '&docType=' + selectDocType;
							}
							else
							{
							//文档下载地址列表重写为静态URL
							var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId;
							}	
							var generalDocBlock = "<div class='spte-blk' id='" + itemId + "' curPage='1' secondTag='" + item1.uniqueTag + "'><div class='spte-blk-vision' onclick='toggleShow(this,"+item1.uniqueTag+")' ><div class='spte-blk-vn-title'>" + item1.name;
							// 获取公共版本的文档
							var innerDocs = item1.innerDocs;
							if (null != innerDocs && innerDocs.length > 0 && innerDocs[0].security == 'hide_section') {
								generalDocBlock +='<div class="spte-fl-right" ><img src="/enterprise/pages/main/images/transparent.gif" alt="" class="icon-img icon_up"></div>';
							} else {
								generalDocBlock +='<div class="spte-fl-right" ><img src="/enterprise/pages/main/images/transparent.gif" alt="" class="icon-img icon_dw"></div>';	
							}
							
							generalDocBlock +="</div></div>";
							generalDocBlock +="<div class='sectionDiv'>";
							if (null != innerDocs && innerDocs.length > 0) {
								if (innerDocs[0].security != 'hide_section') {
									generalDocBlock +="<p class='font-s16 margin-t10'>" + $("#i18n_general_doc").val() + " <a target='_blank' href='"+href_+"' title='"+i18nProperty.batchDownload+"'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_batch_download' /></a></p>";
									var i18nPublic = (null != innerDocs[0].isNewRelease && 'Y' == innerDocs[0].isNewRelease) ? $("#i18nNewReleasePublic").val() : $("#i18nPublic").val();
									generalDocBlock +="<p class='color666'>" + i18nPublic + "</p>";
									$.each(innerDocs, function(key2, item2) {
										generalDocDiv = assemblageContent(key2, item2, generalDocDiv, innerDocs.length, item1.more, seo_path);
									});
								}
								generalDocBlock +="<div class='spte-doc-show' id='generalDocContent'>" + generalDocDiv + "<div class='spte-clearboth'></div></div>";
								/*f (item1.more == '1') {
									generalDocBlock += "<div class='spte-blk-dw_"+ v_lang +"' onclick='showFixhidden(this,false);'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_arrow_down' />" + $("#i18n_spread").val() + "</div>";
								}*/
							}
							// 获取当前版本的子集
							var childrenSection = item1.secondChildren;
							if (null != childrenSection && childrenSection.length > 0) {
								$.each(childrenSection, function(key3, item3) {
									var childrenDocs = item3.innerDocs;	
									if (null != childrenDocs && childrenDocs.length > 0) {
										var childrenDocDiv = "";
										if(selectDocType!="")
										{
										//文档下载地址列表重写为静态URL
										var href_c = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +item3.uniqueTag + '&docType=' + selectDocType;
										}
										else
										{
										//文档下载地址列表重写为静态URL
										var href_c = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +item3.uniqueTag;
										}										
										var childrenDocBlock = "<p style='font-size:16px;margin-top:10px;'>"+ item3.name +" <span class='spte-cursor-hand spte-marginright5 spte-dwn-batch' title='"+i18nProperty.batchDownload+"'><a target='_blank' href='"+href_c+"'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_batch_download' /></a></span></p>";
										$.each(childrenDocs, function(key4, item4) {
											childrenDocDiv = assemblageContent(key4, item4, childrenDocDiv, childrenDocs.length, item3.more, seo_path);
										});
										childrenDocBlock +="<div class='spte-doc-show' id='generalDocContent'>" + childrenDocDiv + "<div class='spte-clearboth'></div></div>";
										/*if (item3.more == '1') {
											childrenDocBlock += "<div class='spte-blk-dw_"+ v_lang +"' onclick='showFixhidden(this,false);'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_arrow_down' />" + $("#i18n_spread").val() + "</div>";
										}*/
										generalDocBlock += childrenDocBlock;
									}
								});
							}
	
							generalDocBlock +="</div></div>";
							$("#docContent").append(generalDocBlock);
						}
						// 如果版块标识为Technical，说明是技术指导
						else if (item1.uniqueTag == 'Technical') {
							var innerDocs = item1.innerDocs;
							if (null != innerDocs && innerDocs.length > 0) {
								var generalDocDiv = "";
								if (innerDocs[0].security != 'hide_section') {
									$.each(innerDocs, function(key2, item2) {
										generalDocDiv = assemblageContent(key2, item2, generalDocDiv, innerDocs.length, item1.more, seo_path);
									});
								}
								var generalDocBlock = "<div class='spte-blk' curPage='1' id='Technical' secondTag='Technical'><div class='spte-blk-vision' onclick='toggleShow(this)' ><div class='spte-blk-vn-title'>" + $("#i18n_technical_doc").val();
								var sectionId = item1.uniqueTag;
								if(selectDocType!="")
								{
								//文档下载地址列表重写为静态URL
								var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId + '&docType=' + selectDocType;
								}
								else
								{
								//文档下载地址列表重写为静态URL
								var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId;
								}								
								generalDocBlock +='<div class="spte-fl-right" ><img src="/enterprise/pages/main/images/transparent.gif" alt="" class="icon-img icon_up"></div></div></div>';
								generalDocBlock +="<div class='sectionDiv'>";
								generalDocBlock +="<div class='spte-doc-show' id='technicalDocContent'>" + generalDocDiv + "<div class='spte-clearboth'></div></div>";
								/*f (item1.more == '1') {
									generalDocBlock += "<div class='spte-blk-dw_"+ v_lang +"' onclick='showFixhidden(this,true);'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_arrow_down' />" + $("#i18n_spread").val() + "</div>";
								}*/
								generalDocBlock += "</div></div>";
								$("#docContent").append(generalDocBlock);
							}
						}
						// 如果版块标识为LearnMeter，说明是学习材料
						else if (item1.uniqueTag == 'LearnMeter') {
							var innerDocs = item1.innerDocs;
							if (null != innerDocs && innerDocs.length > 0) {
								var generalDocDiv = "";
								if (innerDocs[0].security != 'hide_section') {
									$.each(innerDocs, function(key2, item2) {
										generalDocDiv = assemblageContent(key2, item2, generalDocDiv, innerDocs.length, item1.more, seo_path);
									});
								}
								var generalDocBlock = "<div class='spte-blk' id='LearnMeter' curPage='1' secondTag='LearnMeter'><div class='spte-blk-vision' onclick='toggleShow(this)' ><div class='spte-blk-vn-title'>" + $("#i18n_learnMeter_doc").val();
								var sectionId = item1.uniqueTag;
								if(selectDocType!="")
								{
								var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId+ '&docType=' + selectDocType ;
								}
								else
								{
								var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId;
								}
								generalDocBlock +='<div class="spte-fl-right" ><img src="/enterprise/pages/main/images/transparent.gif" alt="" class="icon-img icon_up" /></div></div></div>';
								generalDocBlock +="<div class='sectionDiv'>";
								generalDocBlock +="<div class='spte-doc-show' id='learnMeterDocContent'>" + generalDocDiv + "<div class='spte-clearboth'></div></div>";
								/*if (item1.more == '1') {
									generalDocBlock += "<div class='spte-blk-dw_"+ v_lang +"' onclick='showFixhidden(this,true);'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_arrow_down' />" + $("#i18n_spread").val() + "</div>";
								}*/
								generalDocBlock += "</div></div>";
								$("#docContent").append(generalDocBlock);
								}
							}
						});
						// 加载默认值
						$("#docVersionInfo").prepend("<option value='all'>" + $("#i18n_select_block").val() + "</option>");
						// 默认选中默认值
						$("#docVersionInfo").val("all");
						// 显示产品版本
						$("#docVersionDiv").css("display", "block");
					}
				//性能打点
				if(_haq){
					var ha2pvo = new Object();   
					ha2pvo.aboveTheFoldTime = (new Date()).getTime();   
					_haq.push(['_trackAboveTheFoldTime', ha2pvo]);
				}
				
				
				
		  }
	});	
}

//加载Eos文档
function getEosDocs() {
	var selectDocType = $("#selectDocType").val();
	$.ajax({
		type: "POST",
		url: "/enterprise/DocNewOfferingAction!getEosDocList.action",
		data: {
			idAbsPath:idAbsPath,
			requestType:"ajax.json"
		},
		dataType:'json',
		success:function(data) {
			try {
				if ("ssoLoginTimeOut"==data.ssoLoginFlag) {
					forLogin();
				}
			} catch (e) {
			}
			// 给语种赋值
			lang = $("#language").val();
			var product_name = $("#product_name").val();
			var pid_url = $("#pid_url").val();
			var v_lang ="";
			if (lang == "zh") {
				v_lang = "zh";
			} else {
				v_lang = "en";
			}
			if (null != data && data.length > 0) {
				var seo_path = $("#idAbsPath").val();
				$.each(data, function(key1, item1) {
					var innerDocs = item1.innerDocs;
					if (null != innerDocs && innerDocs.length > 0) {
						var eosDocDiv = "";
						if (innerDocs[0].security != 'hide_section') {
							$.each(innerDocs, function(key2, item2) {
								eosDocDiv = assemblageContent(key2, item2, eosDocDiv, innerDocs.length, item1.more, seo_path);
							});
						}
						var sectionId = 'EOS';
						if(selectDocType!="")
						{
						var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId + '&docType=' + selectDocType;
						}
						else
						{
						var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId;
						}
						var eosDocBlock = "<div class='spte-blk' id='EOS' curPage='1' secondTag='EOS'><div class='spte-blk-vision' onclick='toggleShow(this)' ><div class='spte-blk-vn-title'>" + $("#i18n_isEos_doc").val();
						eosDocBlock +='<div class="spte-fl-right" ><img src="/enterprise/pages/main/images/transparent.gif" alt="" class="icon-img icon_up"></div></div></div>';
						eosDocBlock +="<div class='sectionDiv'>";
						eosDocBlock +="<div class='spte-doc-show' id='eosDocContent'>" + eosDocDiv + "<div class='spte-clearboth'></div></div></div>";
						eosDocBlock +="</div>";
						$("#eosDoc").append(eosDocBlock);
					}
					hasEos=true;
				});
			}
		}
	}
	);
}

//显示、隐藏版块文档列表
function toggleShow(obj, currentTag) {
   if (currentTag == undefined) {
       secondTag = $(obj).parents(".spte-blk").attr("secondtag");
   } else {
   	   secondTag = currentTag;
   }
   var hasDoc = $(obj).parents(".spte-blk").find(".spte-doc-show-half_zh").length || $(obj).parents(".spte-blk").find(".spte-doc-show-half_en").length;
   var sectionDiv = $(obj).siblings(".sectionDiv");
   if (!hasDoc) {
	var selectDocType = $("#selectDocType").val();
	// 锁屏
	var lock_screen = new sui.cbb.blockUI();
	lock_screen.block(true);    
	$.post("/enterprise/DocNewOfferingAction!getOneSectionDocs.action",
		{
			idAbsPath:idAbsPath,
			docType:selectDocType,
			SECONDTAG:secondTag,
			requestType:"ajax.json"
		},
		function(data) {
			try {
				if ("ssoLoginTimeOut"==data.ssoLoginFlag) {
					forLogin();
				}
			} catch (e) {
			}
			lock_screen.unBlock();
			// 给语种赋值
			lang = $("#language").val();
			var product_name = $("#product_name").val();
			var pid_url = $("#pid_url").val();
			var v_lang ="";
			if (lang == "zh") {
				v_lang = "zh";
			} else {
				v_lang = "en";
			}
			if (null != data && data.length > 0) {
				var seo_path = $("#idAbsPath").val();
				$.each(data, function(key1, item1) {
					var generalDocBlock = "";
					var generalDocDiv = "";
					var innerDocs = item1.innerDocs;
					if (null != innerDocs && innerDocs.length > 0) {
						if (innerDocs[0].security != 'hide_section') {
							if(selectDocType!="")
							{
							var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +item1.uniqueTag + '&docType=' + selectDocType;
							}
							else
							{
							var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +item1.uniqueTag;
							}
							if (secondTag == 'Technical' || secondTag=='LearnMeter')
							{
								generalDocBlock +="<p class='color666 margin-t10' >" + $("#i18n" + secondTag).val() + " <a target='_blank' href='"+href_+"' title='"+i18nProperty.batchDownload+"' ><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_batch_download' /></a></span></p>";
							} else if (secondTag == 'EOS') {
								generalDocBlock +="<p class='color666 margin-t10' >" + $("#i18n_eos_description").val() + " <a target='_blank' href='"+href_+"' title='"+i18nProperty.batchDownload+"' ><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_batch_download' /></a></span></p>";
							} else {
								generalDocBlock +="<p class='font-s16 margin-t10' >" + $("#i18n_general_doc").val() + " <a target='_blank' href='"+href_+"' title='"+i18nProperty.batchDownload+"' ><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_batch_download' /></a></span></p>";
								generalDocBlock +="<p class='color666'>" + $("#i18nPublic").val() + "</p>";
							}
							$.each(innerDocs, function(key2, item2) {
								generalDocDiv = assemblageContent(key2, item2, generalDocDiv, innerDocs.length, item1.more, seo_path);
							});
						}
						generalDocBlock +="<div class='spte-doc-show' id='generalDocContent'>" + generalDocDiv + "<div class='spte-clearboth'></div></div>";
						/*f (item1.more == '1') {
							generalDocBlock += "<div class='spte-blk-dw_"+ v_lang +"' onclick='showFixhidden(this,false);'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_arrow_down' />" + $("#i18n_spread").val() + "</div>";
						}*/
					}
					// 获取当前版本的子集
					var childrenSection = item1.secondChildren;
					if (null != childrenSection && childrenSection.length > 0) {
						$.each(childrenSection, function(key3, item3) {
							var childrenDocs = item3.innerDocs;	
							if (null != childrenDocs && childrenDocs.length > 0) {
								var childrenDocDiv = "";
								if(selectDocType!=""){
								var href_c = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +item3.uniqueTag + '&docType=' + selectDocType;
								}
								else{
								var href_c = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +item3.uniqueTag;
								}
								var childrenDocBlock = "<p style='font-size:16px;margin-top:10px;'>"+ item3.name +" <span class='spte-cursor-hand spte-marginright5 spte-dwn-batch' title='"+i18nProperty.batchDownload+"'><a target='_blank' href='"+href_c+"'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_batch_download' /></a></span></p>";
								$.each(childrenDocs, function(key4, item4) {
									childrenDocDiv = assemblageContent(key4, item4, childrenDocDiv, childrenDocs.length, item3.more, seo_path);
								});
								childrenDocBlock +="<div class='spte-doc-show' id='generalDocContent'>" + childrenDocDiv + "<div class='spte-clearboth'></div></div>";
								/*if (item3.more == '1') {
									childrenDocBlock += "<div class='spte-blk-dw_"+ v_lang +"' onclick='showFixhidden(this,false);'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_arrow_down' />" + $("#i18n_spread").val() + "</div>";
								}*/
								generalDocBlock += childrenDocBlock;
							}
						});
					}
					$(obj).parents(".spte-blk").find(".sectionDiv").empty().append(generalDocBlock);
					$(obj).find("img").removeClass("icon_up").addClass("icon_dw");
				});
			}
		},'json'
	);
   } else {
       	if (sectionDiv.css("display")=="none") {
		   sectionDiv.css("display", "block");
		   $(obj).find("img").removeClass("icon_up").addClass("icon_dw");
		} else {
		   sectionDiv.css("display", "none");
		   $(obj).find("img").removeClass("icon_dw").addClass("icon_up");
		}
   }
}

//加载学习材料分类列表
function getLearnMeterInnerDocs() {
	// 加载数据前先清空
	$("#docContent").html("");
	// 获取文档路径
	idAbsPath = $("#idAbsPath").val();
	// 获取当前文档类型
	var selectDocType = $("#selectDocType").val();
	// 锁屏
	var lock_screen = new sui.cbb.blockUI();
	lock_screen.block(true);
	$.ajax({
		type: "POST",
		url:"/enterprise/DocNewOfferingAction!getLearnMeterList.action",
		data:{
			idAbsPath:idAbsPath,
			docType:selectDocType,
			requestType:"ajax.json"
		},
		dataType:'json',
		success:function(data) {
			try {
				if ("ssoLoginTimeOut"==data.ssoLoginFlag) {
					forLogin();
				}
			} catch (e) {
			}
			// 给语种赋值
			lang = $("#language").val();
			var product_name = $("#product_name").val();
			var pid_url = $("#pid_url").val();
			// 解锁
			lock_screen.unBlock();
			if (null != data && data.length > 0) {
				var seo_path = $("#idAbsPath").val();
				$.each(data, function(key1, item1) {
					// 如果版块标识为LearnMeter，说明是学习材料
					if (item1.uniqueTag == 'LearnMeter') {
						var innerDocs = item1.innerDocs;
						if (null != innerDocs && innerDocs.length > 0) {
							var generalDocDiv = "";
							$.each(innerDocs, function(key2, item2) {
								generalDocDiv = assemblageContent(key2, item2, generalDocDiv, innerDocs.length, item1.more, seo_path);
							});
							if (generalDocDiv != "") {
								var generalDocBlock = "<div class='spte-blk' id='LearnMeter' curPage='1' secondTag='LearnMeter'><div class='spte-blk-vision' onclick='toggleShow(this)' ><div class='spte-blk-vn-title'>" + $("#i18n_learnMeter_doc").val();
								var sectionId = item1.uniqueTag;
								if(selectDocType!="")
								{
								var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId + '&docType=' + selectDocType;
								}
								else
								{
								var href_ = '/enterprise/'+ lang + '/download-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +sectionId;
								}
								//generalDocBlock += "<span class='spte-cursor-hand spte-marginright5 spte-dwn-batch' title='"+i18nProperty.batchDownload+"'><a target='_blank' href='"+href_+"'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_batch_download' /></a></span>";
								//通用不需要收起功能
								generalDocBlock +='<div class="spte-fl-right" ><img src="/enterprise/pages/main/images/transparent.gif" alt="" class="icon-img icon_dw"></div>';
								generalDocBlock += "</div></div>";
								generalDocBlock += "<div class='sectionDiv'><p class='color666 margin-t10'>" + $("#i18nLearnMeter").val() +" <a target='_blank' href='"+href_+"' title='"+i18nProperty.batchDownload+"' ><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_batch_download'></a></p><div class='spte-doc-show' id='learnMeterDocContent'>";
								generalDocBlock += generalDocDiv + "<div class='spte-clearboth'></div></div></div></div>";
								$("#docContent").append(generalDocBlock);
							}
						}
					}
				});
				// 加载默认选中版块
				$("#docVersionInfo").prepend("<option value='all'>" + $("#i18n_select_block").val() + "</option>");
				// 默认选中默认值
				$("#docVersionInfo").val("all");
				// 显示产品版本
				$("#docVersionDiv").css("display", "block");
			}
			
			
			
		}
	}
	);
}

// 封装公用的组装列表内容方法
function assemblageContent(key2, item2, contentDiv, length, more, seo_path) {
	// 给语种赋值
	lang = $("#language").val();
	var product_name = $("#product_name").val();
	var pid_url = $("#pid_url").val();
	var v_lang ="";
	if (lang == "zh") {
		v_lang = "zh";
	} else {
		v_lang = "en";
	}
	if (more == '0' || (more == '1' && key2 < length - 1)) {
		// 封装文档的HTML
		var docDiv1 = $('<div class="spte-doc-show-half_'+v_lang+' spte-fl-left"></div>');
		var docA1 = $('<a target="_blank"></a>');
		var seo_url_current = '/enterprise/' + lang + '/doc/'+ item2.contentId + '/?idPath=' + seo_path;
		docA1.attr('href','/enterprise/'+lang + '/doc/'+item2.contentId);
		docA1.html("<span class='spte-blk-doc-title_"+v_lang+" spte-valign-mid' style='word-wrap: break-word;'> " + escapeHtml(item2.ename) + "</span>");
		// 校验是否为聚合文档（1:聚合 0：非聚合)
		if (item2.aggregation == "1" && item2.contentId == null) {
			var selectDocType = $("#selectDocType").val();
			var tips = $("#i18n_juheDocTips").val();//			
			if(selectDocType)
			{
			docA1.attr('href','/enterprise/'+ lang + '/init-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +item2.section + '&docType=' + selectDocType + '&secondType=' + item2.secondType);	
			}
			else
			{
			docA1.attr('href','/enterprise/'+ lang + '/init-doc-list/' + product_name + '-pid-' + pid_url + '?belongVersionId=' +item2.section+'&secondType=' + item2.secondType);
			}			
			docA1.append("<img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_sum' title='"+tips+"'/>");
			//docA1.append("<img src='../enterprise/pages/doc/images/transparent.gif' class='icon-img icon_sum' title='"+tips+"'/>");
		} else {
			if(item2.isHedex == "1")
			{
				var lang_hdx = lang;
				if(lang_hdx != 'zh'){
					lang_hdx ='en';
				}
				if (item2.viewStatus == "L")
				{					
					docA1.attr('href',hedexPath+'?docid='+item2.contentId+'&lang='+lang_hdx +'&idPath=' + idAbsPath);
				}else{
					docA1.attr('target','_self');
					docA1.attr('href','javascript:asyncHedex(\'' + hedexPath + '\',\'' + item2.contentId + '\',\'' + lang_hdx + '\',\'' + idAbsPath + '\');');
				}
			}else{
				docA1.attr('onclick', 'gotoView(\"' + seo_url_current +'\");return false;');
			}
			
			if (item2.isVideo == "1") {
				docA1.append("<span style='float:none;'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_video'/></span>");
			}
			if (item2.viewStatus == "L") {
				docA1.append('<span title="' + $("#lockTip").val() + '" class="lock_icon_doc" style="float:none;"><img src="/enterprise/pages/main/images/transparent.gif" class="icon-img icon_lock"/></span>');
			}
			if (item2.isNew == "1") {
				docA1.append("<span class='newFlag' style='float:none;'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_new'/></span>");
			} 
		}
		docDiv1.html(docA1);
		if (item2.aggregation == "0" || item2.contentId != null) {
			docDiv1.append("<span class='spte-cursor-hand spte-marginright5 spte-dwn' title='"+i18nProperty.relDownload+"'><a href='javascript:void(0);' onclick='shortcutOfDown(\""+item2.contentId+"\",\""+item2.isHedex+"\");' class='spte-doc-down'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_download'/></a></span>");
		}
		if (key2 % 2 == 0) {
			contentDiv += "<div class='spte-doc-show-half_"+v_lang+" spte-fl-left' style='margin-right:2%'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_list'/>" + docDiv1.html() + "</div>";
		} else {
			contentDiv += "<div class='spte-doc-show-half_"+v_lang+" spte-fl-left' style='width:48%'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_list'/>" + docDiv1.html() + "</div>";
		}
	}
	return contentDiv;
}

//封装公用的热门文档/新手入门组装列表内容方法
function assemblageHotContent(key2, item2, contentDiv, seo_path) {
		var v_lang = "";
		if (lang == 'zh') {
			v_lang = 'zh';
		} else {
			v_lang = 'en';
		}
		// 封装文档的HTML
		var docDiv1 = $('<div class="spte-doc-show-half_'+v_lang+' spte-fl-left"></div>');
		var docA1 = $('<a target="_blank"></a>');
		var seo_url_current = '/enterprise/' + v_lang + '/doc/'+ item2.contentId + '/?idPath=' + seo_path;
		docA1.attr('href','/enterprise/'+v_lang+'/doc/'+item2.contentId);
		docA1.attr('onclick', 'gotoView(\"' + seo_url_current +'\");return false;');
		docA1.html("<span class='spte-blk-doc-title_" + v_lang + " spte-valign-mid;' style='word-wrap: break-word;'>" + escapeHtml(item2.name) + "</span>");
		if(item2.isHedex == "1")
		{
			var lang_hdx = lang;
			if(lang_hdx != 'zh'){
				lang_hdx ='en';
			}
			if (item2.viewStatus == "L")
			{				
				docA1.attr('href',hedexPath+'?docid='+item2.contentId+'&lang='+lang_hdx +'&idPath=' + idAbsPath);
			}else{
				docA1.attr('target','_self');
				docA1.attr('href','javascript:asyncHedex(\'' + hedexPath + '\',\'' + item2.contentId + '\',\'' + lang_hdx + '\',\'' + idAbsPath + '\');');
			}
		}
		if (item2.fileType == "FT-media") {

			docA1.append("<span style='float:none;'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_video'/></span>");
		}
		if (item2.viewStatus == "L") {
			docA1.append('<span title="' + $("#lockTip").val() + '" class="lock_icon_doc" style="float:none;"><img src="/enterprise/pages/main/images/transparent.gif" class="icon-img icon_lock"/></span>');
		}
		docDiv1.html(docA1);
		docDiv1.append("<span class='spte-cursor-hand spte-marginright5 spte-dwn' title='"+i18nProperty.relDownload+"'><a href='javascript:void(0);' onclick='shortcutOfDown(\""+item2.contentId+"\",\""+item2.isHedex+"\");' class='spte-doc-down'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_download'/></a></span>");
		if (key2 % 2 == 0) {
			contentDiv += "<div class='spte-doc-show-half_"+v_lang+" spte-fl-left' style='margin-right:2%'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_list'/>" + docDiv1.html() + "</div>";
		} else {

			contentDiv += "<div class='spte-doc-show-half_"+v_lang+" spte-fl-left' style='width:48%'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_list'/>" + docDiv1.html() + "</div>";
		}
	return contentDiv;
}

//选择文档类型后加载产品版本
function getDocVersion() {
	var selectDocType = $("#selectDocType").val();
	// 隐藏产品版本
	$("#docVersionDiv").css("display", "none");
	$.ajax({
		type : "POST",
		url : "/enterprise/DocNewOfferingAction!getDocVersionByType.action",
		data : {
			idAbsPath:idAbsPath,
			docType:selectDocType,
			requestType:"ajax.json"
		},
		dataType : 'json',
		success: function(data) {
			try {
				if ("ssoLoginTimeOut"==data.ssoLoginFlag) {
					forLogin();
				}
			} catch (e) {
			}
		}
	}
	);
}

// 分页展开固定版块的文档列表(通用文档、技术指导、学习材料)
function showFixhidden(obj, isFix) {
	var v_lang = "";
	if (lang == 'zh') {
		v_lang = 'zh';
	} else {
		v_lang = 'en';
	}
	// 若已经获取了展开的数据则直接展开，否则调用后台查询
	if ($(obj).parent().find(".spte-doc-hidden").css("display")=="none") {
		$(obj).parent().find(".spte-doc-hidden").css("display", "block");
		$(obj).parent().find(".spte-blk-dw_"+v_lang).css("display", "none");
		$(obj).parent().find(".spte-blk-up_"+v_lang).css("display", "block");
	} else {
		// 获取当前选择的版块
		var $currentBlock = $(obj).parents(".spte-blk");
		// 获取当前页数
		var curPage = parseInt($currentBlock.attr("curPage")) + 1;
		// 获取当前版块分类
		var SECONDTAG = "";
		// 获取当前R/C版本ID
		var RC_VERSION_ID = "";
		// 调用URL
		var url = "";
		// 获取当前选中的文档分类
		var selectDocType = $("#selectDocType").val();
		// 将分页值回写到版块
		$currentBlock.attr("curPage",curPage);
		if (isFix) {
			// 获取当前版块分类
			SECONDTAG = $currentBlock.attr("secondTag");
			url = "/enterprise/DocNewOfferingAction!getFixedSecondDocs.action";
		} else {
			// 获取当前版块分类
			RC_VERSION_ID = $currentBlock.attr("secondTag");
			url = "/enterprise/DocNewOfferingAction!getRCSecondDocs.action";
		}
		// 锁屏
		var lock_screen = new sui.cbb.blockUI();
		lock_screen.block(true);
		// 调用分页数据
		$.ajax({
			url : url,
			data : {
				idAbsPath:idAbsPath,
				docType:selectDocType,
				SECONDTAG:SECONDTAG,
				RC_VERSION_ID:RC_VERSION_ID,
				curPage:curPage,
				requestType:"ajax.json"
				},
			type: "POST",	
			dataType: 'json',
			success : function(data) {
				try {
					if ("ssoLoginTimeOut"==data.ssoLoginFlag) {
						forLogin();
					}
				} catch (e) {
				}
				// 解锁
				lock_screen.unBlock();
				if (null != data && data.length > 0) {
					var seo_path = $("#idAbsPath").val();
					$.each(data, function(key1, item1) {
						var innerDocs = item1.innerDocs;
						if (null != innerDocs && innerDocs.length > 0) {
							var generalDocDiv = "";
							$.each(innerDocs, function(key2, item2) {
								generalDocDiv = assemblageContent(key2, item2, generalDocDiv, innerDocs.length, item1.more, seo_path);
							});
							if (generalDocDiv != "") {
								var generalDocBlock = "<div class='spte-doc-hidden' style='display: block;'>";
								generalDocBlock += generalDocDiv + "<div class='spte-clearboth'></div></div>";
								if (item1.more == '0') {
									$(obj).hide();
									generalDocBlock += "<div class='spte-blk-up_"+v_lang+"' onclick='hideFixhidden(this);'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_arrow_up' />" + $("#i18n_pack").val() + "</div>";
								}
								$(obj).before(generalDocBlock);
							}
						}
					});
				}
			}
		}
		);
	}
}

/**
 * 隐藏展开的列表
 * @param obj
 */
function hideFixhidden(obj) {
	var v_lang = "";
	if (lang == 'zh') {
		v_lang = 'zh';
	} else {
		v_lang = 'en';
	}
	$(obj).parent().find(".spte-doc-hidden").css("display", "none");
	$(obj).parent().find(".spte-blk-dw_"+v_lang).css("display", "block");
	$(obj).parent().find(".spte-blk-up_"+v_lang).css("display", "none");
	
	// 收起时滚动到当前版块
	//$("html,body").animate({scrollTop: $(obj).parent().offset().top}, 200);
}

/**
 * 描述：防止js脚本注入
 * 
 * 变量说明：
 * @param str:输入的字符串。
 */
function escapeHtml(str) {
	if (null == str) {
		return "";
	} else {
		return $("<div />").text(str).html();
	}
}

/**
 * 从当前URL中获取指定的参数值
 * @param name
 * @returns
 */
function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}

/**
 * hedex文档跳转
 * @param hedexPath
 * @param contentId
 * @param lang
 */
function asyncHedex(hedexPath,contentId,lang,idPath){
	//var href="/ehedex/"+lang+"/"+contentId;
	var href=hedexPath+"?docid="+contentId+"&lang="+lang+"&idPath="+idPath;
	$.ajax({
		type:"POST",
		url:"/enterprise/Counter!addCount.action",
		data:{
			contentId:contentId,
			contentType:"DOC"
		}
	});
	window.open(href);
}

/**
 * 设置链接
 */
function linkhref(){
	idAbsPath = $("#idAbsPath").val();
	var pid = idAbsPath.substring(idAbsPath.lastIndexOf('|')+1,idAbsPath.length);
	var lang = $("#language").val();
	var sessionLang = $("#sessionLang").text();
	var product_name = $("#product_name").val();
	var category_name = $("#category_name").val();	
	var pid_url = $("#pid_url").val();
	var isVocation = $("#isVocation").val();
	setLinkDisplay(idAbsPath,"doc");
	
	//产品预警、整改公告、产品生命周期
	var encodedNewsName0304 = encodeURIComponent(("zh"==sessionLang || ""==sessionLang)? "产品公告|生命周期公告":"productNews|Life Cycle Notices");
	var encodedNewsName0305 = encodeURIComponent(("zh"==sessionLang || ""==sessionLang)? "产品公告|预警公告":"productNews|Warning Notices");
	var encodedNewsName0306 = encodeURIComponent(("zh"==sessionLang || ""==sessionLang)? "产品公告|整改公告":"productNews|Rectification Notices");
	var encodedNewsName0307 = encodeURIComponent(("zh"==sessionLang || ""==sessionLang)? "产品公告|PCN公告":"productNews|PCN");
	
	//产品预警、整改公告、产品生命周期、PCN使用改写后的静态URL
	var productLifeCycleBulletinLink = "/enterprise/"+ lang + "/bulletins-product/life-cycle-notices/" + product_name + "-vid-" + pid;
	var productWarnLink = "/enterprise/"+ lang + "/bulletins-product/warning-notices/" + product_name + "-vid-" + pid;
	var fullchangeNewLink = "/enterprise/"+ lang + "/bulletins-product/rectification-notices/" + product_name + "-vid-" + pid;
	var PCNLink = "/enterprise/"+ lang + "/bulletins-product/pcn/" + product_name + "-vid-" + pid;
	
	if (isVocation == "N") {
		productLifeCycleBulletinLink = "/enterprise/"+ lang + "/bulletins-product/life-cycle-notices/" + product_name + "-pid-" + pid;
		productWarnLink = "/enterprise/"+ lang + "/bulletins-product/warning-notices/" + product_name + "-pid-" + pid;
		fullchangeNewLink = "/enterprise/"+ lang + "/bulletins-product/rectification-notices/" + product_name + "-pid-" + pid;
		PCNLink = "/enterprise/"+ lang + "/bulletins-product/pcn/" + product_name + "-pid-" + pid;
	}

	//var linkSoftRight="/enterprise/softdownload.action?lang="+$("#sessionLang").text()+"&pid="+pid+"&idAbsPath=fixnode01|"+idAbsPath+"&fastLocation=fastLocation";
	var linkSoftRight = "/enterprise/"+ lang + "/" + category_name + "/" + product_name + "-pid-" + pid +"/software/";

	$("#pro_warning_a").attr("href",productWarnLink);
	$("#news_a").attr("href",fullchangeNewLink);
	$("#pro_lifeCycle_a").attr("href",productLifeCycleBulletinLink);
	$("#pro_pcn_a").attr("href",PCNLink);
	$("#pro_soft_right_a").attr("href",linkSoftRight);
	
	//案例库
	var linkKnowledge = "/enterprise/" + lang +"/knowledge/"+ product_name + "-vid-" + pid;
	//如果不是自定义导航跳旧版
	if (isVocation == "N") {
		linkKnowledge = "/enterprise/" + lang +"/knowledge/"+ product_name + "-pid-" + pid;
	}
	$("#knowledge_a").attr("href",linkKnowledge);
	getLink();
	
	var preProductLink = getPreProductLink(pid);
	var relatedLink = getRelatedLinkSet(pid);
	
	//判断是否隐藏相关链接标题
	if(preProductLink == false && relatedLink == false)
	{
		$("#noRelatedLink").show();
	}
}

function setLinkDisplay(idAbsPath,pageType){
	var isnull="yes";
	$.ajax({type: "POST", url:"/enterprise/Main!linkDisplay", data:{idAbsPath:idAbsPath,type:pageType}, success:function(json){
		if(json.soft == "y"){
			$("#pro_soft_right").show();
			isnull="no";
		}
		if(json.warning == "y"){
			$("#pro_warning").show();
			isnull="no";
		}
		if(json.fullchange == "y"){
			$("#news").show();
			isnull="no";
		}
		if(json.lifeCycle == "y"){
			$("#pro_lifeCycle").show();
			isnull="no";
		}
		if(json.kb == "y"){
			$("#knowledge").show();
			isnull="no";
		}
		if(json.pcn == "y"){
			$("#pro_pcn").show();
			isnull="no";
		}
		if(isnull == "yes"){
			$("#noCurrent").show();
		}
	}, dataType:'json'});
}

//转义
function escapeHTML(str){
	if(str==null){
		return "";
	}
	return str.replace(/</g,"&lt;").replace(/>/g, '&gt;').replace(/ /g,'&nbsp;');
}

//获取产品相关链接设置
function getRelatedLinkSet(pid)
{
	var blankTemp = "";
	var listValue = false;
	$.ajax({
		type:"POST",
		url :"/enterprise/DocInfoAction!getRelatedLinkSetValue.action",
		cache: true,
	 	dataType: "json",
	 	async: false,
	 	data: {nodeId:pid},
	 	success: function(data){
	 		data = eval(data);
	 		if(null !=data)
	 		{
	 			$.each(data,function(index,item){
	 				if (jumpWay(item.url)) {
	 					blankTemp = "";
	 				} else {
	 					blankTemp = "target = '_blank'";
	 				}
	 				var html = "<div class='spte-links-docname' id='relatedLinkBut" +index+"'>";
	 				html += "<a href='"+item.url+"' "+blankTemp+">"+escapeHTML(item.name)+"</a></div>";
	 				$("#productLinkSetId").show();
	 				$("#productLinkSetId").append(html);
	 				listValue =true;
	 			});
	 		}
	 	}
	});
	return listValue;
}


// 获取产品售前文档链接
function getPreProductLink(pid)
{
	var itemValue=false;
    $.ajax({
 	   type: "POST",
 	   url: "/enterprise/DocInfoAction!getPreProductLink.action",
 	   cache: true,
 	   dataType: "json",
 	   async: false,
 	   data: {nodeId:pid},
 	   success: function(data){
 		   //session失效时跳到登陆页面
			try {
				if ("ssoLoginTimeOut"==data.ssoLoginFlag) {
					forLogin();
				}
			} catch (e) {
			}
 			if (null != data)
 			{
 				$.each(data,function(key,item){
 					if("preProductLink"==key){
 						if (item != "" && null != item)
 						{
 							$("#pre_productLink").show();
 							$("#productLinkSetId").show();
 							$("#pre_productLink").attr("href",item);
 							if (!jumpWay(item)) {
 								$("#pre_productLink").attr("target","_blank");
							} 
 							itemValue = true;
 							docPreLink = item;
 						} else {
 							$("#pre_productLink").hide();
 							$("#productLinkSetId").hide();
 						}
 					}
 					if("docHelpLink"==key){
 						if (item != "" && null != item)
 						{
 							docHelpLink = item;
 						}	
 					}
 					if("versionHelpLink"==key){
 						if (item != "" && null != item)
 						{
 							$("#docVersionInfo").after("<span class='spte-filter-desc'><a href='" + item + "' title='"+$('#i18n_version_helpLink').val()+"' target='_blank'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_help'/></a></span>");
 						}	
 					}
 				});
 			}	
 	   }
 	});
    
    return itemValue;
}

//从register中取blog的路径
function getLink(){
    $.ajax({
	   type: "POST",
	   url: "/enterprise/DocInfoAction!getLink.action",
	   cache: true,
	   dataType: "json",
	   data: {requestType:"ajax.json"},
	   success: function(data){
		    //session失效时跳到登陆页面
			try {
				if ("ssoLoginTimeOut"==data.ssoLoginFlag) {
					forLogin();
				}
			} catch (e) {
			}
		    $.each(data,function(key,item){
			    if("forum"==key){
				    $("#pro_techBlog").attr("href",item);
						if (!jumpWay(item)) {
							$("#pro_techBlog").attr("target","_blank");
						} 
			    }
			    if("docMap"==key){
			    	var mapUrl=item.split("news");
			    	var seo_url = $("#pro_docMap_URL").val();
			    	$("#pro_docMap").attr("href",seo_url);
					if (!jumpWay(item)) {
						$("#pro_docMap").attr("target","_blank");
					} 
			    }
		    });
	   }
	});
}

/*-------------loadData-------------end */

/*-------------initListener-------------begin */
//添加页面监听
function initListener() {
	// 面包屑
	$('#breadcrumbs-3').xBreadcrumbs(); 

	// 搜索框提示文字
	$(".spte-main-tab").eq(0).children("li").each(function(index, element) {
		$(this).not(".current").mouseover(function() {
			$(this).css("backgroundColor", "#CC3333");
		}).mouseout(function() {
			$(this).css("backgroundColor", "#bbb");
		});
	});

	/**
	 * 文档类选择点击绑定事件
	 */
	$("a[name='docTypeName']").live("click", function() {
		$("a[name='docTypeName']").removeClass("selected");
		
		$(this).addClass("selected");
		var docTypeName = $(this).attr("value");
		//修改url
		var scenario = $(this).attr("scen_name");
		changUrl(scenario);
		//选择其它文档类型隐藏热门文档
		$(".spte-hot").css("display", "none");
		//选择全部则显示热门文档
		if ('' == docTypeName)
		{
			$(".spte-hot").css("display", "block");
		}
		$("#selectDocType").val(docTypeName);
		/* 清空文档类型 */
		$("#docVersionInfo").html("");
		
		
		
		/* 选择学习材料时不区分版块 */
		if ($(this).attr("value") == 'DOCTYPE10') {
			getLearnMeterInnerDocs();
		} else {
			/* 加载列表内容数据 */
			getSecondInnerDocs();
		}
	});
	
	/* 监听热门文档的鼠标移入移出事件 */
	initHotDocListener();
	/* 监听列表文档的鼠标移入移出事件 */
	initDocListener();
	/* 监听版本的点击事件，快速定位到对应版本 */
	initVersionClick();
	/* 监听面包屑的移入事件，获取同级节点数据 */
	initBrothorNodes();
}
/**
 * 监听版本的点击事件，快速定位到对应版本
 */
function initVersionClick() {
	$("#docVersionInfo").change(function(){
		var versionName = $("#docVersionInfo option:selected").val(); 
		if ($("#" + versionName).val() != undefined) {
			$("html,body").animate({scrollTop: $("#" + versionName).offset().top}, 200);
			/* 不改变选项框中的值 */
			$("#docVersionInfo").val("all");
		}
		
		selectDocVersion(versionName);
	});
}

/**
* 监听热门文档的鼠标移入移出事件
*/
function initHotDocListener() {
	$(".ul-h").live("mouseover", function(){
		$(this).find(".spte-dwn").each(function(index, element) {
			$(this).css("visibility","visible");
		});
	}).live("mouseout", function(){
		$(this).find(".spte-dwn").each(function(index, element) {
			$(this).css("visibility","hidden");
		});
	});
}

/**
* 监听列表文档的鼠标移入移出事件
*/
function initDocListener() {
	
	$(".spte-doc-show-half_zh").live("mouseover", function(){
		$(this).children(".spte-dwn").each(function(index, element) {
			$(this).css("visibility","visible");
		});
	}).live("mouseout", function(){
		$(this).children(".spte-dwn").each(function(index, element) {
			$(this).css("visibility","hidden");
		});
	});
	
	$(".spte-doc-show-half_en").live("mouseover", function(){
		$(this).children(".spte-dwn").each(function(index, element) {
			$(this).css("visibility","visible");
		});
	}).live("mouseout", function(){
		$(this).children(".spte-dwn").each(function(index, element) {
			$(this).css("visibility","hidden");
		});
	});
}

// 鼠标移动到求助时发出的求出,获取下拉内容
function mousFuntion() {
	$("#wechat_subdiv").hide();
	if (!$("#selfservice_sel").html()) {
		$.ajax({
			cache : true,
			url : "/enterprise/channelSupNav!getHelp",
			dataType : "text",
			success : function(result) {
				$("#selfservice_sel").remove();
				$("#helpDivId").after(result);
			}
		});
	}
	$("#selfservice_sel").show();
}

// 鼠标移出求助
function outFuntion() {
	$("#selfservice_sel").hide();
}

// 添加到我的关注
function addMyFavorate() {
	var pbiId = "";
	var ids = $("#vocationIdPath").val();
	var isVocation = $("#isVocation").val();
	//查询pbiid
	if (ids.lastIndexOf("|") == -1) {
		pbiId = ids;
	}else {
		pbiId = ids.substring(ids.lastIndexOf("|") + 1,
				ids.length);
	}
	$.ajax({
		type : "POST",
		url : "/enterprise/favorateNodeNewAction!addMyFavorateNode.action",
		data : {
			pbiId : pbiId,
			isVocation : isVocation
			
		},
		dataType : "json",
		success : function(msg) {
			if ("1" == msg) {
				$("#success").fadeIn("slow");
				setTimeout($("#success").fadeOut("slow"), 5000);
			} else if ("2" == msg) {
				forLogin();
			} else if (data.length > 500 && data.indexOf("Login") > 0) {
				forLogin();
				return false;
			} else {
				$("#fail").fadeIn("slow");
				setTimeout($("#fail").fadeOut("slow"), 5000);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			if ("timeout" == textStatus || "timeout" == errorThrown) {
				alert("等待超时！");
			} else if (errorThrown.message != null
					&& errorThrown.message.indexOf("101")) {
				forLogin();
			} else {
				forLogin();
			}
		}
	});
}
/*-------------initListener-------------end */


function changeTab(node,tab){
	$("#from_source").html(tab);
	var _this = $(node);
	
	var _state = _this.attr("_state");
	var _parent_li = _this.parent();
	var lang = $("#language").val();
	if(!_parent_li.hasClass(".selectTag")){
		_parent_li.siblings("li").removeClass("selectTag");
		_parent_li.addClass("selectTag");
		var active_box = $("#spte_"+_this.attr("class")+"_box");
		active_box.siblings("[id ^= 'spte_'][id $= '_box']").hide();
		
		
		
		if(_state != "true"){
			switch(_this.attr("class")){
				case 'case':
					$("#from_source").html("case");
					_this.attr("_state","true");
					$.post("/enterprise/cbb/openSourceModified/pages/paging/js/jquery.pagination_modified.js", 'script');
					if (lang == 'zh') {
						$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_zh.js", 'script');
					} else {
						$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_en.js", 'script');
					}
					$.post("/enterprise/pages/doc/js/product_case.js", function(){
						getCaseCount();
					}, 'script'); 
					break;
					/*---------视频--------*/
				case 'video':
					$("#from_source").html("doc");
					_this.attr("_state","true");
					$.post("/enterprise/cbb/openSourceModified/pages/paging/js/jquery.pagination_modified.js", 'script');
					if (lang == 'zh') {
						$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_zh.js", 'script');
					} else {
						$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_en.js", 'script');
					}
					$.post("/enterprise/pages/doc/js/product_video.js", 'script');
					break;
				case 'software':
					$("#from_source").html("software");
					_this.attr("_state","true");
					$.post("/enterprise/pages/doc/js/product_software.js", function(){
						initSoftVr();
					}, 'script'); 
					break;
				case 'bulletin':
					$("#from_source").html("news");
					_this.attr("_state","true");
					$.post("/enterprise/cbb/openSourceModified/pages/paging/js/jquery.pagination_modified.js", 'script');
					if (lang == 'zh') {
						$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_zh.js", 'script');
					} else {
						$.post("/enterprise/cbb/openSourceModified/res/sui_cbb_en.js", 'script');
					}
					$.post("/enterprise/pages/doc/js/product_bulletin.js", function(){
						getNewsCount();
					}, 'script'); 
					break;
				case 'tool':
					$("#from_source").html("doc");
					_this.attr("_state","true");
					$.post("/enterprise/pages/doc/js/product_tool.js", function(){
						getToolCount();
					}, 'script'); 
					break;	
				case 'community':
					$("#from_source").html("doc");
					_this.attr("_state","true");
					$.post("/enterprise/pages/doc/js/product_community.js", function(){
						getCommunityCount();
					}, 'script'); 
					break;
				case 'doc':
					$("#from_source").html("doc");
					_this.attr("_state","true");
					obtainDocData();
			}
		}
		active_box.show();
		if(typeof (history.replaceState) != "undefined"){
			changeUrl(_this.attr("class"));
		}
	}
	clickOfferingTab(tab);
	//IE 8 9return false 失效情况下
	if(typeof (history.replaceState) == "undefined"){
		window.event.returnValue = false;
	}
	
	//其它资源重新加载一次和页尾重新加载一次
	setTimeout("loadOtherInfo()",1000);
	
	
}

function loadOtherInfo(){
	/* 初始化加载时校验相关文档是否在可视化区域内，若是则加载，反之不加载 */
	$(".spte-links").each(function(){
		
		
		
		if ($(window).height() + $(window).scrollTop() > $(this).offset().top)
		{
			if(!$(".spte-links").hasClass("showOfferLink")){
				
				$(".spte-links").addClass("showOfferLink");
				
				linkhref();
				
			}
		}
	});
	
	/* 初始化加载时校验页尾是否在可视化区域内，若是则加载，反之不加载 */
	$("#footerDIV").each(function(){
		
		
		
		var $footerDiv = $("#footerDIV").html();
		if ($(window).height() + $(window).scrollTop() -2 > $(this).offset().top)
		{
			// 获取页尾内容，若为Null则加载，反之不加载，避免重复调用
			if (null == $footerDiv || '' == $footerDiv) {
				loadFooterIndex();
			}
		}
	});
}

/**
 * 根据点击的tab标签改变url
 * 
 * */
function changeUrl(tab){
	var category_name = $("#category_name").val();
	var product_name = $("#product_name").val();
	var pid = $("#pid_url").val();
	var lang = $("#language").val();
	var url_pre ="/enterprise/" + lang + '/' + category_name + '/' + product_name + '-pid-' + pid + '/' ;
	
	switch(tab){
		case 'case':
			if(typeof (history.replaceState) != "undefined"){
				var scen = $("#caseDiv").find(".selected").attr("scen_name");
				if(scen){
					history.replaceState('','',url_pre+'knowledge-base/?scenario='+scen);
				}else{
					history.replaceState('','',url_pre+'knowledge-base/');
				}
			}
			break;
		case 'video':
			if(typeof (history.replaceState) != "undefined"){
				var scen = $(".videoDiv").find(".selected").attr("scen_name_v");
				var date = $(".videoDiv").find(".year_c.selected").attr("val");
				var url_last = "";
				if(scen && !date){
					url_last = "?scenario=" + scen;
				}else if(!scen && date){
					url_last = "?date=" + date;
				}else if(scen && date){
					url_last = "?scenario=" + scen +"&date=" + date;
				}
				history.replaceState('','',url_pre+"multimedia/"+url_last);
				
			}
			break;
		case 'software':
			if(typeof (history.replaceState) != "undefined"){
				history.replaceState('','',url_pre+'software/');
			}
			break;
		case 'bulletin':
			if(typeof (history.replaceState) != "undefined"){
				var scen = $("#newsDiv").find(".selected").attr("scen_name");
				if(scen){
					history.replaceState('','',url_pre+'bulletins/?type='+scen);
				}else{
					history.replaceState('','',url_pre+'bulletins/');
				}
			}
			break;
		case 'tool':
			if(typeof (history.replaceState) != "undefined"){
				history.replaceState('','',url_pre+'tool/');
			}
			break;
		case 'community':
			if(typeof (history.replaceState) != "undefined"){
				history.replaceState('','',url_pre+'community/');
			}
			break;
		case 'doc':
			if(typeof (history.replaceState) != "undefined"){
				var scen = $("#docDiv").find(".selected").attr("scen_name");
				if(scen){
					history.replaceState('','',url_pre+'?type='+scen);
				}else{
					history.replaceState('','',url_pre);
				}
			}
			
	}
}

/**
 * 获取选定的筛选项
 * 
 * */
function obtainScen(tab){
	
}


//tab页签打点
function clickOfferingTab(tab){
	var o = new Object();
	o.category = "新offering聚合tab页签";
	var action = "";
	if("doc" == tab){
		action = "文档";
	}else if("case" == tab){
		action = "案例";
	}else if("video" == tab){
		action = "视频";
	}else if("software" == tab){
		action = "软件";
	}else if("news" == tab){
		action = "产品公告";
	}else if("tool" == tab){
		action = "工具";
	}else if("community" == tab){
		action = "社区论坛";
	}
	o.action = action;
	var nameAbsPath =$("#nameAbsPath").val();
	var label = nameAbsPath.substring(nameAbsPath.lastIndexOf('|')+1);
	var path = $("#idAbsPath").val();
	var data = path.substring(path.lastIndexOf('|')+1);
	//记录当前节点名称
	o.label = label;
	//记录当前节点ID
	o.c_data = data;
	_haq.push(['_trackEvt', o]);
}
function clickOfferingPage(_this){
	var o = new Object();
  	o.category = $(_this).attr("ha_category");
  	o.action = $(_this).attr("ha_action");
  	o.label = $(_this).attr("ha_label");
  	_haq.push(['_trackEvt', o]);
}
//  热点推荐/新手入门打点
function clickHotOrRaw(type){
	//不记录a标签click
	_haq.push(['_defAutoTrackClick', false]);
	var o = new Object();
	o.category = "新offering聚合推荐/入门页签";
	var action = "热点推荐";
	if("raw" == type){
		action = "新手入门";
	}
	o.action = action;
	var nameAbsPath =$("#nameAbsPath").val();
	var label = nameAbsPath.substring(nameAbsPath.lastIndexOf('|')+1);
	var path = $("#idAbsPath").val();
	var data = path.substring(path.lastIndexOf('|')+1);
	//记录当前节点名称
	o.label = label;
	//记录当前节点ID
	o.c_data = data;
	_haq.push(['_trackEvt', o]);
}


// 文档类型打点
function clickDocType(type){
	//不记录click
	_haq.push(['_defAutoTrackClick', false]);
	var o = new Object();
	o.category = "新offering聚合文档类型";
	o.action = type;
	var nameAbsPath =$("#nameAbsPath").val();
	var label = nameAbsPath.substring(nameAbsPath.lastIndexOf('|')+1);
	var path = $("#idAbsPath").val();
	var data = path.substring(path.lastIndexOf('|')+1);
	//记录当前节点名称
	o.label = label;
	//记录当前节点ID
	o.c_data = data;
	_haq.push(['_trackEvt', o]);
}


// 产品版本打点
function selectDocVersion(versionName){
	var o = new Object();
	o.category = "新offering聚合产品版本";
	var action = "产品VR版本";
	if("General" == versionName){
		action = "各版本通用的文档";
	}else if("Technical" == versionName){
		action = "技术指导";
	}else if("LearnMeter" == versionName){
		action = "学习材料";
	}else if("EOS" == versionName){
		action = "EOS文档";
	}
	o.action = action;
	var nameAbsPath =$("#nameAbsPath").val();
	var label = nameAbsPath.substring(nameAbsPath.lastIndexOf('|')+1);
	var path = $("#idAbsPath").val();
	var data = path.substring(path.lastIndexOf('|')+1);
	//记录当前节点名称
	o.label = label;
	//记录当前节点ID
	o.c_data = data;
	_haq.push(['_trackEvt', o]);
}

/*-------------initUI-------------begin */

// 初始化页面UI
function initUI() {
	/* 加载面包屑 、微信、求助等信息*/
	//initCurrentPath();
	initOfferRelationInfo();
	/* 加载搜索框 */
	initSearchSubPage();
	
	//DTS2016061703491 火狐在刷新页面时不会重载 itemNewsType 的value
	$("#itemNewsType").attr("value","03");
}

//初始化面包屑、微信、智能问答、推荐、我的空间相关信息
function initOfferRelationInfo(){
	
	idAbsPath = $("#idAbsPath").val();
	var nameAbsPath = $("#nameAbsPath").val();
	
	$.ajax({
		type : "post",
		url : "/enterprise/productNewOffering!loadOfferInfo.action",
		dataType : "json",
		data :{"idAbsPath":idAbsPath,"nameAbsPath":nameAbsPath},
		cache : true,
		async:true,
		success : function(data){
			
			//初始化路径
			initCurrentPath(data);
			
			if(null == data)
			{
				return;
			}
			//初始化求助
			/*var htmlquestionlinks = data.htmlquestionlinks;
			$("#selfservice_con").html(htmlquestionlinks);*/
			
			//初始化微信
			/*var wechatAttention = data.wechatAttention;
			$("#wechatAttentions").html(wechatAttention);*/
			//初始化软件版本提示窗
			var softwareVersionRecommend = data.softwareVersionRecommend;
			$("#software_recommend_msg_box").html(softwareVersionRecommend);
			
			//初始化我的空间链接URL
			var mySpaceAndRedirectUrl = data.mySpaceAndRedirectUrl;
			$("#mySpaceAndRedirectUrlID").attr("href",mySpaceAndRedirectUrl);
			
			docPreLink = data.preProductLink;
			docHelpLink = data.docHelpLink;
			
			// 若有售前文档则加载
			if (docPreLink != ""&& null != docPreLink) {
				$("#docTypeInfo").append("<li><a href='"+ docPreLink +"' target='_blank' >" + $('#i18n_doc_preLink').val() + "<img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_zc'/></a></li>");
			}
			// 若有如何选择产品文档链接则加载
			if (docHelpLink != ""&& null != docHelpLink) {
				$("#docTypeInfo").find("li:last").append("<span class='spte-filter-desc' style='padding-left:18px;display:inline'><a href='" + docHelpLink + "' title='"+$('#i18n_doc_helpLink').val()+"' target='_blank'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_help'/></a></span>");
			}
			
			
		}
	});
	
}
// 加载面包屑
function initCurrentPath(data) {
	// 给语种赋值
	lang = $("#language").val();
	idAbsPath = $("#idAbsPath").val();
	var nameAbsPath = $("#nameAbsPath").val();
	var vocationIdPath =  $("#vocationIdPath_t").val();
	var vocationNamePath = $("#vocationNamePath_t").val();
	var isOffering = "";
	
	if(null != data){
		isOffering = data.isOffering;
	}
	
	var nameAbsPaths = (nameAbsPath != undefined ? nameAbsPath.split("|") : []);
	var idAbsPaths = (idAbsPath != undefined ? idAbsPath.split("|") : []);
	var vocationIdPaths = (vocationIdPath != undefined ? vocationIdPath.split("|") : []);
	var vocationNamePaths = (vocationNamePath != undefined ? vocationNamePath.split("|") : []);
	

	
	var idAbsPathsLen = idAbsPaths.length;
	var vocationIdPathsLen = vocationIdPaths.length;
    var innerLi = "";
    var from=$('#from').val();
    var pre_url = "/enterprise/"+$("#language").val()+"/"+ $("#category_name").val() + "/" + $("#product_name").val() + "-pid-" + $("#pid_url").val() + "/";
    if (idAbsPath == vocationIdPath || vocationIdPath == "") {
    	$("#isVocation").val("N");
    	$("#vocationIdPath").val(vocationIdPath);
    	for(var i=0; i<idAbsPathsLen; i++) {
    		var idPathParam = "";
    		var parentId = "";
    		var parentPath = "";
    		for(var cur=0; cur<i; cur++){
    			idPathParam = idPathParam + idAbsPaths[cur] + "|";
    		}
    		if (idPathParam != '') {
    			parentPath = idPathParam.substring(0, idPathParam.length - 1);
    		}
    		idPathParam = idPathParam + idAbsPaths[i];
    		
    		if (i > 0) {
    			parentId = idAbsPaths[i-1];
    		}
    		if(from && from == 'soft'){
    			if (i == idAbsPathsLen - 1) {
    				//innerLi = innerLi + '<li class="current currentPath" curPbiId="'+idAbsPaths[i]+'" curParentId="'+parentId+'" path="'+parentPath+'"><a href="/enterprise/softdownload.action'
    				//+ '?lang=' + lang + '&idAbsPath=fixnode01|' + idPathParam + '&pid='+ idAbsPaths[i] + '">' + nameAbsPaths[i] + '</a>'
    				//+ '<img src="/enterprise/pages/main/images/transparent.gif" class="icon-img icon_arrow_d" /></li>';
    			} else if(i == idAbsPathsLen - 2) {
    				innerLi = innerLi + '<li curPbiId="'+idAbsPaths[i]+'" curParentId="'+parentId+'" path="'+parentPath+'"><a href="/enterprise/softdownload.action'
    				+ '?lang=' + lang + '&idAbsPath=fixnode01|' + idPathParam + '&pid='+ idAbsPaths[i] + '">' + nameAbsPaths[i] + '</a><img src="/enterprise/pages/main/images/transparent.gif" class="icon-img icon_arrow" style="margin-left:5px"/></li>';
    			}else{
    				innerLi = innerLi + '<li curPbiId="'+idAbsPaths[i]+'" curParentId="'+parentId+'" path="'+parentPath+'"><a href="/enterprise/softdownload.action'
    				+ '?lang=' + lang + '&idAbsPath=fixnode01|' + idPathParam + '&pid='+ idAbsPaths[i] + '">' + nameAbsPaths[i] + '</a>'
    				+ '<img src="/enterprise/pages/main/images/transparent.gif" class="icon-img icon_arrow" style="margin-left:5px"/></li>';

    			}
    		}else{
    			if (i == idAbsPathsLen - 1) {
    				//innerLi = innerLi + '<li class="current currentPath" curPbiId="'+idAbsPaths[i]+'" curParentId="'+parentId+'" path="'+parentPath+'"><a href="/enterprise/productsupport'
    				//+ '?lang=' + lang + '&idAbsPath=' + idPathParam + '&pid='+ idAbsPaths[i] + '">' + nameAbsPaths[i] + '</a>'
    				//+ '<img src="/enterprise/pages/main/images/transparent.gif" class="icon-img icon_arrow_d" /></li>';
    			} else if(i == idAbsPathsLen - 2){
    				innerLi = innerLi + '<li curPbiId="'+idAbsPaths[i]+'" curParentId="'+parentId+'" path="'+parentPath+'"><a href="/enterprise/productsupport'
    				+ '?lang=' + lang + '&idAbsPath=' + idPathParam + '&pid='+ idAbsPaths[i] + '">' + nameAbsPaths[i] + '</a>'
    				+ '<img src="/enterprise/pages/main/images/transparent.gif" class="icon-img icon_arrow" style="margin-left:5px"/></li>';
    			}else{
    				innerLi = innerLi + '<li curPbiId="'+idAbsPaths[i]+'" curParentId="'+parentId+'" path="'+parentPath+'"><a href="/enterprise/productsupport'
    				+ '?lang=' + lang + '&idAbsPath=' + idPathParam + '&pid='+ idAbsPaths[i] + '">' + nameAbsPaths[i] + '</a>'
    				+ '<img src="/enterprise/pages/main/images/transparent.gif" class="icon-img icon_arrow" style="margin-left:5px"/></li>';
    			}
    		}
    	}
    	innerLi = innerLi + '<li curPbiId="'+idAbsPaths[i-1]+'" curParentId="'+parentId+'" path="'+parentPath+'"><a href="'+pre_url+'">' + nameAbsPaths[i-1] + '</a>'
		+ '</li>';
    } else {
    	$("#isVocation").val("Y");
    	$("#vocationIdPath").val(vocationIdPath);
    	for(var i=0; i<vocationIdPathsLen; i++) {
			if (i < vocationIdPathsLen - 1) {
		    	innerLi = innerLi + '<li style="font-size:16px;"><span><a onclick="productSort($(this));return false;" selfPbiId="'+vocationIdPaths[0]+'"pbiId="'+vocationIdPaths[i] +'"productFamilyName="'+vocationNamePaths[0]+'">' + vocationNamePaths[i] + '</a></span><img src="/enterprise/pages/main/images/transparent.gif" class="icon-img icon_arrow" style="margin-left:5px"/></li>';			
			}
    	}
    	innerLi = innerLi + '<li style="font-size:16px;"><a href="'+pre_url+'">'+vocationNamePaths[i-1]+'</a></li>';
    }
	if(navigator.userAgent.indexOf("MSIE") !=-1 || (Object.hasOwnProperty.call(window, "ActiveXObject") && !window.ActiveXObject ) ) { 
		innerLi = innerLi + "<li class='current'><span title='"+$("#copypathI8n").val()+"' id='copyPaths' style='cursor: pointer;'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_copy' /></span></li>";
	} else {
		innerLi = innerLi + "<li class='current'><div id='d_clip_button' title='"+$("#copypathI8n").val()+"'><img src='/enterprise/pages/main/images/transparent.gif' class='icon-img icon_copy' /></div></li>";
	 }
	
	// 将产品关注设置图标放在导航栏后面，而设置产品关注的代码在jsp中，并不是动态拼接的
	$("#breadcrumbs-3 li").eq(1).after(innerLi);
	//绑定复制事件
	copyWord();

	
}

function initMySupportMenu(){
	$("#menu1").click(function(){
		
		$("#myFeedback").removeClass("open");
		
		$("#feedbackShow").css("display", "none");
		
		if ($("#mysupportDiv").hasClass("open")) {
			$("#mysupportDiv").removeClass("open");
			return false;
		} else {
			$("#mysupportDiv").addClass("open");
			return false;
		} 	
	});
	
	$("#menu2").click(function(){
		 
		$("#mysupportDiv").removeClass("open");
		
		if ($("#myFeedback").hasClass("open")) {
			$("#myFeedback").removeClass("open");
			$("#feedbackShow").css("display", "none");
			return false;
		} else {
			$("#myFeedback").addClass("open");
			$("#feedbackShow").css("display", "block");
			return false;
		
		} 	
	});
	
	$(document).click(function(e){ 
		if ($("#mysupportDiv").hasClass("open")) {
			$("#mysupportDiv").removeClass("open");
		}
		
		if ($("#myFeedback").hasClass("open")) {
			$("#myFeedback").removeClass("open");
			$("#feedbackShow").css("display", "none");
		}
	});
	
	//判断是否登陆
	var i18n_isLogin = $("#i18n_isLogin").val();
	
	if("false" == i18n_isLogin)
	{
		//新版默认折叠mysupport
		$("#menu1").bind("click",function(){
			if($(this).parent().hasClass("open")){
				$("#noLoginOpen").show();
			}else{
				$("#noLoginOpen").hide();
			}
		});
		
		return;
		
	}
	
	var curUrl = window.location.href;
	$.ajax({
		type : "POST",
		url : "/enterprise/Main!getUserProfilesNew.action",
		dataType : "json",
		data :{curUrl:curUrl},
		cache : true,
		async:false,
		success : function(data){
			//登陆后my support 展示状态
			if (data.USER_INFO != null) {
				isLogin = true;
				//新版默认折叠mysupport
				$("#menu1").bind("click",function(){
					if($(this).parent().hasClass("open")){
						$("#LoginOpen").show();
					}else{
						$("#LoginOpen").hide();
					}
				});
				//设置登录后的个人信息
				$("#ms_applicantsCount").text(data.ms_applicantsCount);
				$("#ms_waitApprovedCount").text(data.ms_waitApprovedCount);
				$("#presentRole").empty();
				//是否显示我的订阅更新标识
				if (data.isShow == true) {
					$("#mySubscribe").show();
				}
				
				//当前角色权限的等级
				popedomLevel(data.popedomLevel);
				//华为工程师可见
				if (data.hwRole == 1) {
					$("#eWar").show();
					$("#productranking").show();
				}
				//显示应用实践和我的待办
				if (data.isHWE == 1) {
					$("#createFAQ_li").css("display", "block");
					$("#myToDo").css("display", "block");
				}
				
			}
			
		}
	});
}

function popedomLevel(popedomLevel) {
	if (popedomLevel == 'LV1') {
		$("#presentRole").append("<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-star spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-greystar spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-greystar spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-greystar spte-valign-m' />"
              );
	}
	if (popedomLevel == 'LV2') {
		$("#presentRole").append("<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-star spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-star spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-greystar spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-greystar spte-valign-m' />"
              );
	}
	if (popedomLevel == 'LV3') {
		$("#presentRole").append("<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-star spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-star spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-star spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-greystar spte-valign-m' />"
              );
	}
	if (popedomLevel == 'LV4') {
		$("#presentRole").append("<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-star spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-star spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-star spte-valign-m' />"
              + "<img src='/enterprise/pages/main/images/transparent.gif' class='spte-icons spte-icn-star spte-valign-m' />"
              );
	}
	
}
//复制功能代码
function copyWord() {
	var copyWordStr = "";
	var $naviBreadcrumbs = $("#navi_IdPath >ul >li");
	$naviBreadcrumbs.each(function(index) {
		var tempStr = $(this).find(">a").text();
		var textStr = $(this).find(">span").text();
		if (tempStr == "" && textStr == "" || $(this).find(">a").attr("id") == "d_clip_button") {
			copyWordStr += tempStr;
			copyWordStr += textStr;
		} else {
			if(tempStr != ""){
				copyWordStr += tempStr + " > ";
			}else if(textStr != ""){
				copyWordStr += textStr + " > ";
			}
		}
	});
	var tempindex = copyWordStr.lastIndexOf(">");
	copyWordStr = copyWordStr.substring(0, tempindex);
	// 如果是IE不使用false复制插件,ie11不含userAgent，增加Ie11的判断
	if (navigator.userAgent.indexOf("MSIE") != -1 || (Object.hasOwnProperty.call(window, "ActiveXObject") && !window.ActiveXObject ) ) {
		$("#copyPaths").click(function() {
			if (window.clipboardData.setData("Text", copyWordStr)) {
				confirmMsg();
			}
		});
	} else {
		//只有之前没有加载相关js时才加载
		if (!window.ZeroClipboard) {
			$.ajax({
				type: "POST",
				url: "/enterprise/cbb/ZeroClipboard/js/ZeroClipboard.js",
				async: false,
				success: function(){
					// 设置ZeroClipboard.swf 路径
					ZeroClipboard.config({
						swfPath : '/enterprise/cbb/ZeroClipboard/swf/ZeroClipboard.swf'
					});
				},
				dataType: "script"
			});
		}
		
		if (window.ZeroClipboard) {
			var client = new ZeroClipboard().clip($("#d_clip_button"));
			
			// 复制内容
			client.on("copy", function(event) {
				event.clipboardData.setData('text/plain', copyWordStr);
			});
			// 绑定完成后触发事件
			client.on("aftercopy", function(e) {
				confirmMsg();
			});
		}
	}
}

// 复制路径成功之后弹出的提示语
function confirmMsg(){
	var CopySuccessI8n =$("#CopySuccessI8n").val();
	var Common_Warn =$("#Common_Warn").val();
	var confirmbtn = $("#confirmbtn").val();
	var Common_cancel = $("#Common_cancel").val();
	$("#showMsgTip").attr("title", Common_Warn);
	$("#showMsgTip").text(CopySuccessI8n);
	$("#dialog:ui-dialog").dialog("destroy");
	$("#showMsgTip").dialog({
		minHeight:150,
		minWidth:100,
		modal : true,
		resizable : false,
		buttons : [ {
			//确定
			text : confirmbtn,
			id : "OKButton",
			click : function() {
				$(this).dialog("close");
			}
		}
		]
	});
}

// 监听面包屑的鼠标事件
function initBrothorNodes() {
	$(".currentPath").live("mouseenter", function() {
		if ($(this).children("ul").length == 0 && $(this).prev().length != 0) {
			var $li = $(this);
			var curPbiId = $(this).attr("curPbiId");
			var curParentId = $(this).attr("curParentId");
			var currentPath = $(this).attr("path");
			var from = $('#from').val();
			lang = $("#language").val();
			$.ajax({
				type: "POST",
				url:"/enterprise/DocNewOfferingAction!getBrothorNode.action",
				data : {
					idAbsPath:currentPath,
					curPbiId:curPbiId,
					curParentId:curParentId,
					from:from,
					requestType:"ajax.json"
				},
				dataType: "json",
				success:function(data) {
				try {
					if("ssoLoginTimeOut" == data.ssoLoginFlag){
						forLogin();
					}
				} catch (e) {
				}
				if (null != data && data.length > 0) {
					var ulInner = "<ul>";
					$.each(data, function(key1, item1) {
						var liInner = '';
						if (from && from == 'soft'){
							liInner = '<li><a href="/enterprise/softdownload.action?lang=' + lang + '&idAbsPath=fixnode01|' + item1.idAbsPath + '&pid='+ item1.pid + '">'+ item1.name + '</a></li>';
						}else{
							liInner = '<li><a href="/enterprise/productsupport?lang=' + lang + '&idAbsPath=' + item1.idAbsPath + '&pid='+ item1.pid + '">'+ item1.name + '</a></li>';
						}
						ulInner += liInner;
					});
					ulInner = ulInner + "</ul>";
					$li.append(ulInner);
					// 显示同级节点
					showHideNodes($li);
				}
			}});
		} else {
			// 显示同级节点
			showHideNodes($(this));			
		}
	});
	
	/** 修改点 **/
	$(".currentPath").live("mouseleave", function() {
        var subLevel = $(this).children('UL');
        _showHideLevel(subLevel, false);
    });
}

// 显示同级节点
function showHideNodes($li) {
    if($li.hasClass('hover')){ return; }
    
    _hideAllLevel();
	if(!_levelExists($li)){ return; }

	// Show sub-level
	var subLevel = $li.children('UL');
	_showHideLevel(subLevel, true);
}

function _hideAllLevel(){
	$('#breadcrumbs-3').children('LI').children('UL').each(function(){
        $(this).hide();
        $(this).parent().removeClass('hover');
	});
};

function _showHideLevel(subLevel, isShow){
	if(isShow){
        subLevel.parent().addClass('hover');
        if($.browser.msie){
        	var pos = subLevel.parent().position();
        	subLevel.css('left', parseInt(pos['left']));
//        	subLevel.css('top', 25 + 'px');
        }
		subLevel.fadeIn( 'fast' );
		setUlHeight();
		$("#myFavorateDiv").attr("style",'z-index:-1;');
	} else {
        subLevel.parent().removeClass('hover');
        subLevel.hide();
        $("#myFavorateDiv").attr("style",'z-index:0;');
	}
};

function _levelExists(obj){
	return obj.children('UL').length > 0;
};

// 加载搜索框
function initSearchSubPage() {
	var textName = $("#nameAbsPath").val();
	var put=$(".kl_qs_input");
	var pointName= $("#i18n_search_range_new").val();
	if($.trim(textName).length > 0){
		/*var nameArray=textName.split("|");
		pointName+=nameArray[nameArray.length-1];*/
		put.val(pointName);
		put.attr("verify",pointName);
	}
	$("#kl_input").focus(function(){
		searchClear();
	});
	$("#kl_input").blur(function(){
		searchShow();
	});
	$("#kl_input").keydown(function(){
		keydown();
	});
	$("#cearchForm").submit(function(){
		return searchSubmit();
	});
}

// 提交
function searchSubmit(){
	var key=$(".kl_qs_input").val();
	var idAbsPath = $("#idAbsPath").val();
	var vocationIdPath = $("#vocationIdPath").val();
	
	// 根据聚合页面当前选中的类型，指定对应搜索类型，若没有搜索对应的类型，统一指向技术支持页签
	var searchType="searchAll";
	if(!searchValidate(key)){
		$(".kl_qs_input").focus();
		return false;
	}
	var url="/enterprisesearch/ebgSearch?newPbi=0#sp.type="+searchType+"&sp.lang="+lang+"&sp.keyword="+encodeURIComponent(key)+"&productPath="+idAbsPath.substr(idAbsPath.indexOf("_")+1, idAbsPath.length);
	//如果为业务导航则跳到业务导航的搜索
	if (vocationIdPath && idAbsPath != vocationIdPath)
    {
		
    	window.location.href = "/enterprisesearch/ebgSearch?newPbi=3#sp.type="+searchType+"&sp.lang="+lang+"&sp.keyword="+encodeURIComponent(key)+"&productPath="+vocationIdPath;
    	return false;
    }
	
	$("#cearchForm").attr("action",url);
	return true;
}

//输入信息验证
function searchValidate(key){
	var put=$(".kl_qs_input");
	//除了数字，字母，汉字，下划线以外，其它都为特殊字符
	var sa=/^[`~!@#\$%\^&\*\(\)\+=\|\{\}'\:;",\\\[\]\.\<\>\/\?~！@#￥%……&\*（）——+|{}【】‘；：”“’。，、？]*$/;
	key= $.trim(key);
	if(put.val()==put.attr("verify")||key.length==0){
		messShow($("#i18n_search_inputkey").val());
		return false;
	}else if(key.length<2){
		messShow($("#i18n_search_inputMinkey").val());
		return false;
	}else if(key.length>200){
		messShow($("#i18n_search_inputMaxkey").val());
		return false;
	}else if(sa.test(key)){
		messShow($("#i18n_search_illegalKey").val());
		return false;
	}
	return true;
}

//输入框获取焦点
function searchClear(){
	var put=$("#kl_input");
	if(put.val()==put.attr("verify")){
		put.val("");
		put.css("color","#000");
	}
	initAutoThink(put);
}

//创建快速定位节点功能
function initAutoThink($obj) {
	var ulLiInput = $obj;
	 if(!ulLiInput)
		  return;
	if (ulLiInput.length > 0) {
		// 初始化快速联想
		ulLiInput.autocomplete({
			autoFocus : true,
			source : function(request, response) {
				var keyword = $.trim(ulLiInput.val());
				//关键字个数大于等于2个的时候才自动联想
				if(keyword.length >= 2){
					$.ajax({
						url : "/enterprise/search/autoComplete.action",
						dataType : "json",
						async : false,
						cache : false,
						data : {
							'sp.keyword' : keyword
						},
						success : function(data) {
							// session失效时跳到登陆页面
							try {
								if("ssoLoginTimeOut" == data.ssoLoginFlag){
									forLoginEscapeParam();
								}
							} catch (e) {
							}
							
							response($.map(data.autoCompleteList, function(item) {
								return item;
							}));
						}
					});
				}
			}
		}).data("ui-autocomplete")._renderItem = function(ul, item) {
			return $("<li style='text-align:left;'></li>")
					.data("item.autocomplete", item)
					.append($("<a style='text-align:left;text-decoration: none;' title='"+item.value+"'></a>")
					.html(highlightKeyword(item.value, $.trim(ulLiInput.val()))))
					.appendTo(ul);
		};
	}
}

/**
 * 用于将联想框中结果与关键字相匹配的进行加粗处理
 * @param resultName
 * @param keyword
 */
function highlightKeyword(resultName, keyword) {
	return resultName.replace(new RegExp("(?![^&;]+;)(?!<[^<>]*)("
			+ keyword.replace(/([\^\$\(\)\[\]\{\}\*\.\+\?\|\\])/gi, "\\$1")
			+ ")(?![^<>]*>)(?![^&;]+;)", "gi"), "<strong>$1</strong>");
}

// 输入框失去焦点
function searchShow() {
	var put=$("#kl_input");
	if(put.val().length <= 0){
		put.val(put.attr("verify"));
		put.css("color","#8e8e8e");
	}
	$("#messge").fadeOut("show");
}
function messShow(mess) {
	var messDiv=$("#messge");
	$("#messge span").html(mess);
	messDiv.fadeIn("show");
}
function keydown() {
	$("#messge").fadeOut("show");
}

/* 展开产品聚合页面的型号 */
function showModels(){
	if ($("#modelsList").css("display")=="none") {
		$("#modelsList").css("display", "block");
		} else {
			$("#modelsList").css("display", "none");
		}
}

/* 关闭产品聚合页面的型号 */
function closeModels(){
	$("#modelsList").css("display", "none");
}

function productZoomLeftRright() {
    // 产品详情如果只有一张，不要切换效果
    if ($("#thumblist li").length > 1) {
        $(".product_pic_thumb_list_inner").show();
        $(".product-overview .pull-right h5").removeClass("bottom");

        var pr_amount = Math.round($(".col-xs-8").width() * 0.75 / $("#thumblist a:first").parent().outerWidth(true));
        if (pr_amount > 5) { pr_amount = 5 }
        $(".product_pic_thumb_list_inner").width(($("#thumblist a:first").parent().outerWidth(true) * pr_amount) + 44);
        $(".thumblist").width($("#thumblist a:first").parent().outerWidth(true) * pr_amount);
        $(".prev-photo").find("a").addClass("disabled");
        if ($("#thumblist a").length <= pr_amount) {
            $(".product_pic_thumb_list .next-photo, .product_pic_thumb_list .prev-photo").hide().find("a").addClass("disabled");
        }
        var currentMoveIndex = 0;
        $(document).on("vchange", "#thumblist a", function (e) {
            var $this = $(this);
            var i = $this.parent().index();
            var $margin_div = $(this).parents("#thumblist");
            var offset_left = -pr_amount * ((currentMoveIndex) * parseInt($(this).parent().outerWidth(true)));
            $margin_div.stop().animate({
                "margin-left": offset_left
            }, 500);
            if (currentMoveIndex <= 0) {
                $(".product_pic_thumb_list .prev-photo a").addClass("disabled");
                $(".product_pic_thumb_list .next-photo a").removeClass("disabled");
            } else {
                $(".product_pic_thumb_list .prev-photo a").removeClass("disabled");
            }
            if (currentMoveIndex >= Math.ceil($("#thumblist a").length / pr_amount) - 1) {
                $(".product_pic_thumb_list .next-photo a").addClass("disabled");
                $(".product_pic_thumb_list .prev-photo a").removeClass("disabled");
            } else {
                $(".product_pic_thumb_list .next-photo a").removeClass("disabled");
            }
        }).on("click", ".product_pic_thumb_list .next-photo a", function (e) {
            e.preventDefault();
            if (currentMoveIndex >= Math.ceil($("#thumblist a").length / pr_amount) - 1) {
                return false;
            } ++currentMoveIndex;
            $("#thumblist a").eq(currentMoveIndex).trigger("vchange");
            return false;
        }).on("click", ".product_pic_thumb_list .prev-photo a", function (e) {
            e.preventDefault();
            if (currentMoveIndex <= 0) {
                return false;
            } --currentMoveIndex;
            $("#thumblist a").eq(currentMoveIndex).trigger("vchange");
            return false;
        });
    } else { 
    	//产品详情如果只有一张，不要切换效果
        $(".product_pic_thumb_list_inner").hide();
        $(".product-overview .pull-right h5").addClass("bottom");
    }
}
/*-------------initUI-------------end */

/*-------------jquery.xbreadcrumbs-------------begin */

(function($){
/*  Variables  */
$.fn.xBreadcrumbs = function(settings){
	var element = $(this);
	var 
	
	settings = $.extend({}, $.fn.xBreadcrumbs.defaults, settings);

	function _build(){
		if(settings.collapsible){
			var sz = element.children('LI').length;
			element.children('LI').children('A').css('white-space', 'nowrap').css('float', 'left');
			element.children('LI').children('A').each(function(i, el){
				if(i != sz - 1){
					$(this).css('overflow', 'hidden');
					$(this).attr('init-width', $(this).width());
					$(this).width(settings.collapsedWidth);
				}
			});
		}
	};
	
	function _hideAllSubLevels(){
		element.children('LI').children('UL').each(function(){
            $(this).hide();
            $(this).parent().removeClass('hover');
		});
	};
	
	function _showHideSubLevel(subLevel, isShow){
		if(isShow){
            subLevel.parent().addClass('hover');
            if($.browser.msie){
            	var pos = subLevel.parent().position();
            	subLevel.css('left', parseInt(pos['left']));
            }
			if(settings.showSpeed != ''){ subLevel.fadeIn( settings.showSpeed ); } 
			else { subLevel.show(); }
		} else {
            subLevel.parent().removeClass('hover');
            if(settings.hideSpeed != ''){ subLevel.fadeOut( settings.hideSpeed ); } 
            else { subLevel.hide(); }
		}
	};
	
	function _subLevelExists(obj){
		return obj.children('UL').length > 0;
	};
	
	//    Entry point
	_build();
};

/*  Default Settings  */
$.fn.xBreadcrumbs.defaults = {
	showSpeed:        'fast',
	hideSpeed:        '',
	collapsible:      false,
	collapsedWidth:   10
};
})(jQuery);

/*-------------jquery.xbreadcrumbs-------------end */

/*-------------docDownload.js-------------begin */
//--列头全选框被单击---
function chkAllClick1(sonName, cbAllId, cbAllId2) {
	var arrSon = document.getElementsByName(sonName);
	var cbAll = document.getElementById(cbAllId);
	var cbAll2 = document.getElementById(cbAllId2);
	cbAll2.checked = false;
	if(cbAll.checked){
		cbAll2.checked = true;
	}
	var tempState = cbAll.checked;
	for (var i = 0; i < arrSon.length; i++) {
		if (arrSon[i].checked != tempState){
			arrSon[i].click();
		}
	}
}
//--列尾全选框被单击---
function chkAllClick2(sonName, cbAllId, cbAllId2) {
	var arrSon = document.getElementsByName(sonName);
	var cbAll = document.getElementById(cbAllId);
	var cbAll2 = document.getElementById(cbAllId2);
	cbAll.checked = false;
	if(cbAll2.checked){
		cbAll.checked = true;
	}
	var tempState = cbAll2.checked;
	for (var i = 0; i < arrSon.length; i++) {
		if (arrSon[i].checked != tempState){
			arrSon[i].click();
		}
	}
}
//--子项复选框被单击---
function chkSonClick1(sonName, cbAllId, cbAllId2) {
	var arrSon = document.getElementsByName(sonName);
// 	var cbAll = document.getElementById(cbAllId);
// 	var cbAll2 = document.getElementById(cbAllId2);
	var cbAll = $("#"+cbAllId);
	var cbAll2 = $("#"+cbAllId2);
	for ( var i = 0; i < arrSon.length; i++) {
		if (!arrSon[i].checked) {
			cbAll.removeAttr("checked");
			cbAll2.removeAttr("checked");
			return;
		}
	}
	cbAll.attr("checked","checked");
	cbAll2.attr("checked","checked");
}

//添加文档批量下载按钮事件
function docBatchDownload() {
	var url=i18nProperty.downloadUrl+"?contentType=DOC";
	var jsonArr = new Array();
	var docidStr="";
	$.each($('[name="docidTemp"]:checked'), function(index, item){
		docidStr+=$(item).val()+",";
	});
	if(docidStr.length>0){
		if(docidStr.substr(docidStr.length-1,docidStr.length)==","){
			docidStr=docidStr.substring(0, docidStr.length-1);
		}
	}
	if(docidStr==""){
		alert(i18nProperty.downloadTitle);
		return;
	}
	$.ajax({
		type:"POST",
		async: false,
		url:"/enterprise/LoadDownloadInfos!getDownLoadDocInfo.action",
		data:{
			idPath:idAbsPath,
			docidStr:docidStr
		},
		dataType:"json",
		success:function(data){
			if(data){
				$.each(data, function(key, value) {
					var tmpArr = new Array();
					var url_ = url;
					tmpArr[0]= url_ += ("&contentId=" + value.CONTENT_ID + "&partNo=" +value.PART_NO + "&idPath=" + idAbsPath);
					tmpArr[1]= value.FILE_NAME;
					tmpArr[2]= location.href;
					tmpArr[3]= true;
					jsonArr.push(tmpArr);
				});
			}
		}
	});
	if(jsonArr.length > 0){
		var strResult = hedexbeeBatchDl(jsonArr);
		if(strResult != "success"){
			getHedexGuideDocUrl(strResult,'2');
		}
	}
}

//直接下载按钮点击事件
function shortcutOfDown(docId,ishedex){
	$.ajax({
		type:"POST",
		url:"/enterprise/LoadDownloadInfos!loadDownLoadFix.action",
		data:{
			contentId:docId,
			idPath:idAbsPath,
			isShortCut:"0",
			ishedex:ishedex
		},
		dataType:"json",
		success:function(resultLoad){
			if(resultLoad == "0"){
				loadDownInfo(docId);
			}else if(resultLoad == "1"){
				window.open("/enterprise/pages/downloadSer/downloadError.jsp?errorType=101");
			}else if(resultLoad == "2"){
				window.open("/enterprise/getPermission.jsp");
			}else if(resultLoad == "3"){
				forLogin();
				return;
			}else if(resultLoad == "4"){
				window.open("/enterprise/pages/softDownload/subfile/application.jsp");
			}else if(resultLoad == "5"){
				window.open("/enterprise/pages/downloadSer/downloadError.jsp?errorType=106");
			}else{
				var url = resultLoad.downloadUrl + "?contentId=" + resultLoad.contentId + "&contentType=DOC&partNo=" + resultLoad.partNo + "&idPath=" + idAbsPath;
				if(!isnotHedexLite){
					$(this).attr("nid", resultLoad.contentId);
					$(this).attr("pno", resultLoad.partNo);
					$(this).attr("title_hedex", resultLoad.fileName);
					$(this).attr("href", url);
					beginHedExLiteDownload($(this),true,true);
				}else{
					window.open(url,"_self");
				}
			}
		}
	});
}

/**
 * 加载下载信息
 * @param contentId
 * @param idPath
 */
function loadDownInfo(contentId){
	var donwLoadTitle = i18nProperty.relDownload;
	var isShortCut = "0";
	$("#dialog:ui-dialog").dialog("destroy");
	$("#downLoadInfos").load("/enterprise/LoadDownloadInfos.action",{
		contentId:contentId,
		idPath:idAbsPath,
		isNew:"1",
		isShortCut:isShortCut,
		requestType:"ajax"},
		function(data){
			if("ssoLoginTimeOut"==data){
		    	forLogin();
			}
			$("#downLoadInfos").dialog({
				title : donwLoadTitle,
				resizable : false,
				width : 520,
				height : 300,
				modal : true ,
				close : function(){
					$("#downLoadInfos").html("");
					$("#downLoadInfos").css("display","none");
				}
			});
	});
}
/*-------------docDownload.js-------------end */

/*-------------messageBox.js--------------begin */
/*方法名：dialog
 *功能：弹出一个消息提示框，通常包含确定和取消两个按钮
 *返回： 无
 *参数列表： 
 * title:标题，String，必填，缺省下为空，支持长度<=32，多于则截取
 * content:内容，String，必填，缺省下为空，支持长度<=64，多于则截取
 * buttons:创建button的 对象，json类型，必填,缺省为{}
 *         例如：var buttons = {"确定": function() {$( this ).dialog( "close" );}};
 * width：宽度，Number，可选，缺省为300px
 * height：高度 ，Number，可选，缺省为'auto':会自己适应其内容的高度
 * titleBg:标题背景，可选，缺省为'true'，有背景，可填入false,无背景
*/
sui.cbb.messageBox = function(){
	this.dialog = function(title, content, buttons, width, height){
		var MAX_TITLE = 32; //最大标题长度
		var MAX_CONTENT = 2550; //最大内容长度
		
		var titleResult = "";//用于保存最终用于显示的标题
		titleResult = this._substring(this.replaceSpace(title), MAX_TITLE);
		
		var temp = '<div style="width:'+(parseInt(width) - 40)+'px;word-wrap:break-word;text-align:left">'+titleResult+'</div>';
		//如果为ie 浏览器
		if($.browser.msie && ($.browser.version != 8)) {
			 temp = '<div style="word-wrap:break-word;text-align:left">'+titleResult+'</div>';
		}   
		
		var contentResult = "";//用于保存最终用于显示的内容
		contentResult = this._substring(this.replaceSpace(content), MAX_CONTENT);
		
		$('<div id="cbbMessageBox" style="word-wrap:break-word;text-align:left">' + contentResult + '</div>').dialog({
			title: temp,
			resizable: false,
			width: width,
			height: height,
			modal: true,
			buttons: buttons
		});

	};
    //截取字符串函数     双字节字符算2个单位，ascii字符算1个单位	
	this._substring = function(str, maxLen){
		var num1= str.replace(/[^\x00-\xff]/g,"aa").length;
		var num2=str.length;
		
		if(num1 == num2 && num2 > maxLen){
			return str.substring(0,maxLen);
		} else if (num1 != num2 && num1 > maxLen){
			var array=str.split("");
			var count=0;
			var resultStr = str;
			for(var i=0;i<array.length;i++) {
				if(count >= maxLen){
					resultStr = str.substring(0,i);
					break;
				}
				if(array[i].replace(/[^\x00-\xff]/g,"aa").length == 2){
					count += 2;
				}else{
					count += 1;
				}
				
			}
			if(count > maxLen){
				resultStr = str.substring(0,i-1);
			}
			return resultStr;
		}else{
			return str;
		}
	};
	
	//利用正则表达式删除字符串左右空格   
	this.replaceSpace = function (str){
		return str.replace(/(^\s*)|(\s*$)/g, "");
	};
}
/*-------------messageBox.js--------------end */

/**
 * 根据选择的场景更改url
 * */
function changUrl(scen){
	
	if(typeof(history.pushState) != "undefined"){
		var tab = $("#tags .selectTag > a").attr("class");
		var url = "/enterprise/" + $("#language").val() + "/" + $("#category_name").val() + "/" + $("#product_name").val() + "-pid-" + $("#pid_url").val() + "/";
		
		if(scen){
			scen = scen.toLowerCase();
			switch(tab){
			case "doc":
				url = url + "?category=" + scen;
				break;
			case "case":
				url = url + "knowledge-base/" + "?scenario=" + scen;
				break;
			case "bulletin":
				url = url + "bulletins/" + "?type=" + scen;
				break;
			}
		}else{
			switch(tab){
			case "doc":
				url = url ;
				break;
			case "case":
				url = url + "knowledge-base/";
				break;
			case "bulletin":
				url = url + "bulletins/";
				break;
			}
		}
		
		history.replaceState("","",url);
	}
}

//增加打点记录方法
function clickIndexPage(_this){
	var o = new Object();
	o.category = $(_this).attr("ha_category");
	o.action = $(_this).attr("ha_action");
	o.label = $(_this).attr("ha_label");
	_haq.push(['_trackEvt', o]);
}

function gotoView(seo_url_current){
	var url = encodeURI(seo_url_current);
	window.open(url,"_blank");
	return;
}
