<script type="text/javascript">   
	$(function()
	{  
$("#checkAllChange").click(function() 
	{   
	if (this.checked == true) 
	{   
		$(".userid").each(function()
		{   
			this.checked = true;   
		});   
	}
	else 
	{   
		$(".userid").each(function()
		{   
			this.checked = false;   
		});   
	}   
	});   

  
$("#checkAll").click(function() {   
	$(".userid").each(function() {   
	this.checked = true;   
	});   
}); 

 
$("#removeAll").click(function() {   
	$(".userid").each(function() {   
	this.checked = false;   
	});   
});   

$("#reverse").click(function() 
		{   
$(".userid").each(function() {   
if (this.checked == true) {   
this.checked = false;   
} else {   
this.checked = true;   
}   
})   
});   

$("#delAll").click(function() {   
var arrUserid = new Array();   
$(".userid").each(function(i) {   
if (this.checked == true) {   
arrUserid[i] = $(this).val();   
}   
});   
alert("批量删除的:" + arrUserid);   
});   
});   
</script>