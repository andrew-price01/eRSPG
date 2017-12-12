<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div class="container">
	<h2>Assign New Chair</h2>
	<form class="form-horizontal" method="post" action="changeChair">
		<p class="text-danger">This will revoke your access to this application!</p>
		<div class="form-group">
			<label class="col-sm-3 control-label required-field form-inline" for="chairEmail">New Chair Email:</label>

			<div class="col-sm-9">
				<input class="form-control"  type="text" path="chairEmail" required="true" />
			</div>

		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label required-field form-inline" for="confirmChairEmail">Confirm New Chair Email:</label>

			<div class="col-sm-9">
				<input class="form-control"  type="text" path="confirmChairEmail" required="true" />
			</div>
		</div>
		<div class="form-group">
			<button class="btn my-btn">Submit</button>
			<button class="btn my-btn" onclick="window.history.back()">Back</button>
		</div>
	</form>
</div>
