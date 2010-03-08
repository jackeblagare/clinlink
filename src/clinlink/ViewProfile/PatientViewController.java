
package clinlink.ViewProfile;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.lang.Strings;

import clinlink.ViewProfile.Patient;
//import Clinlink.ViewProfile.Staff;
//import Clinlink.ViewProfile.Doctor;
public class PatientViewController extends GenericForwardComposer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int patientid;
	public String patientname;
	public String sex;
	public String cont;
	public int page = 0;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public Patient doViewProfile(int user_id){
	    Patient p= new Patient();		
	   // this.patient_id=user_id;	
		//int status=0;
		{
			//p.setPatientID(patientid);	
			p= p.getProfile(user_id);
			//page = 4;
			}
		
			return p;
		}
		
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

