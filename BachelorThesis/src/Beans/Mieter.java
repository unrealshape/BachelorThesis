package Beans;

import javax.print.DocFlavor.STRING;

public class Mieter {
	
	private int mieterID;
	private String vorname;
	private String nachname;
	private String strasse;
	private int hausNummer;
	private int plz;
	private String stadt;
	private int telefonNummer;
	private String IBAN;
	private String BIC;
	private String info;
	/**
	 * @param mieterID
	 * @param vorname
	 * @param nachname
	 * @param strasse
	 * @param hausNummer
	 * @param plz
	 * @param stadt
	 * @param telefonNummer
	 * @param iBAN
	 * @param bIC
	 * @param info
	 */
	public Mieter(int mieterID, String vorname, String nachname, String strasse, int hausNummer, int plz, String stadt,
			int telefonNummer, String iBAN, String bIC, String info) {
		super();
		this.mieterID = mieterID;
		this.vorname = vorname;
		this.nachname = nachname;
		this.strasse = strasse;
		this.hausNummer = hausNummer;
		this.plz = plz;
		this.stadt = stadt;
		this.telefonNummer = telefonNummer;
		IBAN = iBAN;
		BIC = bIC;
		this.info = info;
	}
	public int getMieterID() {
		return mieterID;
	}
	public void setMieterID(int mieterID) {
		this.mieterID = mieterID;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
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
	public String getStadt() {
		return stadt;
	}
	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	public int getTelefonNummer() {
		return telefonNummer;
	}
	public void setTelefonNummer(int telefonNummer) {
		this.telefonNummer = telefonNummer;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public String getBIC() {
		return BIC;
	}
	public void setBIC(String bIC) {
		BIC = bIC;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
