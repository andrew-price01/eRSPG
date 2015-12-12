<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<div class="container">

	<script type="text/javascript">
		year = new Date().getFullYear();
	</script>
	<div class="breadcrumb flat">
		<a href="<s:url value='/proposal/detail' />" class="active">Details
		</a> <a href="<s:url value='/proposal/detail/awardType' />">Award Type</a>
		<a href="<s:url value='/proposal/budget' />">Budget</a> <a
			href="<s:url value='/proposal/body' />">Body</a> <a
			href="<s:url value='/proposal/bodyDetails' />">Body Details</a> <a
			href="<s:url value='/proposal/bodyQuestions' />">Questions</a> <a
			href="<s:url value='/proposal/upload' />">Upload</a>
	</div>

	<legend>
		<h2 style="text-align: center;">Project Details</h2>

	</legend>

	<form:form class="form-horizontal" method="post"
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
				<form:input type="number" min="2000" path="year" value="2015" />
			</div>

		</div>





		<div>
			<button type="submit" class="btn my-btn pull-right">Next</button>

		</div>
	</form:form>
</div>