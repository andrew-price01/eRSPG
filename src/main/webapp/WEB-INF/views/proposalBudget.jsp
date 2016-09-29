<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<head>
<style>
.radio-inline {
    margin-right: 50px;
    left: 50px;
}
</style>
</head>
<script src="http://thecodeplayer.com/uploads/js/prefixfree-1.0.7.js" type="text/javascript" type="text/javascript"></script>
<script type="text/javascript"><!--
//update all totals in table
function updateTotals() {
	var source1Total=0, source2Total=0, source3Total=0, requestedTotal=0;
	source1Total = (document.form.source1_a_1.value -0) + (document.form.source1_b_1.value -0) + (document.form.source1_c_1.value -0)
	+ (document.form.source1_a_ben.value -0) + (document.form.source1_b_ben.value -0)+ (document.form.source1_c_ben.value -0)
	+ (document.form.source1_a_2.value -0) + (document.form.source1_b_2.value -0)+ (document.form.source1_c_2.value -0)
	+ (document.form.source1_a_3.value -0) + (document.form.source1_b_3.value -0)+ (document.form.source1_c_3.value -0)
	+ (document.form.source1_a_4.value -0) + (document.form.source1_b_4.value -0)+ (document.form.source1_c_4.value -0);
	
	source2Total = (document.form.source2_a_1.value -0) + (document.form.source2_b_1.value -0) + (document.form.source2_c_1.value -0)
	+ (document.form.source2_a_ben.value -0) + (document.form.source2_b_ben.value -0)+ (document.form.source2_c_ben.value -0)
	+ (document.form.source2_a_2.value -0) + (document.form.source2_b_2.value -0)+ (document.form.source2_c_2.value -0)
	+ (document.form.source2_a_3.value -0) + (document.form.source2_b_3.value -0)+ (document.form.source2_c_3.value -0)
	+ (document.form.source2_a_4.value -0) + (document.form.source2_b_4.value -0)+ (document.form.source2_c_4.value -0);
	
	source3Total = (document.form.source3_a_1.value -0) + (document.form.source3_b_1.value -0) + (document.form.source3_c_1.value -0)
	+ (document.form.source3_a_ben.value -0) + (document.form.source3_b_ben.value -0)+ (document.form.source3_c_ben.value -0)
	+ (document.form.source3_a_2.value -0) + (document.form.source3_b_2.value -0)+ (document.form.source3_c_2.value -0)
	+ (document.form.source3_a_3.value -0) + (document.form.source3_b_3.value -0)+ (document.form.source3_c_3.value -0)
	+ (document.form.source3_a_4.value -0) + (document.form.source3_b_4.value -0)+ (document.form.source3_c_4.value -0);
	
	requestedTotal = (document.form.requested_a_1.value -0) + (document.form.requested_b_1.value -0) + (document.form.requested_c_1.value -0)
	+ (document.form.requested_a_ben.value -0) + (document.form.requested_b_ben.value -0)+ (document.form.requested_c_ben.value -0)
	+ (document.form.requested_a_2.value -0) + (document.form.requested_b_2.value -0)+ (document.form.requested_c_2.value -0)
	+ (document.form.requested_a_3.value -0) + (document.form.requested_b_3.value -0)+ (document.form.requested_c_3.value -0)
	+ (document.form.requested_a_4.value -0) + (document.form.requested_b_4.value -0)+ (document.form.requested_c_4.value -0);
	
	document.form.source1Total.value = source1Total.toFixed(2);
	document.form.source2Total.value = source2Total.toFixed(2);
	document.form.source3Total.value = source3Total.toFixed(2);
	document.form.requestedTotal.value = requestedTotal.toFixed(2);
	document.form.grandTotal.value = (source1Total + source2Total + source3Total + requestedTotal).toFixed(2);
	}
//prevents letters being put into input and only allows two decimal places
function check_digit(e,obj,intsize,deczize) {
    var keycode;

    if (window.event) keycode = window.event.keyCode;
    else if (e) { keycode = e.which; }
    else { return true; }

    var fieldval= (obj.value),
        dots = fieldval.split(".").length;

    if(keycode == 46) {
        return dots <= 1;
    }
    if(keycode == 8 || keycode == 9 || keycode == 46 || keycode == 13 ) {
        // back space, tab, delete, enter 
        return true;
    }          
    if((keycode>=32 && keycode <=45) || keycode==47 || (keycode>=58 && keycode<=127)) {
    	alert("Please enter only positive money values.");
    	return false;
         
    }
    if(fieldval == "0" && keycode == 48 ) {
    	alert("Please enter only positive money values.");
    	return false;
        
    }
    if(fieldval.indexOf(".") != -1) { 
        if(keycode == 46) {
        	alert("Please enter only positive money values.");
        	return false;
           
        }
        var splitfield = fieldval.split(".");
        if(splitfield[1].length >= deczize && keycode != 8 && keycode != 0 )
            return false;
        }else if(fieldval.length >= intsize && keycode != 46) {
            return false;
        }else {
            return true;
        }
    }
//--></script>


<div class="container">


	<div class="breadcrumb flat">
			<a href="<s:url value='/proposal/department' />">Details </a>
			<a href="<s:url value='/proposal/awardType' />">Award Type</a>
			<a href="<s:url value='/proposal/budget' />" class="active">Budget</a>
			<a href="<s:url value='/proposal/body' />">Body</a>
			<a href="<s:url value='/proposal/bodyDetails' />">Body Details</a>
			<a href="<s:url value='/proposal/bodyQuestions' />">Questions</a>
			<a href="<s:url value='/proposal/upload' />">Upload</a>
	</div>

	
	
	<legend><h2 style="text-align:center;">Budget</h2></legend>
	
	<form:form method="post" name="form" modelAttribute="budgetForm">
		<div class="form-group">
			<label class="required-field">Does this proposal request funds to use an <u>undergraduate student assistant(s)</u>?</label>
			<div class="radio-inline">
		  		<label>
		    		<form:radiobutton path="studentAssistants" value="true" />
		    		Yes
		  		</label>
			</div>
			<div class="radio-inline">
				<label>
		    		<form:radiobutton path="studentAssistants" value="false" />
		    		No
		  		</label>
			</div>
			<form:errors path="studentAssistants" />
		</div>
		

	<br>
	<div class="form-group">
		<div class="table-responsive">
			<table class="table table-bordered table-condensed">
		    	<tbody>
		    		<tr>
		            <th></th>
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
			           	<td><form:input type="text" class="form-control" placeholder="a)" path="a1"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_a_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);" /></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_a_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_a_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_a_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_1"></th>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="b)" path="b1"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_b_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);" /></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_b_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_b_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_b_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_b_1"></th>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="c)" path="c1"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_c_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_c_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_c_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_c_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_c_1"></th>
		        	</tr>
		        	<tr>
		           		<td colspan="6"><strong> BENEFITS for Personnel Resources(8.5% for student employees, 15% for full-time faculty
											requesting reassigned time, 22% for full-time faculty and staff requesting a stipend)
		           		</strong></td>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="a)" path="aBen"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_a_ben" onchange="updateTotals()"  onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_a_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_a_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_a_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_ben"></th>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="b)" path="bBen"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_b_ben" onchange="updateTotals()"  onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_b_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_b_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_b_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_b_ben"></th>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="c)" path="cBen"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_c_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_c_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_c_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_c_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_c_ben"></th>
		        	</tr>
		        	<tr>
		           		<td colspan="6"><strong> 2) EQUIPMENT AND MATERIALS</strong></td>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="a)" path="a2"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_a_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_a_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_a_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_a_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_2"></th>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="b)" path="b2"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_b_2" onchange="updateTotals()"  onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_b_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_b_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_b_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_b_2"></th>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="c)" path="c2"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_c_2"  onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_c_2"  onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_c_2"  onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_c_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_c_2"></th>
		        	</tr>
		        	<tr>
		           		<td colspan="6"><strong> 3) TRAVEL</strong></td>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="a)" path="a3"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_a_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_a_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_a_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_a_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_3"></th>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="b)" path="b3"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_b_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_b_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_b_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_b_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);" /></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_b_3"></th>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="c)" path="c3"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_c_3"  onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_c_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_c_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_c_3" onchange="updateRequested()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_c_3"></th>
		        	</tr>
		        	<tr>
		        		<td colspan="6"><strong> 4) OTHER</strong></td>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="a)" path="a4"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_a_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_a_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_a_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_a_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_4"></th>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="b)" path="b4"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_b_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_b_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_b_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_b_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_b_4"></th>
		        	</tr>
		        	<tr>
			           	<td><form:input type="text" class="form-control" placeholder="c)" path="c4"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1_c_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);" /></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2_c_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3_c_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requested_c_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,10,2);"/></td>
			           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_c_4"></th>
		        	</tr>
		        	
		        	<tr>
			           	<td style="vertical-align:middle;">TOTALS</td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source1Total" readonly="true" /></td>
			           	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source2Total" readonly="true"/></td>
			          	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="source3Total" readonly="true" /></td>
			          	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="requestedTotal" readonly="true"/></td>
			          	<td><form:input type="text" class="form-control" placeholder="0" style="text-align: right" path="grandTotal" readonly="true"/></td>
		        	</tr>
		        </tbody>
			</table>
		</div>
	</div>
	
	<div>
		<button type="button" class="btn my-btn pull-left" onclick='window.location.href="<s:url value="/proposal/awardType" />"'>Previous</button>
		<button type="button" class="btn my-btn pull-right" onclick='window.location.href="<s:url value="/proposal/body" />"'>Next</button>
	</div>
	</form:form>
</div>
