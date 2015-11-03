<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>Project Proposal</title>
		<link type="text/css"  href="../css/bootstrap.css" rel="stylesheet"/>
	
	</head>
	
	<body>
		<div class="container">
			<legend>Project Details</legend>
			<div class="row">
				<form class="form-horizontal"  method="post" action="budget">
					<div class="form-group">
						<label class="col-sm-3 control-label" for="projectTitle">Project Title:</label>
						<div class="col-sm-9">
							<input class="form-control" type="text" name="projectTitle" id="projectTitle" required/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Submission Date:</label>
						<div class="col-sm-9">
							<input class="form-control"  type="date" name="submissionDt" id="submissionDt" required/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Project Director:</label>
						<div class="col-sm-9">
							<input class="form-control"  type="text" name="projectDirector" id="projectDirector" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="emailAddress" >Email Address:</label>
						<div class="col-sm-9">
							<input class="form-control"  type="email" name="emailAddress" id="emailAddress" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="mailCode">Mail Code:</label>
						<div class="col-sm-9">
							<input class="form-control"  type="text" name="mailCode" id="mailCode" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="extension">Extension:</label>
						<div class="col-sm-9">
							<input class="form-control"  type="text" name="extension" id="extension" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="otherParticipants">Other Participants:</label>
						<div class="col-sm-9">
							<input class="form-control"  type="text" name="otherParticipants" id="otherParticipants" required />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-3">
							<label class="control-label">Are You Applying For:</label>
						</div>
						<div class="col-sm-9">
							<div class="checkbox">
								<label><input type="checkbox" name="applyingFor" value="1"/>Research Grant (Fall and Spring)</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" name="applyingFor" value="2" />Instructional Improvement Grant (Fall and Spring Semesters) The Signature of the College</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" name="applyingFor" value="3" />Curriculum Chair is required for instructional improvement proposals (for new or experimental courses)</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" name="applyingFor" value="4" />Hemingway Faculty Vitality Grant (Fall semester, and mid-late Spring semester)</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" name="applyingFor" value="5" />Hemingway New Faculty Grant (Mid-late Spring semester)</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" name="applyingFor" value="6" />Hemingway Excellence Award (Early-mid Spring semester)</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" name="applyingFor" value="7" />Hemingway Collaborative Award (Early-mid Spring semester)</label>
							</div>
							<div class="checkbox">
								<label><input type="checkbox" name="applyingFor" value="2" />Hemingway Adjunct Faculty Grant (Mid-late Spring 2012)</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<h5>Project Type</h5>
						<div class="radio">
  							<label><input type="radio" name="projectType" value="1"/>Travel to attend a workshop or conference (you must select Hemingway Vitality above)</label>
						</div>
						<div class="radio">
  							<label><input type="radio" name="projectType" value="2"/>Travel to present at a workshop or conference</label>
						</div>
						<div class="radio">
  							<label><input type="radio" name="projectType" value="3"/>Research, creative endeavor, or service-oriented project (materials, equipment, travel to collect data,
etc.)</label>
						</div>
						<button class="button-block">Next</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>