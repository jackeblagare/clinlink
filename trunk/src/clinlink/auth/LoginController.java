package clinlink.auth;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.lang.Strings;

import clinlink.auth.User;

public class LoginController extends GenericForwardComposer{
	

	private static final long serialVersionUID = 1L;
	public String user;
	public String pwd;
	public int usertype;
	public int page = 0;
	public int userid = 0;
	
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public int doLogin(String user,String pwd,int usertype){
		User u= new User();
		this.user=user;	
		this.pwd=pwd;
		this.usertype = usertype;
		int status=0;
		
		if(isValid(user,pwd,usertype)==0){
			return 3;
		}
		
		else{
			u.setUser(user);	
			u.setPass(pwd);
			u.setUserType(usertype);
			status = u.login();
			page = u.redFlag;
			this.usertype = Integer.parseInt(u.usertype);
			this.userid = u.userid; 
		}
		
		return status;
	}
	
	public int isValid(String user,String pwd,int usertype){
		
		if(Strings.isBlank(user) || Strings.isEmpty(pwd) || usertype<1 ){
			return 0;
		}
		return 1;

	}	
	
}
