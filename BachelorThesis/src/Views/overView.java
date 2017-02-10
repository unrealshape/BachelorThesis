package Views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Controller.overController;
import DatabaseManager.Connector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class overView extends Observable implements ActionListener,Observer {

	private JPanel contentPane;
	private JFrame frame;
	
	
	private static final Logger logger = LogManager.getLogger();
	private JButton btnMieter;
	private JButton btnImmobilien;
	private JButton btnWohnung;
	private JLabel lblAktuelleMieter;
	private JLabel lblAktuelleImmobilien;
	private JLabel lblAktuelleWohnungen;
	private JLabel lblZahlm;
	private JLabel lblZahli;
	private JLabel lblZahlw;
	
	private overController overCTR = new overController();

	public overView() {
		frame = new JFrame("Übersicht");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnMieter = new JButton("Mieter");
		btnMieter.setBounds(21, 114, 117, 29);
		contentPane.add(btnMieter);
		
		btnImmobilien = new JButton("Immobilien");
		btnImmobilien.setBounds(150, 114, 145, 29);
		contentPane.add(btnImmobilien);
		
		btnWohnung = new JButton("Wohnung");
		btnWohnung.setBounds(307, 114, 130, 29);
		contentPane.add(btnWohnung);
		
		lblAktuelleMieter = new JLabel("Aktuelle Mieter");
		lblAktuelleMieter.setBounds(21, 32, 117, 16);
		contentPane.add(lblAktuelleMieter);
		
		lblAktuelleImmobilien = new JLabel("Aktuelle Immobilien");
		lblAktuelleImmobilien.setBounds(162, 32, 130, 16);
		contentPane.add(lblAktuelleImmobilien);
		
		lblAktuelleWohnungen = new JLabel("Aktuelle Wohnungen");
		lblAktuelleWohnungen.setBounds(307, 32, 130, 16);
		contentPane.add(lblAktuelleWohnungen);
		
		lblZahlm = new JLabel("zahlM");
		lblZahlm.setHorizontalAlignment(SwingConstants.CENTER);
		lblZahlm.setBounds(21, 60, 97, 16);
		contentPane.add(lblZahlm);
		
		lblZahli = new JLabel("zahlI");
		lblZahli.setHorizontalAlignment(SwingConstants.CENTER);
		lblZahli.setBounds(162, 60, 130, 16);
		contentPane.add(lblZahli);
		
		lblZahlw = new JLabel("zahlW");
		lblZahlw.setHorizontalAlignment(SwingConstants.CENTER);
		lblZahlw.setBounds(307, 60, 130, 16);
		contentPane.add(lblZahlw);
		frame.setVisible(false);
	}
	public void openWindow() {
		logger.info("Starte Fenster Übersicht");
		try {
			Connector.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			overCTR.loadOverViewList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setActionListener(this);
		setLabels();
		frame.setVisible(true);
	}
	
	
	public JButton getBtnMieter() {
		return btnMieter;
	}
	public JButton getBtnImmobilien() {
		return btnImmobilien;
	}
	public JButton getBtnWohnung() {
		return btnWohnung;
	}
	public void setLblZahlm(String lblZahlm) {
		this.lblZahlm.setText(lblZahlm);
	}
	public void setLblZahli(String lblZahli) {
		this.lblZahli.setText(lblZahli);
	}
	public void setLblZahlw(String lblZahlw) {
		this.lblZahlw.setText(lblZahlw);
	}
	public void setActionListener(ActionListener l)
	{
		btnImmobilien.addActionListener(l);
		btnMieter.addActionListener(l);
		btnWohnung.addActionListener(l);
	}
	public void setLabels() {
		setLblZahli(Integer.toString(overCTR.getImmobilien()));
		setLblZahlm(Integer.toString(overCTR.getMieter()));
		setLblZahlw(Integer.toString(overCTR.getWohnungen()));
	}
	
	public void mieterPressed()
	{
		logger.info("Mieter Gedrückt");
	}
	public void wohnungPressed()
	{
		logger.info("Wohnung Gedrückt");
	}
	public void immobilienPressed()
	{
		logger.info("Immobilien Gedrückt");
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == getBtnImmobilien())
		{
			immobilienPressed();
		}
		else if(e.getSource() == getBtnMieter())
		{
			mieterPressed();
		}
		else if(e.getSource() == getBtnWohnung())
		{
			wohnungPressed();
		}
		
	}
}
