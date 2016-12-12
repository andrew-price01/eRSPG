<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="container">
	<% String pageName = "upload"; %>
	<%@include file="/WEB-INF/views/breadcrumbs.jsp" %>
	
	<div align="center">
		<!--         <h1>Spring MVC - File Upload to Database Demo</h1> -->
		<legend>
			<h2 style="text-align: center;">File Upload</h2>
		</legend>
		<form:form method="post" action="upload" enctype="multipart/form-data"
			modelAttribute="UploadForm">
			<table border="0">
				<tr>
					<td>Pick file #1:</td>
					<td><input type="file" name="fileUpload" size="50" />
				</tr>

				
			</table>
		
			<input type="hidden" name="nextPage" id="nextPage" value="0" />
			
			<div class="button-row">
				<button type="submit" class="btn my-btn pull-left" onclick='setNextPage("proposal/bodyQuestions", "<s:url value="/" />")'>Previous</button>
				<button type="submit" class="btn my-btn" onclick='setNextPage("proposal/upload", "<s:url value="/" />")'>Save</button>
	           	<button type="submit" class="btn my-btn pull-right" onclick='setNextPage("proposal/review", "<s:url value="/" />")'>Next</button>
	        </div>

		</form:form>
	</div>
</div>
