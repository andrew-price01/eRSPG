<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div class="container">

	<h2>Create Announcement</h2>

	<form class="form-horizontal" method="post" action="submitAnnouncement">
		<div class="form-group col-xs-10">
			<input id="titleInput" class="form-control input-xs-5 input-lg" type="text" placeholder="Title" required/>
		</div>
		<div class="form-group col-xs-10">
			<textarea id="bodyInput" class="form-control input-xs-8" rows="10" required></textarea>
		</div>
		<div class="form-group col-xs-10 clearfix">
			<button id="cancelButton" onclick="window.history.back()" class="btn my-btn">Cancel</button>
			<button id="saveButton" class="btn my-btn pull-right">Publish</button>
		</div>
	</form>


</div>
