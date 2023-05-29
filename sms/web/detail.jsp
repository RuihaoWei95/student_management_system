<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 800px;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid gray;
            padding: 10px;
            text-align: left;
        }

        th {
            background: #f2f2f2;
            font-weight: bold;
        }

        .header-row {
            background-color: #ccc;
            font-size: 20px;
        }

        .row {
            font-size: 18px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
        }
    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<table>
    <tr class="header-row">
        <th>User Account</th>
        <td>${session_person.getUserAccount()}</td>
    </tr>
    <tr class="row">
        <th>User Name</th>
        <td>${session_person.getUserName()}</td>
    </tr>
    <tr class="row">
        <th>User Birthday</th>
        <td>${session_person.getUserBirthday()}</td>
    </tr>
    <tr class="row">
        <th>User ID</th>
        <td>${session_person.getUserIdCard()}</td>
    </tr>
    <tr class="row">
        <th>Course Grades</th>
        <td>
            <table>
                <tr>
                    <th>Course ID</th>
                    <th>Grade</th>
                </tr>
                <c:forEach var="course" items="${courseGrades}">
                    <tr>
                        <td>${course.courseId}</td>
                        <td>${course.score}</td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
    <tr class="row">
        <th>Enrolled Courses</th>
        <td>
            <table>
                <tr>
                    <th>Course ID</th>
                    <th>State</th>
                </tr>
                <c:forEach var="course" items="${enrolledCourses}">
                    <tr>
                        <td>${course.courseId}</td>
                        <c:if test="${course.score != 0.0}">
                            <td>Graded</td>
                        </c:if>
                        <c:if test="${course.score == 0.0}">
                            <td>Enrolled</td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
    <tr class="row">
        <th></th>
        <td>
            <button onclick="upPassword()">Modify Password</button>
        </td>
    </tr>
</table>
</body>
</html>
<script>
    function upPassword() {
        window.open("common.action?action=upPassword", null,"width=700,height=400,left=400,top=150", true);
    }
</script>
