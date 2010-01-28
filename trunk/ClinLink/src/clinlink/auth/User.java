package clinlink.auth;

import java.sql.*;

import clinlink.auth.LoginController;

public class User{
	
	public int status=0; // returns a value if login is successful or not
	public int redFlag=0;
	
	public String excption= "";
	public String username = "";
	public String password = "";
	public String usertype = "";
	
	public ResultSet rs;
	public Connection con;
    public Statement st;
    
	public void setUser(String username){
		this.username = username;
	}
	
	public void setPass(String password){
		this.password = password;
	}
	
	public void setUserType(int usetype){
		usertype = Integer.toString(usetype);
	}
	
    public void login(){
    	
    	
    	LoginController lc = new LoginController();
    	
        try{ 
        	
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","jack","aelendil");
        	st= con.createStatement();
        	rs=st.executeQuery("select * from user where username='"+username+"' and type='"+usertype+"'");
            
        	if(rs.next()){
        		if(rs.getString(2).equals(password) && rs.getString(1).equals(username)){
        			if(rs.getString(3).equals("1")){
        				
        				if(rs.getString(4).equals("1")){
        					this.status = 1;
        					this.redFlag = 1;
        				}
        				else if(rs.getString(4).equals("2")){
        					this.status = 1;
        					this.redFlag = 2;
        				}
        				else if(rs.getString(4).equals("3")){
        					this.status = 1;
        					this.redFlag = 3;
        				}
        				else if(rs.getString(4).equals("4")){
        					this.status = 1;
        					this.redFlag = 4;
        				}
        			}
        			
        			else this.status = 2; //user is inactive
        		}
        	}
        
        } catch(SQLException e){
        	excption = e.toString();
			this.status = 0;
		}
       
        finally{
        	if (st != null) {
        		try {
                     st.close();
                 } 
        		catch (SQLException ex) {
                     
                 }
             }	
             if (con != null) {
                 try {
                     con.close();
                 } 
                 catch (SQLException ex) {
                     
                 }
             	}

        	}
        	
        }
 
}