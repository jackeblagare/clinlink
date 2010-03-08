
package clinlink.ViewProfile;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.lang.Strings;

import clinlink.ViewProfile.Staff;
//import Clinlink.ViewProfile.Staff;
//import Clinlink.ViewProfile.Doctor;
public class StaffViewController extends GenericForwardComposer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int emp_id;
	public String name;
	public String position;
	public int page = 0;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public Staff doViewProfile(int user_id){
	    Staff s= new Staff();		
	   // this.patient_id=user_id;	
		//int status=0;
		{
			//p.setPatientID(patientid);	
			s= s.getProfile(user_id);
			//page = 4;
			}
		
			return s;
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

