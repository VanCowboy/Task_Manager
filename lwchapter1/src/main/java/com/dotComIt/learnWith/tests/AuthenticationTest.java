package com.dotComIt.learnWith.tests;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dotComIt.learnWith.config.DatabaseConfig;
import com.dotComIt.learnWith.services.AuthenticationService;
import com.dotComIt.learnWith.vos.ResultObjectVO;


@Path("test/login")
public class AuthenticationTest {

    private DatabaseConfig dc;
    private AuthenticationService as;

    public AuthenticationTest(){
        System.out.println("In Authentication Test Constructor");
        dc = new DatabaseConfig();
        as = new AuthenticationService(dc.openConnection());
    }

    // get method for success
    @GET
    @Path("success")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultObjectVO loadUserSuccess() {
    	System.out.println("This is a successful test");
        return as.authenticate("me","AB86A1E1EF70DFF97959067B723C5C24");
    }
    // get method for success
    @GET
    @Path("success2")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultObjectVO loadUserSuccess2() {
    	System.out.println("This is another successful test");
        return as.authenticate("wife","BB4694A26A39DF7501F8BB8CBDD13E38");
    }


    // get method for failure
    @GET
    @Path("fail")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultObjectVO loadUserFail() {
        // non hashed password so should fail
    	System.out.println("This is a failed test");
        return as.authenticate("me","me");
    }
}
