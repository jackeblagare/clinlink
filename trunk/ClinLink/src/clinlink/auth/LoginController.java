package clinlink.auth;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.Executions;

import clinlink.auth.User;

public class LoginController extends GenericForwardComposer{
	
	User u = new User();
	private String user;
	private String pwd;
	private int usertype;
	
	public int status = 0;
	public int redFlag1 = 0;
	
	public void setRedirect(int val){
		this.redFlag1 = val;
	}
	
	public int getRedirect(){
		alert(""+this.redFlag1);
		return this.redFlag1;
	}
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	
	
	public int doLogin(String user,String pwd,int usertype){
		this.user=user;	
		this.pwd=pwd;
		this.usertype = usertype;
		
		int status=0;
		
	
		if(isValid()==0){
			alert("Please complete the necessary information!");
		}
		
		else{
			u.setUser(user);	
			u.setPass(pwd);
			u.setUserType(usertype);
			u.login();
			status = u.status;
			redFlag1 = u.redFlag;
		}
		return status;
	}
	
	public int isValid(){
		
		if(Strings.isBlank(user) || Strings.isEmpty(pwd) || usertype<0){
			return 0;
		}
		return 1;

	}	
}
