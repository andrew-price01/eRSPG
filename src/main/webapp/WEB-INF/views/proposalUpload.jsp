<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div class="breadcrumb flat">
		<a href="<s:url value='/proposal/department' />">Details</a> <a
			href="<s:url value='/proposal/awardType' />">Award Type</a> <a
			href="<s:url value='/proposal/budget' />">Budget</a> <a
			href="<s:url value='/proposal/body' />">Body</a> <a
			href="<s:url value='/proposal/bodyDetails' />">Body Details</a> <a
			href="<s:url value='/proposal/bodyQuestions' />">Questions</a> <a
			href="<s:url value='/proposal/upload' />" class="active">Upload</a>
	</div>
	<div align="center">
		<!--         <h1>Spring MVC - File Upload to Database Demo</h1> -->
		<legend>
			<h2 style="text-align: center;">File Upload</h2>
		</legend>
		<form:form method="post" enctype="multipart/form-data"
			modelAttribute="UploadForm">
			<table border="0">
				<tr>
					<td>Pick file #1:</td>
					<td><input type="file" name="fileUpload" size="50" />
				</tr>

				
			</table>
			<div class="button-row">
				<button type="button" class="btn my-btn pull-left" onclick='window.location.href="<s:url value="/proposal/bodyQuestions" />"'>Previous</button>
				<button type="button" class="btn my-btn">Save</button>
				<button type="button" class="btn my-btn pull-right" onclick='window.location.href="<s:url value="/proposal/review" />"'>Next</button>
			</div>

		</form:form>
	</div>
</div>
