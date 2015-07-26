$(document).ready(function(){
	$(".mainNav a").mouseover(function(){
		$(".mainNav a").attr("class","");
		$("#"+this.id).attr("class","actived");
		var currentMenuNo = parseInt(this.id.substring(1));
		$(".secondNav div").each(function(){
			$(this).hide();
			$("#subNav"+currentMenuNo).show();
		});
	});
});