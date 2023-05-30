<%--
  Created by IntelliJ IDEA.
  User: azrae
  Date: 5/29/2023
  Time: 1:41 AM
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

<%--<div style=" width:1300px;height:100px;margin-lef:450px;background-color: aliceblue;border: red 1px solid"></div>--%>


<br><br>
<table border="1" cellspacing="0" align="center" class="con-b">
  <thead>

  <%--    `userAccount``userName``userSex``userBirthday``userIdCard``userIdentify``userOtherName`--%>
  <tr class="row" style="color: black;font-size: 25px" >
    <td class="lf">Course ID</td>
    <td class="lf">Course Name</td>
    <td class="lf" style="width: 10%">Course Time</td>

    <c:if test="${session_person.getUserIdentify()!=0}">
      <td class="lf">生日</td>
      <td class="lf">身份证号码</td>
      <td class="lf">角色</td>
    </c:if>

    <!--  <td class="lf">其他名称</td> -->

    <c:if test="${session_person.getUserIdentify()!=0}">
      <td>删除</td>
    </c:if>

    <td style="width: 10%">Add</td>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${arr}" var="course">
    <tr>
      <td class="lf">${course.getCourseId()}</td>
      <td class="lf">${course.getCourseName()}</td>
      <td class="lf">${course.getCourseTime()}</td>
      <c:if test="${session_person.getUserIdentify()!=0}">
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
      </c:if>

      <!-- <td class="lf">${person.getUserOtherName()}</td> -->

      <c:if test="${session_person.getUserIdentify()==1}">
        <td>
          <img src="del.png" onclick="deleteThisPersonByTeacher('${person.getUserAccount()}')">
        </td>

      </c:if>

      <c:if test="${session_person.getUserIdentify()==2}">
        <td>
          <img src="del.png" onclick="delThisPerson('${person.getUserAccount()}','${person.getUserIdentify()}')">
        </td>

      </c:if>

      <c:if test="${session_person.getUserIdentify()!=0}">
        <td>
          <c:if test="${session_person.getUserIdentify()==1}">
            <img style="width: 40px;height: 40px" src="detail.jpg" onclick="detailTask('${person.getUserAccount()}')">
            <%--                     <img src="detail.jpg" onclick="detailTask('${person.getUserAccount()}')">--%>
          </c:if>

          <c:if test="${session_person.getUserIdentify()==2}">
            <img src="up.jpg" onclick="upThisPerson('${person.getUserAccount()}')">
          </c:if>
        </td>
      </c:if>



      <c:if test="${session_person.getUserIdentify()==0}">
        <td><img style="width:40px;height: 40px" onclick="addClass('${course.getCourseId()}','${course.getCourseName()}')" src="addCourse.png"></td>


      </c:if>
    </tr>

  </c:forEach>

  </tbody>

</table>

</body>

<script>
  function delThisPerson(userAccount,userIdentify) {
    window.location.href = "man.action?action=delThisPerson&userAccount="+userAccount+"&userIdentify="+userIdentify
  }

  function addTeacher(teacherAccount) {
    window.location.href = "student.action?action=addTeacher&teacherAccount="+teacherAccount
  }

  function addClass(courseId,userAccount,courseName) {
    window.location.href = "student.action?action=addClass&userAccount="+userAccount+"&courseName="+courseName+"&courseId="+courseId

  }

  function detailTask(studentAccount) {
    window.location.href = "tea.action?action=goStudentTaskDetail&studentAccount="+studentAccount;
  }
  function deleteThisPersonByTeacher(studentAccount) {
    alert(studentAccount)
    window.location.href = "tea.action?action=deleteThisPersonByTeacher&studentAccount="+studentAccount
  }
  function upThisPerson(userAccount) {
    alert("修改:"+userAccount)
  }
</script>
</html>

