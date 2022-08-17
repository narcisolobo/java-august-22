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
    <title>The WatchList</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3 text-light">
        <div class="container">
            <span class="navbar-brand mb-0 h1">THE WATCHLIST</span>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="navbarNav" class="collapse navbar-collapse me-auto">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/movies">Movie Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/movies/new">Add a Movie</a>
                    </li>
                </ul>
                <div class="d-flex align-items-center gap-3 ms-auto">
                    <p class="nav-text mb-0">Welcome, ${user.username}</p>
                    <a href="/users/logout" class="btn btn-sm btn-outline-light">LOGOUT</a>
                </div>
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
                            <td class="align-middle">
                                <a href="/movies/${movie.id}">${movie.title}</a>
                            </td>
                            <td class="align-middle">${movie.genre}</td>
                            <td class="align-middle">${movie.releaseYear}</td>
                            <c:choose>
                                <c:when test="${movie.creator.id == user.id}">
                                    <td class="d-flex gap-2">
                                        <a href="/movies/${movie.id}/edit" class="btn btn-sm btn-warning">EDIT</a>
                                        <form action="/movies/${movie.id}/delete" method="post">
                                            <input type="hidden" name="_method" value="delete">
                                            <input type="submit" value="DELETE" class="btn btn-sm btn-danger">
                                        </form>
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td class="d-flex gap-2">
                                        <a href="/movies/${movie.id}/edit" class="btn btn-sm btn-warning disabled">EDIT</a>
                                        <form action="/movies/${movie.id}/delete" method="post">
                                            <input type="hidden" name="_method" value="delete">
                                            <input disabled type="submit" value="DELETE" class="btn btn-sm btn-danger">
                                        </form>
                                    </td>
                                </c:otherwise>
                            </c:choose>
                            <td class="align-middle">SEEN</td>
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
                        <c:forEach var="movie" items="${usersMovies}">
                        <tr>
                            <td class="align-middle">
                                <a href="/movies/${movie.id}">${movie.title}</a>
                            </td>
                            <td class="align-middle">${movie.genre}</td>
                            <td class="align-middle">${movie.releaseYear}</td>
                            <td class="d-flex gap-2">
                                <a href="/movies/${movie.id}/edit" class="btn btn-sm btn-warning">EDIT</a>
                                <form action="/movies/${movie.id}/delete" method="post">
                                    <input type="hidden" name="_method" value="delete">
                                    <input type="submit" value="DELETE" class="btn btn-sm btn-danger">
                                </form>
                            </td>
                            <td class="align-middle">SEEN</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>