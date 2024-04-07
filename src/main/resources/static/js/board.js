//var showPage = 1;
var total = 5;
mainList(1);



let index={
		init: function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});
		$("#btn-update").on("click", ()=>{
			this.update();
		});
		$("#btn-delete").on("click", ()=>{
			this.delete();
		});
		$("#btn-reply-save").on("click", ()=>{
			this.reply();
		});
	}
	
	,save: function(){
		let param = {
			title: $("#title").val(),
			content: $("#content").val()
			
		};
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
	,update: function(){
		let id = $("#id").val()
		let param = {
			title: $("#title").val(),
			content: $("#content").val()
			
		};
		$.ajax({
			type:"POST",
			url: "/board/update/"+id,
			data: param,
			dataType:"json",
			success:function(data){
				console.log("수정 완료");
				 location.href = "/board/detail/"+id;
			},
			error: function(e){
				console.log(e);
			}
			
		})
	}
	,delete: function(){
		let id = $("#id").text()
		console.log("id : "+id);
		$.ajax({
			type:"delete",
			url: "/board/delete/"+id,
			dataType:"json",
			success:function(data){
				console.log("삭제 완료");
				 location.href = "/bdListForm_1";
			},
			error: function(e){
				console.log(e);
			}
			
		})
	}
	,reply: function(){		
		let id = $("#id").text();
		let param = {
			id: $("#id").text(),
			content: $("#reply-content").val()
		};
		console.log(param.content);
		$.ajax({
			type:"POST",
			url: "/board/replyWrite",
			data: param,
			dataType:"json",
			success:function(data){
				console.log("댓글 쓰기 완료");
				 location.href = "/board/detail/"+id;
			},
			error: function(e){
				console.log(e);
			}
			
		})
	}
	, replyDelete: function(replyId){
		let id = $("#id").text();
		$.ajax({
			type: "Delete",
			url: "/reply/delete/"+replyId,
			dataType: "json",
			success: function(data){
				console.log("댓글 삭제 완료");
				 location.href = "/board/detail/"+id;
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