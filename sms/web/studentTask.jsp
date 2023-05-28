
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

  <%--    `taskAccount``studentAccount``studentAnswer``isFinish``isScore``userName``taskName`--%>
  <tr class="row" style="color: black;font-size: 25px" >
    <c:if test="${session_person.getUserIdentify()!=0}"><td class="lf">学生姓名</td></c:if>

    <td class="lf" style="width: 10%">题目</td>
    <td class="lf">答案</td>
    <td class="lf">是否完成</td>
    <td class="lf">分数</td>
    <c:if test="${session_person.getUserIdentify()==0}"><td class="lf">点击答题</td></c:if>
    <c:if test="${session_person.getUserIdentify()==1}"><td class="lf">点击批改</td></c:if>
    <td style="height:40px;width: 40px">删除</td>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${arr}" var="stuTask">
    <tr>
      <c:if test="${session_person.getUserIdentify()!=0}"><td class="lf">${stuTask.getUserName()}</td></c:if>
      <td class="lf">${stuTask.getTaskName()}</td>
      <td class="lf">${stuTask.getStudentAnswer()}</td>
      <td class="lf">
        <c:if test="${stuTask.getIsFinish()==0}">
          <span style="color: red">未完成</span>
        </c:if>
        <c:if test="${stuTask.getIsFinish()==1}">
          <span style="color: green">未批改</span>
        </c:if>
        <c:if test="${stuTask.getIsFinish()==2}">
          <span style="color: orange">未完成</span>
        </c:if>
      </td>

      <td class="lf">${stuTask.getIsScore()}</td>
      <c:if test="${session_person.getUserIdentify()==0}"><td class="lf"><button onclick="doAnswer('${stuTask.getTaskAccount()}','${stuTask.getIsFinish()}')">点击答题</button></td></c:if>
      <c:if test="${session_person.getUserIdentify()==1}"><td class="lf"><button onclick="doFenshu('${stuTask.getTaskAccount()}',${stuTask.getStudentAccount()},'${stuTask.getIsFinish()}')">点击批改</button></td></c:if>
      <td> <img src="del.png" onclick="delThisTask('${stuTask.getTaskAccount()}','${stuTask.getStudentAccount()}',${stuTask.getIsFinish()})"> </td>

    </tr>

  </c:forEach>

  </tbody>

</table>

</body>

<script>
  function deleteThisTask(taskAccount, studentAccount){
    alert("删除")
  }

</script>
</html>

