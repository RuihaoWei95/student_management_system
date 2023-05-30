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
    <td class="lf">Account</td>
    <td class="lf">IdCard</td>
    <td class="lf">Score</td>
    <td>Edit</td>
  </tr>
  </thead>
  <tbody>

  <c:forEach items="${arr}" var="student_grade">
    <tr>
      <td class="lf">${student_grade.getUserName()}</td>
      <td class="lf">${student_grade.getUserAccount()}</td>
      <td class="lf">${student_grade.getUserIdCard()}</td>
      <td class="lf">${student_grade.getGrade()}</td>
      <td>
        <img src="edit.png" onclick="openEditModal('${student_grade.getUserAccount()}', '${student_grade.getGrade()}', <%= request.getAttribute("courseId") %>)" width="30" height="30" data-toggle="modal" data-target="#editModal">
      </td>
    </tr>
  </c:forEach>
  </tbody>


</table>

<!-- Edit Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true" style="display: none;">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editModalLabel">Edit Score Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="editForm">
          <input type="hidden" id="editUserAccount" name="userAccount" placeholder="userAccount" style="width: 100%;" required>
          <input type="hidden" id="editCourseId" name="courseId" placeholder="courseId" style="width: 100%;" required>
          <input type="double" id="editScore" name="score" placeholder="score" style="width: 100%;" required>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="updateScoreData( )">Save Changes</button>
      </div>
    </div>
  </div>
</div>


<script>
  function openEditModal(userAccount, score, courseId) {

    // Set the values in the edit form
    document.getElementById('editUserAccount').value = userAccount;
    document.getElementById('editCourseId').value = courseId;
    document.getElementById('editScore').value = score;

    // Show the edit modal
    $('#editModal').modal('show');
  }
</script>
<script>
  function updateScoreData() {
    // Get the updated values from the edit form
    var userAccount = document.getElementById('editUserAccount').value.toString(); // Convert to string
    var courseId = document.getElementById('editCourseId').value.toString(); // Convert to string
    var score = document.getElementById('editScore').value.toString(); // Convert to string


    // Update the values in the table
    window.location.href = "tea.action?action=editScore&score=" + score + "&courseId=" + courseId + "&userAccount=" + userAccount;
    // Hide the edit modal
    $('#editModal').modal('hide');
  }
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>

