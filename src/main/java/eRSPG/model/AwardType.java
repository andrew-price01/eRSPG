package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AwardType")
public class AwardType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="awardTypeID")
	private int awardTypeId;
	
	@Column(name="awardName")
	private String awardName;

	public AwardType(){
		
	}
	
	public int getAwardTypeId() {
		return awardTypeId;
	}

	public void setAwardTypeId(int awardTypeId) {
		this.awardTypeId = awardTypeId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	
	
}
