package DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mysql.fabric.xmlrpc.base.Array;

import Beans.loginBean;
import Beans.overBean;


public class Connector {
	
    private final static String dbserver = "localhost";
    private final static int dbport = 3306;
    private final static String dbname = "BaDiana";
    private final static String dbuser = "root";
    private final static String dbpass ="hallo123";
    private final static String url = "jdbc:mysql://" + dbserver + ":" + dbport + "/" + dbname + "?useSSL=false";
    private static String query = "";
    private static Connector instance = null;
    private static Connection con = null;
    private static final Logger logger = LogManager.getLogger();
    public Connector()
    {
    	
    }
    public static Connector getInstance()
    {
    	return instance;
    }
    private void verbinden(String url,String dbuser,String dbpass,String treiber)throws Exception
    {
        Class.forName(treiber);
        this.con = DriverManager.getConnection(url, dbuser, dbpass);    
    }   
    public static void verbinden() throws Exception
    {
    	logger.info("Verbindung Starten");
        instance = new Connector();
        instance.verbinden(url,dbuser,dbpass,"org.gjt.mm.mysql.Driver");
        logger.info("Verbindung Erfolgreich");
        
    }
    public ResultSet ausfuehren(String query) throws SQLException 
    {
	PreparedStatement stmt = con.prepareStatement(query);
	stmt.execute();

	return stmt.getResultSet();
    }

    public ResultSet ausfuehren(PreparedStatement stmt) throws SQLException 
    {
	stmt.execute();

	return stmt.getResultSet();
    }
    
    public ArrayList<loginBean> getAllLoginUser() throws SQLException
    {
    	ArrayList<loginBean> loginList = new ArrayList<>();
    	query="SELECT * FROM BaDiana.Anmeldung;";
    	ResultSet rs = ausfuehren(query);
	   	 while(rs.next())
	   	 {
	   		 int idAnmeldung = rs.getInt(1);
	   		 String benutzername = rs.getString(2);
	   		 String passwort = rs.getString(3);
	   		 String eMail = rs.getString(4);
	   		 loginList.add(new loginBean(idAnmeldung,benutzername,passwort,eMail));
	   	 }
	   	 return loginList;
    }
    private int getWohnungenAnzahl() throws SQLException
    {
    	String query = "SELECT COUNT(*) FROM BaDiana.Wohnung;"; 
        int count = 0;
    	ResultSet rs = ausfuehren(query);
    	while (rs.next()) {
    		count = rs.getInt(1);
		}
    	return count;
    }
    private int getImmobilienAnzahl() throws SQLException
    {
    	String query = "SELECT COUNT(*) FROM BaDiana.Immobilie;"; 
        int count = 0;
    	ResultSet rs = ausfuehren(query);
    	while (rs.next()) {
    		count = rs.getInt(1);
		}
    	return count;
    }
    private int getMieterAnzahl() throws SQLException
    {
    	String query = "SELECT COUNT(*) FROM BaDiana.Hauptmieter;"; 
        int count = 0;
    	ResultSet rs = ausfuehren(query);
    	while (rs.next()) {
    		count = rs.getInt(1);
		}
    	return count;
    }
    
    public ArrayList<overBean> getOverView() throws SQLException
    {
    	ArrayList<overBean> overList = new ArrayList<>();
    	int zahlWohnungen = getWohnungenAnzahl();
    	int zahlImmobilien = getImmobilienAnzahl();
    	int zahlMieter = getMieterAnzahl();
    	overList.add(new overBean(zahlWohnungen, zahlImmobilien, zahlMieter));
    	return overList;
    }
    

    /*
    public ArrayList<login> getAllLoginUser() throws SQLException
    {
    	ArrayList<login> arrayListLogin = new ArrayList<>();
    	query ="SELECT * FROM neuedb.login";
    	 ResultSet rs = ausfuehren(query);
    	 while(rs.next())
    	 {
    		 int loginID = rs.getInt(1);
    		 String username = rs.getString(2);
    		 String password = rs.getString(3);
    		 String email = rs.getString(4);
    		 arrayListLogin.add(new login(loginID,username,password,email));
    	 }
    	return arrayListLogin;
    }
    public ArrayList<Employee> getAllEmployees() throws SQLException
    {
    	ArrayList<Employee> arrayListEmployee = new ArrayList<>();
    	query = "SELECT `id`,`titel`,`surname`,`lastname`,`adress`,`postcode`,`birthday`,`gross`,`net` FROM neuedb.employees";
    	ResultSet rs = ausfuehren(query);
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String titel = getTitleName(rs.getInt(2));
    		String surname = rs.getString(3);
    		String lastname = rs.getString(4);
    		String adress = rs.getString(5);
    		String postcode = rs.getString(6);
    		String birthday = rs.getString(7);
    		double gross = rs.getDouble(8);
    		double net = rs.getDouble(9);
    		arrayListEmployee.add(new Employee(id,titel,surname,lastname,adress,postcode,birthday,gross,net));
    	}
    	return arrayListEmployee;
    }
    
    private String getTitleName(int idFromTitles) throws SQLException {
		String title = "";
		query = "SELECT titles FROM neuedb.titles WHERE ID='"+idFromTitles+"'";
		ResultSet rs = ausfuehren(query);
		if(rs.next())
		{
			title = rs.getString(1);
		}
		return title;
	}
    public int getEmployeeMax() throws SQLException
    {
    	String query = "select max(id) from neuedb.employees"; 
        int count = 0;
    	ResultSet rs = ausfuehren(query);
    	while (rs.next()) {
    		count = rs.getInt(1)+1;
		}
    	return count;
    }
    public ArrayList<Titel> getTitels() throws SQLException
    {
    	ArrayList<Titel> titelList = new ArrayList<>();
    	query ="SELECT * FROM neuedb.titles;";
    	ResultSet rs = ausfuehren(query);
    	while(rs.next())
    	{
    		int id = rs.getInt(1);
    		String titel = rs.getString(2);
    		titelList.add(new Titel(id, titel));
    	}
    	return titelList;
    }    
    public void deleteEmployee(int id) throws SQLException
    {
    	query ="DELETE FROM `neuedb`.`employees` WHERE ID = ?;";
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setInt(1, id);
    	ausfuehren(pstmt);
    }
    public void addEmployee(Employee newEmployee) throws SQLException
    {
    	query ="INSERT INTO `neuedb`.`employees`(`id`,`surname`,`lastname`,`adress`,`titel`,`postcode`,`birthday`,`gross`,`net`) VALUES (?,?,?,?,?,?,?,?,?)";
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setInt(1, newEmployee.getId());
    	pstmt.setString(2, newEmployee.getSurname());
    	pstmt.setString(3, newEmployee.getLastname());
    	pstmt.setString(4, newEmployee.getAdress());
    	pstmt.setInt(5, searchTitleID(newEmployee.getTitel()));
    	pstmt.setString(6, newEmployee.getPostcode());
    	pstmt.setString(7, newEmployee.getBirthday());
    	pstmt.setDouble(8, newEmployee.getGross());
    	pstmt.setDouble(9, newEmployee.getNet());
    	ausfuehren(pstmt);
    }
    private int searchTitleID(String titleName) throws SQLException
    {
		int titleID = 0;
		query = "Select id From neuedb.titles WHERE titles LIKE ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, titleName);
		ResultSet rs = ausfuehren(pstmt); 
		while(rs.next())
		{
			
			titleID = rs.getInt(1);
		}
		return titleID;
    }
    public void editEmployee(Employee editedEmployee) throws SQLException
    {
    	query ="UPDATE `neuedb`.`employees`SET `surname` = ?,`lastname` = ?,`adress` = ?,`titel` = ?,`postcode` = ?,`birthday` = ?,`gross` = ?,`net` = ? WHERE `id` = ?;";
    	PreparedStatement pstmt = con.prepareStatement(query);
    	pstmt.setString(1, editedEmployee.getSurname());
    	pstmt.setString(2, editedEmployee.getLastname());
    	pstmt.setString(3, editedEmployee.getAdress());
    	pstmt.setInt(4, searchTitleID(editedEmployee.getTitel()));
    	//Postcode birthday gross net
    	pstmt.setString(5, editedEmployee.getPostcode());
    	pstmt.setString(6, editedEmployee.getBirthday());
    	pstmt.setDouble(7, editedEmployee.getGross());
    	pstmt.setDouble(8, editedEmployee.getNet());
    	pstmt.setInt(9, editedEmployee.getId());
    	ausfuehren(pstmt);
    }
	
*/
}
