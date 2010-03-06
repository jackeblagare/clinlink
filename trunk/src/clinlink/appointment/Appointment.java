package clinlink.appointment;

import java.sql.*;
import java.util.ArrayList;

public class Appointment{
	private ResultSet rs;
	private Connection con;
	private Statement st;
	public String exc;
	
	public ArrayList<String> dates = new ArrayList<String>();
	public ArrayList<String> times = new ArrayList<String>();
	public ArrayList<String> reasons = new ArrayList<String>();
	public ArrayList<Integer> patientID = new ArrayList<Integer>();
	public ArrayList<String> patients = new ArrayList<String>();
	public ArrayList<String> appDate = new ArrayList<String>();
	public ArrayList<Integer> appID = new ArrayList<Integer>();
	
    public void getAppointment(int doc){
    	try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		rs=st.executeQuery("select date, time, reason, id, name, appt_ID from appointment, patient where doctor_id="+doc+" and patient_id=id order by date, time");
    		while(rs.next() != false){
    			dates.add(rs.getDate(1).toString());
    			times.add(rs.getTime(2).toString());
    			reasons.add(rs.getString(3));
    			patientID.add(rs.getInt(4));
    			patients.add(rs.getString(5));
    			appID.add(rs.getInt(6));
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
    
    public int setAppointment(String patname, int p_id, int d_id, String date, String time, String reason){
    	int ok;
    	try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		rs=st.executeQuery("select * from appointment where date='"+date+"' and time='"+time+"' and doctor_id="+d_id);
    		if(rs.next() == false){
    			rs=st.executeQuery("select * from appointment where date='"+date+"' and patient_id='"+p_id+"' and doctor_id="+d_id);
    			if(rs.next() == false){
    				st.executeUpdate("insert into appointment values('"+ date +"','"+ time +"',"+ d_id + ",'" + reason +"'," + p_id + ",NULL)");
    				ok=0;
    			}else{
    				ok=-1;
    			}
    		}else{
    			ok=1;
    		}
    	}catch(SQLException e){
    		exc = e.toString();
    		ok=1;
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
    
    public int deleteAppointment(int aId){
    	int ok;
    	try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		st.executeUpdate("delete from appointment where appt_ID="+aId);
    		ok=0;
    	}catch(SQLException e){
    		exc = e.toString();
    		ok=1;
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
    
    public void getPatApp(int doc, int pat){
    	try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		rs=st.executeQuery("select date from appointment where doctor_id="+doc+" and patient_id="+pat+" order by date, time");
    		while(rs.next() != false){
    			appDate.add(rs.getDate(1).toString());
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
}