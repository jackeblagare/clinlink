package clinlink.appointment;

import java.sql.*;
import java.util.ArrayList;

public class DoctorManager{
	public ResultSet rs;
	public Connection con;
	public Statement st;
	public String exc="";
	
	public ArrayList<Integer> id = new ArrayList<Integer>();
	public ArrayList<String> doctors = new ArrayList<String>();
	public ArrayList<String> specialization = new ArrayList<String>();
	
	public void getAllDoctors(){
		try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		rs=st.executeQuery("select doctor_id, name, specialization from doctor order by specialization");
    		while(rs.next() != false){
    			id.add(rs.getInt(1));
    			doctors.add(rs.getString(2));
    			specialization.add(rs.getString(3));
    		}
    	}catch(SQLException e){
    		exc = e.toString();
    	}finally{
    		if(st != null){
    			try{st.close();}catch(SQLException ex){}
             }	
             if(con != null){
            	 try{con.close();}catch(SQLException ex){}
             }
        }
	}
	
	public void getAllDoctors(int pid){
		try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		rs=st.executeQuery("select distinct d.doctor_id, d.name, d.specialization from doctor d, appointment a where d.doctor_id=a.doctor_id and a.patient_id="+pid+" order by d.specialization");
    		while(rs.next() != false){
    			id.add(rs.getInt(1));
    			doctors.add(rs.getString(2));
    			specialization.add(rs.getString(3));
    		}
    	}catch(SQLException e){
    		exc = e.toString();
    	}finally{
    		if(st != null){
    			try{st.close();}catch(SQLException ex){}
             }	
             if(con != null){
            	 try{con.close();}catch(SQLException ex){}
             }
        }
	}
	
	public String getName(int d_id){
		String name="";
		try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		rs=st.executeQuery("select name from doctor where doctor_id="+d_id);
    		while(rs.next() != false){
    			name = rs.getString(1);
    		}
    	}catch(SQLException e){
    		exc = e.toString();
    	}finally{
    		if(st != null){
    			try{st.close();}catch(SQLException ex){}
             }	
             if(con != null){
            	 try{con.close();}catch(SQLException ex){}
             }
        }
		return name;
	}
}