package clinlink.EditProfile;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.lang.Strings;

import clinlink.EditProfile.Doctor;
public class DoctorEditController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	public int doctor_id;
	public String name;
	public String specialization;
	public String license;
	int kat;
	public int page = 0;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public Doctor doEditProfile(String name,String specialization, String license,int doctor_id){
		this.setDoctor_id(doctor_id);
		this.setName(name);	
		this.setSpecialization(specialization);
		this.setLicense(license);
		
		Doctor n = new Doctor();
		if(isValid()==0){
			alert("Please complete the necessary information!");			
		}
		else{
			n.setDoctor_id(doctor_id);
			n.setName(name);	
			n.setSpecialization(specialization);
			n.setLicense(license);	
			n.editDoctor();
			alert("Edit Successful!");
		}
		return null;
	}
	
	private void setLicense(String license) {
		this.license=license;
		
	}

	private void setSpecialization(String specialization) {
		this.specialization=specialization;
		
	}

	private void setDoctor_id(int doctor_id) {
		this.doctor_id=doctor_id;
	}

	public Doctor doViewProfile(int user_id){
	    Doctor p= new Doctor();		
		{
			p= p.getProfile(user_id);
			}
		
			return p;
		}

	public int isValid(){
		if(Strings.isBlank(name) || Strings.isEmpty(specialization) || Strings.isEmpty(license)){
			return 0;
		}
		return 1;
	}

	private void setName(String name) {
		this.name=name;
		
	}
	
}
