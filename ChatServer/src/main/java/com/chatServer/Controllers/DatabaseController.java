package com.chatServer.Controllers;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DatabaseController {
	
	static Logger logger = LoggerFactory.getLogger(DatabaseController.class);
	
	private Connection connection = null;
	
	public DatabaseController(){
		logger.info("Initialized controller");

	    try {
	      Class.forName("org.sqlite.JDBC");
	      connection = DriverManager.getConnection("jdbc:sqlite:chatDatabase.db");
	    } catch ( Exception e ) {
	      logger.error( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	   
	    logger.info("Opened database successfully");
	}
	
	
	
}
