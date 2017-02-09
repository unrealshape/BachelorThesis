
package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Beans.loginBean;
import DatabaseManager.Connector;

/**
 * @author Diana
 *
 */
public class loginController {
	
	private static final Logger logger = LogManager.getLogger();
	private ArrayList<loginBean> loginList;
	
	public loginController()
	{
		this.loginList =  new ArrayList<>();	
	}

	public void getAllLoginUsers() throws SQLException
	{
		logger.info("LoginUser Datenbank runterladen");
		loginList = Connector.getInstance().getAllLoginUser();
	}
	
    public boolean checkLogin(loginBean user)
    {
    	logger.info("Überprüfe ob User vorhanden");
    	int i=0;
    	while(loginList.size() > i)
    	{
    		if(user.getBenutzername().equals(loginList.get(i).getBenutzername()) && user.getPasswort().equals(loginList.get(i).getPasswort()))
    		{
    			
    			return true;
    		}
    		i++;
    	}
    			return false;
    	
    }
}
