package clinlink.EditProfile;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.lang.Strings;

import clinlink.EditProfile.Patient;
public class PatientEditController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
	public String sex;
	public String contact;
	int kat;
	public int page = 0;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public Patient doEditProfile(String name,String sex, String contact,int id){
		this.setId(id);
		this.setName(name);	
		this.setSex(sex);
		this.setContact(contact);
		
		Patient n = new Patient();
		if(isValid3()==0){
			alert("Please complete the necessary information!");			
		}
		else{
			n.setId(id);
			n.setUserName(name);	
			n.setContact(contact);
			n.setSex(sex);	
			n.editPatient();
			alert("Edit Successful!");
		}
		return null;
	}
	
	private void setId(int id) {
		this.id=id;
		
	}

	public Patient doViewProfile(int user_id){
	    Patient p= new Patient();		
		{
			p= p.getProfile(user_id);
			}
		
			return p;
		}

	private void setContact(String contact) {
		this.contact=contact;
		
	}

	private void setSex(String sex) {
		this.sex=sex;
		
	}
	public int isValid3(){
		if(Strings.isBlank(name) || Strings.isEmpty(sex) || Strings.isEmpty(contact)){
			return 0;
		}
		return 1;
	}

	private void setName(String name) {
		this.name=name;
		
	}
	
}
