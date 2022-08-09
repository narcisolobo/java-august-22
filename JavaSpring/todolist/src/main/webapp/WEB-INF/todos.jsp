<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Todo List</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <span class="navbar-brand mb-0 h1">Todo List</span>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col">
                <h1>Welcome ${username}</h1>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-6">
                <div class="card bg-dark text-light mb-3">
                    <h5 class="card-header">Enter Your Name:</h5>
                    <div class="card-body">
                        <form action="/todos/name" method="post">
                            <div class="mb-3">
                                <label for="username" class="form-label">Username:</label>
                                <input type="text" name="username" id="username" class="form-control">
                            </div>
                            <div class="d-flex justify-content-end">
                                <input type="submit" value="SUBMIT" class="btn btn-outline-light">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-6">
                <div class="card bg-dark text-light">
                    <h5 class="card-header">Enter New Todo:</h5>
                    <div class="card-body">
                        <form action="/todos/insert" method="post">
                            <div class="mb-3">
                                <label for="description" class="form-label">Todo Description:</label>
                                <input type="text" name="description" id="description" class="form-control">
                            </div>
                            <div class="d-flex justify-content-end">
                                <input type="submit" value="SUBMIT" class="btn btn-outline-light">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="card bg-dark text-light">
                    <h5 class="card-header">Your Todos:</h5>
                    <div class="card-body">
                        <table class="table table-dark table-hover table-striped">
                            <thead>
                                <tr>
                                    <th>Description:</th>
                                    <th>Created At:</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="todo" items="${todos}">
                                    <tr>
                                        <td>${todo.description}</td>
                                        <td>
                                            <fmt:formatDate value="${todo.createdAt}" type="both" dateStyle="long" timeStyle="short" />
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>