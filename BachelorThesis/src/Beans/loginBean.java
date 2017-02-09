package Beans;

/**
 * @author Diana
 *
 */
public class loginBean {
	
	private int id;
	private String benutzername;
	private String passwort;
	private String eMail;
	/**
	 * @param id
	 * @param benutzername
	 * @param passwort
	 * @param eMail
	 */
	public loginBean(int id, String benutzername, String passwort, String eMail) {
		super();
		this.id = id;
		this.benutzername = benutzername;
		this.passwort = passwort;
		this.eMail = eMail;
	}
	/**
	 * @param benutzername
	 * @param passwort
	 */
	public loginBean(String benutzername, String passwort) {
		super();
		this.benutzername = benutzername;
		this.passwort = passwort;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBenutzername() {
		return benutzername;
	}
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
	

}
