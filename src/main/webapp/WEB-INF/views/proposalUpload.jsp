<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
    <div class="container" align="center">
    <div class="breadcrumb flat">
			<a href="<s:url value='/proposal/detail' />">Details </a>
			<a href="<s:url value='/proposal/detail/awardType' />">Award Type</a>
			<a href="<s:url value='/proposal/budget' />" >Budget</a>
			<a href="<s:url value='/proposal/body' />" >Body</a>
			<a href="<s:url value='/proposal/bodyDetails' />" >Body Details</a>
			<a href="<s:url value='/proposal/bodyQuestions' />" >Questions</a>
			<a href="<s:url value='/proposal/upload' />" class="active">Upload</a>
	</div>
<!--         <h1>Spring MVC - File Upload to Database Demo</h1> -->
         <legend><h2 style="text-align:center;">File Upload</h2></legend>
        <form:form method="post" enctype="multipart/form-data" modelAttribute="UploadForm">
            <table border="0">
                <tr>
                    <td>Pick file #1:</td>
                    <td><input type="file" name="fileUpload" size="50" /></td>
                </tr>
                <tr>
                    <td>Pick file #2:</td>
                    <td><input type="file" name="fileUpload2" size="50" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                </tr>
            </table>
        </form:form>
    </div>
