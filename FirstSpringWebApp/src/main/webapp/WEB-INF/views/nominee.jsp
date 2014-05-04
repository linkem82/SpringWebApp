<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<title>Member nomination</title>
<script type="text/javascript" src="resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<link href="resources/css/bootstrap.css" media="screen" rel="stylesheet" />
<link href="resources/css/bootstrap.css.map" media="screen"
	rel="stylesheet" />
</head>
</head>
<body>
	<div class="container">
		<div>
			<h1 class="text-center">Nominate a member for the award</h1>
		</div>
		<form:form modelAttribute="member" class="form-horizontal" role="form">
			<div class="form-group">
				<label for="lastName" class="col-sm-2 control-label">Last
					Name:</label>
				<div class="col-sm-5">
					<form:input path="firstName" class="form-control" id="lastName" />
				</div>
			</div>
			<div class="form-group">
				<label for="firstName" class="col-sm-2 control-label">First
					Name:</label>
				<div class="col-sm-5">
					<form:input path="lastName" class="form-control" id="firstName" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
