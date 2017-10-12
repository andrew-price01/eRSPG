<div class="breadcrumb flat">
	<a onclick='setNextPage("proposal/detail", "<s:url value="/" />")'<%= pageName.equals("detail") ? " class='active'" : "" %>>Details</a>
	<a onclick='setNextPage("proposal/department", "<s:url value="/" />")'<%= pageName.equals("department") ? " class='active'" : "" %>>Department</a>
	<a onclick='setNextPage("proposal/awardType", "<s:url value="/" />")'<%= pageName.equals("awardType") ? " class='active'" : "" %>>Award Type</a>
	<a onclick='setNextPage("proposal/budget", "<s:url value="/" />")'<%= pageName.equals("budget") ? " class='active'" : "" %>>Budget</a>
	<a onclick='setNextPage("proposal/body", "<s:url value="/" />")'<%= pageName.equals("body") ? " class='active'" : "" %>>Body</a>
	<a onclick='setNextPage("proposal/bodyDetails", "<s:url value="/" />")'<%= pageName.equals("bodyDetails") ? " class='active'" : "" %>>Body Details</a>
	<a onclick='setNextPage("proposal/bodyQuestions", "<s:url value="/" />")'<%= pageName.equals("bodyQuestions") ? " class='active'" : "" %>>Questions</a>
	<a onclick='setNextPage("proposal/upload", "<s:url value="/" />")'<%= pageName.equals("upload") ? " class='active'" : "" %>>Upload</a>
</div>
