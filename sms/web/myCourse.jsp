<%--
  Created by IntelliJ IDEA.
  User: azrae
  Date: 5/29/2023
  Time: 2:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
    table{
      width: 1300px;
    }
    tr,td{
      border: grey 1px ;
    }
    td{
      height: 40px;
    }

    table td{
      height: 60px;
      vertical-align: middle!important;  /*设置文字垂直居中*/
      text-align: center;
    }

    tr,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}

    th{font-weight:bold;background:#ccc;}

    .con-b .row .lf{
      width: 15%;
      text-align: center;
      padding: 10px;
    }
    .con-b .row .rg{
      width: 85%;
    }

    .con-b tr:nth-of-type(odd){
      background-color: #f2f2f2;
    }

    #content{
      width: 1300px;
      height: 70px;
      float: right;
      border: grey 1px solid;
      margin-right: 40px;
      color: grey;
      font-size: 50px;

    }


  </style>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<br><br>
<table border="1" cellspacing="0" align="center" class="con-b">
  <thead>

  <%--    `userAccount``userName``userSex``userBirthday``userIdCard``userIdentify``userOtherName`--%>
  <tr class="row" style="color: black;font-size: 25px" >
    <td class="lf">Course ID</td>
    <td class="lf">Course Name</td>
    <td class="lf">Course Time</td>
    <!--<td class="lf" style="width: 10%">性别</td>-->
    <!-- <td class="lf">科目</td>-->
    <!-- <td class="lf">My</td>-->
    <td style="width: 10%">Delete</td>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${arr}" var="course">
    <tr>
      <td class="lf">${course.getCourseId()}</td>
      <td class="lf">${course.getCourseName()}</td>
      <td class="lf">${course.getCourseTime()}</td>
      <td><img style="width:40px;height: 40px" onclick="deleteThisCourse('${course.getCourseId()}')"  src="del.png"></td>
    </tr>

  </c:forEach>

  </tbody>

</table>

</body>

<script>

  function deleteThisCourse(courseId) {
    window.location.href = "student.action?action=deleteThisCourse&courseId="+courseId;
  }

</script>
</html>

