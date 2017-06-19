package com.chatServer.ChatServer.Controllers;

import java.sql.*;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chatServer.ChatServer.Message;

public class DatabaseController {
	private static Logger logger = LoggerFactory.getLogger(DatabaseController.class);
	private static DatabaseController instance = null;
	
	private Connection connection = null;
	
	private final String userDB = "USERS";
	private final String msgDB = "MESSAGES";
	
	private final String userInit = "CREATE TABLE IF NOT EXISTS " + userDB
			+ "( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT NOT NULL UNIQUE, PASSWORD CHAR(30) NOT NULL); ";
	
	private final String messageInit = "CREATE TABLE IF NOT EXISTS " + msgDB
			+ "( ID INTEGER PRIMARY KEY AUTOINCREMENT, SENDER INT NOT NULL, RECEIVER INT NOT NULL, "
			+ "TIME DATETIME NOT NULL, MESSAGE TEXT NOT NULL, FOREIGN KEY(SENDER) REFERENCES USERS(ID), FOREIGN KEY(RECEIVER) REFERENCES USERS(ID));";

	private DatabaseController() {
		logger.info("Initialized controller");
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:chatDatabase.db");
			init();
		} catch (Exception e) {
			logger.error(e.getClass().getName() + ": " + e.getMessage());
		}

		logger.info("Opened database successfully");
	}

	public static DatabaseController getInstance() {
		if (instance == null) {
			instance = new DatabaseController();
		}
		return instance;
	}

	public void connect() {
		if ((connection != null)) {
			connectForced();
		}
	}

	public void connectForced() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:chatDatabase.db");
		} catch (ClassNotFoundException e) {
			logger.error("Can't find java database class", e);
		} catch (SQLException e) {
			logger.error("Failed to connect to the database", e);
		}
	}

	// add a user
	public boolean addUser(String name, String password) {
		PreparedStatement st = null;
		boolean succes = false;
		try {
			st = connection.prepareStatement("SELECT * FROM " + userDB + " WHERE NAME ?");
			st.setString(1, name);
			if (st.executeQuery().next()) {
				logger.info("duplicate name");
			} else {
				st = connection.prepareStatement("INSERT INTO " + userDB + " (NAME, PASSWORD) values (?, ?)");
				st.setString(1, name);
				st.setString(2, password);
				st.executeUpdate();
				
				// validate
				succes = isAuth(name, password);
			}
		} catch (SQLException e) {
			logger.error("Failed to add user" + e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				logger.info("Failed to close statement", e);
			}
		}
		return succes;
	}

	// check if the tables exists
	public void removeUser(int userid) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement("DELETE FROM " + userDB + " WHERE ID = ?;");
			st.setInt(1, userid);
			st.executeUpdate();
		} catch (SQLException e) {
			logger.error("Failed to delete user: ", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				logger.info("Failed to close statement", e);
			}
		}
	}

	public boolean isAuth(String name, String pass) {
		PreparedStatement st = null;
		boolean succes = false;
		try {
			st = connection.prepareStatement("SELECT * FROM " + userDB + " WHERE NAME = ? AND PASSWORD = ?;");
			st.setString(1, name);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			succes = rs.next();
		} catch (SQLException e) {
			logger.error("Failed to delete user: ", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				logger.info("Failed to close statement", e);
			}
		}
		return succes;
	}

	public int getUser(String name) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement("SELECT ID FROM " + userDB + " WHERE NAME = ?;");
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
		} catch (SQLException e) {
			logger.error("Failed to delete user: ", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				logger.info("Failed to close statement", e);
			}
		}
		return 0;
	}
	
	public void init(){
		logger.info("Initialize database");
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.execute(userInit);
			stmt.execute(messageInit);

			ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table';");
			while (rs.next()) {
				logger.info("Checked: " + rs.getString("name"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			logger.error("Failed to setup database ", e);
		}
		
	}

	public void deleteDatabase(){
		logger.warn("DROPPING TABLES!");
		Statement stmt = null;
		try {
			stmt = connection.createStatement();
			stmt.execute("DROP TABLE " + userDB + ";");
			stmt.execute("DROP TABLE " + msgDB + ";");
		} catch (SQLException e) {
			logger.error("Failed to delete database!", e);
		}finally {
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					logger.error("Failed to close drop statement!", e);
				}
			}
		}
		
	}

	public void addMessage(Message msg) {
		PreparedStatement st = null;
		boolean succes = false;
		try {
			st = connection.prepareStatement("INSERT INTO " + msgDB + " (SENDER, RECEIVER, TIME, MESSAGE) VALUES (?, ?, datetime('now'), ?);");
			st.setInt(1, msg.getSender());
			st.setInt(2, msg.getReceiver());
			// time has changed to 'on insert'
			// st.setString(3, msg.getTime());
			st.setString(3, msg.getContent());
			st.execute();
		} catch (SQLException e) {
			logger.error("Failed to delete user: ", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				logger.info("Failed to close statement", e);
			}
		}
	}
	
	public ArrayList<Message>  getChat(int sender, int receiver) {
		// return all message, point is chosen on a point in time before i created this
		// 2017-06-17 was not a nice value - Jop van Buuren
		return getChat(sender,receiver, "2017-01-01");
	}
	
	public ArrayList<Message> getChat(int sender, int receiver, String dateTime) {
		PreparedStatement st = null;
		ArrayList<Message> messages = new ArrayList<Message>();
		try {
			st = connection.prepareStatement(
					"SELECT SENDER, RECEIVER, TIME, MESSAGE FROM " + 
					msgDB + " WHERE (SENDER IN (?,?)) AND (RECEIVER IN (?,?))" + 
					" AND (TIME > strftime('%Y-%m-%d %H:%M:%S', ?)) ORDER BY TIME ASC;"
			);
			st.setInt(1, sender);
			st.setInt(2, receiver);
			st.setInt(3, sender);
			st.setInt(4, receiver);
			st.setString(5, dateTime);
			ResultSet rs = st.executeQuery();
			if(rs != null){
				while(rs.next()){
					Message msg = new Message(
						rs.getInt(0), 		// Sender
						rs.getInt(1), 		// Receiver
						rs.getString(2), 	// Time		
						rs.getString(3)		// Message
					);
					messages.add(msg);
				}
			}
		} catch (SQLException e) {
			logger.error("Failed to delete user: ", e);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				logger.info("Failed to close statement", e);
			}
		}
		
		return messages;
	}
}
