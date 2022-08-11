<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Lakers Roster</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <a class="navbar-brand mb-0 h1" href="/lakers">LAKERS ROSTER</a>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="card bg-dark text-light">
                    <h5 class="card-header">Laker Details</h5>
                    <div class="card-body">
                        <h5 class="card-title">Player Name: ${laker.firstName} ${laker.lastName}</h5>
                        <ul class="list-group">
                            <li class="list-group-item"><strong>Position: </strong>${laker.position}</li>
                            <li class="list-group-item"><strong>Age: </strong>${laker.age}</li>
                            <li class="list-group-item"><strong>Height: </strong>${laker.height}</li>
                            <li class="list-group-item"><strong>Weight: </strong>${laker.weight}</li>
                            <li class="list-group-item"><strong>College: </strong>${laker.college}</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>