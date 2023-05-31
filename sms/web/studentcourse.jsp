<%--
  Created by IntelliJ IDEA.
  User: azrae
  Date: 5/29/2023
  Time: 8:07 PM
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
    <td class="lf">UID</td>
    <td class="lf">User Account</td>
    <td class="lf">Course Id</td>
    <td class="lf">Score</td>
    <td>Edit</td>
    <td>Delete</td>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${arr}" var="studentCourse">
    <tr>
      <td class="lf">${studentCourse.getUID()}</td>
      <td class="lf">${studentCourse.getUserAccount()}</td>
      <td class="lf">${studentCourse.getCourseId()}</td>
      <td class="lf">${studentCourse.getScore()}</td>
      <td>
        <img src="edit.png" onclick="openEditModal('${studentCourse.getUID()}','${studentCourse.getUserAccount()}','${studentCourse.getCourseId()}','${studentCourse.getScore()}')" width="30" height="30" data-toggle="modal" data-target="#editModal">
      </td>
      <td>
        <img src="delete.png" class="delete-icon" onclick="confirmDelete('${studentCourse.getUID()}')" alt="Delete" width="30" height="30">
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<div class="text-center">
  <button class="btn btn-primary" onclick="openAddModal()" data-toggle="modal" data-target="#addModal"
          style="font-size: 20px; padding: 10px 20px; background-color: blue; color: white;">
    Add Record
  </button>
</div>


<!-- Edit Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true" style="display: none;">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editModalLabel">Edit Student Course Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="editForm">
          <input type="hidden" id="editUID" name="UID">
          <select id="editUserAccount" name="userAccount" style="width: 100%;" required>
            <c:forEach items="${studentArr}" var="person">
              <option value="${person.userAccount}">${person.userAccount}</option>
            </c:forEach>
          </select>
          <select id="editCourseId" name="courseId" style="width: 100%;" required>
            <c:forEach items="${courseArr}" var="course">
              <option value="${course.courseId}">${course.courseId}</option>
            </c:forEach>
          </select>
          <input type="number" id="editScore" name="score" placeholder="Score" style="width: 100%;" step="any" required>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="updateStudentCourseData()">Save Changes</button>
      </div>
    </div>
  </div>
</div>

<!-- Add Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true" style="display: none;">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addModalLabel">Add Student Course Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="addForm">
          <input type="hidden" id="addUID" name="UID">
          <select id="addUserAccount" name="userAccount" style="width: 100%;" required>
            <c:forEach items="${studentArr}" var="person">
              <option value="${person.userAccount}">${person.userAccount}</option>
            </c:forEach>
          </select>
          <select id="addCourseId" name="courseId" style="width: 100%;" required>
            <c:forEach items="${courseArr}" var="course">
              <option value="${course.courseId}">${course.courseId}</option>
            </c:forEach>
          </select>
          <input type="number" id="addScore" name="score" placeholder="Score" style="width: 100%;" step="any" required>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="addStudentCourseData()">Add Student Course</button>
      </div>
    </div>
  </div>
</div>



<script>

  function confirmDelete(UID) {
    if (confirm("Are you sure you want to delete this course?")) {
      delThisStudentCourse(UID);
    }
  }

  function delThisStudentCourse(UID) {
    window.location.href = "man.action?action=delThisStudentCourse&UID=" + UID;
  }


  function openEditModal(UID, userAccount, courseId, score) {

    // Set the values in the edit form
    document.getElementById('editUID').value = UID;
    document.getElementById('editUserAccount').value = userAccount;
    document.getElementById('editCourseId').value = courseId;
    document.getElementById('editScore').value = score;

    // Show the edit modal
    $('#editModal').modal('show');
  }

  function updateStudentCourseData() {
    // Get the updated values from the edit form
    var UID = document.getElementById('editUID').value.toString(); // Convert to string
    var userAccount = document.getElementById('editUserAccount').value.toString(); // Convert to string
    var courseId = document.getElementById('editCourseId').value.toString(); // Convert to string
    var score = parseFloat(document.getElementById('editScore').value); // Parse the score as a float
    // Update the values in the table
    window.location.href = "man.action?action=editThisStudentCourse&UID=" + UID + "&userAccount=" + userAccount + "&courseId=" + courseId + "&score=" + score;

    // Hide the edit modal
    $('#editModal').modal('hide');
  }


  function openAddModal() {
    // Clear the input fields in the add form
    document.getElementById('addForm').reset();

    // Show the add modal
    $('#addModal').modal('show');
  }

  function addStudentCourseData() {
    // Get the values from the input fields in the add form
    var userAccount = document.getElementById('addUserAccount').value.toString(); // Convert to string
    var courseId = document.getElementById('addCourseId').value.toString(); // Convert to string
    var score = parseFloat(document.getElementById('addScore').value); // Parse the score as a float
    console.log("hi",score);
    // Add the Course data
    window.location.href = "man.action?action=addThisStudentCourse&userAccount=" + userAccount + "&courseId=" + courseId + "&score=" + score;

    // Hide the add modal
    $('#addModal').modal('hide');
  }


</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>