<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div class="container">

	<script type="text/javascript">
		year = new Date().getFullYear();
	</script>
	
	<% String pageName = "department"; %>
	<%@include file="/WEB-INF/views/breadcrumbs.jsp" %>

	<legend>
		<h2 style="text-align: center;">Project Details</h2>

	</legend>

	<form:form class="form-horizontal" method="post" action="department"
		modelAttribute="departmentForm">
		<div class="form-group">
			<label class="col-sm-3 control-label required-field"
				for="departmentID">Department: </label>
			<div class="col-sm-9">
				<form:select items="${deptList}" path="departmentID">

				</form:select>

			</div>



		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label required-field" for="semesterID">Semester:
			</label>
			<div class="col-sm-9">

				<form:select path="semesterID" items="${semesterList}">

				</form:select>
			</div>



		</div>

		<div class="form-group">
			<label class="col-sm-3 control-label required-field" for="year">Year:
			</label>
			<div class="col-sm-9">
				<% int currentYear = new java.util.Date().getYear() + 1900; %>
				<form:input type="number" min="<%= currentYear - 5 %>" max="<%= currentYear + 10 %>" path="year" />
			</div>

		</div>
		
		<input type="hidden" name="nextPage" id="nextPage" value="0" />




		
		<script>
			function asyncSubmit(dest) {
			    var xhttp = new XMLHttpRequest();

			    xhttp.open("POST", "<s:url value="/proposal/department" />", true);
			    xhttp.send();
				
				window.location.href="<s:url value="/proposal/awardType" />"
			}
		</script>

		<div class="button-row">
			<!-- Placeholder to help align buttons -->
			<button type="submit" class="btn my-btn pull-left" onclick='setNextPage("proposal/detail", "<s:url value="/" />")'>Previous</button>
			<button type="submit" class="btn my-btn" onclick='setNextPage("proposal/department", "<s:url value="/" />")'>Save</button>
			<button type="submit" class="btn my-btn pull-right" onclick='setNextPage("proposal/awardType", "<s:url value="/" />")'>Next</button>
		</div>
	</form:form>
</div>