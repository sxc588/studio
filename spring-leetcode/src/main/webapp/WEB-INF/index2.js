function outerFunction() {
	// 1.获取setting值
	function getSetting() {
		var setting = {
			view : {
				dblClickExpand : true,
				selectedMulti : true,// 可以多选
				showLine : true
			},
			check : {
				enable : true,// 显示复选框
				chkStyle : "checkbox"
			},
			data : {
				key : {
					title : "t"
				},
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "pId",
					rootPId : null
				}
			},
			callback : {
				onCheck : onCheck
			}
		};
		return setting;
	}

	// 2.创建树
	function createTree(treeId, dL, dLSize) {
		// 获取树参数默认值
		var setting = getSetting();
		var zNodes = new Array();
		// 设置根节点数据
		zNodes[0] = {
			id : '##',
			pId : "-1",
			name : '物资类别',
			t : '物资类别',
			open : true
		};
		for (var i = 0; i < dLSize; i++) {// 设置子节点数据
			zNodes[i + 1] = {
				id : dL[i].classCode,
				pId : dL[i].parentCode,
				name : dL[i].className + "(" + dL[i].classCode + ")",
				classId : dL[i].classId,
				t : dL[i].className
			};
		}
		// 1)创建zTree树
		$.fn.zTree.init($(treeId), setting, zNodes);
		// 2)初始化已经被选中的物资类别
		checkMaterial();
	}

	// 3.初始化被选中的物资类别
	function checkMaterial() {
		var classCodes = $("#classCodes").val();// 物资编码
		var datalist = classCodes.split("，");// 将物资编码打散成数组
		// 获取所有树节点
		var treeObj = $.fn.zTree.getZTreeObj("materialTree");
		if (datalist != '' && datalist.length > 0) {
			var nodes = treeObj.getNodes();// 获取所有子节点
			for (var i = 0; i < datalist.length; i++) {
				// 通过id查找节点
				var node = treeObj.getNodeByParam("classId", datalist[i], null);
				// 选中该节点
				if (node != null) {// 先判断节点是否为空
					// 选中该节点
					treeObj.checkNode(node, true, true);
					// 获取该节点父节点
					var parent = node.getParentNode();
					if (!parent.open) {// 如果父节点没有展开则展开父节点
						treeObj.expandNode(parent, true, true);
					}
				}
			}
		}
	}
	// 4.树的点击事件回调函数
	function onCheck(event, treeId, treeNode) {
		var classCodes = $("#classCodes").val();// 物资编码
		var classNames = $("#classNames").val();// 物资名字
		// alert("onCheck");
		// 获取所有树节点
		var treeObj = $.fn.zTree.getZTreeObj("materialTree");
		if (treeNode.checked) {// 如果是选中节点
			if (treeNode.isParent) {// 如果选中的是父节点(有子节点的节点)
				// 获取选中的父节点的所有子节点
				var childrenNodes = treeNode.children;
				for (var i = 0; i < childrenNodes.length; i++) {
					classCodes += "，" + childrenNodes[i].classId;
					classNames += "，" + childrenNodes[i].name;
				}
			} else {// 如果是子节点(无子节点的节点)
				classCodes += "，" + treeNode.classId;
				classNames += "，" + treeNode.name;
			}
		} else {// 如果是取消选中
			if (treeNode.isParent) {// 如果取消的是父节点(有子节点的节点)
				// 获取消的父节点的所有子节点
				var childrenNodes = treeNode.children;
				for (var i = 0; i < childrenNodes.length; i++) {
					var classCode = "，" + childrenNodes[i].classId;
					var className = "，" + childrenNodes[i].name;
					// 删除取消的节点对应的数据
					classCodes = classCodes.replace(classCode, "");
					classNames = classNames.replace(className, "");
				}
			} else {// 如果是子节点(无子节点的节点)
				classCode = "，" + treeNode.classId;
				className = "，" + treeNode.name;
				// 删除取消的节点对应的数据
				classCodes = classCodes.replace(classCode, "");
				classNames = classNames.replace(className, "");
			}
		}
		// 保存选中的值(物资类别编码、物资类别名字)
		$("#classCodes").val(classCodes);
		$("#classNames").val(classNames);
	}

	// 5.保存所选物资类别
	function saveMaterial(inputName) {
		// 获取父页要修改input元素
		var $input = parent.$("input[name=" + inputName + "]");
		// 获取选中的物资类别名称
		var className = $("#classNames").val();
		var classCode = $("#classCodes").val();
		// 截取掉多余的“，”
		var classNames = className.substring(1, className.length + 1);
		// 截取掉多余的“，”
		var classCodes = classCode.substring(1, classCode.length + 1);
		// 修改所选的物资类别名字
		$input.val(classNames);
		// 修改所选的物资类别编码
		$input.attr("classCodes", classCodes);
		$input.next().val(classCodes);
		// 关闭弹窗
		parent.layer.closeAll();
	}
	
	// 6.关闭弹窗
	function closeMaterial() {
		parent.layer.closeAll();
	}
}