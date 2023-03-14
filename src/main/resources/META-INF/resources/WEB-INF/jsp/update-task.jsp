<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Update Task</title>
</head>

<body>
<div class="container">

    <h1>Update Task</h1>

    <form:form method="post" modelAttribute="task">
        <input type="hidden" name="tid" value="${task.tid}" />

        <label for="taskname"><b>Task Name:</b></label>
        <input type="text" id="taskname" name="taskname" value="${task.taskname}" required />

        <label for="duedate"><b>Due:</b></label>
        <input type="datetime-local" id="duedate" name="duedate" value="${task.duedate}" />

        <input type="submit" class="btn btn-success" value="Update" />
    </form:form>

    <br>
    <a href="${pageContext.request.contextPath}/tasks" class="btn btn-secondary">Back to Tasks</a>

    <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.3/jquery.min.js"></script>

</div>
</body>
</html>
