package clinlink.deleteAccount;
import java.sql.*;

//import org.zkoss.zk.ui.Executions;
public class User{
        
        public int status=0; // returns a value if login is successful or not
        public int redFlag=0;
        public String excption= "";
        public String user = "";
        public String usertype = "";
        public ResultSet rs;
        public Connection con;
        public Statement st;
    
        public void setUser(String user){
                this.user = user;
        }
        
        public void setUserType(int usetype){
                usertype = Integer.toString(usetype);
        }
        
    public int delete(){
                
        try{ 
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinklink");
        	st= con.createStatement();
        	System.out.println(usertype);
        	System.out.println(user);

        	if (usertype.equals("1")){
        		st.executeUpdate("DELETE from doctor where doctor_id='"+user+"' ");
        	}
        	else if (usertype.equals("2")){
        		st.executeUpdate("DELETE from staff where emp_id='"+user+"' ");	
        	}
        	else if (usertype.equals("3")){
            	st.executeUpdate("DELETE from patient where id='"+user+"' ");       	
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