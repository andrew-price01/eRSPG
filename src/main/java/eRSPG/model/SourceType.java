package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SourceType")
public class SourceType {
	@Id
	@Column(name="sourceTypeID")
	private int sourceTypeId;
	
	@Column(name="sourceTypeDesc")
	private String sourceTypeDesc;
	
	public SourceType(){
		
	}

	public int getSourceTypeId() {
		return sourceTypeId;
	}

	public void setSourceTypeId(int sourceTypeId) {
		this.sourceTypeId = sourceTypeId;
	}

	public String getSourceTypeDesc() {
		return sourceTypeDesc;
	}

	public void setSourceTypeDesc(String sourceTypeDesc) {
		this.sourceTypeDesc = sourceTypeDesc;
	}
	
}
