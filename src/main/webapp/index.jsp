<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<html>
<head>
<title>Login Page</title>
</head>
<!--  <link rel="stylesheet" type="text/css" href="CSS\index.css">-->
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Fonts -->
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">




<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<body>
	<div class="container" style="margin-top: 7em">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header"
						style="color: white; background-color: #3398FF">
						<b>Login</b>
					</div>
					
					<div class="card-body" style="background-color: #F6F5FB">
						<form action="login" method="post">
							
							<div class="form-group row">
								<label for="uname" class="col-md-4 col-form-label text-md-right">Username:</label>
								<div class="col-md-5" style="display:inline-block">
									<input type="text" id="uname" class="form-control"
										name="userName" required autofocus>
								</div>
								<div style = "text-align:center; color:red; display:inline-block">
									${invalidUsername}
								</div>
							</div>

							<div class="form-group row">
								<label for="password"
									class="col-md-4 col-form-label text-md-right">Password:</label>
								<div class="col-md-5">
									<input type="password" id="password" class="form-control"
										name="password" required>
								</div>
								<div style = "text-align:center; color:red; display:inline-block">
									${invalidPassword}
								</div>
							</div>
							<div class="col-md-6 offset-md-4">
								<a href="registration.jsp" class="btn btn-link">New
									User/Create-Account</a>
							</div>
					</div>
					<div class="card-header" style="background-color: #3398FF">
						<input type="submit" value="Login" id="btn"
							style="float: right; background-color: #020606; color: white">
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>

	
</body>
</html>

<!-- <script defer type="text/javascript">
		let username = document.getElementById("uname").value();
		console.log(username + "-----");
		let userNameRegex = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
		if (username == '') {
			alert('Please enter your name');
		} else if (!username.test(Name)) {
			alert('Username field required only alphabet characters');
		}
	</script>
 -->
