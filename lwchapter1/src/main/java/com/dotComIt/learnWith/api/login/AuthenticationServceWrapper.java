package com.dotComIt.learnWith.api.login;
 import com.dotComIt.learnWith.config.DatabaseConfig;
 import com.dotComIt.learnWith.services.AuthenticationService;
 import com.dotComIt.learnWith.vos.ResultObjectVO;
 import com.dotComIt.learnWith.vos.UserVO;
 import javax.ws.rs.Path;
 @Path("login")
public class AuthenticationServiceWrapper {
  private DatabaseConfig dc;
  private AuthenticationService as;
  public AuthenticationServiceWrapper(){
    dc = new DatabaseConfig();
    as = new AuthenticationService(dc.openConnection());
  }
}