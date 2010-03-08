package clinlink.deleteAccount;

import clinlink.deleteAccount.User;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;
import org.zkoss.lang.Strings;
//import org.zkoss.zk.ui.Executions;

public class DeleteAccountController extends GenericForwardComposer{
	private static final long serialVersionUID = 1L;
		Button Create;
		Window main;
		private String user = " ";
		private int usertype;
		
		public void doAfterCompose(Component comp) throws Exception {
			super.doAfterCompose(comp);
		}

	public void doDelete(String user, int usertype){
		this.user=user;	
		this.usertype = usertype;
		
		User u = new User();
		if(isValid()==0){
			alert("Please complete the necessary information!");
		}
		else{
			u.setUser(user);	
			u.setUserType(usertype);		
			u.delete();
			alert("Deleted!");
		}
	}
	
	public int isValid(){
		if(Strings.isBlank(user) || usertype<0){
			return 0;
		}
		return 1;
	}	
}