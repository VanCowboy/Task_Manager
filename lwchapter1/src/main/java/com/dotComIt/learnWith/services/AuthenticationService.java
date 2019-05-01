package com.dotComIt.learnWith.services;

//import com.dotComIt.learnWith.config.DatabaseConfig;
import com.dotComIt.learnWith.vos.ResultObjectVO;
import com.dotComIt.learnWith.vos.UserVO;

import java.sql.*;

public class AuthenticationService {

  Connection connection = null;

  public AuthenticationService(Connection connection) {
    this.connection = connection;
    //System.out.println("Connection String: " + connection);

    // System.out.println("AuthenticationService Constructor");
    // this.connection = new DatabaseConfig().openConnection();
    // System.out.println(this.connection.toString());

  }

  public ResultObjectVO authenticate(String username, String password) {

    //System.out.println("Connection String (toString): " + connection.toString());
    //System.out.println("Connection String: " + connection);
    String SQL;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ResultObjectVO ro = new ResultObjectVO();

    try {
      /*
       * approach for running a simple statement SQL =
       * "SELECT * FROM users where username = '" + username + "' and password = '" +
       * password + "'"; System.out.println(SQL ); stmt =
       * connection.createStatement(); rs = stmt.executeQuery(SQL);
       */

      // using a prepared statement which is better suited against injection attacks
      SQL = "SELECT * FROM users where username = ? and password = ?";
      System.out.println(SQL);
      pstmt = connection.prepareStatement(SQL);
      pstmt.setString(1, username);
      pstmt.setString(2, password);
      rs = pstmt.executeQuery();
      if (!rs.isBeforeFirst()) {
        // has zero rows
        ro.setError(true);

      } else {
        // get first row
        rs.next();
        // save results
        ro.setError(false);
        UserVO user = new UserVO();
        user.setRoleID(rs.getInt("roleID"));
        user.setUserID(rs.getInt("userID"));
        user.setUsername(rs.getString("userName"));
        ro.setResultObject(user);
        
      }
    } catch (Exception e) {
      System.out.println("Authentication Service Exception");
      e.printStackTrace();
      ro.setError(true);
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (Exception e) {
        }
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (Exception e) {
        }
      if (connection != null)
        try {
          connection.close();
        } catch (Exception e) {
        }
    }
    ;

    return ro;

  };
}
