<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" type="text/css" href="style.css" />
    <title>Login Page</title>
</head>

<body>
<div class="container">

    <form>

        <img src="../../SquareLogo.png" alt="TwoDue logo">

        <button onclick="location.href='${pageContext.request.contextPath}/tasks'" type="button" class="btn"
                style="background-color: #333333;
                color: #FFFFFF;
                padding: 14px 20px;
                margin: 20px 0 10px 0;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;">Tasks
        </button>
        <button onclick="location.href='${pageContext.request.contextPath}/friends'" type="button" class="btn"
                style="background-color: #333333;
                color: #FFFFFF;
                padding: 14px 20px;
                margin: 20px 0 10px 0;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;">Friends
        </button>
        <button onclick="location.href='${pageContext.request.contextPath}/logout'" type="button" class="btn"
                style="background-color: #333333;
                color: #FFFFFF;
                padding: 14px 20px;
                margin: 20px 0 10px 0;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                width: 100%;">Logout
        </button>

    </form>
</div>
</body>

</html>