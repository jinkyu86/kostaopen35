function menu_hover(obj, num){
	$('#'+obj).hover(function(){
		$(this).addClass('hover');
		$(this).css('background-color','#C4E2FF');
		check_display(obj);		
		$('.sub_menu').css('display', 'block');
		$('#'+obj+'_sub').css('display', 'block');
		$('#'+obj+'_sub').hover(function(){
			$('#'+obj+'_sub').addClass('hover');
		},function(){
			$('#'+obj+'_sub').removeClass('hover');
			$('#'+obj).css('background-color','#ffffff');
			$('.sub_menu').css('display', 'none');
			$('#'+obj+'_sub').css('display', 'none');
		});
	});
}
function check_display(obj){
	if(obj=='movie'){
		$('#reservation').css('background-color','#ffffff');
		$('#reservation_sub').css('display', 'none');
		$('#buy').css('background-color','#ffffff');
		$('#buy_sub').css('display', 'none');
	}else if(obj=='reservation'){
		$('#movie').css('background-color','#ffffff');
		$('#movie_sub').css('display', 'none');
		$('#buy').css('background-color','#ffffff');
		$('#buy_sub').css('display', 'none');
	}else if(obj=='buy'){
		$('#movie').css('background-color','#ffffff');
		$('#movie_sub').css('display', 'none');
		$('#reservation').css('background-color','#ffffff');
		$('#reservation_sub').css('display', 'none');
	}
}
$(document).ready(function(){
	menu_hover('movie',3);
	menu_hover('reservation',3);
	menu_hover('buy',3);
});