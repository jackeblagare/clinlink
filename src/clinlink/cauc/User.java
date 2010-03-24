package clinlink.cauc;
import java.sql.*;
import clinlink.cauc.User;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;

public class User extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
		public int status=0;
        public String excption= "";
        public String username = "";
        public int user_id;
        public int emp_id;
        public int id;
        public String type = "";
        public String password = "";
        public String usertype = "";
        public String position="";
        public String contact="";
        public String sex="";
        public String name = "";
        public String license = "";
        public String spec = "";
        public ResultSet rs;
        public ResultSet rs2;
        public Connection con1;
        public Connection con2;
        public Statement st;
        public Statement st2;
    
        public void setUser(String username){
                this.username = username;}
        public void setUserName(String name){
            this.name = name;}
        public void setUserLicense(String license){
            this.license = license;}
        public void setSpec(String spec){
            this.spec = spec;}   
        public void setPass(String password){
                this.password = password;}       
        public void setUserType(int usetype){
                usertype = Integer.toString(usetype);}    
    	public void setContact(String contact) {
    		this.contact = contact;}
    	public String getContact() {
    		return contact;}
    	public void setPosition(String position) {
    		this.position = position;}  
    	public void setId(int id) {
    		this.id = id;}
    	public void setSex(String sex) {
    		this.sex = sex; }
    	
        public int moveDoc(){           
            try{int stat=1;	
        	con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");  
        	st= con1.createStatement();
        	st2= con1.createStatement();
        	rs=st.executeQuery("select * from doctor where name='"+name+"'");
        	System.out.println(name);
        	while(rs.next())
            {
                    if(rs.getString(2).equals(name))
                    {
                    alert("Name of doctor already exists already exist");
                    Executions.sendRedirect("createDoctor.zul");
                    stat=0;
                    }      
            }
        	if (stat!=0){
            	st.executeUpdate("INSERT INTO doctor " + "VALUES (0,'"+name+"','"+license+"','"+spec+"')");
            	st2.executeUpdate("UPDATE user set user_id=(select doctor_id from doctor where name='"+name+"') where type=2 and user_id=0");	
        		}
        	} catch(SQLException e){
                    excption = e.toString();
                            return 0;
                    }          
            finally{
                    if (st != null) {
                            try {
                         st.close();
                     }catch (SQLException ex) {
                     }
                 }  
                 if (con1 != null) {
                     try {
                         con1.close();
                     } 
                     catch (SQLException ex) {                     
                     }
                    }
                  }
                    return status;
            } 
      
public int moveStaff(){           
            try{int stat=1;	
        	con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");  
        	st= con1.createStatement();
        	st2= con1.createStatement();
        	rs=st.executeQuery("select * from staff where name='"+name+"'");
        	System.out.println(name);
        	while(rs.next())
            {
                    if(rs.getString(1).equals(name))
                    {
                    alert("Name of staff already exists already exist");
                    Executions.sendRedirect("createStaff.zul");
                    stat=0;
                    }      
            }
        	if (stat!=0){
            	st.executeUpdate("INSERT INTO staff " + "VALUES ('"+name+"',0,'"+position+"')"); 
            	st2.executeUpdate("UPDATE user set user_id=(select emp_id from staff where name='"+name+"') where type=3 and user_id=0");         	        	
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
                 if (con1 != null) {
                     try {
                         con1.close();
                     } 
                     catch (SQLException ex) {                        
                     }
                    }
                  }
                    return status;
            } 
public int movePatient(){   
    try{int stat=1;	
    	con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");  
    	st= con1.createStatement();
    	st2= con1.createStatement();
    	rs=st.executeQuery("select * from patient where name='"+name+"'");
    	System.out.println(name);
    	while(rs.next())
        {
                if(rs.getString(1).equals(name))
                {
                alert("Name of patient already exists already exist");
                Executions.sendRedirect("createPatient.zul");
                stat=0;
                }      
        }
    	if (stat!=0){
    		st.executeUpdate("INSERT INTO patient " + "VALUES ('"+name+"',0,'"+sex+"','"+contact+"')");
        	st2.executeUpdate("UPDATE user set user_id=(select id from patient where name='"+name+"') where type=4 and user_id=0");         	        	
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
         if (con1 != null) {
             try {
                 con1.close();
             } 
             catch (SQLException ex) {               
             }
            }
          }
            return status;
    } 

public int create(){
	int stat=1;
    try{ 
    	con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");  
    	st= con1.createStatement();
    	st2= con1.createStatement();
    	rs=st.executeQuery("select * from user where username='"+username+"'");
    	while(rs.next())
        {
                if(rs.getString(1).equals(username))
                {
                alert("Username already exist");
                Executions.sendRedirect("createAccount.zul");
                stat=0;
                }      
        }
    	if (stat!=0){
        	st2.executeUpdate("INSERT INTO user " + "VALUES ('"+username+"','"+password+"',0,"+usertype+",0)");
        }
    }catch(SQLException e){
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
if (con2 != null) {
 try {
     con1.close();
 } 
 catch (SQLException ex) {
     
 }
}
}
return status;    
    } 
}