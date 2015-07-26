$(document).ready(function(){
	$("#firstpane .menu_body:eq(0)").show();
	$("#firstpane p.menu_head").click(function(){
		$(this).addClass("current").next("div.menu_body").slideToggle(300).siblings("div.menu_body").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
	$(".menu_body a").click(function(){
		$(".menu_body a").removeClass("isClick");
		$(this).addClass("isClick");
	});
	$(".menu_body a").mouseover(function(){
		$(this).addClass("current");
		$(this).siblings().removeClass("current");
	});
	$(".menu_body a").mouseout(function(){
		$(this).removeClass("current");
	});
});