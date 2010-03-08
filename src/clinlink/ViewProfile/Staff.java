package clinlink.ViewProfile;
import java.sql.*;
public class Staff {
	
	public int emp_id;
	public String name;
	public String position;
	public String excption;
	public ResultSet rs;
	public Connection con;
    public Statement st;
	
    public void setEmpID(int staff_id){
		this.emp_id= staff_id;
	}


	public void setname(String name){
		this.name = name;
	}
	public void setPos(String pos){
		this.position= pos;
	}

	
	public Staff getProfile(int user_id){
		Staff s2=new Staff();
        try{ 
        	//int io=2;
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	rs=st.executeQuery("SELECT * from patient WHERE id="+user_id+"");
        	//Patient p2=new Patient();
        	if(rs.next()){
        	s2.setEmpID(rs.getInt(2));
        	s2.setname(rs.getString(1));
        	s2.setPos(rs.getString(3));
  }
        	return s2;
        } catch(SQLException e){
        	excption = e.toString();
        	// p2=null;
        	 return s2;
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
