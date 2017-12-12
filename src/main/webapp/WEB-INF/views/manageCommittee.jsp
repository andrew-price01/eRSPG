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
    <link rel="stylesheet" type="text/css" href="<s:url value="/css/table.css"/> "/>
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
            <li><a class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chair/home'" value="Chair Home">Home</a></li>
            <li class="active"><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chair/committee'" value="Manage Committee">Manage Committee</a></li>
            <li><a class="btn my-btn" type="button"  onclick="window.location.href = '/eRSPG/chair/manageBudget'" value="Manage Budget">Manage Budget</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chair/proposal'" value="Chair Proposals">Proposals</a></li>
            <li><a class="btn my-btn" type="button" onclick="window.location.href = '/eRSPG/chair/makeAnnouncement'" value="Announcement">Make Announcement</a></li>
        </ul>
    </nav>

    <!-- Page Content -->
    <div id="content" class="main">
        <h1>Manage Committee</h1>

        <br>

        <div id="window">
            <h3 align="left">Committee Members</h3>
            <input type='button' class="btn btn-info" style="float: right;" id='btnAddMember' value='Add New Member'
                   onclick="addMemberDialog();">

            <div id="box1">
                <table align="center">
                    <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Manage</th>
                    </tr>
                    </thead>
                    <tbody id="members"></tbody>
                </table>

            </div>
        </div>

        <div id="dialogTabForm" style="display:none;" class="ui-helper-hidden tabdialog">
            <div id="tabs" class="tabs">
                <ul>
                    <li id="tab1" class="myTabs"><a href="#tabSearch">Search</a></li>
                    <li id="tab2" class="myTabs"><a href="#tabNew">New</a></li>
                    </li>
                </ul>

                <div class="ui-front" id="tabSearch" align="center">
                    <label for="searchEmail">Add faculty by email</label>
                    <input type="text" id="searchEmail">
                </div>

                <div id="tabNew" align="center">
                    <h3 align="center">Add new user</h3>
                    <form>
                        <fieldset>
                            <label for="newfirstName">First Name</label>
                            <input type="text" name="firstName" id="newFirstName"
                                   class="text ui-widget-content ui-corner-all">

                            <label for="newlastName">Last Name</label>
                            <input type="text" name="lastName" id="newLastName"
                                   class="text ui-widget-content ui-corner-all">

                            <label for="newEmail">Email</label>
                            <input type="text" name="email" id="newEmail" class="text ui-widget-content ui-corner-all">

                            <!-- Allow form submission with keyboard without duplicating the dialog button -->
                            <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

        <div id="dialog-form" style="display:none;" title="Edit Committee Member">
            <p>All fields are required.</p>

            <form>
                <fieldset>
                    <label for="firstName">First Name</label>
                    <input type="text" name="firstName" id="firstName" class="text ui-widget-content ui-corner-all">

                    <label for="lastname">Last Name</label>
                    <input type="text" name="lastName" id="lastName" class="text ui-widget-content ui-corner-all">

                    <label for="email">Email</label>
                    <input type="text" name="email" id="email" class="text ui-widget-content ui-corner-all">

                    <!-- Allow form submission with keyboard without duplicating the dialog button -->
                    <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                </fieldset>
            </form>
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