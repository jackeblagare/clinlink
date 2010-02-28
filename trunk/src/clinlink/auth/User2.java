package clinlink.auth;

import java.sql.*;
import java.util.ArrayList;


public class User2{
	
	public int status=0; // returns a value if login is successful or not
    public int redFlag=0;
    
    public String excption= "";
    public String username = "";
    public String password = "";
    public String usertype = "";
    public String userid = "";
    public ResultSet rs;
    public ResultSet rs2;
    public Connection con;
    public Statement st;

    
	
public void setUser(String username){
        this.username = username;
}

public void setPass(String password){
        this.password = password;
}

public void setUserType(int usetype){
        usertype = Integer.toString(usetype);
}

public void setUserid(int useid)
{	
	userid = Integer.toString(useid);
}


public Object[][] approve()
{
	Object[][] lahat;
	try
	{       
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
        st= con.createStatement();
        
        rs2=st.executeQuery("select * from user where isActive=0");
        int size=0;
        while(rs2.next())
        	size++;
        lahat = new Object [size+1][2];
        for (int i=0; i<size+1; i++)
        	for (int j=0; j<2; j++)
        			lahat[i][j]=-1;
        int pat_idcount=-1;
        rs=st.executeQuery("select * from user where isActive=0");
        while(rs.next())
        {
                	
                	pat_idcount++;
                	
                	lahat[pat_idcount][0]=rs.getString(1);
                	lahat[pat_idcount][1]=rs.getString(4);
                
                
        }
        return lahat;
   
    } 
	catch(SQLException e)
	{
		lahat = new Object[1][1];
    	int[] exp3 = new int[100];
    	for (int i=0; i<100; i++)
    		exp3[i]=-1;
        excption = e.toString();
        	return lahat;
    }
   
    finally
    {
        if (st != null) {
        	try 
        	{
        		st.close();
            }
            catch (SQLException ex) {}
        }  
        if (con != null) {
             try 
             {
                 con.close();
             }
             catch (SQLException ex) {}
        }
    }
}

public void denyAccount()
{
	try
	{       
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
        st= con.createStatement();
        
        st.executeUpdate("UPDATE user SET isActive=-1 WHERE username='"+username+"'");
    } 
	catch(SQLException e)
	{
    	int[] exp3 = new int[100];
    	for (int i=0; i<100; i++)
    		exp3[i]=-1;
        excption = e.toString();
    }
   
    finally
    {
        if (st != null) {
        	try 
        	{
        		st.close();
            }
            catch (SQLException ex) {}
        }  
        if (con != null) {
             try 
             {
                 con.close();
             }
             catch (SQLException ex) {}
        }
    }
}

public void approveAccount()
{
	try
	{       
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
        st= con.createStatement();
        
        st.executeUpdate("UPDATE user SET isActive=1 WHERE username='"+username+"'");
    } 
	catch(SQLException e)
	{
    	int[] exp3 = new int[100];
    	for (int i=0; i<100; i++)
    		exp3[i]=-1;
        excption = e.toString();
    }
   
    finally
    {
        if (st != null) {
        	try 
        	{
        		st.close();
            }
            catch (SQLException ex) {}
        }  
        if (con != null) {
             try 
             {
                 con.close();
             }
             catch (SQLException ex) {}
        }
    }
}

public Object[][] searchMed()
{
	Object[][] lahat;
	try
	{       
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
        st= con.createStatement();
        
        rs2=st.executeQuery("select * from med_record");
        int size=0;
        while(rs2.next())
        	size++;
        lahat = new Object [size+1][13];
        for (int i=0; i<size+1; i++)
        	for (int j=0; j<2; j++)
        			lahat[i][j]=-1;
        int pat_idcount=-1;
        rs=st.executeQuery("select * from med_record");
        while(rs.next())
        {
                if(rs.getString(1).contains(userid))
                {
                	
                	pat_idcount++;
                	for (int ii=1; ii<=13; ii++)
                	{
                		lahat[pat_idcount][ii-1]=rs.getString(ii);
                	}
                }
                
        }
        return lahat;
   
    } 
	catch(SQLException e)
	{
		lahat = new Object[1][1];
    	int[] exp3 = new int[100];
    	for (int i=0; i<100; i++)
    		exp3[i]=-1;
        excption = e.toString();
        	return lahat;
    }
   
    finally
    {
        if (st != null) {
        	try 
        	{
        		st.close();
            }
            catch (SQLException ex) {}
        }  
        if (con != null) {
             try 
             {
                 con.close();
             }
             catch (SQLException ex) {}
        }
    }
}
public Object[][] search()
{
	Object[][] lahat;
	try
	{       
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
        st= con.createStatement();
        
        rs2=st.executeQuery("select * from patient");
        int size=0;
        while(rs2.next())
        	size++;
        lahat = new Object [size+1][2];
        for (int i=0; i<size+1; i++)
        	for (int j=0; j<2; j++)
        			lahat[i][j]=-1;
        int pat_idcount=-1;
        rs=st.executeQuery("select * from patient");
        while(rs.next())
        {
                if(rs.getString(1).contains(username))
                {
                	
                	pat_idcount++;
                	lahat[pat_idcount][0]=rs.getString(1);
                	lahat[pat_idcount][1]=rs.getInt(2);
                }
                
        }
        return lahat;
   
    } 
	catch(SQLException e)
	{
		lahat = new Object[1][1];
    	int[] exp3 = new int[100];
    	for (int i=0; i<100; i++)
    		exp3[i]=-1;
        excption = e.toString();
        	return lahat;
    }
   
    finally
    {
        if (st != null) {
        	try 
        	{
        		st.close();
            }
            catch (SQLException ex) {}
        }  
        if (con != null) {
             try 
             {
                 con.close();
             }
             catch (SQLException ex) {}
        }
    }
}


public int login(){
    
    try{
           
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
            st= con.createStatement();
            rs=st.executeQuery("select * from user where username='"+username+"' and type='"+usertype+"'");
       
            if(rs.next()){
                    if(rs.getString(2).equals(password) && rs.getString(1).equals(username)){
                            if(rs.getString(3).equals("1")){
                                   
                                    if(rs.getString(4).equals("1")){
                                            this.redFlag = 1;
                                            status =1;
                                    }
                                    else if(rs.getString(4).equals("2")){
                                            this.redFlag = 2;
                                            status = 1;
                                    }
                                    else if(rs.getString(4).equals("3")){
                                            this.redFlag = 3;
                                            status = 1;
                                    }
                                    else if(rs.getString(4).equals("4")){
                                           
                                            this.redFlag = 4;
                                            status = 1;
                                    }
                            }
                           
                            else  status = 2; //user is inactive
                    }
            }
   
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
            return status;
    }

}

