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
</head>
<body>
<span style="color: grey; margin-right: 120px"> User: ${person.getUserName()}</span>
<br><br>
<div id="navigation">
  <li id="file"><a href="common">browse main page</a></li>
  <li id="file"><a href="common">student management</a></li>
  <li id="file"><a href="common">task management</a></li>
  <li id="file"><a href="common">my information</a></li>
  <li id="file"><a href="common">exist</a></li>

</div>

<jsp:include page="${mainRight=null?'blank.jsp':mainRight}"></jsp:include>
</body>
</html>
