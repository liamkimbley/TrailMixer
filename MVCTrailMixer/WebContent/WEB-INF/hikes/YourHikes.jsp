<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Hikes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<link rel="stylesheet" href="styles.css">
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div
			class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="index.do">Home</a>
				</li>
				<li class="nav-item">
                	<a class="nav-link" href="profile.do">Profile</a>
            	</li>
				<li class="nav-item active"><a class="nav-link"
					href="ListOfTrails.do">Trails</a></li>
				<li class="nav-item">
        		<a class="nav-link" href="TrailMatches.do">Matches</a>
      		</li>
			</ul>
		</div>
		<div class="mx-auto order-0">
			<a class="navbar-brand mx-auto" href="#">Trail Details</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target=".dual-collapse2">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
		<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
			<ul class="navbar-nav ml-auto">
			 <li class="nav-item">
                <a class="nav-link" href="logout.do">Logout</a>
            </li>
			</ul>
		</div>
	</nav>

<div class="yourHikes">
	<h2>Your Hikes</h2>

	<c:if test="${trails == null}">
		No hikes available
	</c:if>

	<c:if test="${trails != null}">
		<table class="yourHikesTable">
			<c:forEach var="t" items="${trails}">
				<tr>
					<td>Trail Name: <a href="TrailDetails.do?tId=${t.id}">${t.name}</a></td>
				</tr>
			</c:forEach>
		</table>

	</c:if>
</div>

</body>
</html>