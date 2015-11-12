<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <div align="center">
        <h1>Spring MVC - File Upload to Database Demo</h1>
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
