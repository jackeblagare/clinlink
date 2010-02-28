package clinlink.ViewProfile;
import java.sql.*;
public class user{
	
	public int status=1; // returns a value if login is successful or not
	public int redFlag=0;
	
	public String excption= "";
	public int user_id;
	public int usertype;
	
	public ResultSet rs;
	public Connection con;
    public Statement st;
    
	public void setUserID(int userId){
		this.user_id= userId;
	}

	
	public void setUserType(int usetype){
		this.usertype = usetype;
	}
	
    public int getProfile(){
    		
        try{ 
        	
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	//rs=st.executeQuery("select * from patient where user_id='"+user_id+"' and type='"+usertype+"'");
        	if (usertype==1)
        		rs=st.executeQuery("select * from patient where user_id='"+user_id+"' and type='"+usertype+"'");
        		
        		this.redFlag = 1;
        	if (usertype==2)
            	rs=st.executeQuery("select * from doctor where user_id='"+user_id+"' and type='"+usertype+"'");
        	this.redFlag = 2;

        	if (usertype==3)
            	rs=st.executeQuery("select * from staff where user_id='"+user_id+"' and type='"+usertype+"'");
        	this.redFlag = 3;

        	if (usertype==4)
            	rs=st.executeQuery("select * from admin where user_id='"+user_id+"' and type='"+usertype+"'");
        	this.redFlag = 4;

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

        	}return 1;
    	}
    
}
