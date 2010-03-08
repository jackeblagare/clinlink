package clinlink.cauc;
import java.sql.*;

public class User{
        
        public int status=0;
        public String excption= "";
        public String username = "";
        public String password = "";
        public String usertype = "";
        public String position="";
        public String contact="";
        public String sex="";
        public String name = "";
        public String license = "";
        public String spec = "";
        public ResultSet rs;
        public Connection con;
        public Statement st;
    
        public void setUser(String username){
                this.username = username;
        }
        
        public void setUserName(String name){
            this.name = name;
    }
        public void setUserLicense(String license){
            this.license = license;
    }
        public void setSpec(String spec){
            this.spec = spec;
    }
        
        public void setPass(String password){
                this.password = password;
        }
        
        public void setUserType(int usetype){
                usertype = Integer.toString(usetype);
        }
        
    	public void setContact(String contact) {
    		this.contact = contact;
    	}

    	public String getContact() {
    		return contact;
    	}

    	public void setPosition(String position) {
    		this.position = position;
    	}
        
        public int move(){
            
            try{ 
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","kat","kat");
            	st= con.createStatement();
            	if(usertype.equals("1")){
            		st.executeUpdate("INSERT INTO doctor " + "VALUES (0,'"+name+"','"+license+"','"+spec+"')");
            		System.out.println("naadd sa doctor");
            	}
            	else if(usertype.equals("2")){
            		st.executeUpdate("INSERT INTO patient " + "VALUES ('"+name+"',0,'"+sex+"','"+contact+"')");
            		System.out.println("naadd sa patient");
            	}
            	else if(usertype.equals("3")){
            		st.executeUpdate("INSERT INTO staff " + "VALUES ('"+name+"',0,'"+position+"')");
            		System.out.println("naadd sa staff");
            	}

           } catch(SQLException e){
                    excption = e.toString();
                            return 0;
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
                    return status;
            } 
       
    public int create(){
                
        try{ 
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	st.executeUpdate("INSERT INTO user " + "VALUES ('"+username+"','"+password+"',0,"+usertype+",0)");
        	System.out.println("naadd sa user");
       } catch(SQLException e){
                excption = e.toString();
                        return 0;
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
                return status;
        }
    
}