//var showPage = 1;
var total = 5;
mainList(1);



let index={
		init: function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});
	}
	
	,save: function(){
		let param = {
			title: $("#title").val(),
			content: $("#content").val()
			
		};
		console.log(content);
		$.ajax({
			type:"POST",
			url: "/board/write",
			data: param,
			dataType:"json",
			success:function(data){
				console.log("글쓰기 완료");
				 location.href = "/";
			},
			error: function(e){
				console.log(e);
			}
			
		})
	}
}





function mainList(page){
	$.ajax({
		type : 'post',
		url : '/boardList_1',
		data : {'page' : page},
		dataType: 'json',
		success : function(data){
			boardDraw(data.list);
			var total = data.total;
			
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
	var content = '';
	for(var i = 0; i<list.length; i++){
		content += '<li class="list-group-item d-flex justify-content-between"><div><a href="/board/detail/'+list[i].id+'">'+list[i].title+'</a></div><div class="d-flex font-italic"><div>작성자 : '+list[i].username+'&nbsp;</div><div>조회수 : '+list[i].count+'</div></div></li>';
	}
	$('#boardList').empty();
	$('#boardList').append(content);
}

index.init();