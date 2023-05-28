<%--
  Created by IntelliJ IDEA.
  User: azrae
  Date: 5/28/2023
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
    table{
      width: 1200px;
    }
    tr,td{
      border: grey 1px ;
    }
    td{
      height: 40px;
    }

    table td{
      height: 60px;
      vertical-align: middle!important;
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

  </style>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>


<table border="1" cellspacing="0" align="center" class="con-b">
  <thead>
  <tr class="row" style="color: black;font-size: 25px" >
    <td class="lf">Name</td>
    <td class="lf">IdCard</td>
    <td class="lf">Score</td>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${arr}" var="student_grade">
    <tr>
      <td class="lf">${student_grade.getUserAccount()}</td>
      <td class="lf">${student_grade.getUserIdCard()}</td>
      <td class="lf">${student_grade.getGrade()}</td>
    </tr>
  </c:forEach>
  </tbody>


</table>

</body>

</html>

