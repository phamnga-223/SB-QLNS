<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	
	<!--<link href="resources/css/bootstrap.min.css" rel="stylesheet" />-->
	
	<!-- Custom fonts for this template -->
	<link href="resources/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	        rel="stylesheet">	
	<link href="resources/css/datatables/dataTables.bootstrap4.min.css">			
	<link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
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
	                   <h1 class="h3 mb-2 text-gray-800">List Company Information</h1>
	                 
	                   <!-- DataTales Example -->
	                   <div class="card shadow mb-4">
	                       <div class="card-body">
	                           <div class="table-responsive">
	                               <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                                   <thead>
	                                       <tr>
											<th>Id</th>
											<th>Name</th>
											<th>Revenue</th>
	                                       </tr>
	                                   </thead>
	                                   <tfoot>
	                                       <tr>
	                                           <th>Id</th>
	                                           <th>Name</th>
	                                           <th>Revenue</th>
	                                       </tr>
	                                   </tfoot>
									   <tbody>
										<c:choose>
											<c:when test="${listCompany == null || listCompany.size() == 0}">
												<tr>
													<td>List Company is Empty!</td>
												</tr>
											</c:when>
											<c:otherwise>
														<c:forEach items="${listCompany}" var="c">
															<tr>
																<th scope="row">${c.getId()}</th>
																<td>${c.getName()}</td>
																<td>${c.getRevenue()}</td>
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

	           </div>
	           <!-- End of Main Content -->

	           <!-- Footer -->
	           <footer class="sticky-footer bg-white">
	               <div class="container my-auto">
	                   <div class="copyright text-center my-auto">
	                       <span>SB_QLNS-2024-PhamThiNga</span>
	                   </div>
	               </div>
	           </footer>
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
	<script src="resources/js/bootstrap.min.js"></script>

	<!-- Page level plugins -->
	<script src="resources/js/jquery/jquery.min.js"></script>
	
	<script src="resources/js/datatables/jquery.dataTables.min.js"></script>
	<script src="resources/js/datatables/dataTables.bootstrap4.min.js"></script>
	
	<!-- Custom JS -->
	<script src="resources/js/custom/table.js"></script>	
</body>
</html>
