package clinlink.EditProfile;
import java.sql.*;

import clinlink.EditProfile.Doctor;
public class Doctor {
	
	public int doctor_id;
	public String name;
	public String license;
	public String specialization;
	public String excption;
	public ResultSet rs;
	public Connection con;
    public Statement st;
    
	public void setLicense(String license){
		this.license= license;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setSpecialization(String specialization){
		this.specialization= specialization;
	}
	public void setDoctor_id(int doctor_id){
		this.doctor_id= doctor_id;
	}

	
	public Doctor getProfile(int user_id){
		Doctor p2=new Doctor();
        try{ 
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	rs=st.executeQuery("SELECT * from doctor WHERE doctor_id="+user_id+"");
        	if(rs.next()){
        	p2.setDoctor_id(rs.getInt(1));
        	p2.setName(rs.getString(2));
        	p2.setSpecialization(rs.getString(4));
        	p2.setLicense(rs.getString(3));}
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
	
	public int editDoctor(){   
	    try{	
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");     	
	    	st= con.createStatement();
	    	st.executeUpdate("UPDATE doctor SET  name='"+name+"',specialization='"+specialization+"',license='"+license+"' WHERE  doctor_id='"+doctor_id+"'");	 
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

	
	public Doctor getDoctorID(String username){
		Doctor p2=new Doctor();
        try{ 
        	int io=2;
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	rs=st.executeQuery("SELECT * from patient WHERE id="+io+"");
        	if(rs.next()){
        	p2.setDoctor_id(rs.getInt(1));
        	p2.setName(rs.getString(2));
        	p2.setSpecialization(rs.getString(4));
        	p2.setLicense(rs.getString(3));}
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
}
