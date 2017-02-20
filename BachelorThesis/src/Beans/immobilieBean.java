package Beans;

public class immobilieBean {
	
	private int id;
	private String bezeichnung;
	private String land;
	private String straße;
	private int hausNummer;
	private int plz;
	private int anzahlWohnung;
	private int anzahlStockwerk;
	private int quadratmeter;
	private String info;
	/**
	 * @param id
	 * @param bezeichnung
	 * @param land
	 * @param straße
	 * @param hausNummer
	 * @param plz
	 * @param anzahlWohnung
	 * @param anzahlStockwerk
	 * @param quadratmeter
	 * @param info
	 */
	public immobilieBean(int id, String bezeichnung, String land, String straße, int hausNummer, int plz,
			int anzahlWohnung, int anzahlStockwerk, int quadratmeter, String info) {
		super();
		this.id = id;
		this.bezeichnung = bezeichnung;
		this.land = land;
		this.straße = straße;
		this.hausNummer = hausNummer;
		this.plz = plz;
		this.anzahlWohnung = anzahlWohnung;
		this.anzahlStockwerk = anzahlStockwerk;
		this.quadratmeter = quadratmeter;
		this.info = info;
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
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	public String getStraße() {
		return straße;
	}
	public void setStraße(String straße) {
		this.straße = straße;
	}
	public int getHausNummer() {
		return hausNummer;
	}
	public void setHausNummer(int hausNummer) {
		this.hausNummer = hausNummer;
	}
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	public int getAnzahlWohnung() {
		return anzahlWohnung;
	}
	public void setAnzahlWohnung(int anzahlWohnung) {
		this.anzahlWohnung = anzahlWohnung;
	}
	public int getAnzahlStockwerk() {
		return anzahlStockwerk;
	}
	public void setAnzahlStockwerk(int anzahlStockwerk) {
		this.anzahlStockwerk = anzahlStockwerk;
	}
	public int getQuadratmeter() {
		return quadratmeter;
	}
	public void setQuadratmeter(int quadratmeter) {
		this.quadratmeter = quadratmeter;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
