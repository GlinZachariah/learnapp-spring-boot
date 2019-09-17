package dev.glinzac.learnapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="card_details")
public class CardDetails {
	@Id
	private int cardNo;
	private int MM;
	private int YY;
	private int CV;
	
	@OneToOne
	@JoinColumn(name = "user_name")
	private UserDetails userDetails;
	
	public CardDetails(){
		
	}
	
	public CardDetails(int cardNo, int mM, int yY, int cV) {
		super();
		this.cardNo = cardNo;
		MM = mM;
		YY = yY;
		CV = cV;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public int getMM() {
		return MM;
	}
	public void setMM(int mM) {
		MM = mM;
	}
	public int getYY() {
		return YY;
	}
	public void setYY(int yY) {
		YY = yY;
	}
	public int getCV() {
		return CV;
	}
	public void setCV(int cV) {
		CV = cV;
	}
	
}
