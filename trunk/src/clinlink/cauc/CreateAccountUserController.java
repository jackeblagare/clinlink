package clinlink.cauc;
//import java.sql.*;

import clinlink.cauc.User;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.Executions;

public class CreateAccountUserController extends GenericForwardComposer{
	private static final long serialVersionUID = 1L;
		Button Create;
		Window main;
		private String user = " ";
		private String name = " ";
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

	public void doCreate(String user,String pwd,int usertype){
		this.user=user;	
		this.pwd=pwd;
		this.usertype = usertype;
		
		User u = new User();
		if(isValid()==0){
			alert("Please complete the necessary information!");
		}
		else{
			u.setUser(user);	
			u.setPass(pwd);
			u.setUserType(usertype);		
			u.create();
			alert("Complete the following informations!");
			if(usertype == 2){
			Executions.sendRedirect("doctor.zul");
			}
			else if(usertype == 3){
			Executions.sendRedirect("staff.zul");
			}
			else if(usertype == 4){
				Executions.sendRedirect("patient.zul");
				}
			System.out.println("nagredirect");
		}
	}
	
	public void doMoveDoc(String name,String license,String spec){
		this.setName(name);	
		this.setLicense(license);
		this.setSpec(spec);
		
		User n = new User();
		if(isValid2()==0){
			alert("Please complete the necessary information!");
			
		}
		else{
			n.setUserName(name);	
			n.setSpec(spec);
			n.setUserLicense(license);		
			n.move();
			alert("Registration Complete!");
			alert("Wait for approval from the Administrator!");
		}
	}

	public void doMovePatient(String name,String sex, String contact){
		this.setName(name);	
		this.setSex(sex);
		this.setContact(contact);
		
		User n = new User();
		if(isValid3()==0){
			alert("Please complete the necessary information!");
			
		}
		else{
			n.setUserName(name);	
			n.setContact(contact);		
			n.move();
			alert("Registration Complete!");
			alert("Wait for approval from the Administrator!");
		}
	}
	
	public void doMoveStaff(String name,String position){
		this.setName(name);	
		this.setPosition(position);
		
		User n = new User();
		if(isValid4()==0){
			alert("Please complete the necessary information!");
			
		}
		else{
			n.setUserName(name);	
			n.setPosition(position);	
			n.move();
			alert("Registration Complete!");
			alert("Wait for approval from the Administrator!");
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
}