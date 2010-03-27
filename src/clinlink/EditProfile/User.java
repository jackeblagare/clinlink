package clinlink.EditProfile;
import java.sql.*;

public class User{
        
        public int status=0;
        public String excption= "";
        public String username = "";
        public String user_id = "";
        public int doctor_id;
		public int id;
        public int emp_id;
        public String type = "";
        public String password = "";
        public String usertype = "";
        public String position="";
        public String contact="";
        public String Sex="";
        public String name = "";
        public String license = "";
        public String spec = "";
        public ResultSet rs;
        public Connection con;
        public Statement st;
        public Statement st2;
    
        public void setUser(String username){
                this.username = username;}
        public void setDoctor_id(int doctor_id){
            this.doctor_id = doctor_id;}
        public void setEmp_id(int emp_id){
            this.emp_id = emp_id;}
        public void setUserName(String name){
            this.name = name;}
        public void setUserLicense(String license){
            this.license = license;}
        public void setSpec(String spec){
            this.spec = spec;}   
        public void setPass(String password){
                this.password = password;}       
        public void setUserType(int usetype){
                usertype = Integer.toString(usetype);}    
    	public void setContact(String contact) {
    		this.contact = contact;
    	}
    	public String getContact() {
    		return contact;
    	}
    	public void setPosition(String position) {
    		this.position = position;
    	}      
        public int editDoc(){           
            try{
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");     	
            	st= con.createStatement();
            	st.executeUpdate("UPDATE doctor " + "VALUES ('"+doctor_id+"','"+name+"','"+license+"','"+spec+"')");
            	System.out.println("naadd sa user");
            	} catch(SQLException e){
                    excption = e.toString();
                            return 0;
                    }          
            finally{
                    if (st != null) {
                            try {
                         st.close();
                     }catch (SQLException ex) {
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
      
public int editStaff(){           
            try{           	
            	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");     	
            	st= con.createStatement();
            	st.executeUpdate("UPDATE staff " + "VALUES ('"+name+"','"+emp_id+"','"+position+"')");       	      	
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
public int editPatient(){   
    try{	
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");     	
    	st= con.createStatement();
    	st.executeUpdate("UPDATE patient " + "VALUES ('"+name+"','"+id+"','"+Sex+"','"+contact+"')");
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
public void setId(int id) {
	this.id = id;
}
public void setSex(String Sex) {
	this.Sex = Sex;
}
public int getId() {
	return id;
} }
