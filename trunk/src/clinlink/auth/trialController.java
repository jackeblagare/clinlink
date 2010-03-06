package clinlink.auth;

import java.sql.*;
//import java.util.ArrayList;


public class trialController{
	
	public int status=0; // returns a value if login is successful or not
    public int redFlag=0;
    
    public String userid = "";
    public ResultSet rs;
    public ResultSet rs2;
    public Connection con;
    public Statement st;

    public void setParam(String userid){
        this.userid = userid;
    }
}