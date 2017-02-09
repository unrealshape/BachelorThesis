package Views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Beans.loginBean;
import Controller.loginController;
import DatabaseManager.Connector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author Diana
 *
 */
public class loginView extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBenutzername;
	private JLabel lblPasswort;
	private JPasswordField pwdPasswort;
	private JTextField txtBenutzername;
	private JButton btnEinloggen;
	private JButton btnAbrrechen;
	private JButton btnPassoworVergessen;
	private JLabel lblFailureNotice;
	private loginController loginCTR = new loginController();
	private loginBean user ;
	
	private static final Logger logger = LogManager.getLogger();

	public loginView() {
		setTitle("Anmeldung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBenutzername = new JLabel("Benutzername");
		lblBenutzername.setBounds(46, 66, 108, 16);
		contentPane.add(lblBenutzername);
		
		lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(46, 94, 108, 16);
		contentPane.add(lblPasswort);
		
		pwdPasswort = new JPasswordField();
		pwdPasswort.setText("diana");
		pwdPasswort.setBounds(166, 89, 130, 26);
		contentPane.add(pwdPasswort);
		
		txtBenutzername = new JTextField();
		txtBenutzername.setText("diana");
		txtBenutzername.setBounds(166, 61, 130, 26);
		contentPane.add(txtBenutzername);
		txtBenutzername.setColumns(10);
		
		btnEinloggen = new JButton("Einloggen");
		btnEinloggen.setBounds(81, 155, 117, 29);
		contentPane.add(btnEinloggen);
		
		btnAbrrechen = new JButton("Abrrechen");
		btnAbrrechen.setBounds(211, 155, 117, 29);
		contentPane.add(btnAbrrechen);
		
		btnPassoworVergessen = new JButton("Passowor Vergessen");
		btnPassoworVergessen.setBounds(81, 189, 247, 29);
		contentPane.add(btnPassoworVergessen);
		
		lblFailureNotice = new JLabel("");
		lblFailureNotice.setBounds(6, 229, 438, 16);
		contentPane.add(lblFailureNotice);
		this.setVisible(false);
	}
	//öffnet das Fenster
	public void openWindow()
	{
		try
		{
			Connector.verbinden();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			loginCTR.getAllLoginUsers();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		setActionListener(this);
		this.setVisible(true);
		
	}
	//setzt alle ActionListener für Buttons
	public void setActionListener(ActionListener l)
	{
		btnAbrrechen.addActionListener(l);
		btnEinloggen.addActionListener(l);
		btnPassoworVergessen.addActionListener(l);
	}
	
	public JButton getBtnEinloggen() {
		return btnEinloggen;
	}
	public JButton getBtnAbrrechen() {
		return btnAbrrechen;
	}
	public JButton getBtnPassoworVergessen() {
		return btnPassoworVergessen;
	}
	
	@SuppressWarnings("deprecation")
	public String getPwdPasswort() {
		return pwdPasswort.getText();
	}
	public String getTxtBenutzername() {
		return txtBenutzername.getText();
	}
	public void abbrechenPressed() {
		logger.info("Abrrechen gedrückt");
		Object[] options = {"Ja","Nein"};
        int selected = JOptionPane.showOptionDialog(null, "Sind Sie sich sicher das Sie das Programm Beenden wollen?",
        		"Programm schließen",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, 
    null, options, options[0]);
        if(selected == 0)
        {
        	System.exit(0);
        }
        else if(selected == 1)
        {
        	return;
        }
	}
	@SuppressWarnings("deprecation")
	public void einloggenPressed() {
		logger.info("Einloggen gedrueckt");
		if(txtBenutzername.getText().isEmpty() && pwdPasswort.getText().isEmpty())
		{
			lblFailureNotice.setForeground(Color.red);
			lblFailureNotice.setText("Sie haben nicht alle Felder ausgefuellt!");
			return;
		}else
		{
			String benutzername = getTxtBenutzername();
			String passwort = getPwdPasswort();
			user = new loginBean(benutzername, passwort);
			if(loginCTR.checkLogin(user))
			{
				logger.info("Login Erfolgt - Fenster wird geöffnet");
				lblFailureNotice.setForeground(Color.green);
				lblFailureNotice.setText("Anmeldung Erfolgreich");
			}
			else
			{
				lblFailureNotice.setForeground(Color.red);
				lblFailureNotice.setText("Anmeldung nicht Korrekt!");
				return;
			}
		}
		
	}
	public void passwordVergessenPressed() {
		logger.info("Password Vergessen gedrueckt");
	}
	//Automatisch generierte Funktionen Grund Klasse : ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getBtnAbrrechen())
		{
			abbrechenPressed();
		}
		else if(e.getSource() == getBtnEinloggen())
		{
			einloggenPressed();
		}
		else if(e.getSource() == getBtnPassoworVergessen())
		{
			passwordVergessenPressed();
		}
	}
}
