$('button#employeeBtn').on("click", function() {
	inputs = $("form#employee").find("input");
	inputs.each(function(index, element) {	
		if (!element.checkValidity()) {
			$(element).addClass('is-invalid');
		}				
	}, false);
});

$('button#deleteEmployee').on("click", function() {
	$.ajax({
		url: '/employee/delete',
		type: 'DELETE',
		data: {id: this.value},
		success: function(response) {
			console.log(response);
			location.reload();
		},
		error: function(response) {
			console.log(response);	
			location.reload();
		}
	});
});
