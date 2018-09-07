<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Trails</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
</head>
<body>


<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="index.do">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="profile.do">Profile</a>
            </li>
            <li class="nav-item">
        		<a class="nav-link" href="TrailMatches.do">Matches</a>
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
                <a class="nav-link" href="login.do">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout.do">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<h1 class="trailsTitle">Trails</h1>


<div class="listButtons">
	<form action="ListOfTrailsSorted.do" method="GET">
		Sort By: <select name="sortBy">
			<option value="none">---</option>
			<option value="difficultyHard">Difficulty (Hardest to Easiest)</option>
			<option value="difficultyEasy">Difficulty (Easiest to Hardest)</option>
			<option value="distanceFar">Distance (Farthest to Shortest)</option>
			<option value="distanceShort">Distance (Shortest to Farthest)</option>
			<option value="altitudeHigh">Altitude (Highest to Lowest)</option>
			<option value="altitudeLow">Altitude (Lowest to Highest)</option>
			<option value="rating">Rating</option>
		</select> <button type="submit" class="btn btn-dark">Search</button>
	</form>

	<form action="ListOfTrailsSearched.do" method="GET">
		Search By: <select name="searchBy">
			<option value="none">---</option>
			<option value="difficulty">Difficulty (1-5)</option>
			<option value="distance">Distance</option>
			<option value="altitude">Altitude</option>
			<option value="keyword">Keyword</option>
		</select> <input type="text" name="search"> <button type="submit" class="btn btn-dark">Search</button>
	</form>
</div>
<br>

	<div class="trailsTable">
	<fieldset style="box-shadow: 5px 5px 10px gray; display: inline-block">
		<!-- <legend> Trails </legend> -->
		<table>
			<tr>
				<th>Trail</th>
				<th>Difficulty</th>
				<th>Distance</th>
				<th>Altitude</th>
			</tr>

			<c:forEach var="t" items="${trails}">
				<tr>
					<td>${t.name}</td>
					<td>${t.difficulty.name}</td>
					<td>${t.distance} mi</td>
					<td>${t.altitude} ft</td>
					<td>
						<form action="TrailDetails.do" method="GET">
							<input type="hidden" name="tId" value="${t.id}"> <button
								type="submit" class="btn btn-dark">Trail Details</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
	</div>
	
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>