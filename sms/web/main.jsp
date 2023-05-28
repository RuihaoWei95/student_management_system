<%--
  Created by IntelliJ IDEA.
  User: azrae
  Date: 5/24/2023
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

      #navigation{
        float:left;
        border: grey 1px solid;
      }

      #file{
        width: 230px;
        height: 50px;
        margin-left: 11px;
        margin-top: 10px;
        border: grey 1px solid;
        background-color: mediumslateblue;
      }
      a{
          color: white;
          front-size: 26px;
          margin-left: 30px;
          margin-top: 25px;
      }
    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link href="${pageContext.request.contextPath}/css/table.css" rel="stylesheet" media="screen">
</head>
<body>
<span style="color: grey; margin-right: 120px"> User: ${session_person.userName}</span>
<br><br>
<div id="navigation">
    <%-- if student--%>
    <c:if test="${session_person.getUserIdentify()==0}">
        <li id="file"><a href="common.action?action=index">main page</a></li>
        <li id="file"><a href="common">my profile</a></li>
        <li id="file"><a href="common">course enrollment</a></li>
        <li id="file"><a href="common">course details</a></li>
        <li id="file"><a href="outLogin">exist</a></li>
    </c:if>
    <%-- if teacher--%>
    <c:if test="${session_person.getUserIdentify()==1}">
        <li id="file"><a href="common.action?action=index">main page</a></li>
        <li id="file"><a href="tea.action?action=list">student management</a></li>
        <li id="file"><a href="tea.action?action=goMyTask">task management</a></li>
        <li id="file"><a href="common">my profile</a></li>
        <li id="file"><a href="outLogin">exist</a></li>
    </c:if>
    <%-- if admin --%>
    <c:if test="${session_person.getUserIdentify()==2}">
        <li id="file"><a href="common.action?action=index">main page</a></li>
        <li id="file"><a href="man.action?action=list">people management</a></li>
        <li id="file"><a href="common">instructor management</a></li>
        <li id="file"><a href="common">student management</a></li>
        <li id="file"><a href="outLogin">exist</a></li>
    </c:if>
</div>

<jsp:include page="${mainRight=null?'blank.jsp':mainRight}"></jsp:include>
</body>
</html>
