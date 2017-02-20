package Beans;

public class wohnungBezeichnungBean {
	
	private int id;
	private String bezeichnung;
	/**
	 * @param id
	 * @param bezeichnung
	 */
	public wohnungBezeichnungBean(int id, String bezeichnung) {
		super();
		this.id = id;
		this.bezeichnung = bezeichnung;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	

}
