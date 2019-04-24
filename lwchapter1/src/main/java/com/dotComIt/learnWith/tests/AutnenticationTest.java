package com.dotComIt.learnWith.tests;
 import com.dotComIt.learnWith.config.DatabaseConfig;
 import com.dotComIt.learnWith.services.AuthenticationService;
 import com.dotComIt.learnWith.vos.ResultObjectVO;

 @Path("test/login")
 @GET
 @Path("success")
 @Produces(MediaType.APPLICATOIN_JSON)

 public ResultObjectVO loadUserSuccess(){
   reutrn as authenticate("me",AB86A1E1EF70DFF97959067B723C5C24");

 }

 public class AuthenticationTest {
    private DatabaseConfig dc;
    private AuthenticationService as;
    public AuthenticationTest(){
        dc = new DatabaseConfig();
        as = new AuthenticationService(dc.openConnection());
      }
  

