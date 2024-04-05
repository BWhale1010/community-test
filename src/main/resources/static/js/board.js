//var showPage = 1;
var total = 5;
mainList(1);

function mainList(page){
	console.log("1");
	$.ajax({
		type : 'post',
		url : '/boardList',
		data : {'page' : page},
		dataType: 'json',
		success : function(data){
			console.log("2");
			boardDraw(data.list);
			console.log("4");
			var total = data.total;
			console.log("5");
			console.log("total : "+total);
			
			$('#pagination').twbsPagination({
				startPage : 1,
				totalPages: total,
				visiblePages: 5,
				onPageClick: function(e,page){
					console.log(e);
					mainList(page);
					
				}
			});
		},
		error : function(e){
			console.log(e);
		}
	})
	
}

function boardDraw(list){
	console.log("3");
	var content = '';
	
	console.log(list);

	for(var i = 0; i<list.length; i++){
	content += '<li id="'+list[i].id+'" class="list-group-item d-flex justify-content-between"><div><a href="#">'+list[i].title+'</a></div><div class="d-flex font-italic"><div>작성자 : '+list[i].username+'&nbsp;</div><div>조회수 : '+list[i].count+'</div></div></li>';

	}
	
	$('#boardList').empty();
	$('#boardList').append(content);
	
	

}