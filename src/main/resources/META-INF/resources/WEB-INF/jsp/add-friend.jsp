<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Add Friend</title>
</head>

<body>
<div class="container">
    <h1>Add a Friend</h1>

    <form:form method="post">

        <label for="friendemail"><b>Friend's Email:</b></label>
        <input type="text" placeholder="Enter friend's email" id="friendemail" name="friendemail" required />

        <input type="submit" class="btn btn-success" value="Add"/>

    </form:form>

</div>

<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.3/jquery.min.js"></script>

</body>

</html>
