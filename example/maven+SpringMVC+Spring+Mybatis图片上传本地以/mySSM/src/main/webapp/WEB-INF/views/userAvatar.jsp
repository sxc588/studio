<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="zh_CN"/>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery.imgareaselect-0.9.10/jquery.imgareaselect.pack.js"></script>
<script type="text/javascript" src="js/progressbar/jquery.progressbar.min.js"></script>
<link type="text/css" rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/themes/excite-bike/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="css/default.css" />
<link type="text/css" rel="stylesheet" href="css/jquery.imgareaselect-0.9.10/imgareaselect-default.css" />
</head>



<html>
<body>
	<script type="text/javascript" 
		    src="http://www.xiami.com/widget/player-single?uid=0&sid=3556769&mode=js">
	</script>
	
	<script language="javascript">
	
		var re = /^[A-Za-z0-9]*$/;
		var re2 = /^[0-9]*$/;

		//准备提交
		function readySubmit(){
			//检查文件类型
			var flag = checkFile();
			if(flag){
				window.mainForm2.submit();
			}
			return true;
		}

		//点击上传按钮触发的方法
		function checkFile(){
    	   var str = $("#picture").val();
	       var index = str.lastIndexOf('.');
	       var strtype = str.substr(index,4);
	       strtype = strtype.toLowerCase();
	       if(str.length != 0){
	    	    if(strtype != ".gif" && strtype != ".jpg" && strtype != ".png"){
		            alert("请上传gif、jpg、png格式的图片");
		            return false;
		        }
   	  	    	//window.form1.submit();
   	  	    	return true;
	       }else{
			    alert("请选择要上传的文件");
			    return false;
		   }
		}
	</script>




		<div id="top">
		</div>


		<div id="body">

			<!-- content begin -->
			<div class="set_sec set_buddy" style="clear:both;">
				<h3>当前上传的图片</h3>
				<img id="cropbox" src="<%=basePath%>user/changeUserAvatar/displayImage?UserRegist=${UserRegist.memberImg}" width="200" height="200" />
				<br><br>

				<div class="buddy_upload">
					<div id="buddy_mini" >
						<h3>当前用户头像</h3>
						<div class="frame"  style="margin: 0 1em; width: 100px; height: 100px;">
					      <div id="preview" style="width: 100px; height: 100px; overflow: hidden;">
					      	<img id="preview_img" src="<%=basePath%>user/changeUserAvatar/displayImage?UserRegist=${UserRegist.memberImg}"
					             style="width: ${UserRegist.memberImgWidth};
					             height: ${UserRegist.memberImgHeight};
					             margin-left: ${UserRegist.memberImgMarginLeft};
					             margin-top: ${UserRegist.memberImgMarginTop};"/>
					      </div>
					    </div>

						<p class="mi_tips">请在左图中选择要保存作为小头像的区域， <br />确定需要裁剪的部分后点击'保存'按钮进行裁剪。</p>
						<form action="<%=basePath%>user/changeUserAvatar/cutUserAvatar"
						      method="post" enctype="application/x-www-form-urlencoded"
						      id="mainForm1" name="mainForm1" >
							<input type="hidden" name="memberImgWidth" id="memberImgWidth"/>
							<input type="hidden" name="memberImgHeight" id="memberImgHeight"/>
							<input type="hidden" name="memberImgMarginLeft" id="memberImgMarginLeft"/>
							<input type="hidden" name="memberImgMarginTop" id="memberImgMarginTop"/>
							<input type="hidden" name="memberImg" id="saveImgSrc" />

							<p class="save_acts">
								<!-- <input id="mainForm1Submit" type="submit" value="保 存" /> -->
								<input id="btnSave" type="button" value="保存修改" />

							</p>
						</form>

						<p class="getNew"><a class="reupload" href="javascript:void(0)" title="">换张图片，重新上传</a></p>
					</div>


					<div  id="reupload_div" style="display:none">
						<p class="getNew"><a class="reupload" href="javascript:void(0)" title="">返回框选小头像</a></p>
						<form action="<%=basePath%>user/changeUserAvatar" method="post"  enctype="multipart/form-data"
							  id="mainForm2" name="mainForm2" onsubmit="javascript:return check();">
							<p>
								<input type="file" id="picture" class="f_file" name="avatar" />
							</p>
							<p class="tips">支持gif、jpg、png等多种格式图片。</p>
							<p class="notes">上传反动、色情等照片将导致您的帐号被删除。</p>
							<p class="acts">
								<%-- <input id="submit" type="submit"  value="确认上传头像1" /> --%>
								<%-- <input id="btnTest" type="button" value="测试按钮"  /> --%>
								<input id="btnUpdateAvatar" type="button" value="确认上传头像" />
								<span class="progressBar" id="pb1"  style="display:none"></span>
							</p>

						</form>
					</div>
				</div>
			</div>


			<div id="buttons">
			<p style="text-align: center; height: 36px; line-height: 36px; width: 100%;">
				<%--<input type="button" value="返回主页" onclick="javascript:location.href='<%=basePath%>'" />--%>
				<%--<input type="reset" name="reset" value="重新输入" />--%>
				<%--<input id="submitBtn" type="submit" value="保存修改"  /> --%>
			</p>
			</div>


		</div>


		<div id="bottom">
		</div>

		<!-- 加载页面后执行 -->
		<script language="javascript">
		//测试按钮
		$("#btnTest").click(function() {
			//var ias = $("#cropbox").imgAreaSelect({ instance: true });
			var memberImgWidth = $("#preview_img").css("width");
			var memberImgHeight = $("#preview_img").css("height");
			var memberImgMarginLeft = $("#preview_img").css("marginLeft");
			var memberImgMarginTop = $("#preview_img").css("marginTop")
			alert(memberImgWidth+"  "+memberImgHeight+"  "+memberImgMarginLeft+"  "+memberImgMarginTop);

			$("#memberImgWidth").val(memberImgWidth);
			$("#memberImgHeight").val(memberImgHeight);
			$("#memberImgMarginLeft").val(memberImgMarginLeft);
			$("#memberImgMarginTop").val(memberImgMarginTop);
			$("#memberImg").val($("#picture").val());
		});


		$(document).ready(function(){
			$(".reupload").click(function(){
				$("#buddy_mini").toggle("fast");
				$("#reupload_div").toggle("fast");
			});

			$("img#cropbox").imgAreaSelect({
				handles: true,
				resizable : true,
		        aspectRatio: "1:1",
		        instance: true,
		        movable:true,
		        keys:false,
		        onSelectEnd : preview
		        //onSelectEnd: function (img, selection) {
		        	//alert("selected !!!!!");
		        //}
		    });

		});


		$("#btnSave").click(function(){
			var memberImgWidth = $("#preview_img").css("width");
			var memberImgHeight = $("#preview_img").css("height");
			var memberImgMarginLeft = $("#preview_img").css("marginLeft");
			var memberImgMarginTop = $("#preview_img").css("marginTop")

			$("#memberImgWidth").val(memberImgWidth);
			$("#memberImgHeight").val(memberImgHeight);
			$("#memberImgMarginLeft").val(memberImgMarginLeft);
			$("#memberImgMarginTop").val(memberImgMarginTop);
			//取img对象src最后的文件名,去掉路径和.后缀名
			var a = $("#cropbox").attr("src");
		    var b = a.lastIndexOf("/");
			var c = a.substring(b+1,a.length);
			//var d = c.lastIndexOf(".");
			//var e = c.substring(0,d);
			$("#saveImgSrc").val(c);

			window.mainForm1.submit();
		});


		//选中图片后生成的预览
		function preview(img, selection) {
		    if (!selection.width || !selection.height){
		    	return;
		    }
		    var scaleX = 100 / selection.width;
		    var scaleY = 100 / selection.height;
		    //200是根据id="cropbox"的宽高设定的,以后可能会调整
		    $("#preview_img").css({
		        width: Math.round(scaleX * 200),
		        height: Math.round(scaleY * 200),
		        marginLeft: -Math.round(scaleX * selection.x1),
		        marginTop: -Math.round(scaleY * selection.y1)
		    });

		}

		$("#btnUpdateAvatar").click(function(){
            //this.disabled="disabled";
            var flag = checkFile();
    		if(flag){
    			window.mainForm2.submit();

    			var i = window.setInterval(function(){
    	            $.ajax({
    	            	url:"user/changeUserAvatar/progressBar",
    	            	type:"POST",
    	            	dataType:"json",
    	            	data:"time="+new Date(), //参数
    	            	async : true, //默认为true 异步
    	            	success: function(data){
    	            		if(data.retVal=='100.0'){
    	                        clearInterval(i);
    	                        $("#pb1").progressBar(0,{ boxImage : "images/progressbar/progressbar.gif",barImage: "images/progressbar/progressbg_green.gif" });//将进度条设置为0
    	                        $("#pb1").css("display","none");
    	                        alert("上传成功！");
    	                    }else if(data.retVal=='-1.0') {
    	                        clearInterval(i);
    	                        alert("上传失败，请重新上传");
    	                    }else{
    	                        $("#pb1").css("display","block");
    	                        $("#pb1").progressBar(data.retVal,{boxImage : "images/progressbar/progressbar.gif", barImage: "images/progressbar/progressbg_green.gif" });
    	                    }
    	            	},
    	            	error:function(msg){
    	            		alert(msg.retVal);
    	            	}

    	            });
    			}, 100);
    		}else{

    		}
        });
		</script>
		
</body>
</html>
