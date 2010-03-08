package clinlink.EditMedRecord;

//import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
//import org.zkoss.lang.Strings;

import clinlink.EditMedRecord.Medical_record;
import clinlink.EditMedRecord.Patient;
//import Clinlink.ViewProfile.Doctor;
public class Medcontroller extends GenericForwardComposer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public String patient_id;
	public String record_id;
	public String date_admin;
	public String date_rel;
	public String class_name;
	public String bday;
	public String time_adm;
	public String discharge_time;
	public int doctor_id;
	public String height;
	public String weight;
	public int age;
	public int page = 0;
	public int pat;
	
	public Medical_record doEditRecord(String username){
	Patient p=new Patient();
	p=p.getPatientID(username);
	Medical_record mr= new Medical_record();
	//int pid= pat;
	mr=mr.getMedicalRecord(p.patient_id);
	return mr;
	}
	
	public int doUpdateRecord(int record_id, int patient_id, int doctor_id, String height, String weight,String diagnosis,int age){
		Medical_record mm= new Medical_record();
		int status;
		status=mm.updateMedicalRecord(record_id, patient_id, doctor_id, height, weight, diagnosis, age);
		return status;
		}
}