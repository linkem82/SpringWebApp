<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<link href="resources/css/bootstrap.css" media="screen" rel="stylesheet" />
<link href="resources/css/bootstrap.css.map" media="screen"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="jumbotron text-center">
			<h1>Hello world!</h1>
			<h3>
				<a href="nominee">Vote for a candidate</a>
			</h3>
			<P>The time on the server is ${serverTime}.</P>
		</div>
	</div>
</body>
</html>
