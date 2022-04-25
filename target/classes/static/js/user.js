let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
	},

	save: function() {
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		
		$.ajax({
			type: "POST",
			url: "api/user",
			data: JSON.stringify(data), // js object를 json 타입으로 변환, 이게 http body data
			contentType: "application/json; charset=utf-8", // body data type 명시
			dataType: "json" // 요청에 대한 응답을 어떤 타입으로 받을지			
		}).done(function(resp) {
			console.log(resp);
			//location.href = "/blog";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
}

index.init();