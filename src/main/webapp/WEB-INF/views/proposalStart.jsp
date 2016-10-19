<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="eRSPG.model.User" %>
<%@ page import="eRSPG.Repository.UserImpl" %>
<jsp:useBean id="user" class="eRSPG.model.User"/>

<div class="container">
	<legend><h2 style="text-align:center;">RSPG Proposal Submission</h2></legend>

	<div class="text-center">

			<form:form class="form-horizontal" method="post" modelAttribute="startForm" cssStyle="align-items: center" >
				<form:label path="firstName" for="firstName" cssStyle="align-items: center">First Name: </form:label>
				<form:input path="firstName" name="firstName" />

				<form:label path="lastName" for="lastName" cssStyle="align-items: center">Last Name: </form:label>
				<form:input path="lastName" name="lastName" />

				<form:label path="userEmail" for="userEmail" cssStyle="align-items: center">Email: </form:label>
				<form:input path="userEmail" name="userEmail"/>

				<form:label path="userPassword" for="userPassword" cssStyle="align-items: center">Password: </form:label>
				<form:input path="userPassword" name="userPassword"/>

				<form:button name="myBtn" value="NewButton" />

			</form:form>

			<%--<form action="<%--%>
							<%--String firstName = request.getParameter("firstName");--%>
							<%--String lastName = request.getParameter("lastName");--%>
							<%--String userEmail = request.getParameter("userEmail");--%>

							<%--user.setFirstName(firstName);--%>
							<%--user.setLastName(lastName);--%>
							<%--user.setEmail(userEmail);--%>
							<%--System.out.println("First: " +" "+ user.getFirstName() + " " + "Last: " +" "+--%>
								<%--user.getLastName() + " " + "Email: " +" "+ user.getEmail() + " " + "Id: " + user.getUserId());--%>

							<%--User aUser = new User();--%>
							<%--aUser.setFirstName(firstName);--%>
							<%--aUser.setLastName(lastName);--%>
							<%--aUser.setEmail(userEmail);--%>
							<%--System.out.println("First: " +" "+ aUser.getFirstName() + " " + "Last: " +" "+--%>
								<%--aUser.getLastName() + " " + "Email: " +" "+ aUser.getEmail() + " " + "Id: " + aUser.getUserId());--%>
						<%--%>"--%>
				  <%--method="post" encrypt="text/plain">--%>

				<%--<label for="firstName" style="align-content: center"> First Name:&nbsp </label>--%>
				<%--<input id="firstName" type="text" name="firstName" value="" style="align-self: center;" /><br /><br />--%>

				<%--<label for="lastName" style="alignment: center"> Last Name:&nbsp </label>--%>
				<%--<input id="lastName" type="text" name="lastName" value="" style="align-self: center;" /><br /><br />--%>

				<%--<label for="userEmail">Email:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>--%>
				<%--<input id="userEmail" type="text" name="userEmail" value="" style="align-self: center;" /><br /><br />--%>

				<%--<label for="userPassword">Password:&nbsp&nbsp</label>--%>
				<%--<input id="userPassword" type="password" name="userPassword" value="" style="align-self: center;"/><br /><br />--%>

				<%--<Button type="submit" class="btn my-btn" value="Submit" >Submit</Button>--%>
			<%--</form>--%>
			<br />
			<br />
			<%--<%= "Welcome " + firstName + " " + lastName + " " + userEmail %><br />--%>
			<Button type="button" class="btn my-btn" onclick='window.location.href="<s:url value="start" />"' >Start</Button>
	</div>
</div>




