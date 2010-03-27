package clinlink.EditProfile;
import java.sql.*;

import clinlink.EditProfile.Staff;
public class Staff {
	
	public int emp_id;
	public String name;
	public String position;
	public String excption;
	public ResultSet rs;
	public Connection con;
    public Statement st;
    
	public void setPosition(String position){
		this.position=position;
	}
	public void setName(String name){
		this.name = name;
	}

	public void setEmp_id(int emp_id){
		this.emp_id= emp_id;
	}

	
	public Staff getProfile(int user_id){
		Staff p2=new Staff();
        try{ 
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	rs=st.executeQuery("SELECT * from staff WHERE emp_id="+user_id+"");
        	if(rs.next()){
        	p2.setEmp_id(rs.getInt(2));
        	p2.setName(rs.getString(1));
        	p2.setPosition(rs.getString(3));
        	}
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
	
	public int editStaff(){   
	    try{	
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");     	
	    	st= con.createStatement();
	    	st.executeUpdate("UPDATE staff SET  name='"+name+"',position='"+position+"' WHERE  emp_id='"+emp_id+"'");	 
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

	
	public Staff getStaffID(String username){
		Staff p2=new Staff();
        try{ 
        	int io=2;
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	rs=st.executeQuery("SELECT * from staff WHERE id="+io+"");
        	if(rs.next()){
        	p2.setEmp_id(rs.getInt(2));
        	p2.setName(rs.getString(1));
        	p2.setPosition(rs.getString(3));
        	}
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
