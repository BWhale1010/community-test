let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});
	}
	
	, save: function(){
		let param = {
			username : $("#username").val(),
			email : $("#email").val(),
			password : $("#password").val()
		};
		$.ajax({
			type: "POST",
			url: "/join",
			data: param,
			dataType: "JSON",
			success: function(data){
				if(data.success > 0){
					alert("회원 가입에 성공했습니다.");
					location.href = "/";
				}else{
					alert("회원 가입에 실패했습니다.");
				}
			},
			error: function(e){
				console.log(e);
			}
		})
	}
		
	
}

index.init();