package clinlink.auth;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;


import clinlink.auth.User2;

public class ApproveController extends GenericForwardComposer{
        
		public Object[][] pat_id;
		private static final long serialVersionUID = 1L;

 
        
        public void doAfterCompose(Component comp) throws Exception {
                super.doAfterCompose(comp);
        }

        public Object[][] doApprove(){
        		
                User2 u= new User2();
                pat_id = u.approve();

                return pat_id;
        }
        
        public void doApproveAccount(String username){
    		
            User2 u= new User2();
            System.out.println("asa approve controller username = " + username);
            u.setUser(username);
            u.approveAccount();
    }
        
        public void doDenyAccount(String username){
    		
            User2 u= new User2();
            System.out.println("asa approve controller username = " + username);
            u.setUser(username);
            u.denyAccount();
    }
}
