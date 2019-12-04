<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">

<jsp:include page="header.jsp" />

<body>

	<jsp:include page="navbar.jsp" />

	<div class="container-fluid" style="margin-top: 40px">
		<div class="row">

			<jsp:include page="sidebar.jsp" />

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Dashboard</h1>
				</div>
			</main>
		</div>
	</div>
</body>

</html>