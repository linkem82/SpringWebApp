<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
	<head>
		<title>Registration</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" media="screen" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css.map" media="screen"
			rel="stylesheet" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<h1 class="col-sm-offset-3 col-sm-9">Insert your data</h1>
			</div>
			<div class="row">
				<form:form modelAttribute="account" class="form-horizontal" role="form">
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<form:errors path="*">
								<div class="alert-danger form-control">
									<spring:message code="error.global" ></spring:message>
								</div>
							</form:errors>
						</div>
					</div>
					<div class="form-group">
						<label for="user_name" class="col-sm-2 col-sm-offset-1 control-label">
							Username:
						</label>
						<div class="col-sm-5">
							<form:input path="username" cssClass="form-control" cssErrorClass="form-control has-error" id="user_name" />
							<div><form:errors cssClass="form-control alert-danger" path="username" htmlEscape="false"/></div>						
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 col-sm-offset-1 control-label">
							Password:
						</label>
						<div class="col-sm-5">
							<form:input path="password" type="password" class="form-control" id="password" />
							<div><form:errors cssClass="form-control alert-danger" path="password" htmlEscape="false"/></div>						
						</div>
					</div>
					<div class="form-group">
						<label for="confirmPassword" class="col-sm-2 col-sm-offset-1 control-label">
							Confirm password:</label>
						<div class="col-sm-5">
							<form:input path="confirmPassword" type="password" class="form-control" id="confirmPassword" />
						</div>
					</div>
					<div class="form-group">
						<label for="firstName" class="col-sm-2 col-sm-offset-1 control-label">
							First Name:</label>
						<div class="col-sm-5">
							<form:input path="firstName" class="form-control" id="firstName" />
							<div><form:errors cssClass="form-control alert-danger" path="firstName" htmlEscape="false"/></div>
						</div>
					</div>
					<div class="form-group">
						<label for="lastName" class="col-sm-2 col-sm-offset-1 control-label">
							Last Name:</label>
						<div class="col-sm-5">
							<form:input path="lastName" class="form-control" id="lastName" />
							<div><form:errors cssClass="form-control alert-danger" path="lastName" htmlEscape="false"/></div>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 col-sm-offset-1 control-label">
							E-mail address:</label>
						<div class="col-sm-5">
							<form:input path="email" class="form-control" id="email" />
							<div><form:errors cssClass="form-control alert-danger" path="email" htmlEscape="false"/></div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
					      <div class="checkbox">
					        <label>
					        	<form:checkbox path="marketingOk"/> Please send me products updates by e-mail.
					        </label>
					      </div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
					      <div class="checkbox">
					        <label>
					          <form:checkbox path="acceptTerms"/> I accept the terms of use.
					          <div ><form:errors cssClass="form-control alert-danger" path="acceptTerms" htmlEscape="false"/></div>
					        </label>
					      </div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-default">Submit</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</body>
</html>
