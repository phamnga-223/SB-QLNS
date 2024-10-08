<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	
	<!-- Custom fonts for this template -->
	<link href="${pageContext.request.contextPath}/resources/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	        rel="stylesheet">	
	<link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
		
	<link href="${pageContext.request.contextPath}/resources/css/common/pages/welcome.css" rel="stylesheet">
</head>
<body>
	<!-- Page Wrapper -->
		   

		           <!-- Main Content -->
		           <div id="page-top">

		               <!-- Topbar -->
		               <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

		                   <!-- Sidebar Toggle (Topbar) -->
		                   <form class="form-inline">
		                       <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
		                           <i class="fa fa-bars"></i>
		                       </button>
		                   </form>                
						   
		               </nav>
					   <!-- End of Topbar -->
					   
					   <!-- Begin Page Content -->
					   <!--<div class="page-top">-->						
							
							<!-- Masthead-->
							<header class="masthead">
								<div class="container px-4 px-lg-5">
									<div class="row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center">
										<div class="col-lg-8 align-self-end">
											<h1 class="text-white font-weight-bold">Manager Employee Information By SB-QLNS System</h1>
											<hr class="divider" />
										</div>
										<div class="col-lg-8 align-self-baseline">
											<p class="text-white-75 mb-5">Start SB_QLNS can help you manager employee information by Spring Boot, MySQL, Bootstrap, Jquery<p>
											<a class="btn btn-primary btn-xl" href="/company">Company</a>
											<a class="btn btn-primary btn-xl" href="/employee">Employee</a>
										</div>
									</div>
								</div>
							</header>
					   <!--</div>-->
					   <!-- /.page-top -->
									   
					<!-- Footer -->
		           <jsp:include page="../footer.jsp"/>
		           <!-- End of Footer -->
				   
				</div>
		   <!-- End of Page Wrapper -->

		   <!-- Scroll to Top Button-->
		   <a class="scroll-to-top rounded" href="#page-top">
		       <i class="fas fa-angle-up"></i>
		   </a>
	
	<!-- Bootstrap core JavaScript-->
	<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>
