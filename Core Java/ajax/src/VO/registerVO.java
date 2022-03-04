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
@Table(name="register_tbl")

public class registerVO {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name="registerId") 
	private int registerId; 

	@Column(name="firstname") 
	private String fn;

	@Column(name="lastname") 
	private String ln;

	
	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

}
