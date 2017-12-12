<%--
  Created by IntelliJ IDEA.
  User: Andrew
  Date: 11/15/2017
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/bootstrap-theme.min.css"/>"/>
    <%-- <link rel="stylesheet" type="text/css" href="<s:url value="/css/home.css"/>" /> --%>
    <%--<link rel="stylesheet" type="text/css" href="<s:url value="/css/table.css"/> "/>--%>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/form-styles.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/breadcrumb.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/navbar.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/button-design.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/chairman.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/sidenavbar.css"/>"/>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript" src="<s:url value="/js/jquery-2.1.4.min.js"/>"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src="<s:url value="/js/committeeList.js"/>"></script>

    <title>eRSPG</title>

</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>


<div class="wrapper">
    <nav id="sidebar" class="sidebar">
        <!-- Sidebar Header -->
        <div class="sidebar-header">
            <h3>Chair Dashboard</h3>
        </div>

        <!-- Sidebar Links -->
        <ul class="list-unstyled components">
            <li><a class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chair/home'" value="Chairman Home">Home</a></li>
            <li class="active"><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chair/committee'" value="Manage Committee">Manage Committee</a></li>
            <li><a class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chair/manageBudget'" value="Manage Budget">Manage Budget</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chair/proposal'" value="Chairman Proposals">Proposals</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href = '/eRSPG/chair/makeAnnouncement'" value="Announcement">Make Announcement</a></li>
        </ul>
    </nav>

    <!-- Page Content -->
    <div id="content" class="main">
        <h1>Manage Committee</h1>

        <br>

        <div id="window">
            <table id="usersTable" class="table">
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Actions</th>
                </tr>
                <%-- Put a foreach here to display all the reviewers --%>
                <tr>
                    <td>Yong Zhang</td>
                    <td>yongzhang@weber.edu</td>
                    <td>EAST</td>
                    <td>
                        <button class="btn my-btn" onclick="removeButtonPressed(this)">Remove</button>
                        <button class="btn my-btn" onclick="editButtonPressed(this)">Edit</button>
                    </td>
                </tr>
                <tr>
                    <td>Rieneke Holman</td>
                    <td>rienekeholman@weber.edu</td>
                    <td>HP</td>
                    <td>
                        <button class="btn my-btn" onclick="removeButtonPressed(this)">Remove</button>
                        <button class="btn my-btn" onclick="editButtonPressed(this)">Edit</button>
                    </td>
                </tr>
            </table>
            <button id="newButton" class="btn my-btn" onclick="newButtonPressed()">Add New</button>

            <hr/>

            <button class="btn my-btn" onclick="window.location.href = '/eRSPG/chair/changeChair'">Assign New Chair</button>

            <script>

                var editRow = 0;

                function removeButtonPressed(b) {
                    var name = $(b).closest('tr').find('td:first').text();
                    var c = confirm("Are you sure you want to remove " + name + " from the committee?");
                    if (!c) return;
                    $(b).closest('tr').remove();
                }

                function editButtonPressed(b) {
                    editRow = $(b).closest('tr')[0];
                    var cells = editRow.cells;
                    cells[0].innerHTML = "<input value=\"" + cells[0].innerHTML + "\" id=\"nameInput\" class=\"form-control\" type=\"text\" placeholder=\"Name\" required=\"true\" />";
                    cells[1].innerHTML = "<input value=\"" + cells[1].innerHTML + "\" id=\"emailInput\" class=\"form-control\" type=\"text\" placeholder=\"Email Address\" required=\"true\" />";
                    cells[2].innerHTML = "<input value=\"" + cells[2].innerHTML + "\" id=\"departmentInput\" class=\"form-control\" type=\"text\" placeholder=\"Department\" required=\"true\" />";
                    cells[3].innerHTML = "<button class=\"btn my-btn\" onclick=\"saveButtonPressed()\">Save</button>";
                }

                function newButtonPressed() {
                    $("#newButton").hide();
                    editRow = $("#usersTable")[0].insertRow();
                    var nameCell = editRow.insertCell();
                    nameCell.innerHTML = "<input id=\"nameInput\" class=\"form-control\" type=\"text\" placeholder=\"Name\" required=\"true\" />";
                    var emailCell = editRow.insertCell();
                    emailCell.innerHTML = "<input id=\"emailInput\" class=\"form-control\" type=\"text\" placeholder=\"Email Address\" required=\"true\" />";
                    var departmentCell = editRow.insertCell();
                    departmentCell.innerHTML = "<input id=\"departmentInput\" class=\"form-control\" type=\"text\" placeholder=\"Department\" required=\"true\" />";
                    var saveCell = editRow.insertCell();
                    saveCell.innerHTML= "<button class=\"btn my-btn\" onclick=\"saveButtonPressed()\">Save</button>"
                }

                function saveButtonPressed() {
                    var cells = editRow.cells;
                    cells[0].innerHTML = $("#nameInput").val();
                    cells[1].innerHTML = $("#emailInput").val();
                    cells[2].innerHTML = $("#departmentInput").val();
                    cells[3].innerHTML = "<button class=\"btn my-btn\" onclick=\"removeButtonPressed(this)\">Remove</button><button class=\"btn my-btn\" onclick=\"editButtonPressed(this)\">Edit</button>";
                    editRow = 0;
                    $("#newButton").show();
                }
            </script>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

<%--<script type="text/javascript">
    $(document).ready(function() {
        var list = [
            "Yong",
            "Dan",
            "Brian"
        ];
        $("#searchEmail").autocomplete({source: list});
    })
</script>--%>
</body>
</html>