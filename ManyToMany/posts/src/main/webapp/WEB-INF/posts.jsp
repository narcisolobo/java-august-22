<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>POSTS</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <span class="navbar-brand mb-0 h1">Welcome, ${user.username}</span>
            <div class="d-flex justify-content-end align-items-center ms-auto gap-3">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/posts/new">Add Post</a>
                    </li>
                </ul>
                <a href="/users/logout" class="btn btn-sm btn-outline-light">LOGOUT</a>
            </div>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col">
                <c:forEach var="post" items="${posts}">
                    <div class="card mb-3">
                        <div class="card-body">
                            <h5 class="card-title">${post.creator.username}</h5>
                            <p class="card-text">${post.content}</p>
                        </div>
                        <div class="card-footer d-flex justify-content-end gap-2">
                            <c:choose>
                                <c:when test="${post.usersWhoLiked.contains(user)}">
                                    <form action="/posts/${post.id}/unlike" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input type="submit" value="UNLIKE" class="btn btn-sm btn-primary">
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="/posts/${post.id}/like" method="post">
                                        <input type="submit" value="LIKE" class="btn btn-sm btn-primary">
                                    </form>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${post.creator.id == user.id}">
                                    <a href="/posts/${post.id}/edit" class="btn btn-sm btn-warning">EDIT</a>
                                    <form action="/posts/${post.id}/delete" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input type="submit" value="DELETE" class="btn btn-sm btn-danger">
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <a href="/posts/${post.id}/edit" class="btn btn-sm btn-warning disabled">EDIT</a>
                                    <form action="/posts/${post.id}/delete" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input disabled type="submit" value="DELETE" class="btn btn-sm btn-danger">
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>