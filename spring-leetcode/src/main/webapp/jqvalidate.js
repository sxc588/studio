//为表单的必填文本框添加提示信息（选择form中的所有后代input元素）
$("form :input.required").each(function() {
	//通过jquery api：$("HTML字符串") 创建jquery对象
	var $required = $("<strong class='high'>*</strong>");
	//添加到this对象的父级对象下
	$(this).parent().append($required);
});

//为表单元素添加失去焦点事件
$("form :input").blur(
		function() {
			var $parent = $(this).parent();
			//验证姓名
			if ($(this).is("#name")) {
				var nameVal = $.trim(this.value); //原生js去空格方式：this.replace(/(^\s*)|(\s*$)/g, "")
				var regName = /[~#^$@%&!*()<>:;'"{}【】  ]/;
				if (nameVal == "" || nameVal.length < 6
						|| regName.test(nameVal)) {
					var errorMsg = " 姓名非空，长度6位以上，不包含特殊字符！";
					//class='msg onError' 中间的空格是层叠样式的格式
					$parent.append("<span class='msg onError'>" + errorMsg
							+ "</span>");
				} else {
					var okMsg = " 输入正确";
					$parent.find(".high").remove();
					$parent.append("<span class='msg onSuccess'>" + okMsg
							+ "</span>");
				}
			}
			//验证邮箱
			if ($(this).is("#email")) {
				var emailVal = $.trim(this.value);
				var regEmail = /.+@.+\.[a-zA-Z]{2,4}$/;
				if (emailVal == ""
						|| (emailVal != "" && !regEmail.test(emailVal))) {
					var errorMsg = " 请输入正确的E-Mail住址！";
					$parent.append("<span class='msg onError'>" + errorMsg
							+ "</span>");
				} else {
					var okMsg = " 输入正确";
					$parent.find(".high").remove();
					$parent.append("<span class='msg onSuccess'>" + okMsg
							+ "</span>");
				}
			}
		});