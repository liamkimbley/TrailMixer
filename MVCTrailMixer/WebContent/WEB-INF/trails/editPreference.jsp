<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Preferences</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="index.do">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="ListOfTrails.do">Trails</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="profile.do">Profile</a>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
        <a class="navbar-brand mx-auto" href="#">Trail Mixer</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="login.do">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout.do">Logout</a>
            </li>
        </ul>
    </div>
</nav>

	<h2>Preferences</h2>
	<table>
	<c:choose>
		<c:when test="${! empty preferences }">
		<c:forEach var="preference" items="${preferences}">
			<form action="EditPreferences.do" method="POST">
			<input type="hidden" name="id" value="${preference.id}">
			<%-- <input type="hidden" name="profileId" value="${profile.id}"> --%>
			<tr>
				<td>Difficulty:
						<select name="difficulty">
							<c:if test="${preference.difficulty.name == 'Expert'}">
								<option value="expert" selected>Expert</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Expert'}">
								<option value="expert">Expert</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name == 'Hard'}">
								<option value="hard" selected>Hard</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Hard'}">
								<option value="hard">Hard</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name == 'Moderate'}">
								<option value="moderate" selected>Moderate</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Moderate'}">
								<option value="moderate">Moderate</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name == 'Easy'}">
								<option value="easy" selected>Easy</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Easy'}">
								<option value="easy">Easy</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name == 'Beginner'}">
								<option value="beginner" selected>Beginner</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Beginner'}">
								<option value="beginner">Beginner</option>
							</c:if>
					</select>
				</td>
			</tr>
			<tr>
				<td>Area:
						<select name="area">
							<c:if test="${preference.difficulty.name == 'Denver'}">
								<option value="Denver" selected>Denver</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Denver'}">
								<option value="Denver">Denver</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name == 'Boulder'}">
								<option value="Boulder" selected>Boulder</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name != 'Boulder'}">
								<option value="Boulder">Boulder</option>
							</c:if>
							
					</select>
				</td>
			</tr>
			<tr>
				<td><div class="slidecontainer">
							<input type="hidden" value="${preference.distance}">
							<p>Distance:</p>
							0 <input type="range" min="1" max="20"
								name="distance" value="${preference.distance}">20+
						</td>
			</tr>
			<tr>
				<td><div class="slidecontainer">
							<input type="hidden" value="${preference.altitude}">
							<p>Altitude:</p>
							0 <input type="range" min="0" max="20000"
								name="altitude" value="${preference.altitude}"> 20,000+
						</td>
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-dark">Save Preferences</button></td>
			</tr>
			</form>
		</c:forEach>
		</c:when>
		<c:when test="${empty preferences }">
				<form action="addPreferences.do" method="POST">
				<input type="hidden" name="profileId" value="${profile.id}">
				<tr>
				<td>Difficulty:
						<select name="difficulty">
							<c:if test="${preference.difficulty.name == 'Expert'}">
								<option value="expert" selected>Expert</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Expert'}">
								<option value="expert">Expert</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name == 'Hard'}">
								<option value="hard" selected>Hard</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Hard'}">
								<option value="hard">Hard</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name == 'Moderate'}">
								<option value="moderate" selected>Moderate</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Moderate'}">
								<option value="moderate">Moderate</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name == 'Easy'}">
								<option value="easy" selected>Easy</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Easy'}">
								<option value="easy">Easy</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name == 'Beginner'}">
								<option value="beginner" selected>Beginner</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Beginner'}">
								<option value="beginner">Beginner</option>
							</c:if>
					</select>
				</td>
			</tr>
			<tr>
				<td>Area:
						<select name="area">
							<c:if test="${preference.difficulty.name == 'Denver'}">
								<option value="Denver" selected>Denver</option>
							</c:if>
							<c:if test="${preference.difficulty.name != 'Denver'}">
								<option value="Denver">Denver</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name == 'Boulder'}">
								<option value="Boulder" selected>Boulder</option>
							</c:if>
							
							<c:if test="${preference.difficulty.name != 'Boulder'}">
								<option value="Boulder">Boulder</option>
							</c:if>
							
					</select>
				</td>
			</tr>
			<tr>
				<td><div class="slidecontainer">
							<input type="hidden" value="${preference.distance}">
							<p>Distance:</p>
							0 <input type="range" min="1" max="20"
								name="distance" value="${preference.distance}">20 miles
						</td>
			</tr>
			<tr>
				<td><div class="slidecontainer">
							<input type="hidden" value="${preference.altitude}">
							<p>Altitude:</p>
							0 <input type="range" min="0" max="20000"
								name="altitude" value="${preference.altitude}"> 20,000 feet
						</td>
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-dark">Save Preferences</button></td>
			</tr>
			</form>
		</c:when>
	</c:choose>
	</table>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>