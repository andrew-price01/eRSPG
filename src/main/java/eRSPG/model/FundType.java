package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FundType")
public class FundType {
	@Id
	@Column(name="fundTypeID")
	private int fundTypeId;
	
	@Column(name="fundTypeDesc")
	private String fundTypeDesc;
	
	public FundType(){
		
	}

	public int getFundTypeId() {
		return fundTypeId;
	}

	public void setFundTypeId(int fundTypeId) {
		this.fundTypeId = fundTypeId;
	}

	public String getFundTypeDesc() {
		return fundTypeDesc;
	}

	public void setFundTypeDesc(String fundTypeDesc) {
		this.fundTypeDesc = fundTypeDesc;
	}
	
}
