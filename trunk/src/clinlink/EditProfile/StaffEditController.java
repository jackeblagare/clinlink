package clinlink.EditProfile;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.lang.Strings;

import clinlink.EditProfile.Staff;
public class StaffEditController extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	public int emp_id;
	public String name;
	public String position;
	int kat;
	public int page = 0;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public Staff doEditProfile(String name,String position, int emp_id){
		this.setEmp_id(emp_id);
		this.setName(name);	
		this.setPosition(position);
		
		Staff n = new Staff();
		if(isValid()==0){
			alert("Please complete the necessary information!");			
		}
		else{
			n.setEmp_id(emp_id);
			n.setName(name);	
			n.setPosition(position);	
			n.editStaff();
			alert("Edit Successful!");
		}
		return null;
	}
	
	private void setPosition(String position) {
		this.position=position;
		
	}

	private void setEmp_id(int emp_id) {
		this.emp_id=emp_id;
	}

	public Staff doViewProfile(int user_id){
	    Staff p= new Staff();		
		{
			p= p.getProfile(user_id);
			}
		
			return p;
		}

	public int isValid(){
		if(Strings.isBlank(name) || Strings.isEmpty(position)){
			return 0;
		}
		return 1;
	}

	private void setName(String name) {
		this.name=name;
		
	}
	
}
