<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>第一个jqGrid!</title>

<script src="/springmvc/3rd/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<script src="/springmvc/3rd/Chart.js/Chart.min.js"></script>

<script type="text/javascript">
	function load () {
		var popCanvas = $("#popChart");
		var popCanvas = document.getElementById("popChart");
		var popCanvas = document.getElementById("popChart").getContext("2d");
		<!-- line, bar, radar, polarArea, pie, doughnut 以及bubble -->
		var barChart = new Chart(popCanvas, {
			type : 'bar',
			data : {
				labels : [ "China", "India", "United States", "Indonesia",
						"Brazil", "Pakistan", "Nigeria", "Bangladesh",
						"Russia", "Japan" ],
				datasets : [ {
					label : 'Population',
					data : [ 1379302771, 1281935911, 326625791, 260580739,
							207353391, 204924861, 190632261, 157826578,
							142257519, 126451398 ],
					backgroundColor : [ 'rgba(255, 99, 132, 0.6)',
							'rgba(54, 162, 235, 0.6)',
							'rgba(255, 206, 86, 0.6)',
							'rgba(75, 192, 192, 0.6)',
							'rgba(153, 102, 255, 0.6)',
							'rgba(255, 159, 64, 0.6)',
							'rgba(255, 99, 132, 0.6)',
							'rgba(54, 162, 235, 0.6)',
							'rgba(255, 206, 86, 0.6)',
							'rgba(75, 192, 192, 0.6)',
							'rgba(153, 102, 255, 0.6)' ]
				} ]
			}
		});
	};

	$(function($) {
		load();
	});
</script>

</head>
<body>
	<button onclick="load()">点击这里刷新</button>
	<canvas id="popChart" width="600" height="200"></canvas>

	<script type="text/javascript">
	$(function(){
	      var j_all_area = $("#sel_all_area"), j_selected_areas = $("#sel_selected_areas");
	      $("#btn_select_all_area").click(function(){
	              var selectedAreaArray = [];
	            j_all_area.find("option").each(function(i){
	                selectedAreaArray[i] = $(this).val();
//	                 $(this).appendTo(j_selected_areas);
	            });
	            doSubmit('add',selectedAreaArray.toString());
	            
	            return false;
	        });
	        $("#btn_choose_selected_area").click(function(){
	             var selectedAreaArray = [];
	            j_all_area.find("option:selected").each(function(i){
	                selectedAreaArray[i] = $(this).val();
//	                 $(this).appendTo(j_selected_areas);
	            });
	            doSubmit('add',selectedAreaArray.toString());
	            return false;
	        });
	        $("#btn_remove_selected_area").click(function(){
	            var selectedAreaArray = [];
	            j_selected_areas.find("option:selected").each(function(i){
	                selectedAreaArray[i] = $(this).val();
//	                 $(this).appendTo(j_all_area);
	            });
	            doSubmit('del',selectedAreaArray.toString());
	            return false;
	        });
	        $("#btn_remove_all_area").click(function(){
	            var selectedAreaArray = [];
	            j_selected_areas.find("option").each(function(i){
	                selectedAreaArray[i] = $(this).val();
//	                 $(this).appendTo(j_all_area);
	            });
	            doSubmit('del',selectedAreaArray.toString());
	            return false;
	        });
	      
	  })

	   function doSubmit(select_type,roleids){
	      var userid = $("#userid").val();
	            $.post("doroledefine",{userid:userid,roleids:roleids,type:select_type},function(result){
	                if (result == "error") {
	                    layer.msg('更新失败！', {
	                      icon: 2
	                    }) 
	                }else{
	                    initParams();
	                    layer.msg('更新成功！', {
	                      icon: 1
	                    })
	                }
	            });
	  }
    </script>

	<fieldset>
		<input type="hidden" name="userid" value="${userid }" id="userid" />
		<table class="table table-bordered dchannel-table">
			<tbody>
				<tr class="item-default">
					<td align="right" style="width: 50%;"><select
						id="sel_all_area" multiple="multiple" size="10"
						style="width: 100%;">
						  <option value="1">AAAAAAAAAAAAAAAAA</option>
						   <option value="2">BBBBBBB</option>
							<%--                       <c:forEach items="${unselectedAreas}" var="area" varStatus="loop"> --%>
							<%--                         <option value="${area.code}">${area.name}(${area.code})</option> --%>
							<%--                       </c:forEach> --%>
					</select></td>
					<td style="width: 50px;" valign="middle">
						<button type="button" class="btn btn-default btn-small"
							id="btn_select_all_area">
							<span class="glyphicon glyphicon-forward"></span>
						</button>
						<button type="button" class="btn btn-default btn-small"
							id="btn_choose_selected_area">
							<span class="glyphicon glyphicon-chevron-right"></span>
						</button>
						<button type="button" class="btn btn-default btn-small"
							id="btn_remove_selected_area">
							<span class="glyphicon glyphicon-chevron-left"></span>
						</button>
						<button type="button" class="btn btn-default btn-small"
							id="btn_remove_all_area">
							<span class="glyphicon glyphicon-backward"></span>
						</button>
					</td>
					<td style="width: 50%;"><select id="sel_selected_areas"
						multiple="multiple" size="10" style="width: 100%;">
						
						 <option value="3">CCCCC</option>
						   <option value="4">DDDDD</option>
							<%--                   <c:forEach items="${selectedAreas}" var="area" varStatus="loop"> --%>
							<%--                         <option value="${area.code}">${area.name}(${area.code})</option> --%>
							<%--                       </c:forEach> --%>
					</select></td>
				</tr>
			</tbody>
		</table>
	</fieldset>
	
<script type="text/javascript">
$(function(){  
    $("#checkall").click(function(){   
        //第一种方法 全选全不选  
        if(this.checked){   
            $("input[name='check1']:checkbox").attr('checked',true);   
        }else{   
            $("input[name='check1']:checkbox").attr('checked',false);    
        } */   
        //第二种方法 全选全不选   
        $('[name=check1]:checkbox').attr('checked',this.checked);//checked为true时为默认显示的状态   
    });  
    $("#checkrev").click(function(){  
        //实现反选功能  
        $('[name=check1]:checkbox').each(function(){  
            this.checked=!this.checked;  
        });  
    });   
});  
</script>   
	
	<label>1<input type="checkbox" name="check1"></label>  
<label>2<input type="checkbox" name="check1" ></label>  
<label for="checkall">全选<input type="checkbox" id="checkall"></label>  
<label for="checkrev">反选<input type="checkbox" id="checkrev"></label>  

</body>
</html>