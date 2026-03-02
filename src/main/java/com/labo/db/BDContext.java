package com.labo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDContext {
	private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
	private static final String USER = "user_labo";
	private static final String PASSWORD = "#WonderMint-flash#9324@";

  static {
    try { Class.forName("oracle.jdbc.driver.OracleDriver"); }
    catch (ClassNotFoundException e) { throw new RuntimeException(e); }
  }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASSWORD);
  }
}
