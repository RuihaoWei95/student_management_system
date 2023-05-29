<%--
  Created by IntelliJ IDEA.
  User: azrae
  Date: 5/29/2023
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 1300px;
        }

        tr,
        td {
            border: grey 1px;
        }

        td {
            height: 40px;
        }

        table td {
            height: 60px;
            vertical-align: middle!important;
            text-align: center;
        }

        tr,
        td {
            border-right: 1px solid #888;
            border-bottom: 1px solid #888;
            padding: 5px 15px;
        }

        th {
            font-weight: bold;
            background: #ccc;
        }

        .con-b .row .lf {
            width: 15%;
            text-align: center;
            padding: 10px;
        }

        .con-b .row .rg {
            width: 85%;
        }

        .con-b tr:nth-of-type(odd) {
            background-color: #f2f2f2;
        }

        #content {
            width: 1300px;
            height: 70px;
            float: right;
            border: grey 1px solid;
            margin-right: 40px;
            color: grey;
            font-size: 50px;
        }

        .modified-cell {
            background-color: yellow;
        }
        .text-center {
            text-align: center;
        }
    </style>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<br><br>
<table border="1" cellspacing="0" align="center" class="con-b">
    <thead>
    <tr class="row" style="color: black; font-size: 25px;">
        <td class="lf">Course Name</td>
        <td class="lf">Course Id</td>
        <td class="lf">Course Time</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${arr}" var="course">
        <tr>
            <td class="lf">${course.getCourseName()}</td>
            <td class="lf">${course.getCourseId()}</td>
            <td class="lf">${course.getCourseTime()}</td>
            <td>
                <img src="edit.png" onclick="openEditModal('${course.getCourseName()}','${course.getCourseId()}','${course.getCourseTime()}')" width="30" height="30" data-toggle="modal" data-target="#editModal">
            </td>
            <td>
                <img src="delete.png" class="delete-icon" onclick="confirmDelete('${course.getCourseId()}')" alt="Delete" width="30" height="30">
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="text-center">
    <button class="btn btn-primary" onclick="openAddModal()" data-toggle="modal" data-target="#addModal"
            style="font-size: 20px; padding: 10px 20px; background-color: blue; color: white;">
        Add Course
    </button>
</div>


<!-- Edit Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Edit Course Information</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="editForm">
                    <input type="hidden" id="editCourseId" name="courseId">
                    <input type="text" id="editCourseName" name="courseName" placeholder="Course Name" style="width: 100%;" required>
                    <input type="time" id="editCourseTime" name="courseTime" placeholder="Course Time" style="width: 100%;" required>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="updateCourseData()">Save Changes</button>
            </div>
        </div>
    </div>
</div>

<!-- Add Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addModalLabel">Add Course Information</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="addForm">
                    <input type="text" id="addCourseId" name="courseId" placeholder="Course Id" style="width: 100%;" required>
                    <input type="text" id="addCourseName" name="courseName" placeholder="Course Name" style="width: 100%;" required>
                    <input type="text" id="addCourseTime" name="courseTime" placeholder="Course Time" style="width: 100%;" required>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="addCourseData()">Add Course</button>
            </div>
        </div>
    </div>
</div>



<script>

    function confirmDelete(courseId) {
        if (confirm("Are you sure you want to delete this course?")) {
            delThisCourse(courseId);
        }
    }

    function delThisCourse(courseId) {
        window.location.href = "man.action?action=delThisCourse&courseId=" + courseId;
    }


    function openEditModal(courseName, courseId, courseTime) {

        // Set the values in the edit form
        document.getElementById('editCourseName').value = courseName;
        document.getElementById('editCourseId').value = courseId;
        document.getElementById('editCourseTime').value = courseTime;

        // Show the edit modal
        $('#editModal').modal('show');
    }

    function updateCourseData() {
        // Get the updated values from the edit form
        var courseName = document.getElementById('editCourseName').value.toString(); // Convert to string
        var courseId = document.getElementById('editCourseId').value.toString(); // Convert to string
        var courseTime = document.getElementById('editCourseTime').value.toString(); // Convert to string

        // Update the values in the table
        window.location.href = "man.action?action=editThisCourse&courseName=" + courseName + "&courseId=" + courseId + "&courseTime=" + courseTime;
        // Hide the edit modal
        $('#editModal').modal('hide');
    }

    function openAddModal() {
        // Clear the input fields in the add form
        document.getElementById('addForm').reset();

        // Show the add modal
        $('#addModal').modal('show');
    }

    function addCourseData() {
        // Get the values from the input fields in the add form
        var courseName = document.getElementById('addCourseName').value.toString(); // Convert to string
        var courseId = document.getElementById('addCourseId').value.toString(); // Convert to string
        var courseTime = document.getElementById('addCourseTime').value.toString(); // Convert to string
        console.log(courseTime);

        // Add the Course data
        window.location.href = "man.action?action=addThisCourse&courseName=" + courseName + "&courseId=" + courseId + "&courseTime=" + courseTime;
        // Hide the add modal
        $('#addModal').modal('hide');
    }

</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>