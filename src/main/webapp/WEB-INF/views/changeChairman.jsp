<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div class="container">
	<h2>Assign New Chairman</h2>
	<form class="form-horizontal" method="post" action="changeChairman">
		<p class="text-danger">This will revoke your access to this application!</p>
		<div class="form-group">
			<label class="col-sm-3 control-label required-field form-inline" for="chairmanEmail">New Chairman Email:</label>

			<div class="col-sm-9">
				<input class="form-control"  type="text" path="chairmanEmail" required="true" />
			</div>

		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label required-field form-inline" for="confirmChairmanEmail">Confirm New Chairman Email:</label>

			<div class="col-sm-9">
				<input class="form-control"  type="text" path="confirmChairmanEmail" required="true" />
			</div>
		</div>
		<div class="form-group">
			<button class="btn my-btn">Submit</button>
			<button class="btn my-btn" onclick="window.history.back()">Back</button>
		</div>
	</form>
</div>
