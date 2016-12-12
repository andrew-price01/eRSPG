<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div align="center">
		<!--         <h1>Spring MVC - File Upload to Database Demo</h1> -->
		<legend>
			<h2 style="text-align: center;">Submission Complete</h2>
		</legend>
		<form:form method="post" enctype="multipart/form-data"
			modelAttribute="UploadForm">
			<table border="0">
<!-- 				<tr> -->
<!-- 					<td>Pick file #1:</td> -->
<!-- 					<td><input type="file" name="fileUpload" size="50" /> -->
<!-- 				</tr> -->

				
			</table>
			
			<div>
				<p>Your proposal was submitted successfully and is pending review. You will be notified when the review is complete.</p>
			</div>
			
			<div class="button-row">
				<button type="button" class="btn my-btn pull-left" onclick='window.location.href="<s:url value="/proposal/upload" />"'>Back</button>
				<button type="button" class="btn my-btn pull-center">Save</button>
				<button type="submit" class="btn my-btn pull-right">Submit</button>
			</div>

		</form:form>
	</div>
</div>
