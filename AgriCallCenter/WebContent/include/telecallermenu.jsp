<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul class="navbar-nav bg-gradient-info sidebar sidebar-dark accordion"
		id="accordionSidebar">

		<!-- Sidebar - Brand -->
		<a
			class="sidebar-brand d-flex align-items-center justify-content-center"
			href="">

			<div class="sidebar-brand-text mx-3">Call Center</div>
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Nav Item - Dashboard -->
		<li class="nav-item active"><a class="nav-link" href="telecaller.jsp">
				<i class="fas fa-fw fa-tachometer-alt"></i> <span>Staff Home</span>
		</a></li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->

		<!-- Nav Item - Pages Collapse Menu -->




		<!-- Divider -->


		<!-- Heading -->



		<hr class="sidebar-divider">
		<div class="sidebar-heading">Former</div>

		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseOne"
			aria-expanded="true" aria-controls="collapseOne"> <i
				class="fas fa-user-plus"></i> <span>Formers</span>
		</a>
			<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
				data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Formers Control:</h6>
					<a class="collapse-item" href="RegisterFormer.jsp">Register Former Inquiry</a> <a
						class="collapse-item" href="ShowFormers">Show Formers Inquiries</a>

				</div>
			</div></li>

	<li class="nav-item"><a class="nav-link" href="SearchInformations.jsp">
				<i class="fas fa-search"></i> <span>Search Information</span>
		</a></li>
		<hr class="sidebar-divider">
		<div class="sidebar-heading">Others</div>



		<li class="nav-item"><a class="nav-link" href="ChangePassword">
				<i class="fas fa-user-lock"></i> <span>Change Password</span>
		</a></li>

		<!-- Nav Item - Tables -->
		<li class="nav-item"><a class="nav-link" href="LogoutController">
				<i class="fas fa-sign-out-alt"></i> <span>Logout</span>
		</a></li>

		<!-- Divider -->
		<hr class="sidebar-divider d-none d-md-block">

		<!-- Sidebar Toggler (Sidebar) -->
		<div class="text-center d-none d-md-inline">
			<button class="rounded-circle border-0" id="sidebarToggle"></button>
		</div>

	</ul>
</body>
</html>