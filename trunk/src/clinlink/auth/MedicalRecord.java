package clinlink.auth;
import java.sql.*;
import java.util.Date;

public class MedicalRecord {
public int status =0;
public String excption= "";
public int record_id;
public int doctor_id;
public int patient_id;
public Date date_admin=new Date(0);
public Date date_rel=new Date(0);
public String classname="";
public Date bday=new Date(0);
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
public void setDateAdmin(Date date_ad){
	this.date_admin=date_ad;	
	}
public void setDateRel(Date date_rel){
	this.date_rel=date_rel;	
	}
public void setClass(String classname){
	this.classname=classname;	
	}
public void setBday(Date bd){
	this.bday=bd;	
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


public MedicalRecord getMedicalRecord(int patient_id){
	MedicalRecord m=new MedicalRecord();
    try{ 
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","clinlink","clinlink");
    	st= con.createStatement();
    	rs=st.executeQuery("SELECT * FROM `med_record` WHERE patient_id="+patient_id+"");
    	if(rs.next()){
    	m.setRecordId(rs.getInt(2));    	
    	m.setPatientId(rs.getInt(1));
    	m.setDateAdmin(rs.getDate(3));
    	m.setDateRel(rs.getDate(4));
    	m.setClass(rs.getString(5));
    	m.setBday(rs.getDate(6));
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





public int updateMedicalRecord(int record_id, int patient_id, int doct_id, String height, String weight, String diagnosis, int age, String classname, Date date_admin, Date date_rel, String time_adm, String discharge_time, Date bday)
{
	try{ 
    	
    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinlink","root","");
    	st= con.createStatement();

    	rs=st.executeQuery("SELECT * FROM `doctor` WHERE doctor_id="+doct_id+"");
    	if(!rs.next()){
    		return 2; }
    	else {
    	st.executeUpdate("UPDATE med_record SET diagnosis='"+diagnosis+"', height='"+height+"', discharge_time='"+discharge_time+"',doctor_id='"+doct_id+"', age='"+age+"', date_adm='"+date_admin+"', date_rel='"+date_rel+"',dob='"+bday+"', time_adm='"+time_adm+"', class='"+classname+"', weight='"+weight+"'"+"WHERE record_id="+record_id+"");
       	return 1;//
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
    	
	}
}
	
