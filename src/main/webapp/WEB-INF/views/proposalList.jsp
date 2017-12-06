<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div class="container">

	<h2>List of Proposals</h2>

	<table id="proposalTable" class="table">
		<tr>
			<th>Submitted By</th>
			<th>Project Title</th>
			<th>Project Director</th>
			<th>Award Type</th>
			<th>Actions</th>
		</tr>
		<%-- Put a foreach here to display all the proposals --%>
		<tr>
			<td>Benjamin Benson</td>
			<td>Neuroscience Research</td>
			<td>John Johnson</td>
			<td>Research Grant</td>
			<td>
				<button class="btn my-btn" onclick="window.location.href = '/erspg/reviewer/reviewProposal?1'">Review</button>
			</td>
		</tr>
		<tr>
			<td>Christian Christiansen</td>
			<td>Experimental Chemistry Course</td>
			<td>John Johnson</td>
			<td>Instructional Improvement Grant</td>
			<td>
				<button class="btn my-btn" onclick="window.location.href = '/erspg/reviewer/reviewProposal?2'">Review</button>
			</td>
		</tr>
	</table>

	<hr/>
</div>
