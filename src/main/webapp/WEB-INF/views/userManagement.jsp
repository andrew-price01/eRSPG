<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div class="container">

	<h2>Reviewers</h2>

	<table id="usersTable" class="table">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Department</th>
			<th>Actions</th>
		</tr>
		<%-- Put a foreach here to display all the reviewers --%>
		<tr>
			<td>Yong Zhang</td>
			<td>yongzhang@weber.edu</td>
			<td>EAST</td>
			<td>
				<button class="btn my-btn" onclick="removeButtonPressed(this)">Remove</button>
			</td>
		</tr>
		<tr>
			<td>Rieneke Holman</td>
			<td>rienekeholman@weber.edu</td>
			<td>HP</td>
			<td>
				<button class="btn my-btn" onclick="removeButtonPressed(this)">Remove</button>
			</td>
		</tr>
	</table>
	<button id="newButton" class="btn my-btn" onclick="newButtonPressed()">Add New</button>

	<hr/>

	<button class="btn my-btn" onclick="window.location.href = '/erspg/chairman/changeChairman'">Assign New Chairman</button>

</div>

<script>

	var editRow = 0;

	function removeButtonPressed(b) {
	    var name = $(b).closest('tr').find('td:first').text();
	    var c = confirm("Are you sure you want to remove " + name + " from the committee?");
	    if (!c) return;
	    $(b).closest('tr').remove();
	}

	function newButtonPressed() {
       $("#newButton").hide();
       editRow = $("#usersTable")[0].insertRow();
       var nameCell = editRow.insertCell();
       nameCell.innerHTML = "<input id=\"nameInput\" class=\"form-control\" type=\"text\" placeholder=\"Name\" required=\"true\" />";
       var emailCell = editRow.insertCell();
       emailCell.innerHTML = "<input id=\"emailInput\" class=\"form-control\" type=\"text\" placeholder=\"Email Address\" required=\"true\" />";
       var departmentCell = editRow.insertCell();
       departmentCell.innerHTML = "<input id=\"departmentInput\" class=\"form-control\" type=\"text\" placeholder=\"Department\" required=\"true\" />";
       var saveCell = editRow.insertCell();
       saveCell.innerHTML= "<button class=\"btn my-btn\" onclick=\"saveButtonPressed()\">Save</button>"
    }

    function saveButtonPressed() {
	    var cells = editRow.cells;
	    cells[0].innerHTML = $("#nameInput").val();
	    cells[1].innerHTML = $("#emailInput").val();
	    cells[2].innerHTML = $("#departmentInput").val();
	    cells[3].innerHTML = "<button class=\"btn my-btn\" onclick=\"removeButtonPressed(this)\">Remove</button>";
	    editRow = 0;
	    $("#newButton").show();
    }
</script>
