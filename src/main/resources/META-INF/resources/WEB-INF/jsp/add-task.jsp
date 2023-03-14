<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
        <title>Add Task</title>
    </head>

    <body>
        <div class="container">
            <h1>Enter Task Details</h1>

            <form:form method="post">

                <label for="taskname"><b>Task Name:</b></label>
                <input type="text" placeholder="Enter task description" id="taskname" name="taskname" required />

                <label for="duedate"><b>Due:</b></label>
                <input type="datetime-local" id="duedate" name="duedate" />

                <input type="submit" class="btn btn-success" value="Add"/>

            </form:form>

        </div>

        <script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.3/jquery.min.js"></script>

    </body>

</html>
