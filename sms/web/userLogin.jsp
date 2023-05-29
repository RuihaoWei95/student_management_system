<%--
  Created by IntelliJ IDEA.
  User: azrae
  Date: 5/24/2023
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="userLogin" method="post" onsubmit="return checkLogin()">
    account:<input type="text" id = "userAccount" name="userAccount" class="myText"><br>
    password:<input type="password" id = "userPassword" name="userPassword" class="myText"><br>
    <input type="submit" value="Login">
    <input type="button" value="Signup" onclick="redirectToPage('signUp.jsp')">
    <span style="color:red" id="tip">${tip}</span>
</form>


</body>
</html>

<script>
    function checkLogin(){
        let userAccount = document.getElementById("userAccount").value;
        let userPassword = document.getElementById("userPassword").value;
        if(userAccount == null || userAccount.trim()==""){
            document.getElementById("tip").innerHTML = "account can't be empty!";
            return false;
        }
        if(userPassword == null || userPassword.trim()==""){
            document.getElementById("tip").innerHTML = "password can't be empty!";
            return false;
        }
    }

    function redirectToPage(pageURL) {
        window.location.href = pageURL;
    }
</script>
