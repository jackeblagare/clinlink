package clinlink.ViewProfile;
import java.sql.*;
public class Doctor {
	
	public int doctor_id;
	public String name;
	public String license;
	public String specialization;
	public String excption;
	public ResultSet rs;
	public Connection con;
    public Statement st;
    
	public void setDoctorID(int doc_id){
		this.doctor_id= doc_id;
	}


	public void setDname(String name){
		this.name = name;
	}
	public void setLicense(String lic){
		this.license= lic;
	}


	public void setSpecial(String spe){
		this.specialization= spe;
	}
	
	public Doctor getProfile(int user_id){
		Doctor d2=new Doctor();
        try{ 
        	//int io=2;
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
        	st= con.createStatement();
        	rs=st.executeQuery("SELECT * from patient WHERE id="+user_id+"");
        	//Patient p2=new Patient();
        	if(rs.next()){
        	d2.setDoctorID(rs.getInt(2));
        	d2.setDname(rs.getString(1));
        	d2.setLicense(rs.getString(3));
        	d2.setSpecial(rs.getString(4));}
        	return d2;
        } catch(SQLException e){
        	excption = e.toString();
        	// p2=null;
        	 return d2;
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
