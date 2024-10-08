function openSalaryModal(entity) {
	$('#salaryModal #id').val(entity.id);
	$('#salaryModal #employeeId').val(entity.employeeId);
	$('#salaryModal #month').val(entity.month);
	$('#salaryModal #workDay').val(entity.workDay);
	$('#salaryModal #allowance').val(entity.allowance);
	$('#salaryModal #insurance').val(entity.insurance);
	$('#salaryModal #salary').val(entity.salary);
	$('#salaryModal #status').val(entity.status);
	$('#salaryModal #note').val(entity.note);


	$('#salaryModal').removeClass('fade');
	$('#salaryModal').show();
}

$('button#employeeBtn').on("click", function() {
	inputs = $("form#employee").find("input");
	inputs.each(function(index, element) {	
		if (!element.checkValidity()) {
			$(element).addClass('is-invalid');
		}				
	}, false);
});

$('button#deleteEmployee').on("click", function() {
	var value = this.value;
	
	$.ajax({
		url: '/employee/delete',
		type: 'DELETE',
		data: {id: this.value},
		success: function(response) {
			console.log(response);
			location.href = "/employee?result=" + response;
		},
		error: function(response) {
			console.log(response);	
			location.reload();
		}
	});
});

$('button#calculateForm').on("click", function() {
	var value = this.value;
	
	$.ajax({
		url: '/employee-salary',
		type: 'GET',
		data: {employeeId: value},
		success: function(response) {
			console.log(response);
			
			openSalaryModal(response);
			disabledBtn('button#saveSalary');
			disabledBtn('button#exportSalary');
		},
		error: function(response) {
			console.log(response);
			disabledBtn('button#saveSalary');
			disabledBtn('button#exportSalary');
		}
	});	
});

$('button#calculateSalary').on("click", function() {
	var inputs = $('#employeeSalary').serializeArray();
	var employeeSalaryValue = {};
	inputs.forEach(function (item) {
		employeeSalaryValue[item.name] = item.value;
	});
	
	$.ajax({
		url: '/employee-salary',
		type: 'POST',
		data: JSON.stringify({ 'employeeSalary': employeeSalaryValue }),
		dataType: "json",
		contentType: 'application/json',
		success: function(response) {
			console.log(response);
			
			openSalaryModal(response);
			
			enabledBtn('button#saveSalary');
			enabledBtn('button#exportSalary');
		},
		error: function(response) {
			console.log(response);
			
			disabledBtn('button#saveSalary');
			disabledBtn('button#exportSalary');
		}
	});	
});

$('button#saveSalary').on("click", function() {
	var inputs = $('#employeeSalary').serializeArray();
	var employeeSalaryValue = {};
	inputs.forEach(function (item) {
		employeeSalaryValue[item.name] = item.value;
	});
	
	$.ajax({
		url: '/employee-salary/save',
		type: 'POST',
		data: JSON.stringify({ 'employeeSalary': employeeSalaryValue }),
		dataType: "json",
		contentType: 'application/json',
		success: function(response) {
			console.log(response);
			
			openSalaryModal(response);
			
			enabledBtn('button#exportSalary');
		},
		error: function(response) {
			console.log(response);
			
			disabledBtn('button#exportSalary');
		}
	});
});

$('button#exportSalary').on("click", function() {
	var idInput = $('#employeeSalary input#id').val();
	
	$.ajax({
		url: '/employee-salary/export',
		type: 'POST',
		data: { id: idInput },
		success: function (response) {
			console.log(response);
		},
		error: function(response) {
			console.log(response);
		}
	})
});

function disabledBtn(itemSelected) {
	$(itemSelected).attr('disabled', true);
}

function enabledBtn(itemSelected) {
	$(itemSelected).attr('disabled', false);
}
