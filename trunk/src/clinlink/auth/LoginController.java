package clinlink.auth;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.lang.Strings;

import clinlink.auth.User;

public class LoginController extends GenericForwardComposer{
	
	public String user;
	public String pwd;
	public int usertype;
	public int page = 0;
	
	
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public int doLogin(String user,String pwd,int usertype){
		User u= new User();
		this.user=user;	
		this.pwd=pwd;
		this.usertype = usertype;
		
		int status=0;
		
	
		if(isValid()==0){
			return 3;
		}
		
		else{
			u.setUser(user);	
			u.setPass(pwd);
			u.setUserType(usertype);
			status = u.login();
			page = u.redFlag;
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
