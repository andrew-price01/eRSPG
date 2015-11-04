<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript"><!--
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
         return false;
    }
    if(fieldval == "0" && keycode == 48 ) {
        return false;
    }
    if(fieldval.indexOf(".") != -1) { 
        if(keycode == 46) {
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
	<div class="center-block">
	<h1 class="text-center">Budget</h1>
	</div>
	
	<br>
	<form name="form" onsubmit="" >
	<p><strong>Does this proposal request funds to use an <u>undergraduate student assistant(s)</u>?</strong></p>
	<div class="radio">
  		<label>
    		<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
    		Yes
  		</label>
	</div>
	<div class="radio">
		<label>
    		<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2" checked>
    		No
  		</label>
	</div>
	<br>
	<div class="table-responsive">
		<table class="table table-bordered table-condensed">
	    	<tbody>
	    		<tr>
	            <th></th>
	            <th class="text-center" style="background-color:gray">Funds Committed from Source #1</th>
	            <th class="text-center" style="background-color:gray">Funds Committed from Source #2</th>
	            <th class="text-center" style="background-color:gray">Funds Committed from Source #3</th>
	            <th	class="text-center" style="background-color:gray">Funds <u>Requested</u> from <strong>RSPG</strong></th>
	            <th	class="text-center" style="background-color:gray">GRAND TOTAL</th>
	        	</tr>
	        	<tr>
	           	<td colspan="6"><strong> 1) PERSONNEL RESOURCES (assistants, consultants, released time)</strong></td>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">a)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_a_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);" /></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_a_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_a_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_a_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_1"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">b)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_b_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);" /></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_b_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_b_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_b_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_b_1"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">c)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_c_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_c_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_c_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_c_1" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_c_1"></th>
	        	</tr>
	        	<tr>
	           	<td colspan="6"><strong> BENEFITS for Personnel Resources(8.5% for student employees, 15% for full-time faculty
										requesting reassigned time, 22% for full-time faculty and staff requesting a stipend)
	           	</strong></td>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">a)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_a_ben" onchange="updateTotals()"  onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_a_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_a_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_a_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_ben"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">b)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_b_ben" onchange="updateTotals()"  onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_b_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_b_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_b_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_b_ben"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">c)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_c_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_c_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_c_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_c_ben" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           		<th class="text-right" style="vertical-align:middle;" id="grantTotal_c_ben"></th>
	        	</tr>
	        	<tr>
	           	<td colspan="6"><strong> 2) EQUIPMENT AND MATERIALS</strong></td>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">a)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_a_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_a_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_a_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_a_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_2"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">b)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_b_2" onchange="updateTotals()"  onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_b_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_b_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_b_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_b_2"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">c)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_c_2"  onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_c_2"  onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_c_2"  onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_c_2" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_c_2"></th>
	        	</tr>
	        	<tr>
	           	<td colspan="6"><strong> 3) TRAVEL</strong></td>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">a)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_a_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_a_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_a_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_a_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_3"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">b)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_b_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_b_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_b_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_b_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);" /></td>
	           		<th class="text-right" style="vertical-align:middle;" id="grantTotal_b_3"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">c)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_c_3"  onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_c_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_c_3" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_c_3" onchange="updateRequested()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_c_3"></th>
	        	</tr>
	        	<tr>
	        	<td colspan="6"><strong> 4) OTHER</strong></td>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">a)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_a_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_a_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_a_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_a_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           		<th class="text-right" style="vertical-align:middle;" id="grantTotal_a_4"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">b)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_b_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_b_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_b_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_b_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_b_4"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">c)</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1_c_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);" /></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2_c_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3_c_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requested_c_4" onchange="updateTotals()" onkeypress="return check_digit(event,this,15,2);"/></td>
	           	<th class="text-right" style="vertical-align:middle;" id="grantTotal_c_4"></th>
	        	</tr>
	        	<tr>
	           	<td style="vertical-align:middle;">TOTALS</td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source1Total" readonly /></td>
	           	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source2Total"  readonly /></td>
	          	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="source3Total" readonly /></td>
	          	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="requestedTotal"  readonly /></td>
	          	<td><input type="text" class="form-control" placeholder="0" style="text-align: right" id="grandTotal" readonly /></td>
	        	</tr>
	        	
	   	 	</tbody>
		</table>
	</div>
	</form>

	<input class="buttons"  onclick="window.location.href='detail';" type="button" value="Previous"/>
	<input class="buttons pull-right" type="button"  onclick="window.location.href='body';" value="Next" />

	<br>
	<br>
</div>
