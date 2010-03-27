package clinlink.deleteAccount;
import java.sql.*;
import java.util.ArrayList;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;

public class DeleteManager extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	public ResultSet rs;
	public ResultSet rs2;
	public ResultSet rs3;
	public Connection con;
	public Connection con2;
	public Connection con1;
	public Connection con3;
	public Statement st;
	public Statement st2;
	public Statement st3;
	public String exc="";
	public String empID;
	private int usertype;
	private String user;
	
	public ArrayList<Integer> emp_id = new ArrayList<Integer>();
	public ArrayList<Integer> doctor_id = new ArrayList<Integer>();
	public ArrayList<Integer> id = new ArrayList<Integer>();
	public ArrayList<String> name = new ArrayList<String>();
	public ArrayList<String> position = new ArrayList<String>();
	public ArrayList<String> sex = new ArrayList<String>();
	public ArrayList<String> specialization = new ArrayList<String>();
	
	public void getAllStaff(){
		try{
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
    		st= con.createStatement();
    		rs=st.executeQuery("select emp_id, name, position from staff order by name");
    		while(rs.next() != false){
    			emp_id.add(rs.getInt(1));
    			name.add(rs.getString(2));
    			position.add(rs.getString(3));
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
	
	public void getAllDoctor(){
		try{
    		con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
    		st2= con2.createStatement();
    		rs2=st2.executeQuery("select doctor_id, name, specialization from doctor order by name");
    		while(rs2.next() != false){
    			doctor_id.add(rs2.getInt(1));
    			name.add(rs2.getString(2));
    			specialization.add(rs2.getString(3));
    		}
    	}catch(SQLException e){
    		exc = e.toString();
    	}finally{
    		if(st2 != null){
    			try{st2.close();}catch(SQLException ex){}
             }	
             if(con2 != null){
            	 try{con2.close();}catch(SQLException ex){}
             }
        }
	}
	
	public void getAllPatient(){
		try{
    		con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
    		st3= con3.createStatement();
    		rs3=st3.executeQuery("select id, name, sex from patient order by name");
    		while(rs3.next() != false){
    			id.add(rs3.getInt(1));
    			name.add(rs3.getString(2));
    			sex.add(rs3.getString(3));
    		}
    	}catch(SQLException e){
    		exc = e.toString();
    	}finally{
    		if(st3 != null){
    			try{st3.close();}catch(SQLException ex){}
             }	
             if(con3 != null){
            	 try{con3.close();}catch(SQLException ex){}
             }
        }
	}
	
	public void setUser(String user){
        this.user = user;}
	public void setUserType(int usertype){
        this.usertype = usertype;}

public int delete(){                
try{
	System.out.println(usertype);
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");     	
	st= con.createStatement();
	if (usertype==1){

		System.out.println("doctor");
		System.out.println(usertype);
		int stat=1;
	    try{ 
	    	con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");  
	    	st= con1.createStatement();
	    	st2= con1.createStatement();
	    	st3=con1.createStatement();
	    	rs=st.executeQuery("select * from doctor where doctor_id='"+user+"'");
	    	while(rs.next())
	        {
	                if(rs.getString(1).equals(user))
	                {
	            	st2.executeUpdate("DELETE from doctor where doctor_id='"+user+"' ");
	            	st3.executeUpdate("DELETE from user where user_id='"+user+"' and type=2");
	            	alert("Deleted!");
	            	stat=0;
	            	Executions.sendRedirect("admin.zul");
	                }      
	        }
	    	if (stat!=0){
                alert("User ID does not Exist.");
                Executions.sendRedirect("deleteAccountUser.zul");
                stat=0;
	        }
	    }catch(SQLException e){
	        exc = e.toString();
	        return 0;
	}

	
	}	else if (usertype==2){

		System.out.println("staff");
		System.out.println(usertype);
		int stat=1;
	    try{ 
	    	con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");  
	    	st= con1.createStatement();
	    	st2= con1.createStatement();
	    	st3=con1.createStatement();
	    	rs=st.executeQuery("select * from staff where emp_id='"+user+"'");
	    	while(rs.next())
	        {
	                if(rs.getString(2).equals(user))
	                {
	            	st2.executeUpdate("DELETE from staff where emp_id='"+user+"' ");
	            	st3.executeUpdate(" DELETE from user where user_id='"+user+"' and type=3 ");
	            	alert("Deleted!");	
	            	stat=0;
	            	Executions.sendRedirect("admin.zul");
	                }      
	        }
	    	if (stat!=0){
                alert("User ID does not Exist.");
                Executions.sendRedirect("deleteAccountUser.zul");
                stat=0;
	        }
	    }catch(SQLException e){
	        exc = e.toString();
	        return 0;
	}

	
	}
	else if (usertype==3){
		System.out.println("patient");
		System.out.println(usertype);
		int stat=1;
	    try{ 
	    	con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");  
	    	st= con1.createStatement();
	    	st2= con1.createStatement();
	    	st3=con1.createStatement();
	    	rs=st.executeQuery("select * from patient where id='"+user+"'");
	    	while(rs.next())
	        {
	                if(rs.getString(2).equals(user))
	                {
	            	st2.executeUpdate("DELETE from patient where id='"+user+"' ");
	            	st3.executeUpdate("DELETE from user where user_id='"+user+"' and type=4");
	            	alert("Deleted!");
	            	Executions.sendRedirect("admin.zul");
	            	stat=0;
	                }      
	        }
	    	if (stat!=0){
                alert("User ID does not Exist.");
                Executions.sendRedirect("deleteAccountUser.zul");
                stat=0;
	        }
	    }catch(SQLException e){
	        exc = e.toString();
	        return 0;
	}
	}
} catch(SQLException e){
        exc = e.toString();
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
        return 1;
}
}