<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="homeUrl" value="/" />
<c:url var="loginUrl" value="/spring_security_login" />
<c:url var="logoutUrl" value="/j_spring_security_logout" />
<html>
<head>
<title>Home</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" media="screen" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css.map" media="screen"
	rel="stylesheet" />
</head>
</head>
<body>
	<div class="container text-center">
		<h1>Thanks</h1>
		<p>Thank you for nominating ${passedMember}</p>
		<a href="${logoutUrl}">Log out</a>
	</div>
</body>
</html>
