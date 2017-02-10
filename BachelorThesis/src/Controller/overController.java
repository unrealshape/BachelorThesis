package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Beans.overBean;
import DatabaseManager.Connector;

public class overController {
	
	ArrayList<overBean> overList;
	
	public overController()
	{
		overList = new ArrayList<>();
	}
	
	public void loadOverViewList() throws SQLException
	{
		overList = Connector.getInstance().getOverView();
	}
	
	public int getWohnungen()
	{
		return overList.get(0).getZahlWohnungen();
	}
	public int getImmobilien()
	{
		return overList.get(0).getZahlImmobilien();
	}
	public int getMieter()
	{
		return overList.get(0).getZahlMieter();
	}

}
