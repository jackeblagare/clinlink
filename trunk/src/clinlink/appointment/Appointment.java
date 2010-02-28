package clinlink.appointment;

import java.sql.*;
import java.util.ArrayList;

public class Appointment{
	public ResultSet rs;
	public Connection con;
	public Statement st;
	public String exc="";
	
	public ArrayList<String> dates = new ArrayList<String>();
	public ArrayList<String> times = new ArrayList<String>();
	public ArrayList<String> reasons = new ArrayList<String>();
	public ArrayList<Integer> patientID = new ArrayList<Integer>();
	public ArrayList<String> patients = new ArrayList<String>();
	
    public void getAppointment(int doc){
    	try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		rs=st.executeQuery("select date, time, reason, id, name from appointment, patient where doctor_id="+doc+" and patient_id=id order by date, time");
    		while(rs.next() != false){
    			dates.add(rs.getDate(1).toString());
    			times.add(rs.getTime(2).toString());
    			reasons.add(rs.getString(3));
    			patientID.add(rs.getInt(4));
    			patients.add(rs.getString(5));
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
    
    public boolean setAppointment(String patname, int p_id, int d_id, String date, String time, String reason){
    	boolean ok;
    	try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		rs=st.executeQuery("select * from appointment where date='"+date+"' and time='"+time+"' and doctor_id="+d_id);
    		if(rs.next() == false){
    			System.out.println("rs.next pumasok");
    			st.executeUpdate("insert into appointment values('"+ date +"','"+ time +"',"+ d_id + ",'" + reason +"'," + p_id + ",NULL)");
    			ok=true;
    		}else{
    			ok=false;
    		}
    	}catch(SQLException e){
    		exc = e.toString();
    		ok=false;
    	}finally{
    		if(st != null){
    			try{st.close();}catch(SQLException ex){}
             }	
             if(con != null){
            	 try{con.close();}catch(SQLException ex){}
             }
        }
    	return ok;
    }
}