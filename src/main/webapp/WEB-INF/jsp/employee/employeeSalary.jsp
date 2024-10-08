<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Salary Modal-->
<div class="modal fade" id="salaryModal" tabindex="-1" role="dialog" aria-labelledby="salaryModalLabel"
    aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="salaryModalLabel">Calculate Salary</h5>
                <button id="cancelCalculateX" class="close" type="button" data-dismiss="modal" aria-label="Close" onclick="hideSalaryModal()">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <form:form action="/employee-salary" method="POST" modelAttribute="employeeSalary">
                    <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                            <label name="id">Id </label>
                            <input name="id" id="id" class="form-control form-control-user" readonly/>
                        </div>
						<div class="col-sm-6 mb-3 mb-sm-0">
						    <label name="employeeId">Employee Id </label>
						    <input name="employeeId" id="employeeId" class="form-control form-control-user" readonly/>
						</div>
                    </div>
                    <div class="form-group row">
						<div class="col-sm-3 mb-3 mb-sm-0">
						    <form:label path="month">Month </form:label>
						    <form:input path="month" class="form-control form-control-user" type="number" />
						    <form:errors path="month" cssClass="invalid-feedback d-block" />
						</div>
                        <div class="col-sm-3 mb-3 mb-sm-0">
                            <form:label path="workDay">Work Day </form:label>
                            <form:input path="workDay" class="form-control form-control-user" type="number" />
							<form:errors path="workDay" cssClass="invalid-feedback d-block" />
                        </div>
                        <div class="col-sm-6 mb-3 mb-sm-0">
                                <form:label path="allowance">Allowance </form:label>
                                <form:input path="allowance" class="form-control form-control-user" type="number" readonly="true" />
                                <form:errors path="allowance" cssClass="invalid-feedback d-block" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                            <form:label path="insurance">Insurance </form:label>
                            <form:input path="insurance" class="form-control form-control-user" readonly="true" />
                        </div>
                        <div class="col-sm-6 mb-3 mb-sm-0">
                                <form:label path="salary">Salary </form:label>
                                <form:input path="salary" class="form-control form-control-user" type="number" readonly="true" />
                                <form:errors path="salary" cssClass="invalid-feedback d-block" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                            <form:label path="status">Status </form:label>
                            <form:input path="status" class="form-control form-control-user" />
                        </div>
                        <div class="col-sm-6 mb-3 mb-sm-0">
                            <form:label path="note">Note </form:label>
                            <form:textarea path="note" class="form-control form-control-user" />
	                    </div>
                    </div>
                </form:form>
            </div>
	        <div class="modal-footer">
				<button id="calculateSalary" class="btn btn-success" type="submit">Calculate</button>
				<button id="saveSalary" class="btn btn-success" type="button" disabled>Save</button>
				<button id="exportSalary" class="btn btn-success" type="button" disabled>Export</button>
	            <button id="cancelCalculate" class="btn btn-secondary" type="button" data-dismiss="modal" onclick="hideSalaryModal()">Cancel</button>
	        </div>
		</div>
    </div>
</div>
