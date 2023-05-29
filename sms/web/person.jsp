
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

<div id="content">
  <div style="float: right;height: 70px">
    <form action="man.action?action=search" method="post">
      <input type="text" name="matchText" value="search by user name" style="height: 35px;width: 500px;font-size: 28px;color: darkslateblue;border: grey solid 1px;">
      <input type="submit" style="margin-left: 6px;margin-right: 30px" value="search">
    </form>
  </div>
</div>
<br><br>
<table border="1" cellspacing="0" align="center" class="con-b">
  <thead>
  <tr class="row" style="color: black; font-size: 25px;">
    <td class="lf">User Account</td>
    <td class="lf">User Name</td>
    <td class="lf">User Birthday</td>
    <td class="lf">User Id Card</td>
    <td class="lf">User Role</td>
    <td>Edit</td>
    <td>Delete</td>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${arr}" var="person">
    <tr>
      <td class="lf">${person.getUserAccount()}</td>
      <td class="lf">${person.getUserName()}</td>
      <td class="lf">${person.getUserBirthday()}</td>
      <td class="lf">${person.getUserIdCard()}</td>
      <td class="lf">
        <c:if test="${person.getUserIdentify()==0}">
          student
        </c:if>
        <c:if test="${person.getUserIdentify()==1}">
          teacher
        </c:if>
      </td>
      <td>
        <img src="edit.png" onclick="openEditModal('${person.getUserAccount()}','${person.getUserName()}','${person.getUserBirthday()}','${person.getUserIdCard()}','${person.getUserIdentify()}')" width="30" height="30" data-toggle="modal" data-target="#editModal">
      </td>
      <td>
        <img src="delete.png" class="delete-icon" onclick="confirmDelete('${person.getUserAccount()}','${person.getUserIdentify()}')" alt="Delete" width="30" height="30">
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<div class="text-center">
  <button class="btn btn-primary" onclick="openAddModal()" data-toggle="modal" data-target="#addModal"
          style="font-size: 20px; padding: 10px 20px; background-color: blue; color: white;">
    Add Person
  </button>
</div>


<!-- Edit Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true" style="display: none;">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editModalLabel">Edit Person Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="editForm">
          <input type="hidden" id="editUserAccount" name="userAccount">
          <input type="text" id="editUserName" name="userName" placeholder="User Name" style="width: 100%;" required>
          <input type="date" id="editUserBirthday" name="userBirthday" placeholder="User Birthday" style="width: 100%;" required>
          <input type="text" id="editUserIdCard" name="userIdCard" placeholder="User ID Card" style="width: 100%;" required>
          <select id="editUserIdentify" name="userIdentify" style="width: 100%;" required>
            <option value= "0">student</option>
            <option value= "1">teacher</option>
          </select>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="updatePersonData()">Save Changes</button>
      </div>
    </div>
  </div>
</div>

<!-- Add Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true" style="display: none;">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="addModalLabel">Add Person Information</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="addForm">
          <input type="text" id="addUserAccount" name="userAccount" placeholder="User Account" style="width: 100%;" required>
          <input type="text" id="addUserName" name="userName" placeholder="User Name" style="width: 100%;" required>
          <input type="date" id="addUserBirthday" name="userBirthday" placeholder="User Birthday" style="width: 100%;" required>
          <input type="text" id="addUserIdCard" name="userIdCard" placeholder="User ID Card" style="width: 100%;" required>
          <select id="addUserIdentify" name="userIdentify" style="width: 100%;" required>
            <option value= "0">student</option>
            <option value= "1">teacher</option>
          </select>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="addPersonData()">Add Person</button>
      </div>
    </div>
  </div>
</div>



<script>

  function confirmDelete(userAccount, userIdentify) {
    if (confirm("Are you sure you want to delete this person?")) {
      delThisPerson(userAccount, userIdentify);
    }
  }

  function delThisPerson(userAccount, userIdentify) {
    window.location.href = "man.action?action=delThisPerson&userAccount=" + userAccount + "&userIdentify=" + userIdentify;
  }


  function openEditModal(userAccount, userName, userBirthday, userIdCard, userIdentify) {

    // Set the values in the edit form
    document.getElementById('editUserAccount').value = userAccount;
    document.getElementById('editUserName').value = userName;
    document.getElementById('editUserBirthday').value = userBirthday;
    document.getElementById('editUserIdCard').value = userIdCard;
    document.getElementById('editUserIdentify').value = userIdentify;

    // Show the edit modal
    $('#editModal').modal('show');
  }

  function updatePersonData() {
    // Get the updated values from the edit form
    var userAccount = document.getElementById('editUserAccount').value.toString(); // Convert to string
    var userName = document.getElementById('editUserName').value.toString(); // Convert to string
    var userBirthday = document.getElementById('editUserBirthday').value.toString(); // Convert to string
    var userIdCard = document.getElementById('editUserIdCard').value.toString(); // Convert to string
    var userIdentify = parseInt(document.getElementById('editUserIdentify').value, 10); // Convert to integer

    // Update the values in the table
    window.location.href = "man.action?action=editThisPerson&userAccount=" + userAccount + "&userName=" + userName + "&userBirthday=" + userBirthday + "&userIdCard=" + userIdCard + "&userIdentify=" + userIdentify;
    // Hide the edit modal
    $('#editModal').modal('hide');
  }

  function openAddModal() {
    // Clear the input fields in the add form
    document.getElementById('addForm').reset();

    // Show the add modal
    $('#addModal').modal('show');
  }

  function addPersonData() {
    // Get the values from the input fields in the add form
    var userAccount = document.getElementById('addUserAccount').value.toString(); // Convert to string
    var userName = document.getElementById('addUserName').value.toString(); // Convert to string
    var userBirthday = document.getElementById('addUserBirthday').value.toString(); // Convert to string
    var userIdCard = document.getElementById('addUserIdCard').value.toString(); // Convert to string
    var userIdentify = parseInt(document.getElementById('addUserIdentify').value, 10); // Convert to integer


    // Add the person data
    window.location.href = "man.action?action=addThisPerson&userAccount=" + userAccount + "&userName=" + userName + "&userBirthday=" + userBirthday + "&userIdCard=" + userIdCard + "&userIdentify=" + userIdentify;

    // Hide the add modal
    $('#addModal').modal('hide');
  }


</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
