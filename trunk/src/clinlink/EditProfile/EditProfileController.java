
package clinlink.EditProfile;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.lang.Strings;

import clinlink.EditProfile.Patient;

public class EditProfileController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	public int user_id;
	public int usetype;
	public int page = 0;
	public int patient_id;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public Patient doEditProfile(int user_id, int usetype){
		Patient p= new Patient();		
		this.patient_id=user_id;	
	//	int status=0;
		{
			p.setID(patient_id);	
			p= p.getProfile(patient_id);
			page = 4;
			}
		
			return p;
		}
		
	
	public int isValid(String user,String pwd,int usetype){
		
		if(Strings.isBlank(user)|| usetype<1 ){
			return 0;
		}
		return 1;

	}	
	
}

