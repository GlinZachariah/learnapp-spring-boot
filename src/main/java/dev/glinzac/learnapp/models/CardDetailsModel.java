package dev.glinzac.learnapp.models;

public class CardDetailsModel {
	private int cardNo;
	private int MM;
	private int YY;
	private int CV;
	private String username;
	
	public CardDetailsModel() {
		
	}
	
	public CardDetailsModel(int cardNo, int mM, int yY, int cV, String username) {
		super();
		this.cardNo = cardNo;
		MM = mM;
		YY = yY;
		CV = cV;
		this.username = username;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
