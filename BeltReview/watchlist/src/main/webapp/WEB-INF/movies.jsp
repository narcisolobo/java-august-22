<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Login/Register</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3 text-light">
        <div class="container">
            <span class="navbar-brand mb-0 h1">THE WATCHLIST</span>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/movies/new">Add a Movie</a>
                </li>
            </ul>
            <div class="d-flex justify-content-end align-items-center gap-3">
                <p class="nav-text mb-0">Welcome, ${user.username}</p>
                <a href="/users/logout" class="btn btn-sm btn-outline-light">LOGOUT</a>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col">
                <h4>Global WatchList</h4>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Movie Title:</th>
                            <th>Genre:</th>
                            <th>Release Year:</th>
                            <th>Actions:</th>
                            <th>Seen It?</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="movie" items="${movies}">
                        <tr>
                            <td>${movie.title}</td>
                            <td>${movie.genre}</td>
                            <td>${movie.releaseYear}</td>
                            <td>ACTIONS</td>
                            <td>SEEN</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <h4>Your WatchList</h4>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Movie Title:</th>
                            <th>Genre:</th>
                            <th>Release Year:</th>
                            <th>Actions:</th>
                            <th>Seen It?</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="movie" items="${movies}">
                        <tr>
                            <td>${movie.title}</td>
                            <td>${movie.genre}</td>
                            <td>${movie.releaseYear}</td>
                            <td>ACTIONS</td>
                            <td>SEEN</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>