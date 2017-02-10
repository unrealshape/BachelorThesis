package Beans;

public class overBean {
	
	private int zahlWohnungen;
	private int zahlImmobilien;
	private int zahlMieter;
	/**
	 * @param zahlWohnungen
	 * @param zahlImmobilien
	 * @param zahlMieter
	 */
	public overBean(int zahlWohnungen, int zahlImmobilien, int zahlMieter) {
		super();
		this.zahlWohnungen = zahlWohnungen;
		this.zahlImmobilien = zahlImmobilien;
		this.zahlMieter = zahlMieter;
	}
	public int getZahlWohnungen() {
		return zahlWohnungen;
	}
	public void setZahlWohnungen(int zahlWohnungen) {
		this.zahlWohnungen = zahlWohnungen;
	}
	public int getZahlImmobilien() {
		return zahlImmobilien;
	}
	public void setZahlImmobilien(int zahlImmobilien) {
		this.zahlImmobilien = zahlImmobilien;
	}
	public int getZahlMieter() {
		return zahlMieter;
	}
	public void setZahlMieter(int zahlMieter) {
		this.zahlMieter = zahlMieter;
	}
	
	

}
