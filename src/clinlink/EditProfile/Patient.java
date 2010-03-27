package clinlink.EditProfile;
import java.sql.*;

import clinlink.EditProfile.Patient;
public class Patient {
	
	public int id;
	public String name;
	public String sex;
	public String contact;
	public String excption;
	public ResultSet rs;
	public Connection con;
    public Statement st;
	public void setID(int id){
		this.id= id;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setSex(String sex){
		this.sex= sex;
	}
	public void setContact(String contact){
		this.contact= contact;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public Patient getProfile(int user_id){
		Patient p2=new Patient();
        try{ 
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	rs=st.executeQuery("SELECT * from patient WHERE id="+user_id+"");
        	if(rs.next()){
        	p2.setID(rs.getInt(2));
        	p2.setName(rs.getString(1));
        	p2.setSex(rs.getString(3));
        	p2.setContact(rs.getString(4));}
        	return p2;
        } catch(SQLException e){
        	excption = e.toString();
        	 return p2;
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
	
	public int editPatient(){   
	    try{	
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");     	
	    	st= con.createStatement();
	    	st.executeUpdate("UPDATE patient SET  name='"+name+"',sex='"+sex+"',contact='"+contact+"' WHERE  id='"+id+"'");	 
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
	           return 0;
	    }

	
	public Patient getPatientID(String username){
		Patient p2=new Patient();
        try{ 
        	int io=2;
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	rs=st.executeQuery("SELECT * from patient WHERE id="+io+"");
        	if(rs.next()){
        	p2.setID(rs.getInt(2));
        	p2.setName(rs.getString(1));
        	p2.setSex(rs.getString(3));
        	p2.setContact(rs.getString(4));}
        	return p2;
        } catch(SQLException e){
        	excption = e.toString();
        	 p2=null;
        	 return p2;
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


	public void setUserName(String patientName) {
		this.name=patientName;
		
	}  
}
