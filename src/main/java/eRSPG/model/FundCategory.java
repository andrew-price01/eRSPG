package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FundCategory")
public class FundCategory {
	@Id
	@Column(name="fundCategoryID")
	private int fundCategoryId;
	
	@Column(name="fundCategoryDesc")
	private String fundCategoryDesc;
	
	public FundCategory(){
		
	}

	public int getFundCategoryId() {
		return fundCategoryId;
	}

	public void setFundCategoryId(int fundCategoryId) {
		this.fundCategoryId = fundCategoryId;
	}

	public String getFundCategoryDesc() {
		return fundCategoryDesc;
	}

	public void setFundCategoryDesc(String fundCategoryDesc) {
		this.fundCategoryDesc = fundCategoryDesc;
	}
	
}
