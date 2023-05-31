<%--
  Created by IntelliJ IDEA.
  User: azrae
  Date: 5/29/2023
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">

</script>
<div class="data_list">
</div>

<form method="post" action="man.action?action=signUp" onsubmit="return checkThis()">

    <div class="data_form">
        <table align="center">
            <tr>
                <td><font color="red">*</font>account：</td>
                <td><input type="text" id="userAccount" name="userAccount"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>

            <tr>
                <td><font color="red">*</font>name：</td>
                <td><input type="text" id="userName" name="userName"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>


            <tr>
                <td><font color="red">*</font>birthday：</td>
                <td><input type="date" id="userBirthday" name="userBirthday"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>

            <tr>
                <td><font color="red">*</font>userIdCard：</td>
                <td><input type="text" id="userIdCard" name="userIdCard" style="margin-top:5px;height:30px;"/>
                </td>
            </tr>

            <tr>
                <td><font color="red">*</font>role：</td>

                <td>
                    <select id="userIdentify" name="userIdentify" style="width: 205px" ;>
                        <option id="a" value="0">student</option>
                        <option id="b" value="1">teacher</option>
                    </select>
                </td>
            </tr>


            <tr>
                <td><font color="red">*</font>enter password：</td>
                <td><input type="password" id="userPassword" name="userPassword"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>

            <tr>
                <td><font color="red">*</font>enter password again：</td>
                <td><input type="password" id="rUserPassword" name="rUserPassword"
                           style="margin-top:5px;height:30px;"/></td>
            </tr>


            <script>

                function checkThis() {
                    let userAccount = document.getElementById("userAccount").value;
                    let userName = document.getElementById("userName").value;
                    let userIdCard = document.getElementById("userIdCard").value;
                    let userPassword = document.getElementById("userPassword").value;
                    let rUserPassword = document.getElementById("rUserPassword").value;


                    if (userAccount.trim() == null || userAccount.trim() == "") {
                        document.getElementById("error").innerHTML = "Account cannot be empty";
                        return false;
                    }

                    if (userName.trim() == null || userName.trim() == "") {
                        document.getElementById("error").innerHTML = "Name can not be empty";
                        return false;
                    }

                    if (userIdCard.trim() == null || userIdCard.trim() == "") {
                        document.getElementById("error").innerHTML = "UserIdCard can not be empty";
                        return false;
                    }


                    if (userPassword == null || userPassword.trim() == "") {
                        document.getElementById("error").innerHTML = "password can not be empty";
                        return false;
                    }


                    if (rUserPassword.trim() == null || rUserPassword.trim() == "") {
                        document.getElementById("error").innerHTML = "password can not be empty";
                        return false;
                    }

                    if (rUserPassword != userPassword) {
                        document.getElementById("error").innerHTML = "password is not the same, recheck!";
                        return false;
                    }

                    // Regular expression to validate email address
                    let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                    if(emailRegex.test(userAccount) === false){
                        alert("illegal email address!");
                        return false;
                    }
                    return true;


                }


            </script>


        </table>
        <div align="center">
            <input type="submit" class="btn btn-primary" value="save"/>
            <span style="color: #dd1144" id="error">${tip}</span>
        </div>
    </div>
</form>
</div>
