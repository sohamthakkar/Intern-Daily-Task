package VO;

import javax.persistence.*;
import VO.stateVO;

@Entity 
@Table(name="city_tbl")

public class cityVO {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="cityId") 
	private int cityId; 

	@Column(name="cityName") 
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name="stateId")
	private stateVO v2;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public stateVO getV2() {
		return v2;
	}

	public void setV2(stateVO v2) {
		this.v2 = v2;
	}


}
