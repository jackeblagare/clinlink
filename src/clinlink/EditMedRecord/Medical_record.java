package clinlink.EditMedRecord;
import java.sql.*;

public class Medical_record {
public int status =0;
public String excption= "";
public int record_id;
public int doctor_id;
public int patient_id;
public String date_admin="";
public String date_rel="";
public String classname="";
public String bday="";
public String time_adm="";
public String discharge_time="";
public String height="";
public String weight="";
public String diagnosis="";
public int age;
public ResultSet rs;
public Connection con;
public Statement st;

public void setRecordId(int id){
this.record_id=id;	
}
public void setDoctorId(int d_id){
	this.doctor_id=d_id;	
	}
public void setPatientId(int p_id){
	this.patient_id=p_id;	
	}
public void setDateAdmin(String date_ad){
	this.date_admin=date_ad;	
	}
public void setDateRel(String date_rel){
	this.date_rel=date_rel;	
	}
public void setClass(String classname){
	this.classname=classname;	
	}
public void setBday(String bd){
	this.classname=bd;	
	}
public void setTimeAdm(String time){
	this.time_adm=time;
}
public void setDisTime(String dtime){
	this.discharge_time=dtime;
}
public void setHeight(String ht){
		this.height=ht;	
	}
public void setWeight(String wt){
	this.weight=wt;	
	}
public void setDiagnosis(String diag){
	this.diagnosis=diag;	
}
public void setAge(int age){
		this.age=age;	
	}


public Medical_record getMedicalRecord(int patient_id){
	Medical_record m=new Medical_record();
    try{ 
    	//int io=2;
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
    	st= con.createStatement();
    	rs=st.executeQuery("SELECT * FROM `med_record` WHERE patient_id="+patient_id+"");
    	//Patient p2=new Patient();
    	if(rs.next()){
    	m.setRecordId(rs.getInt(2));    	
    	m.setPatientId(rs.getInt(1));
    	m.setDateAdmin(rs.getString(3));
    	m.setDateRel(rs.getString(4));
    	m.setClass(rs.getString(5));
    	m.setBday(rs.getString(6));
    	m.setTimeAdm(rs.getString(7));
    	m.setDisTime(rs.getString(8));
    	m.setDoctorId(rs.getInt(9));
    	m.setHeight(rs.getString(10));
    	m.setWeight(rs.getString(11));
    	m.setDiagnosis(rs.getString(12));
    	m.setAge(rs.getInt(13));
    	}
    	return m;
    } catch(SQLException e){
    	excption = e.toString();
    	//m=null;
    	 return m;
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





public int updateMedicalRecord(int record_id, int patient_id, int doct_id, String height, String weight, String diagnosis, int age)
{
	//this.patient_id = patient_id;
	try{ 
    	
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
    	st= con.createStatement();
    	st.executeUpdate("UPDATE med_record SET diagnosis='"+diagnosis+"', height='"+height+"', age='"+age+"', weight='"+weight+"'"+"WHERE record_id="+record_id+"");
       	return 1;
    
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
    	
	}
}
	
