<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Friends</title>
    <style>
        body {
            margin-left: 150px;
            margin-right: 150px;
        }
    </style>
</head>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="../../SquareLogo.png" alt="TwoDue logo" style="max-width: 150px;">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="d-flex">
                <span class="me-3">Hello ${displayName != null ? displayName : showEmail},</span>
            </div>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/tasks">Tasks</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/friends">Friends</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<body>
<div class="container">
    <div class="user-info">
        <h4>Your friends are:</h4>
    </div>
    <div class="accordion" id="friendAccordion" style="padding-bottom: 15px">
        <c:forEach items="${friendList}" var="friend">
            <div class="accordion-item">
                <h2 class="accordion-header" id="heading${friend.id}">
                    <button class="accordion-button collapsed" style="background-color: #8EAA93" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${friend.id}" aria-expanded="false" aria-controls="collapse${friend.id}">
                            ${friend.friendemail}
                    </button>
                </h2>
                <div id="collapse${friend.id}" class="accordion-collapse collapse" style="background-color: #cccccc" aria-labelledby="heading${friend.id}" data-bs-parent="#friendAccordion">
                    <div class="accordion-body">
                        <p style="display:none">Friend ID: ${friend.id}</p>
                        <p>Status: ${friend.friendstatus}</p>
                        <a href="update-friend?id=${friend.id}" class="btn btn-success">Update</a>
                        <a href="delete-friend?id=${friend.id}" class="btn btn-danger">Delete</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
<a href="${pageContext.request.contextPath}/add-friend" class="btn btn-success" style="background-color: #2b4463;
            border-color: #2b4463;">Add a Friend</a>
<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.3/jquery.min.js"></script>
</div>
</body>
</html>
