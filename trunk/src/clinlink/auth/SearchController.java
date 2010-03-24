package clinlink.auth;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;


import clinlink.auth.User2;

public class SearchController extends GenericForwardComposer{
        
		public Object[][] pat_id;
		private static final long serialVersionUID = 1L;
		public String user;
		public int userid;
        public int page = 0;
        
        
        
        public void doAfterCompose(Component comp) throws Exception {
                super.doAfterCompose(comp);
        }
        

        public Object[][] doSearchMed(int userid)
        {
            User2 u= new User2();
            this.userid=userid; 
            u.setUserid(userid);
            pat_id = u.searchMed();
            return pat_id;
        }
        public Object[][] doSearch(String user){
        		
                User2 u= new User2();
                this.user=user; 
                u.setUser(user);
                pat_id = u.search();
                return pat_id;
        }
}
