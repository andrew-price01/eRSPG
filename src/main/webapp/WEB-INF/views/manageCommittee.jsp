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
    <%--<script>
        $( function() {
            var dialog, form,

                // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
                emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
                name = $( "#name" ),
                email = $( "#email" ),
                password = $( "#password" ),
                allFields = $( [] ).add( name ).add( email ).add( password ),
                tips = $( ".validateTips" );


            function addUser() {
                var valid = true;
                allFields.removeClass( "ui-state-error" );

                valid = valid && checkLength( name, "username", 3, 16 );
                valid = valid && checkLength( email, "email", 6, 80 );
                valid = valid && checkLength( password, "password", 5, 16 );

                valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
                valid = valid && checkRegexp( email, emailRegex, "eg. ui@jquery.com" );
                valid = valid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );

                if ( valid ) {
                    $( "#users tbody" ).append( "<tr>" +
                        "<td>" + name.val() + "</td>" +
                        "<td>" + email.val() + "</td>" +
                        "<td>" + password.val() + "</td>" +
                        "</tr>" );
                    dialog.dialog( "close" );
                }
                return valid;
            }

            dialog = $( "#dialog-form" ).dialog({
                autoOpen: false,
                height: 400,
                width: 350,
                modal: true,
                buttons: {
                    "Create an account": addUser,
                    Cancel: function() {
                        dialog.dialog( "close" );
                    }
                },
                close: function() {
                    form[ 0 ].reset();
                    allFields.removeClass( "ui-state-error" );
                }
            });

            form = dialog.find( "form" ).on( "submit", function( event ) {
                event.preventDefault();
                addUser();
            });

            $( "#editMember" ).button().on( "click", function() {
                dialog.dialog( "open" );
            });
        } );
    </script>--%>

    <title>eRSPG</title>

</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>


<div class="wrapper">
        <nav id="sidebar" class="sidebar">
            <!-- Sidebar Header -->
            <div class="sidebar-header">
                <h3>Chairman Dashboard</h3>
            </div>

            <!-- Sidebar Links -->
            <ul class="list-unstyled components">
                <li><a class="btn my-btn" type="button" onclick="window.location.href = '/eRSPG/chairman/home'" value="Chairman Home">Home</a></li>
                <li class="active"><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chairman/committee'" value="Manage Committee">Manage Committee</a></li>
                <li><a class="btn my-btn" type="button" onclick="window.location.href= '/eRSPG/chairman/proposal'" value="Chairman Proposals">Proposals</a></li>
                <li><a class="btn my-btn" type="button" onclick="window.location.href = '/eRSPG/chairman/makeAnnouncement'" value="Announcement">MakeAnnouncement</a></li>
            </ul>
        </nav>

        <!-- Page Content -->
        <div id="content" class="main">
            <h1>Manage Committee</h1>

            <br>

            <div id="window">
                <h3 align="left">Committee Members</h3>
                <input type='button' class="btn btn-info" style="float: right;" id='addNewMember' value='Add New Member'>
                <%--<input type='button' class="btn btn-info" style="float: right;" id='hideshow' value='hide/show'>--%>
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
</body>
</html>