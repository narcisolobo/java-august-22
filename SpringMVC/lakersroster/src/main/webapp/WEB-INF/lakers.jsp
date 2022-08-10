<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Los Angeles Lakers Roster</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <span class="navbar-brand mb-0 h1">LAKERS ROSTER</span>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Player Name</th>
                            <th>Position</th>
                            <th>Age</th>
                            <th>Height</th>
                            <th>Weight</th>
                            <th>College</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="laker" items="${allLakers}">
                            <tr>
                                <td>${laker.firstName} ${laker.lastName}</td>
                                <td>${laker.position}</td>
                                <td>${laker.age}</td>
                                <td>${laker.height}</td>
                                <td>${laker.weight}</td>
                                <td>${laker.college}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>