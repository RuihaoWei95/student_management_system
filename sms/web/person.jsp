
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
    <td class="lf">账户</td>
    <td class="lf">姓名</td>
    <td class="lf">性别</td>
    <td class="lf">生日</td>
    <td class="lf">身份证号码</td>
    <td class="lf">角色</td>
    <td class="lf">其他名称</td>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${arr}" var="person">
    <tr>
      <td class="lf">${person.getUserAccount()}</td>
      <td class="lf">${person.getUserName()}</td>
      <td class="lf">${person.getUserSex()}</td>
      <td class="lf">${person.getUserBirthday()}</td>
      <td class="lf">${person.getUserIdCard()}</td>
      <td class="lf">
        <c:if test="${person.getUserIdentify()==0}">
          学生
        </c:if>
        <c:if test="${person.getUserIdentify()==1}">
          老师
        </c:if>
      </td>
      <td class="lf">${person.getUserOtherName()}</td></tr>
  </c:forEach>
  </tbody>


</table>

</body>
</html>

