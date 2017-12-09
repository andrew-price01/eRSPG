<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div class="container">

	<h2>List of Proposals</h2>

	<table id="proposalTable" class="table">
		<tr>
			<th>Submitted By</th>
			<th>Project Title</th>
			<th>Project Director</th>
			<th>Department</th>
			<th>Award Type</th>
			<th>Status</th>
			<th>Submission Date</th>
			<th>Actions</th>
		</tr>
		<%-- Put a foreach here to display all the proposals --%>
		<tr>
			<td>Benjamin Benson</td>
			<td>Neuroscience Research</td>
			<td>John Johnson</td>
			<td>Biology</td>
			<td>Research Grant</td>
			<td>In Review</td>
			<td>11/29/2017</td>
			<td>
				<button class="btn my-btn" onclick="window.location.href = '/erspg/reviewer/reviewProposal?1'">Review</button>
			</td>
		</tr>
		<tr>
			<td>Christian Christiansen</td>
			<td>Experimental Chemistry Course</td>
			<td>John Johnson</td>
			<td>Chemistry</td>
			<td>Instructional Improvement Grant</td>
			<td>Submitted</td>
			<td>12/02/2017</td>
			<td>
				<button class="btn my-btn" onclick="window.location.href = '/erspg/reviewer/reviewProposal?2'">Review</button>
			</td>
		</tr>
	</table>

	<hr/>
</div>
