<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

			<html lang="en">

			<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>Document</title>

				<!-- Custom fonts for this template -->
				<link href="${pageContext.request.contextPath}/resources/fontawesome-free/css/all.min.css"
					rel="stylesheet" type="text/css">
				<link
					href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
					rel="stylesheet">
				<link href="${pageContext.request.contextPath}/resources/css/datatables/dataTables.bootstrap4.min.css">
				<link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
			</head>

			<body>
				<!-- Page Wrapper -->
				<div id="wrapper">

					<!-- Sidebar -->
					<jsp:include page="../common/side-bar.jsp" />
					<!-- End of Sidebar -->

					<!-- Content Wrapper -->
					<div id="content-wrapper" class="d-flex flex-column">

						<!-- Main Content -->
						<div id="content">

							<!-- Topbar -->
							<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

								<!-- Sidebar Toggle (Topbar) -->
								<form class="form-inline">
									<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
										<i class="fa fa-bars"></i>
									</button>
								</form>

								<!-- Topbar Navbar -->
								<jsp:include page="../common/top-bar.jsp" />

							</nav>
							<!-- End of Topbar -->

							<!-- Begin Page Content -->
							<div class="container-fluid">

								<!-- Page Heading -->
								<h1 class="h3 mb-2 text-gray-800">Update Employee</h1>

								<!-- DataTales Example -->
								<div class="card shadow mb-4">
									<div class="card-body">
										<form:form action="/employee/update" method="POST" modelAttribute="e">
											<div class="form-group row">
												<div class="col-sm-6 mb-3 mb-sm-0">
													<form:label path="employeeType">Employee Type: </form:label>														
													<form:select class="form-control" path="employeeType" value="${e.getEmployeeType()}">
														  <option value="Employee" ${e.getEmployeeType() == 'Employee' ? 'selected' : ''}>Employee</option>
														  <option value="Department Manager"  ${e.getEmployeeType() == 'Department Manager' ? 'selected' : ''}>Department Manager</option>
														  <option value="Director"  ${e.getEmployeeType() == 'Director' ? 'selected' : ''}>Director</option>
													</form:select>
												</div>

												<div class="col-sm-6">
													<label name="id">Id: </label>
													<input name="id" value="${e.getId()}"
														class="form-control form-control-user" readonly />
												</div>
											</div>

											<div class="form-group row">
												<div class="col-sm-6 mb-3 mb-sm-0">
													<form:label path="name">Name: </form:label>
													<form:input path="name" class="form-control form-control-user"
														value="${e.getName()}" />
													<form:errors path="name" class="invalid-feedback d-block"/>
												</div>

												<div class="col-sm-6 mb-3 mb-sm-0">
													<form:label path="phone">Phone: </form:label>
													<form:input path="phone" class="form-control form-control-user"
														value="${e.getPhone()}" />
													<form:errors path="phone" class="invalid-feedback d-block" />
												</div>
											</div>

											<div class="form-group row">
												<div class="col-sm-6 mb-3 mb-sm-0">
													<form:label path="salaryPerDay">Salary Per day: </form:label>
													<form:input path="salaryPerDay" class="form-control form-control-user"
														value="${e.getSalaryPerDay()}" />
													<form:errors path="salaryPerDay" class="invalid-feedback d-block" />
												</div>

												<div class="col-sm-6 mb-3 mb-sm-0">
													<form:label path="workDay">Work days: </form:label>
													<form:input path="workDay" class="form-control form-control-user"
														value="${e.getWorkDay()}" />
													<form:errors path="workDay" class="invalid-feedback d-block" />
												</div>
											</div>

											<div class="form-group row">
												<div class="col-sm-6 mb-3 mb-sm-0">
													<label name="department">Department: </label>
													<input name="department" class="form-control form-control-user"
														value="${e.getDepartment()}" />
												</div>
												<div class="d-flex align-items-end">
													<button id="employeeBtn" class="btn btn-primary btn-block">Update Employee</button>
												</div>
											</div>
										</form:form>
									</div>
								</div>

							</div>
							<!-- /.container-fluid -->

						</div>
						<!-- End of Main Content -->

						<!-- Footer -->
						<jsp:include page="../common/footer.jsp" />
						<!-- End of Footer -->

					</div>
					<!-- End of Content Wrapper -->

				</div>
				<!-- End of Page Wrapper -->

				<!-- Scroll to Top Button-->
				<a class="scroll-to-top rounded" href="#page-top">
					<i class="fas fa-angle-up"></i>
				</a>

				<!-- Bootstrap core JavaScript-->
				<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

				<!-- Page level plugins -->
				<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery.min.js"></script>

				<script
					src="${pageContext.request.contextPath}/resources/js/datatables/jquery.dataTables.min.js"></script>
				<script
					src="${pageContext.request.contextPath}/resources/js/datatables/dataTables.bootstrap4.min.js"></script>

				<!-- Custom JS -->
				<script src="${pageContext.request.contextPath}/resources/js/custom/table.js"></script>
			</body>

			</html>