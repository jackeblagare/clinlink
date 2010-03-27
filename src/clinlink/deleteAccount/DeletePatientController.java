package clinlink.deleteAccount;

import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import clinlink.deleteAccount.DeleteManager;

public class DeletePatientController extends GenericForwardComposer{
	static final long serialVersionUID = 1L;
	private String user_id;
	private int usertype;
	public DeletePatientController(){		
	}
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public void doDelete(String user_id,int usertype){
		this.user_id=user_id;	
		this.usertype = usertype;
		
		DeleteManager dp = new DeleteManager();
		if(isValid()==0){
			alert("Please complete the necessary information!");
		}
		else{
			dp.setUser(user_id);	
			dp.setUserType(usertype);
			dp.delete();			
		}
	}

	public int isValid(){
		if( Strings.isBlank(user_id) || usertype<0){
			return 0;
		}
		return 1;
	}
	
	public void getPatientNames(DeleteManager dp){
		dp.getAllPatient();
	}
}