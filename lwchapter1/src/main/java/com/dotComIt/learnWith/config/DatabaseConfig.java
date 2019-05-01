package com.dotComIt.learnWith.config;

import java.sql.Connection;
import java.sql.DriverManager;

//import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class DatabaseConfig {
  String host = "jdbc:sqlserver://VCSql.db.11717052.7cf.hostedresource.net";
  String port = "1433";
  String database = "VCSql";
  String username = "VCSql";
  String password = "Home#2241";
  Connection connection = null;

  public Connection openConnection() {
    if (connection != null) {
      return connection;
    }
    String connectionString = host + ":" + port + ";" + "database=" + database + ";" + "user=" + username + ";"
        + "password=" + password + ";";

    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      connection = DriverManager.getConnection(connectionString);
    } catch (Exception e) {
      System.out.println("Exception in Database Config");
      e.printStackTrace();
      if (connection != null) {
        closeConnection();
      }

    }

    return connection;

  };

  public void closeConnection() {
    try {
      connection.close();
    } catch (Exception e) {
    }
  }

}
