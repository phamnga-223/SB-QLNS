<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	
	<!-- Custom fonts for this template -->
		<link href="${pageContext.request.contextPath}/resources/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		        rel="stylesheet">	
		<link href="${pageContext.request.contextPath}/resources/css/datatables/dataTables.bootstrap4.min.css">			
		<link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
	<!-- Page Wrapper -->
		   <div id="wrapper">

		       <!-- Sidebar -->
		       <jsp:include page="../common/side-bar.jsp"/>
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
						   <jsp:include page="../common/top-bar.jsp"/>	                
						   
		               </nav>
					   <!-- End of Topbar -->

					   	               <!-- Begin Page Content -->
					   	               <div class="container-fluid">

					   	                   <!-- Page Heading -->
					   	                   <h1 class="h3 mb-2 text-gray-800">List Employees Information</h1>
										   <c:choose>
												<c:when test="${result != null && result != ''}">
											   		<div>Result: ${result}</div>
											   </c:when>
										   </c:choose>
										   <div>
										   		<a href="/employee/add">Add New Employee</a>
										   	</div>
					   	                 
					   	                   <!-- DataTales Example -->
					   	                   <div class="card shadow mb-4">
					   	                       <div class="card-body">
					   	                           <div class="table-responsive">
					   	                               <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
					   	                                   <thead>
					   	                                       <tr>																
																	<th>Id</td>
																	<th>Name</th>
																	<th>Phone</th>
																	<th>Work Day</th>
																	<th>Salary Per Day</th>
																	<th>Department</th>
																	<th>Stock</th>
																	<th>Action</th>
					   	                                       </tr>
					   	                                   </thead>
					   	                                   <tfoot>
					   	                                       <tr>
																<th>Id</td>
																																	<th>Name</th>
																																	<th>Phone</th>
																																	<th>Work Day</th>
																																	<th>Salary Per Day</th>
																																	<th>Department</th>
																																	<th>Stock</th>
																																	<th>Action</th>
					   	                                       </tr>
					   	                                   </tfoot>
					   									   <tbody>
					   										<c:choose>
					   											<c:when test="${listEmployee == null || listEmployee.size() == 0}">
					   												<tr>
					   													<td>List Employee is Empty!</td>
					   												</tr>
					   											</c:when>
					   											<c:otherwise>
					   														<c:forEach items="${listEmployee}" var="e">
					   															<tr>
					   																<th scope="row">${e.getId()}</th>
					   																<td>${e.getName()}</td>
					   																<td>${e.getPhone()}</td>
																					<td>${e.getWorkDay()}</td>
																					<td>${e.getSalaryPerDay()}</td>
																					<td>${e.getDepartment()}</td>
																					<td>
																						<c:choose>
																							<c:when test="${e.getClass().name == 'com.example.demo.entity.Director'}">
																								${e.getStock()}
																							</c:when>
																						</c:choose>
																					</td>
																					<td><a href="/employee/update?id=${e.getId()}">Update Employee</a></td>
					   															</tr>
					   														</c:forEach>
					   											</c:otherwise>	
					   										</c:choose>	
					   										</tbody>
					   	                               </table>
					   	                           </div>
					   	                       </div>
					   	                   </div>

					   	               </div>
					   	               <!-- /.container-fluid -->
									   
					<!-- Footer -->
		           <jsp:include page="../common/footer.jsp"/>
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
		
		<script src="${pageContext.request.contextPath}/resources/js/datatables/jquery.dataTables.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/datatables/dataTables.bootstrap4.min.js"></script>
		
		<!-- Custom JS -->
		<script src="${pageContext.request.contextPath}/resources/js/custom/table.js"></script>	
</body>
</html>
