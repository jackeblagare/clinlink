package clinlink.EditMedRecord;
import java.sql.*;

import clinlink.EditMedRecord.Patient;
public class Patient {
	
	public int patient_id;
	public String name;
	public String sex;
	public String contact;
	public String excption;
	public ResultSet rs;
	public Connection con;
    public Statement st;
	public void setPatientID(int patient_id){
		this.patient_id= patient_id;
	}


	public void setPname(String name){
		this.name = name;
	}
	public void setSex(String sex){
		this.sex= sex;
	}


	public void setContact(String contact){
		this.contact= contact;
	}
	
	public Patient getProfile(int user_id){
		Patient p2=new Patient();
        try{ 
        	//int io=2;
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	rs=st.executeQuery("SELECT * from patient WHERE id="+user_id+"");
        	//Patient p2=new Patient();
        	if(rs.next()){
        	p2.setPatientID(rs.getInt(2));
        	p2.setPname(rs.getString(1));
        	p2.setSex(rs.getString(3));
        	p2.setContact(rs.getString(4));}
        	return p2;
        } catch(SQLException e){
        	excption = e.toString();
        	// p2=null;
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
	
	public Patient getPatientID(String username){
		Patient p2=new Patient();
        try{ 
//        	int io=1
//        	Class.forName(mysql.);
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	rs=st.executeQuery("SELECT * from patient WHERE name='"+username+"'");
        	//Patient p2=new Patient();
        	if(rs.next()){
        	p2.setPatientID(rs.getInt(2));
        	p2.setPname(rs.getString(1));
        	p2.setSex(rs.getString(3));
        	p2.setContact(rs.getString(4));}
        	return p2;
        } catch(SQLException e){
        	excption = e.toString();
        	 //p2=null;
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
