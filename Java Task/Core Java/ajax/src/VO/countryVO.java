package VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author admin
 *
 */
@Entity 
@Table(name="country_tbl")

public class countryVO {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="countryId") 
	private int countryId; 

	@Column(name="countryName") 
	private String countryName;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
	
	
}
