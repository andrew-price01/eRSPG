<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<div class="container">

	<table width="100%">
		<td><h2>Review Proposal</h2></td>
		<td style="text-align: right;">
			<a href="#score-header"><button class="btn my-btn">Score</button></a>
			<a href="#comment-header"><button class="btn my-btn">Comment</button></a>
		</td>
	</table>
	<table class="table">
		<tr>
			<td>
				<b>Project Title:</b>
			</td>
			<td colspan="1">Neuroscience Research</td>
		</tr>
		<tr>
			<td>
				<b>Project Director:</b>
			</td>
			<td colspan="3">John Johnson</td>
		</tr>
		<tr>
			<td>
				<b>Email Address:</b>
			</td>
			<td>johnjohnson@weber.edu</td>
		</tr>
		<tr>
			<td><b>Mail Code:</b></td>
			<td>112244</td>
		</tr>
		<tr>
			<td><b>Extension:</b></td>
			<td>555</td>
		</tr>
		<tr><td></td><td></td></tr>
		<tr>
			<td><b>Award Type:</b></td>
			<td>Research Grant</td>

		</tr>
		<tr>
			<td><b>Project Type:</b></td>
			<td>Research, creative endeavor, or service-oriented project (materials, equipment, travel to collect data, etc.)</td>
		</tr>
		<tr><td></td><td></td></tr>
	</table>

	<h3>Budget</h3>

	<table class="table table-bordered table-condensed">
		<tbody>
		<tr>
			<th style="width:20%;"></th>
			<th class="text-center" style="background-color: rgb(87,80,71); color:white">Funds Committed from Source #1</th>
			<th class="text-center" style="background-color: rgb(87,80,71); color:white">Funds Committed from Source #2</th>
			<th class="text-center" style="background-color: rgb(87,80,71); color:white">Funds Committed from Source #3</th>
			<th	class="text-center" style="background-color: rgb(87,80,71); color:white">Funds <u>Requested</u> from <strong>RSPG</strong></th>
			<th	class="text-center" style="background-color: rgb(87,80,71); color:white">GRAND TOTAL</th>
		</tr>
		<tr>
			<td colspan="6"><strong> 1) PERSONNEL RESOURCES (assistants, consultants, released time)</strong></td>
		</tr>
		<tr>
			<td>a) Assistants</td>
			<td class="text-right">$30</td>
			<td class="text-right">$40</td>
			<td class="text-right">$50</td>
			<td class="text-right">$200</td>
			<th class="text-right">$320</th>
		</tr>
		<tr>
			<td>b) Consultants</td>
			<td class="text-right">$30</td>
			<td class="text-right">$40</td>
			<td class="text-right">$50</td>
			<td class="text-right">$200</td>
			<th class="text-right">$320</th>
		</tr>
		<tr>
			<td>c)</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<th class="text-right"></th>
		</tr>
		<tr>
			<td colspan="6"><strong> BENEFITS for Personnel Resources(8.5% for student employees, 15% for full-time faculty
				requesting reassigned time, 22% for full-time faculty and staff requesting a stipend)
			</strong></td>
		</tr>
		<tr>
			<td>a) Assistants</td>
			<td class="text-right">$30</td>
			<td class="text-right">$40</td>
			<td class="text-right">$50</td>
			<td class="text-right">$200</td>
			<th class="text-right">$320</th>
		</tr>
		<tr>
			<td>b) Consultants</td>
			<td class="text-right">$30</td>
			<td class="text-right">$40</td>
			<td class="text-right">$50</td>
			<td class="text-right">$200</td>
			<th class="text-right">$320</th>
		</tr>
		<tr>
			<td>c)</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_1"></th>
		</tr>
		<tr>
			<td colspan="6"><strong> 2) EQUIPMENT AND MATERIALS</strong></td>
		</tr>
		<tr>
			<td>a) Assistants</td>
			<td class="text-right">$30</td>
			<td class="text-right">$40</td>
			<td class="text-right">$50</td>
			<td class="text-right">$200</td>
			<th class="text-right">$320</th>
		</tr>
		<tr>
			<td>b) Consultants</td>
			<td class="text-right">$30</td>
			<td class="text-right">$40</td>
			<td class="text-right">$50</td>
			<td class="text-right">$200</td>
			<th class="text-right">$320</th>
		</tr>
		<tr>
			<td>c)</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_1"></th>
		</tr>
		<tr>
			<td colspan="6"><strong> 3) TRAVEL</strong></td>
		</tr>
		<tr>
			<td>a) Assistants</td>
			<td class="text-right">$30</td>
			<td class="text-right">$40</td>
			<td class="text-right">$50</td>
			<td class="text-right">$200</td>
			<th class="text-right">$320</th>
		</tr>
		<tr>
			<td>b) Consultants</td>
			<td class="text-right">$30</td>
			<td class="text-right">$40</td>
			<td class="text-right">$50</td>
			<td class="text-right">$200</td>
			<th class="text-right">$320</th>
		</tr>
		<tr>
			<td>c)</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_1"></th>
		</tr>
		<tr>
			<td colspan="6"><strong> 4) OTHER</strong></td>
		</tr>
		<tr>
			<td>a) Assistants</td>
			<td class="text-right">$30</td>
			<td class="text-right">$40</td>
			<td class="text-right">$50</td>
			<td class="text-right">$200</td>
			<th class="text-right">$320</th>
		</tr>
		<tr>
			<td>b) Consultants</td>
			<td class="text-right">$30</td>
			<td class="text-right">$40</td>
			<td class="text-right">$50</td>
			<td class="text-right">$200</td>
			<th class="text-right">$320</th>
		</tr>
		<tr>
			<td>c)</td>
			<td class="text-right"></td>
			<td class="text-right"></td>
			<td class="text-right"></td>
			<td class="text-right"></td>
			<th></th>
		</tr>
		<tr>
			<td style="vertical-align:middle;">TOTALS</td>
			<td class="text-right" style="vertical-align:middle;"></td>
			<td class="text-right" style="vertical-align:middle;"></td>
			<td class="text-right" style="vertical-align:middle;"></td>
			<td class="text-right" style="vertical-align:middle;"></td>
			<td></td>
		</tr>
		</tbody>
	</table>

	<h3>Proposal Body</h3>

	<p><b>PROJECT SUMMARY (ABSTRACT):</b></p>
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse finibus tincidunt tortor eu mollis. Duis malesuada eros vel mauris rhoncus ornare. Sed arcu eros, egestas in magna a, pellentesque ultricies purus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nullam a eros porta, porta augue et, pellentesque sem. Donec placerat justo sit amet enim rutrum ullamcorper. Donec facilisis, nibh sit amet sagittis dignissim, nunc mauris tempor dui, ac vehicula elit neque vel neque. Vivamus pharetra, elit in ornare gravida, lectus arcu feugiat nulla, in mattis ipsum tellus venenatis sem. Proin eget nisi imperdiet, eleifend ex et, laoreet metus. Ut sed massa ac leo semper ullamcorper. Curabitur quis tortor et lectus pulvinar semper a a sem. Nullam maximus nisl ac pellentesque suscipit. Donec iaculis vulputate nulla a blandit. Etiam volutpat dignissim lacus, sed vulputate est malesuada at. In semper eleifend aliquam. Phasellus nunc tellus, ullamcorper at ligula sit amet, imperdiet rutrum est.</p>

	<p><b>I-A. BACKGROUND AND OBJECTIVES OF RESEARCH/PROJECT.</b></p>
	<p>Sed non volutpat risus, vitae aliquam quam. Ut ac efficitur mauris. Ut maximus auctor orci eget scelerisque. Pellentesque rutrum est nisl, et laoreet lectus molestie vehicula. Maecenas vitae tristique dui. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed velit libero, interdum eget ex ac, gravida feugiat sem. Nam quis venenatis nulla.</p>

	<p><b>II. PROCEDURES AND METHODS.</b></p>
	<p>Fusce non molestie erat. Vivamus varius, urna et finibus ultrices, lacus erat iaculis odio, eget tempus augue dolor vitae libero. Integer id luctus nisl, vel facilisis elit. Cras id purus in felis sollicitudin tincidunt a in nulla. Mauris eu mi eros. In placerat purus sed leo feugiat egestas. Mauris porttitor fringilla massa, eu accumsan lectus fringilla viverra. In et sapien pharetra, consequat justo vel, dapibus enim. Fusce odio odio, ultricies et nibh vitae, imperdiet vehicula purus. Integer varius laoreet erat et fringilla. Nullam non porta lectus. Mauris luctus porta sodales. Nunc sit amet velit sed velit hendrerit consequat. Nullam quis tellus odio. Sed maximus, mauris non pellentesque viverra, odio enim egestas ante, a lobortis turpis metus efficitur dolor.</p>

	<p><b>III. TIME-LINE.</b></p>
	<p>Duis commodo egestas mi et consectetur. Nulla mattis magna in orci mattis sodales. Proin aliquam, mi a auctor egestas, neque diam ultricies velit, nec lobortis ante nunc quis diam. Proin feugiat dignissim felis, vitae tristique diam fringilla eu. Phasellus sed purus id turpis vestibulum placerat ut a elit. Aliquam quis massa nec massa tincidunt tincidunt eget ut lacus. Quisque vel purus eget lectus vestibulum condimentum quis ac odio.</p>

	<p><b>IV. EVALUATION AND DISSEMINATION.</b></p>
	<p>Suspendisse tincidunt tellus id laoreet pretium. Proin scelerisque commodo dictum. Nunc rhoncus dolor et neque tincidunt, gravida porttitor dolor ullamcorper. Phasellus sit amet urna imperdiet, finibus lectus ut, gravida ligula. Nam facilisis sapien sed leo vehicula, et posuere risus dapibus. Integer ligula elit, maximus a urna ac, gravida consequat nisl. Aenean efficitur gravida mauris eget lobortis. Vivamus imperdiet placerat libero ac pretium. Curabitur nec tortor urna. Vestibulum quis ex risus.</p>

	<p><b>V. PROVIDE A BUDGET NARRATIVE</b></p>
	<p>Mauris feugiat hendrerit est sit amet condimentum. Quisque pulvinar sapien vel urna suscipit, sit amet varius nisi accumsan. Duis eget rutrum ex. Sed vulputate sem nec justo consequat, ut aliquet libero pharetra. Curabitur sed semper dui, id tincidunt ex. Fusce bibendum tellus ut eros placerat volutpat. Donec id leo leo.</p>

	<p><b>VI. ANSWER THE FOLLOWING QUESTIONS:</b></p>

	<p><i>1. What RSPG funding have you applied for or have been awarded in the past 5 years? For awarded projects, please provide information regarding these projects including (1) the project title, (2) the status of the project, and (3) the outcome(s) of the project. Please indicate whether a final report has been submitted for each RSPG award. (It is recommended that a copy of the final report be included as an appendix.)</i></p>
	<p>Nulla eros libero, pharetra eget diam id, rutrum euismod nulla. In ac dictum ex. Etiam nec massa mi. Vestibulum malesuada malesuada lectus at iaculis. Donec dictum non lectus eget tempus. Aenean finibus dui a scelerisque scelerisque. Pellentesque facilisis id risus id placerat. Nulla facilisis ex massa, sed venenatis urna accumsan at. Mauris malesuada eros non dui dignissim, eu consectetur neque placerat. Integer porta eros iaculis magna imperdiet placerat. Duis molestie lacus dolor, vitae tincidunt lacus vestibulum sed.</p>

	<p><i>2. What other sources of funding have you sought for this project?</i><b></b></p>
	<p>Nunc blandit rhoncus scelerisque. Aenean a tincidunt ligula, non pulvinar leo. Donec tristique laoreet lectus sed aliquet. Aenean ultrices sem et scelerisque tincidunt. Fusce pulvinar massa odio, ac fringilla mauris porta at. Mauris cursus risus ornare eros porttitor, id lobortis massa condimentum. Cras tempus arcu porttitor orci malesuada mattis.</p>

	<p><i>3. Have you checked with the Office of Sponsored Projects to determine if this office is an appropriate place to seek additional funding? Please explain.</i></p>
	<p>Sed facilisis sollicitudin turpis, ut eleifend velit gravida ac. Nunc sollicitudin odio vitae urna tincidunt, ut elementum tortor consectetur. Integer quis imperdiet nisi, non vestibulum risus. Integer id mauris quam. Etiam porta placerat elit, sit amet placerat ligula cursus sed. Cras a efficitur ante, sed maximus neque. Vivamus aliquet porta pharetra. Ut eu ex convallis, lobortis neque quis, maximus purus.</p>

	<p><i>4. Is this the type of project your department or college would normally fund? Please explain?</i></p>
	<p>Maecenas blandit odio vel consequat consectetur. Nulla lobortis vulputate tortor eget hendrerit. Integer sapien massa, tristique sed ante eget, commodo tempus sapien. Pellentesque vulputate pulvinar ornare. Curabitur vel tellus sit amet sem ornare fermentum. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin a eros non risus congue vulputate sagittis nec lorem. Mauris eleifend neque erat, ac imperdiet nisi convallis ac. Fusce luctus, sapien feugiat iaculis faucibus, ipsum mi luctus nibh, at semper ipsum nisl sit amet nunc.</p>

	<p><i>5. Would completion of this project create opportunities for external funding (for example, is this proposal a request for a pilot study or seed money that may lead to a larger project)?</i></p>
	<p>Integer in sollicitudin metus. Duis dictum tempor quam, at auctor erat rhoncus eu. Integer ex lacus, feugiat nec congue vel, viverra at dolor. Integer tristique mattis sagittis. Suspendisse pharetra in urna non blandit. Donec volutpat, erat sed sollicitudin sagittis, ligula tortor suscipit nisl, ac facilisis dui diam id neque. Nunc tortor quam, semper vel aliquet ac, sodales quis justo. Vestibulum faucibus eros nec ultrices eleifend. Vivamus porttitor interdum diam, quis eleifend nulla mattis in. Donec quis massa libero. Sed rhoncus metus at convallis posuere. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam accumsan aliquet semper.</p>

	<p><i>6. If you are applying for release time or a stipend, please list what your course load would be if you received the reassigned time. You MUST include any overload courses which you plan on teaching.</i></p>
	<p>Morbi vitae sapien rhoncus, feugiat leo sit amet, aliquet sem. Suspendisse vulputate purus congue ipsum congue lacinia. Cras pretium, nunc ut pharetra pellentesque, orci erat egestas ligula, suscipit imperdiet felis nisi non felis. Integer vel laoreet justo. Cras venenatis nisi nec ante viverra consectetur. Duis ac consequat arcu, id aliquam ante. Pellentesque interdum interdum tortor, id pharetra nisi bibendum eget.</p>

	<p><i>7. For instructional improvement proposals, are course fees an appropriate place to seek additional funding? Please explain.</i></p>
	<p>Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nunc et nunc iaculis, sodales risus eget, luctus quam. Pellentesque ac magna ac velit dignissim imperdiet. Aenean tincidunt, arcu id faucibus ultricies, ante quam semper magna, sed maximus sem ipsum ut libero. Aenean diam elit, tincidunt ac velit in, egestas auctor est. Nullam suscipit nisl magna, vel maximus nibh ultricies lobortis. Ut tempor nisi sit amet lectus faucibus, ac mattis eros posuere. Nulla ornare sapien id faucibus pharetra. Cras scelerisque facilisis est. Cras non suscipit urna, sed elementum magna. Etiam nec diam facilisis, rutrum massa eget, laoreet magna. Sed vitae mauris et turpis dapibus fringilla quis nec ligula.</p>


	<h3>Attachments</h3>
	<ul>
		<li><a>Attachment_1.pdf</a></li>
		<li><a>Attachment_2.xlsx</a></li>
	</ul>

	<hr />

	<h3 id="score-header">Score Proposal</h3>
	<table class="table">
		<tr>
			<th>Criteria</th>
			<th>Description</th>
			<th>Rating Suggestions</th>
			<th style="min-width: 70px">Score</th>
		</tr>
		<tr>
			<td>Budget/Project Efficiency/Support</td>
			<td>Is there broad support for the project (through matching funds or collaborations)?</td>
			<td>2 - The project has demonstrated
				support (through significant
				matching funds and/or letters of
				collaboration with other areas on
				campus or in the
				community)<br />
				1 - The project has general support
				from the college or department.<br />
				0 - The is no documentation of
				additional support for the project</td>
			<td><input class="score form-control" type="number" min="0" max="2" /></td>
		</tr>
		<tr>
			<td>Summary &
				Background</td>
			<td>Does this project enhance the
				reputation of instructor's program
				and of Weber State University in
				general? Does the proposed
				project enhance the educational
				experience at Weber State
				University? How many
				students are impacted? Are
				multiple departments or
				programs involved?</td>
			<td>2 - Proposal documents a real
			     need. Impacts a large number of
			     students or several programs.
			     Research/Presentation improves
			the university's prestige.<br/>
			1 - Impacts many students in
			one program<br/>
			0 - Impacts a small number of
			students
			</td>
			<td><input class="score form-control" type="number" min="0" max="2" /></td>
		</tr>
		<tr>
			<td>Procedures,
				Methods,
				Timeline</td>
			<td>Are the proposed methods and
				strategies, realistic, effective and
				outcome oriented?</td>
			<td>2 - Methods, approaches, etc. are
				realistic, effective, and outcome
				oriented.<br/>
				1 - Some tangible strategies are
				noted.<br/>
				0 - Ability to implement project
				not addressed.</td>
			<td><input class="score form-control" type="number" min="0" max="2" /></td>
		</tr>
		<tr>
			<td>Evaluation
				Dissemination</td>
			<td>How will the work be disseminated
				to other areas on campus or to
				other institutions? Are there
				publishable results or
				documentation?</td>
			<td>2 - The project has the potential to
				be widely disseminated beyond
				the University. If a conference, the
				conference has national
				importance.<br/>
				1 - The project success will be
				documented and shared within the
				University (e.g. Teaching and
				Learning Forum). If a conference,
				the conference has local
				importance.<br/>
				0 - The project will have no
				publishable or sharable results</td>
			<td><input class="score form-control" type="number" min="0" max="2" /></td>
		</tr>
		<tr>
			<td>Supporting
				Documentation</td>
			<td>Are there supporting documents
				to strengthen the proposal?</td>
			<td>2 - Multiple items to support
				proposal (e.g., proof of acceptance
				to conference; memos from
				administrators, travel costs, etc.)<br/>
				1 - Some evidence to support
				proposal (e.g., email memo, etc.)<br/>
				0 - No supporting evidence.</td>
			<td><input class="score form-control" type="number" min="0" max="2" /></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><b>Total:</b></td>
			<td id="score-total">0 / 10</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><button class="btn my-btn">Submit Score</button></td>
			<td></td>
		</tr>
	</table>

	<h3 id="comment-header">Comments</h3>
	<table id="comments" class="table">
		<tr>
			<th>Ron Reviewer - 12/2/2017 2:32:24 PM</th>
		</tr>
		<tr>
			<td style="padding-bottom: 25px;">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</td>
		</tr>
		<tr>
			<th>Rachel Reviewer - 12/3/2017 1:42:59 PM</th>
		</tr>
		<tr>
			<td style="padding-bottom: 25px;">Mauris ligula risus, ullamcorper vitae lobortis in, ornare sed felis. In non lacus accumsan libero accumsan ornare id ac dolor. Fusce scelerisque eros elit, nec vehicula lectus dignissim nec. Curabitur vitae purus tristique, placerat leo quis, cursus nisi. Proin euismod dignissim augue, et tristique lectus aliquet ac. Suspendisse finibus felis nec nibh consectetur, sed vulputate diam tempus. Donec et augue blandit orci commodo vehicula ut at erat.</td>
		</tr>
	</table>

	<textarea id="commentInput" class="form-control input-xs-8" rows="4" placeholder="Write a comment..." required></textarea>
	<br/>
	<button id="commentButton" class="btn my-btn pull-right">Publish</button>
</div>

<script>
	$("document").ready(function() {
	   $("input.score").change(function() {
	       if ($(this).val() > 2) {
	           $(this).val(2);
	       } else if ($(this).val() < 0) {
	           $(this).val(0);
	       }
	       updateScoreTotal();
	   });
	});

	function updateScoreTotal() {
		var score = 0;
		$("input.score").each(function() {
		    score += parseInt($(this).val() || 0);
		})
		$("#score-total").text(score + " / 10");
	}

	$("#commentButton").click(function() {
	    var header = document.createElement("th");
	    header.innerText = "Current User - " + getDate();
        $("#comments")[0].insertRow().appendChild(header);
		$("#comments")[0].insertRow().insertCell().innerHTML = $("#commentInput").val();
		$("#commentInput").val("")
	});

	function getDate() {
	    var ts = new Date();
	    return ts.toLocaleDateString() + " " + ts.toLocaleTimeString();
	}
</script>

