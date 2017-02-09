package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Views.loginView;

/**
 * @author Diana
 *
 */
public class start {
	
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("Programm Startet");
		loginView loginView = new loginView();
		loginView.openWindow();

	}

}
