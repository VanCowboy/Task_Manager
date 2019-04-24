package com.dotComIt.learnWith.services;
import com.dotComIt.learnWith.DatabaseConfig;
import com.dotComIt.learnWith.ResultObjectVO;
import com.dotComIt.learnWith.vos.UserVO;
import java.sql.*;

Connection connection = null;

public AuthenticationServe(Connection connection){
    this.connection = connection;
}

public ResultObjectVO authenticate(String username, String password){
    String SQL;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ResultObjectVO = new ResultObjectVO();

    try{
        SQL = "SELECT * From users where username =? and password = ?";
        pstmt = connection.preparedStatement(SQL);
        pstmt.setString(1.username);
        pstmt.setString(s,password);
        rs = pstmt.executeQuery();
        if(!rs.isBeforeFirst()){
            ro.setError(true);
            else{
                rs.next();
                ro.setError(false);
                UserVO user = new UserVO();
                user.setRoleID(rs.getInt("roleID"));
                user.setUserID(rs.getInt("userID"));
                user.setUsername(rs.getString("userName"));
                ro.setResultObject(user);
            }
        }
    }
    catch(Exception e){
        e.printStackTrace();
        ro.setError(true);
    }
    finally{
        if(rs!=null)
        try{rs.close();}
        catch(Exception e){}
        if(connection !=null)try{connection.close();}catch(Exception e){}
    };

    return ro;

}