<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Tasks</title>
</head>

<body>
<div class="container">
    <div class="user-info">
        <img src="../../SquareLogo.png" alt="TwoDue logo" style="max-width: 150px; padding-bottom: 20px">
        <h3>${displayName != null ? displayName : showEmail}, Your tasks are:</h3>
    </div>
    <div class="accordion" id="taskAccordion">
        <c:forEach items="${taskList}" var="task">
            <div class="accordion-item">
                <h2 class="accordion-header" id="heading${task.tid}">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${task.tid}" aria-expanded="false" aria-controls="collapse${task.tid}">
                            ${task.taskname}
                    </button>
                </h2>
                <div id="collapse${task.tid}" class="accordion-collapse collapse" aria-labelledby="heading${task.tid}" data-bs-parent="#taskAccordion">
                    <div class="accordion-body">
                        <p style="display:none">Task ID: ${task.tid}</p>
                        <p>Due Date: ${task.duedate}</p>
                        <p>Status: ${task.status}</p>
                        <a href="update-task?id=${task.tid}" class="btn btn-success">Update</a>
                        <a href="delete-task?id=${task.tid}" class="btn btn-danger">Delete</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <a href="${pageContext.request.contextPath}/add-task" class="btn btn-success">Add a Task</a>
    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.3/jquery.min.js"></script>
</div>
</body>
</html>
