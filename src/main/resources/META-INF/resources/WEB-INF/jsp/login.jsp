<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" type="text/css" href="style.css" />
    <title>Login Page</title>
</head>

<body>
<div class="container">

    <form method="post">

        <p>${errorMessage}</p>

        <img src="../../SquareLogo.png" alt="TwoDue logo">

        <label for="email"><b>Email:</b></label>
        <input type="text" placeholder="Enter Email Address" id="email" name="email" required />

        <label for="password"><b>Password:</b></label>
        <input type="password" placeholder="Enter Password" id="password" name="password" required />

        <button type="submit" class="btn">Login</button>

        <div class="signup-link">
            <p>Don't have an account? <a href="${pageContext.request.contextPath}/registration">Sign up</a></p>
        </div>


    </form>
</div>
</body>

</html>