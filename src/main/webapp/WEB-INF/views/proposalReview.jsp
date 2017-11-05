<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div align="center">
		<!--         <h1>Spring MVC - File Upload to Database Demo</h1> -->
		<legend>
			<h2 style="text-align: center;">Submit Proposal</h2>
		</legend>
		<form:form method="post" enctype="multipart/form-data"
			modelAttribute="uploadForm">
			<table border="0">
 				<tr> 
 					<td>Pick file #1:</td> 
 					<td><input type="file" name="fileUpload" size="50" /> 
 				</tr>

				
			</table>
			
			<div>
				<p>Please review your proposal before submitting it.</p>
			</div>
			
			<div class="button-row">
				<button type="button" class="btn my-btn pull-left" onclick='window.location.href="<s:url value="/proposal/upload" />"'>Back</button>
				<%--<button type="button" class="btn my-btn pull-center" onclick='window.location.href="<s:url value="/proposal/review" />"'>Save</button>--%>
				<button type="button" class="btn my-btn pull-right" onclick='window.location.href="<s:url value="/proposal/submit" />"'>Submit</button>
			</div>

		</form:form>
	</div>
</div>
