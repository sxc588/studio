<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Index pages - Simple Data</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="3rd/zTree_v3/css/demo.css" type="text/css">
<link rel="stylesheet" href="3rd/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="3rd/zTree_v3/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="3rd/zTree_v3/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="3rd/zTree_v3/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="3rd/zTree_v3/js/jquery.ztree.exedit.min.js"></script>
<script type="text/javascript" src="3rd/zTree_v3/js/jquery.ztree.exhide.min.js"></script>
<script type="text/javascript" src="3rd/echart/echarts-gl.min.js"></script>
<script type="text/javascript">
    var setting = {
		view: {
		    dblClickExpand: true,
			selectedMulti : true,//可以多选
	        addHoverDom: addHoverDom,
	        removeHoverDom: removeHoverDom,
			showLine: true
			
		},check : {
			enable : true,//显示复选框  
			chkStyle : "checkbox"
		},
		edit:{
			enable: true,
			drag:{
			isMove:true,
			prev:true,
			autoOpenTime: 0
			},
			editNameSelectAll: true,
			showRemoveBtn: true,
			removeTitle: "删除节点",
			renameTitle: "编辑节点名称",
			showRenameBtn: true
			}
		,data : {
			simpleData : {
				enable : true
			}
		},
		 callback: {
		        onClick: zTreeOnClick, //单击事件
		        onRemove: onRemove, //移除事件
		        onRename: onRename //修改事件
		    }
	};

	$(document).ready(
			function() {
				var zNodes;
				var select;
				var selectarry = []; //要勾选的id
				var allnodes;
				$.ajax({
					type:"POST",
					url:"<%=request.getContextPath()%>
	/setting/ztree/tree", //请求的后台地址
			data : "name=John&location=Bpston",//前台传给后台的参数
			dataType : "json",
			ansync : false,
			ContentType : "application/json; charset=utf-8",
			success : function(msg) { //msg:返回值
				zNodes = msg;
				console.log(zNodes);

				//alert(zNodes)
				var t = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
				var zTree2 = $.fn.zTree.getZTreeObj("treeDemo");
				// 		           selectarry=msg.data.nodes.split(",");
				// 		           allnodes=zTree2.getNodes();
				// 		           for(select=1;select<selectarry.length;select++)
				// 		           {
				// 		               allnodes[select]=msg.data.list[select];
				// 		           }
				console.log(zTree2);

				// 						console.log(Performance);
				//console.log(selectarry);
				// 						for (select = 0; select < zNodes.length; select++) {
				// 							if (zNodes[select]))
				// 						{
				// 					       zTree2.checkNode(zTree2.getNodesByParam("id", zNodes[select]).id, true);
				// 						}
				// 						}
			}
		});
	});

	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span"); //获取节点信息
		if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
			return;

		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' οnfοcus='this.blur();'></span>"; //定义添加按钮
		sObj.after(addStr); //加载添加按钮
		var btn = $("#addBtn_" + treeNode.tId);

		// 			    //绑定添加事件，并定义添加操作
		// 			    if (btn) btn.bind("click", function(){
		// 			        var zTree = $.fn.zTree.getZTreeObj("tree");
		// 			        //将新节点添加到数据库中
		// 			        var name='NewNode';
		// 			        $.post('./index.php?r=data/addtree&pid='+treeNode.id+'&name='+name,function (data) {
		// 			            var newID = data; //获取新添加的节点Id
		// 			            zTree.addNodes(treeNode, {id:newID, pId:treeNode.id, name:name}); //页面上添加节点
		// 			            var node = zTree.getNodeByParam("id", newID, null); //根据新的id找到新添加的节点
		// 			            zTree.selectNode(node); //让新添加的节点处于选中状态
		// 			        });
		// 			    });
	};

	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_" + treeNode.tId).unbind().remove();
	};

	function zTreeOnClick(e, treeId, treeNode, isCancel) {
		console.log(treeNode);
		$("#addBtn_" + treeNode.tId).unbind().remove();
	};

	function onRemove(e, treeId, treeNode, isCancel) {
		console.log(treeNode);
	};

	function onRename(e, treeId, treeNode, isCancel) {
		console.log("onRename");
		//需要对名字做判定的，可以来这里写~~
		$.post('./index.php?r=data/modifyname&id=' + treeNode.id + '&name='
				+ treeNode.name);
	};

	function beforeRename(treeId, treeNode, newName, isCancel) {

		console.log("beforeRename");
		if (newName.length == 0) {
			alert("节点名称不能为空.");
			return false;
		}
		return true;
	};
</script>
</head>
<body>

 <h1>welcome to index page[springmvc] !</h1>
		
</body>
</html>
