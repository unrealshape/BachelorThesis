package Beans;

import java.sql.Date;

public class monatsMieteBean {
	
	private int id;
	private Date datum_eingang_kaution;
	private String info;
	private int hauptMieterDd;
	private int monatId;
	/**
	 * @param id
	 * @param datum_eingang_kaution
	 * @param info
	 * @param hauptMieterDd
	 * @param monatId
	 */
	public monatsMieteBean(int id, Date datum_eingang_kaution, String info, int hauptMieterDd, int monatId) {
		super();
		this.id = id;
		this.datum_eingang_kaution = datum_eingang_kaution;
		this.info = info;
		this.hauptMieterDd = hauptMieterDd;
		this.monatId = monatId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getHauptMieterDd() {
		return hauptMieterDd;
	}
	public void setHauptMieterDd(int hauptMieterDd) {
		this.hauptMieterDd = hauptMieterDd;
	}
	public int getMonatId() {
		return monatId;
	}
	public void setMonatId(int monatId) {
		this.monatId = monatId;
	}
	
	

}
