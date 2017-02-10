package Beans;

public class monatBean {
	
	private int monatID;
	private String monatName;
	
	/**
	 * @param monatID
	 * @param monatName
	 */
	public monatBean(int monatID, String monatName) {
		super();
		this.monatID = monatID;
		this.monatName = monatName;
	}
	
	public int getMonatID() {
		return monatID;
	}
	public void setMonatID(int monatID) {
		this.monatID = monatID;
	}
	public String getMonatName() {
		return monatName;
	}
	public void setMonatName(String monatName) {
		this.monatName = monatName;
	}

	
	

}
