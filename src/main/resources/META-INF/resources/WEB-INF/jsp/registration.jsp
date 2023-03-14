<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" type="text/css" href="style.css" />
    <title>Registration Page</title>
</head>

<body>
<div class="container">

    <form method="post">

        <h3>Registration</h3>

        <img src="../../SquareLogo.png" alt="TwoDue logo">

        <label for="firstname"><b>First Name:</b></label>
        <input type="text" placeholder="Enter First Name" id="firstname" name="firstname" />

        <label for="lastname"><b>Last Name:</b></label>
        <input type="text" placeholder="Enter Last Name" id="lastname" name="lastname" />

        <label for="displayname"><b>Display Name:</b></label>
        <input type="text" placeholder="Enter Your Desired Display Name" id="displayname" name="displayname" />

        <label for="email"><b>Email:</b></label>
        <input type="text" placeholder="Enter Email Address" id="email" name="email" required />

        <p>${emailExistsError}</p>

        <label for="confirmEmail"><b>Confirm Email:</b></label>
        <input type="text" placeholder="Confirm Email Address" id="confirmEmail" name="confirmEmail" required />

        <p>${emailMatchError}</p>

        <label for="password"><b>Password:</b></label>
        <input type="password" placeholder="Enter Password" id="password" name="password" required />

        <label for="confirmPassword"><b>Confirm Password:</b></label>
        <input type="password" placeholder="Confirm Password" id="confirmPassword" name="confirmPassword" required />

        <p>${passwordMatchError}</p>

        <button type="submit" class="btn">Register</button>

        <div class="login-link">
            <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Log In</a></p>
        </div>

    </form>
</div>
</body>
</html>