package VO;

import javax.persistence.*;
import VO.countryVO;

@Entity 
@Table(name="state_tbl")

public class stateVO {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="stateId") 
	private int stateId; 

	@Column(name="stateName") 
	private String stateName;

	@ManyToOne
	@JoinColumn(name="countryId")
	private countryVO v1;

	
	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public countryVO getV1() {
		return v1;
	}

	public void setV1(countryVO v1) {
		this.v1 = v1;
	}


	
}
