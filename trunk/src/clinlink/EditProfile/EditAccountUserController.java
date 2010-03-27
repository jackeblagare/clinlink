package clinlink.EditProfile;

import clinlink.EditProfile.User;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;
import org.zkoss.lang.Strings;

public class EditAccountUserController extends GenericForwardComposer{
	private static final long serialVersionUID = 1L;
		Button Create;
		Window main;
		private String user = " ";
		private String name = " ";
		public int doctor_id;
		public int emp_id;
		public int id;
		private String license = " ";
		private String spec = " ";
		private String pwd;
		private String sex;
		private String contact;
		private String position;
		
		private int usertype;
		
		public void doAfterCompose(Component comp) throws Exception {
			super.doAfterCompose(comp);
		}

	
	public void doEditDoc(String name,String license,String spec,int doctor_id){
		this.setName(name);	
		this.setLicense(license);
		this.setSpec(spec);
		this.setDoctor_id(doctor_id);
		
		User n = new User();
		if(isValid2()==0){
			alert("Please complete the necessary information!");
		}
		else{
			n.setUserName(name);	
			n.setSpec(spec);
			n.setUserLicense(license);
			n.setDoctor_id(doctor_id);	
			n.editDoc();
			alert("Edit Successful!");
		}
	}

	public void doEditPatient(String name,String sex, String contact,int id){
		this.setName(name);	
		this.setSex(sex);
		this.setId(id);
		this.setContact(contact);
		
		User n = new User();
		if(isValid3()==0){
			alert("Please complete the necessary information!");			
		}
		else{
			n.setUserName(name);	
			n.setContact(contact);	
			n.setId(id);	
			n.editPatient();
			alert("Edit Successful!");
		}
	}
	
	public void doEditStaff(String name,String position,int emp_id){
		this.setName(name);	
		this.setEmp_id(emp_id);	
		this.setPosition(position);	
		
		User n = new User();
		if(isValid4()==0){
			alert("Please complete the necessary information!");			
		}
		else{
			n.setUserName(name);	
			n.setPosition(position);
			n.setEmp_id(emp_id);	
			n.editStaff();
			alert("Edit Successful!");
		}
	}
	
	public int isValid(){
		if(Strings.isBlank(user) || Strings.isEmpty(pwd) || usertype<0){
			return 0;
		}
		return 1;
	}
	
	public int isValid2(){
		if(Strings.isBlank(name) || Strings.isEmpty(spec) || Strings.isEmpty(license)){
			return 0;
		}
		return 1;
	}

	public int isValid3(){
		if(Strings.isBlank(name) || Strings.isEmpty(sex) || Strings.isEmpty(contact)){
			return 0;
		}
		return 1;
	}
	
	public int isValid4(){
		if(Strings.isBlank(name) || Strings.isEmpty(position)){
			return 0;
		}
		return 1;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicense() {
		return license;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getSpec() {
		return spec;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContact() {
		return contact;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}


	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}


	public int getDoctor_id() {
		return doctor_id;
	}


	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}


	public int getEmp_id() {
		return emp_id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}	
}