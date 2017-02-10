package Beans;

import java.sql.Date;

public class wohnungenBean {
	
	private int wohnungID;
	private int anzahlZimmer;
	private int quadratmeter;
	private float miete;
	private String status;
	private Date datum_eingang_kaution;
	private String info;
	private int immobilienID;
	private int hauptmieterID;
	private String wohnungsBezeichnung;
	/**
	 * @param wohnungID
	 * @param anzahlZimmer
	 * @param quadratmeter
	 * @param miete
	 * @param status
	 * @param datum_eingang_kaution
	 * @param info
	 * @param immobilienID
	 * @param hauptmieterID
	 * @param wohnungsBezeichnung
	 */
	public wohnungenBean(int wohnungID, int anzahlZimmer, int quadratmeter, float miete, String status,
			Date datum_eingang_kaution, String info, int immobilienID, int hauptmieterID, String wohnungsBezeichnung) {
		super();
		this.wohnungID = wohnungID;
		this.anzahlZimmer = anzahlZimmer;
		this.quadratmeter = quadratmeter;
		this.miete = miete;
		this.status = status;
		this.datum_eingang_kaution = datum_eingang_kaution;
		this.info = info;
		this.immobilienID = immobilienID;
		this.hauptmieterID = hauptmieterID;
		this.wohnungsBezeichnung = wohnungsBezeichnung;
	}
	public int getWohnungID() {
		return wohnungID;
	}
	public void setWohnungID(int wohnungID) {
		this.wohnungID = wohnungID;
	}
	public int getAnzahlZimmer() {
		return anzahlZimmer;
	}
	public void setAnzahlZimmer(int anzahlZimmer) {
		this.anzahlZimmer = anzahlZimmer;
	}
	public int getQuadratmeter() {
		return quadratmeter;
	}
	public void setQuadratmeter(int quadratmeter) {
		this.quadratmeter = quadratmeter;
	}
	public float getMiete() {
		return miete;
	}
	public void setMiete(float miete) {
		this.miete = miete;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDatum_eingang_kaution() {
		return datum_eingang_kaution;
	}
	public void setDatum_eingang_kaution(Date datum_eingang_kaution) {
		this.datum_eingang_kaution = datum_eingang_kaution;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getImmobilienID() {
		return immobilienID;
	}
	public void setImmobilienID(int immobilienID) {
		this.immobilienID = immobilienID;
	}
	public int getHauptmieterID() {
		return hauptmieterID;
	}
	public void setHauptmieterID(int hauptmieterID) {
		this.hauptmieterID = hauptmieterID;
	}
	public String getWohnungsBezeichnung() {
		return wohnungsBezeichnung;
	}
	public void setWohnungsBezeichnung(String wohnungsBezeichnung) {
		this.wohnungsBezeichnung = wohnungsBezeichnung;
	}
	
	

}
