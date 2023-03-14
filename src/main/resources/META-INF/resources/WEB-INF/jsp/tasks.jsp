<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Tasks</title>
</head>

<body>
<div class="container">

    <div>${showEmail}, Your tasks are:</div>
        <table class = "table">
            <thead>
                <tr>
                    <th>Task ID</th>
                    <th>Task Name</th>
                    <th>Due Date</th>
                    <th>Status</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${taskList}" var="tasks">
                <tr>
                    <td>${tasks.tid}</td>
                    <td>${tasks.taskname}</td>
                    <td>${tasks.duedate}</td>
                    <td>${tasks.status}</td>
                    <td> <a href="update-task?id=${tasks.tid}" class="btn btn-success">Update</a> </td>
                    <td> <a href="delete-task?id=${tasks.tid}" class="btn btn-warning">Delete</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/add-task" class="btn btn-success">Add a Task</a>
    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.3/jquery.min.js"></script>

</div>
</body>
</html>
