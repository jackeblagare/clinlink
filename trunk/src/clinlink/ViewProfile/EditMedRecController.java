package clinlink.ViewProfile;

//import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
//import org.zkoss.lang.Strings;

import clinlink.ViewProfile.Medical_record;
import clinlink.ViewProfile.Patient;
//import Clinlink.ViewProfile.Doctor;
public class EditMedRecController extends GenericForwardComposer{
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
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	//requests patient id
	public Medical_record doEditRecord(String username){
	Patient p=new Patient();
	p=p.getPatientID("anna");
	Medical_record mr= new Medical_record();
	//int pid= pat;
	mr=mr.getMedicalRecord(p.patient_id);
	return mr;
	}
	//sets the previous values
/*public Patient LoadProfile(){
		return(p);
		
	}*/ 
	
	public int isValid(String user,String pwd,int usetype){
		
		if(Strings.isBlank(user)|| usetype<1 ){
			return 0;
		}
		return 1;

	}	
	
}

