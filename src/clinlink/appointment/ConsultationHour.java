package clinlink.appointment;

import java.sql.*;
import java.util.ArrayList;

public class ConsultationHour{
	public ResultSet rs;
	public Connection con;
	public Statement st;
	public String exc="";
	
	public ArrayList<Integer> day = new ArrayList<Integer>();
	public ArrayList<Time> start = new ArrayList<Time>();
	public ArrayList<Time> end = new ArrayList<Time>();
	
    public void getSchedule(int doc){
    	try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
    		st= con.createStatement();
    		rs=st.executeQuery("select day, start, end from consultationhour where doctor_id="+doc+" order by day, start");
    		while(rs.next() != false){
    			day.add(rs.getInt(1));
    			start.add(rs.getTime(2));
    			end.add(rs.getTime(3));
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