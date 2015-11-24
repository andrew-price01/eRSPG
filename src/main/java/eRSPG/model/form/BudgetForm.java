package eRSPG.model.form;


import javax.validation.constraints.NotNull;


public class BudgetForm {
	
	@NotNull(message="Please select if you wish to fund student assistants for this proposal")
	private boolean studentAssistants;
	
	public boolean getStudentAssistants() {
		return studentAssistants;
	}

	public void setStudentAssistants(boolean studentAssistants) {
		this.studentAssistants = studentAssistants;
	}
	
	private String a1;
	private String a2;
	private String a3;
	private String a4;
	private String aBen;
	
	private String b1;
	private String b2;
	private String b3;
	private String b4;
	private String bBen;
	
	private String c1;
	private String c2;
	private String c3;
	private String c4;
	private String cBen;
	
	private double source1_a_1;
	private double source2_a_1;
	private double source3_a_1;
	private double requested_a_1;
	
	private double source1_b_1;
	private double source2_b_1;
	private double source3_b_1;
	private double requested_b_1;
	
	private double source1_c_1;
	private double source2_c_1;
	private double source3_c_1;
	private double requested_c_1;
	
	
	private double source1_a_ben;
	private double source2_a_ben;
	private double source3_a_ben;
	private double requested_a_ben;
	
	private double source1_b_ben;
	private double source2_b_ben;
	private double source3_b_ben;
	private double requested_b_ben;
	
	private double source1_c_ben;
	private double source2_c_ben;
	private double source3_c_ben;
	private double requested_c_ben;
	
	private double source1_a_2;
	private double source2_a_2;
	private double source3_a_2;
	private double requested_a_2;
	
	private double source1_b_2;
	private double source2_b_2;
	private double source3_b_2;
	private double requested_b_2;
	
	private double source1_c_2;
	private double source2_c_2;
	private double source3_c_2;
	private double requested_c_2;
	
	private double source1_a_3;
	private double source2_a_3;
	private double source3_a_3;
	private double requested_a_3;
	
	private double source1_b_3;
	private double source2_b_3;
	private double source3_b_3;
	private double requested_b_3;
	
	private double source1_c_3;
	private double source2_c_3;
	private double source3_c_3;
	private double requested_c_3;
	
	private double source1_a_4;
	private double source2_a_4;
	private double source3_a_4;
	private double requested_a_4;
	
	private double source1_b_4;
	private double source2_b_4;
	private double source3_b_4;
	private double requested_b_4;
	
	private double source1_c_4;
	private double source2_c_4;
	private double source3_c_4;
	private double requested_c_4;
	
	private double source1Total;
	private double source2Total;
	private double source3Total;
	private double requestedTotal;
	private double grandTotal;

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public String getA3() {
		return a3;
	}

	public void setA3(String a3) {
		this.a3 = a3;
	}

	public String getA4() {
		return a4;
	}

	public void setA4(String a4) {
		this.a4 = a4;
	}

	public String getaBen() {
		return aBen;
	}

	public void setaBen(String aBen) {
		this.aBen = aBen;
	}

	public String getB1() {
		return b1;
	}

	public void setB1(String b1) {
		this.b1 = b1;
	}

	public String getB2() {
		return b2;
	}

	public void setB2(String b2) {
		this.b2 = b2;
	}

	public String getB3() {
		return b3;
	}

	public void setB3(String b3) {
		this.b3 = b3;
	}

	public String getB4() {
		return b4;
	}

	public void setB4(String b4) {
		this.b4 = b4;
	}

	public String getbBen() {
		return bBen;
	}

	public void setbBen(String bBen) {
		this.bBen = bBen;
	}

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	public String getC3() {
		return c3;
	}

	public void setC3(String c3) {
		this.c3 = c3;
	}

	public String getC4() {
		return c4;
	}

	public void setC4(String c4) {
		this.c4 = c4;
	}

	public String getcBen() {
		return cBen;
	}

	public void setcBen(String cBen) {
		this.cBen = cBen;
	}

	public double getSource1_a_1() {
		return source1_a_1;
	}

	public void setSource1_a_1(double source1_a_1) {
		this.source1_a_1 = source1_a_1;
	}

	public double getSource2_a_1() {
		return source2_a_1;
	}

	public void setSource2_a_1(double source2_a_1) {
		this.source2_a_1 = source2_a_1;
	}

	public double getSource3_a_1() {
		return source3_a_1;
	}

	public void setSource3_a_1(double source3_a_1) {
		this.source3_a_1 = source3_a_1;
	}

	public double getRequested_a_1() {
		return requested_a_1;
	}

	public void setRequested_a_1(double requested_a_1) {
		this.requested_a_1 = requested_a_1;
	}

	public double getSource1_b_1() {
		return source1_b_1;
	}

	public void setSource1_b_1(double source1_b_1) {
		this.source1_b_1 = source1_b_1;
	}

	public double getSource2_b_1() {
		return source2_b_1;
	}

	public void setSource2_b_1(double source2_b_1) {
		this.source2_b_1 = source2_b_1;
	}

	public double getSource3_b_1() {
		return source3_b_1;
	}

	public void setSource3_b_1(double source3_b_1) {
		this.source3_b_1 = source3_b_1;
	}

	public double getRequested_b_1() {
		return requested_b_1;
	}

	public void setRequested_b_1(double requested_b_1) {
		this.requested_b_1 = requested_b_1;
	}

	public double getSource1_c_1() {
		return source1_c_1;
	}

	public void setSource1_c_1(double source1_c_1) {
		this.source1_c_1 = source1_c_1;
	}

	public double getSource2_c_1() {
		return source2_c_1;
	}

	public void setSource2_c_1(double source2_c_1) {
		this.source2_c_1 = source2_c_1;
	}

	public double getSource3_c_1() {
		return source3_c_1;
	}

	public void setSource3_c_1(double source3_c_1) {
		this.source3_c_1 = source3_c_1;
	}

	public double getRequested_c_1() {
		return requested_c_1;
	}

	public void setRequested_c_1(double requested_c_1) {
		this.requested_c_1 = requested_c_1;
	}

	public double getSource1_a_ben() {
		return source1_a_ben;
	}

	public void setSource1_a_ben(double source1_a_ben) {
		this.source1_a_ben = source1_a_ben;
	}

	public double getSource2_a_ben() {
		return source2_a_ben;
	}

	public void setSource2_a_ben(double source2_a_ben) {
		this.source2_a_ben = source2_a_ben;
	}

	public double getSource3_a_ben() {
		return source3_a_ben;
	}

	public void setSource3_a_ben(double source3_a_ben) {
		this.source3_a_ben = source3_a_ben;
	}

	public double getRequested_a_ben() {
		return requested_a_ben;
	}

	public void setRequested_a_ben(double requested_a_ben) {
		this.requested_a_ben = requested_a_ben;
	}

	public double getSource1_b_ben() {
		return source1_b_ben;
	}

	public void setSource1_b_ben(double source1_b_ben) {
		this.source1_b_ben = source1_b_ben;
	}

	public double getSource2_b_ben() {
		return source2_b_ben;
	}

	public void setSource2_b_ben(double source2_b_ben) {
		this.source2_b_ben = source2_b_ben;
	}

	public double getSource3_b_ben() {
		return source3_b_ben;
	}

	public void setSource3_b_ben(double source3_b_ben) {
		this.source3_b_ben = source3_b_ben;
	}

	public double getRequested_b_ben() {
		return requested_b_ben;
	}

	public void setRequested_b_ben(double requested_b_ben) {
		this.requested_b_ben = requested_b_ben;
	}

	public double getSource1_c_ben() {
		return source1_c_ben;
	}

	public void setSource1_c_ben(double source1_c_ben) {
		this.source1_c_ben = source1_c_ben;
	}

	public double getSource2_c_ben() {
		return source2_c_ben;
	}

	public void setSource2_c_ben(double source2_c_ben) {
		this.source2_c_ben = source2_c_ben;
	}

	public double getSource3_c_ben() {
		return source3_c_ben;
	}

	public void setSource3_c_ben(double source3_c_ben) {
		this.source3_c_ben = source3_c_ben;
	}

	public double getRequested_c_ben() {
		return requested_c_ben;
	}

	public void setRequested_c_ben(double requested_c_ben) {
		this.requested_c_ben = requested_c_ben;
	}

	public double getSource1_a_2() {
		return source1_a_2;
	}

	public void setSource1_a_2(double source1_a_2) {
		this.source1_a_2 = source1_a_2;
	}

	public double getSource2_a_2() {
		return source2_a_2;
	}

	public void setSource2_a_2(double source2_a_2) {
		this.source2_a_2 = source2_a_2;
	}

	public double getSource3_a_2() {
		return source3_a_2;
	}

	public void setSource3_a_2(double source3_a_2) {
		this.source3_a_2 = source3_a_2;
	}

	public double getRequested_a_2() {
		return requested_a_2;
	}

	public void setRequested_a_2(double requested_a_2) {
		this.requested_a_2 = requested_a_2;
	}

	public double getSource1_b_2() {
		return source1_b_2;
	}

	public void setSource1_b_2(double source1_b_2) {
		this.source1_b_2 = source1_b_2;
	}

	public double getSource2_b_2() {
		return source2_b_2;
	}

	public void setSource2_b_2(double source2_b_2) {
		this.source2_b_2 = source2_b_2;
	}

	public double getSource3_b_2() {
		return source3_b_2;
	}

	public void setSource3_b_2(double source3_b_2) {
		this.source3_b_2 = source3_b_2;
	}

	public double getRequested_b_2() {
		return requested_b_2;
	}

	public void setRequested_b_2(double requested_b_2) {
		this.requested_b_2 = requested_b_2;
	}

	public double getSource1_c_2() {
		return source1_c_2;
	}

	public void setSource1_c_2(double source1_c_2) {
		this.source1_c_2 = source1_c_2;
	}

	public double getSource2_c_2() {
		return source2_c_2;
	}

	public void setSource2_c_2(double source2_c_2) {
		this.source2_c_2 = source2_c_2;
	}

	public double getSource3_c_2() {
		return source3_c_2;
	}

	public void setSource3_c_2(double source3_c_2) {
		this.source3_c_2 = source3_c_2;
	}

	public double getRequested_c_2() {
		return requested_c_2;
	}

	public void setRequested_c_2(double requested_c_2) {
		this.requested_c_2 = requested_c_2;
	}

	public double getSource1_a_3() {
		return source1_a_3;
	}

	public void setSource1_a_3(double source1_a_3) {
		this.source1_a_3 = source1_a_3;
	}

	public double getSource2_a_3() {
		return source2_a_3;
	}

	public void setSource2_a_3(double source2_a_3) {
		this.source2_a_3 = source2_a_3;
	}

	public double getSource3_a_3() {
		return source3_a_3;
	}

	public void setSource3_a_3(double source3_a_3) {
		this.source3_a_3 = source3_a_3;
	}

	public double getRequested_a_3() {
		return requested_a_3;
	}

	public void setRequested_a_3(double requested_a_3) {
		this.requested_a_3 = requested_a_3;
	}

	public double getSource1_b_3() {
		return source1_b_3;
	}

	public void setSource1_b_3(double source1_b_3) {
		this.source1_b_3 = source1_b_3;
	}

	public double getSource2_b_3() {
		return source2_b_3;
	}

	public void setSource2_b_3(double source2_b_3) {
		this.source2_b_3 = source2_b_3;
	}

	public double getSource3_b_3() {
		return source3_b_3;
	}

	public void setSource3_b_3(double source3_b_3) {
		this.source3_b_3 = source3_b_3;
	}

	public double getRequested_b_3() {
		return requested_b_3;
	}

	public void setRequested_b_3(double requested_b_3) {
		this.requested_b_3 = requested_b_3;
	}

	public double getSource1_c_3() {
		return source1_c_3;
	}

	public void setSource1_c_3(double source1_c_3) {
		this.source1_c_3 = source1_c_3;
	}

	public double getSource2_c_3() {
		return source2_c_3;
	}

	public void setSource2_c_3(double source2_c_3) {
		this.source2_c_3 = source2_c_3;
	}

	public double getSource3_c_3() {
		return source3_c_3;
	}

	public void setSource3_c_3(double source3_c_3) {
		this.source3_c_3 = source3_c_3;
	}

	public double getRequested_c_3() {
		return requested_c_3;
	}

	public void setRequested_c_3(double requested_c_3) {
		this.requested_c_3 = requested_c_3;
	}

	public double getSource1_a_4() {
		return source1_a_4;
	}

	public void setSource1_a_4(double source1_a_4) {
		this.source1_a_4 = source1_a_4;
	}

	public double getSource2_a_4() {
		return source2_a_4;
	}

	public void setSource2_a_4(double source2_a_4) {
		this.source2_a_4 = source2_a_4;
	}

	public double getSource3_a_4() {
		return source3_a_4;
	}

	public void setSource3_a_4(double source3_a_4) {
		this.source3_a_4 = source3_a_4;
	}

	public double getRequested_a_4() {
		return requested_a_4;
	}

	public void setRequested_a_4(double requested_a_4) {
		this.requested_a_4 = requested_a_4;
	}

	public double getSource1_b_4() {
		return source1_b_4;
	}

	public void setSource1_b_4(double source1_b_4) {
		this.source1_b_4 = source1_b_4;
	}

	public double getSource2_b_4() {
		return source2_b_4;
	}

	public void setSource2_b_4(double source2_b_4) {
		this.source2_b_4 = source2_b_4;
	}

	public double getSource3_b_4() {
		return source3_b_4;
	}

	public void setSource3_b_4(double source3_b_4) {
		this.source3_b_4 = source3_b_4;
	}

	public double getRequested_b_4() {
		return requested_b_4;
	}

	public void setRequested_b_4(double requested_b_4) {
		this.requested_b_4 = requested_b_4;
	}

	public double getSource1_c_4() {
		return source1_c_4;
	}

	public void setSource1_c_4(double source1_c_4) {
		this.source1_c_4 = source1_c_4;
	}

	public double getSource2_c_4() {
		return source2_c_4;
	}

	public void setSource2_c_4(double source2_c_4) {
		this.source2_c_4 = source2_c_4;
	}

	public double getSource3_c_4() {
		return source3_c_4;
	}

	public void setSource3_c_4(double source3_c_4) {
		this.source3_c_4 = source3_c_4;
	}

	public double getRequested_c_4() {
		return requested_c_4;
	}

	public void setRequested_c_4(double requested_c_4) {
		this.requested_c_4 = requested_c_4;
	}

	public double getSource1Total() {
		return source1Total;
	}

	public void setSource1Total(double source1Total) {
		this.source1Total = source1Total;
	}

	public double getSource2Total() {
		return source2Total;
	}

	public void setSource2Total(double source2Total) {
		this.source2Total = source2Total;
	}

	public double getSource3Total() {
		return source3Total;
	}

	public void setSource3Total(double source3Total) {
		this.source3Total = source3Total;
	}

	public double getRequestedTotal() {
		return requestedTotal;
	}

	public void setRequestedTotal(double requestedTotal) {
		this.requestedTotal = requestedTotal;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	
	
	
	
	

}
