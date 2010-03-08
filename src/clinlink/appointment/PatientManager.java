package clinlink.appointment;

import java.sql.*;
import java.util.ArrayList;

public class PatientManager{
	public ResultSet rs;
	public Connection con;
	public Statement st;
	public String exc="";
	
	public ArrayList<Integer> id = new ArrayList<Integer>();
	public ArrayList<String> patients = new ArrayList<String>();
	
	public void getAllPatients(){
		try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		rs=st.executeQuery("select id, name from patient");
    		while(rs.next() != false){
    			id.add(rs.getInt(1));
    			patients.add(rs.getString(2));
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
	
	public String getName(int p_id){
		String name="";
		try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    		st= con.createStatement();
    		rs=st.executeQuery("select name from patient where id="+p_id);
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