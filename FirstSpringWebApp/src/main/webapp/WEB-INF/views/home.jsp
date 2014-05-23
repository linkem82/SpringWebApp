<%@ page session="false"%>
<html>
	<head>
		<title>Home</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" media="screen" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css.map" media="screen"
			rel="stylesheet" />
			<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	</head>
	<body>
		<div class="container-fluid">
			<div class="jumbotron text-center">
				<h1>Hello world!</h1>
				<h3>
					<div class="row">
						<a href="${pageContext.request.contextPath}/nominee">Vote for a candidate</a>
					</div>
					<div class="row">
						<a href="${pageContext.request.contextPath}/users/new">Sign up</a>
					</div>
				</h3>
				<P>The time on the server is ${serverTime}.</P>
			</div>
		</div>
	</body>
</html>
