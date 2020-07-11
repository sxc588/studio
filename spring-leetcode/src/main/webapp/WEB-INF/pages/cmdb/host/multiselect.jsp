<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">  
  <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />  
    <title>Query MultiSelect（左右选择框）</title>  
    <script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
    <script>  
    $(function(){  
        //选择一项  
        $("#addOne").click(function(){  
            $("#from option:selected").clone().appendTo("#to");  
            $("#from option:selected").remove();  
        });  
  
        //选择全部  
        $("#addAll").click(function(){  
            $("#from option").clone().appendTo("#to");  
            $("#from option").remove();  
        });  
  
        //移除一项  
        $("#removeOne").click(function(){  
            $("#to option:selected").clone().appendTo("#from");  
            $("#to option:selected").remove();  
        });  
  
        //移除全部  
        $("#removeAll").click(function(){  
            $("#to option").clone().appendTo("#from");  
            $("#to option").remove();  
        });  
  
        //移至顶部  
        $("#Top").click(function(){  
            var allOpts = $("#to option");  
            var selected = $("#to option:selected");  
  
            if(selected.get(0).index!=0){  
                for(i=0;i<selected.length;i++){  
                   var item = $(selected.get(i));  
                   var top = $(allOpts.get(0));  
                   item.insertBefore(top);  
                }  
            }  
        });  
  
        //上移一行  
        $("#Up").click(function(){  
            var selected = $("#to option:selected");  
            if(selected.get(0).index!=0){  
                selected.each(function(){  
                    $(this).prev().before($(this));  
                });  
            }  
        });  
  
        //下移一行  
        $("#Down").click(function(){  
            var allOpts = $("#to option");  
            var selected = $("#to option:selected");  
  
            if(selected.get(selected.length-1).index!=allOpts.length-1){  
                for(i=selected.length-1;i>=0;i--){  
                   var item = $(selected.get(i));  
                   item.insertAfter(item.next());  
                }  
            }  
        });  
  
        //移至底部  
        $("#Buttom").click(function(){  
            var allOpts = $("#to option");  
            var selected = $("#to option:selected");  
  
            if(selected.get(selected.length-1).index!=allOpts.length-1){  
                for(i=selected.length-1;i>=0;i--){  
                   var item = $(selected.get(i));  
                   var buttom = $(allOpts.get(length-1));  
                   item.insertAfter(buttom);  
                }  
            }  
        });  
    });  
    </script>  
  </head>  
<body>  
<table align="center" width="300" border="1" cellpadding="0" cellspacing="0">  
    <tr>  
        <td colspan="4" width="75">
            <select name="from" id="from" multiple="multiple" size="10" style="width:100%">  
                <option value="1">选项1</option>  
                <option value="2">选项2</option>  
                <option value="3">选项3</option>  
                <option value="4">选项4</option>  
                <option value="5">选项5</option>  
                <option value="6">选项6</option>  
                <option value="7">选项7</option>  
            </select>  
        </td>  
        <td align="center" width="75">  
            <input type="button" id="addAll" value=" >> " style="width:50px;" /><br />  
            <input type="button" id="addOne" value=" > " style="width:50px;" /><br />  
            <input type="button" id="removeOne" value="<" style="width:50px;" /><br />  
            <input type="button" id="removeAll" value="<<" style="width:50px;" /><br />  
        </td>  
        <td colspan="4" width="75">  
            <select name="to" id="to" multiple="multiple" size="10" style="width:100%">  
            </select>  
        </td>  
        <td align="center" width="75">  
            <input type="button" id="Top" value="置顶" style="width:50px;" /><br />  
            <input type="button" id="Up" value="上移" style="width:50px;" /><br />  
            <input type="button" id="Down" value="下移" style="width:50px;" /><br />  
            <input type="button" id="Buttom" value="置底" style="width:50px;" /><br />  
        </td>  
    </tr>  
</table>  



<div class="container" style="padding: 100px 50px 10px;" >
    <button type="button" class="btn btn-default" title="Popover title"
            data-container="body" data-toggle="popover" data-placement="left"
            data-content="左侧的 Popover 中的一些内容">
        左侧的 Popover
    </button>
    <button type="button" class="btn btn-primary" title="Popover title"
            data-container="body" data-toggle="popover" data-placement="top"
            data-content="顶部的 Popover 中的一些内容">
        顶部的 Popover
    </button>
    <button type="button" class="btn btn-success" title="Popover title"
            data-container="body" data-toggle="popover" data-placement="bottom"
            data-content="底部的 Popover 中的一些内容">
        底部的 Popover
    </button>
    <button type="button" class="btn btn-warning" title="Popover title"
            data-container="body" data-toggle="popover" data-placement="right"
            data-content="右侧的 Popover 中的一些内容">
        右侧的 Popover
    </button>
</div>
 
<script>
$(function (){
    $("[data-toggle='popover']").popover();
});
</script>
</div>
</body>  
</html>  