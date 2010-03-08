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
                System.out.println("before dapat 0 pat_id" + pat_id[0][0]);
                System.out.println("dianne labas!" + pat_id[1][0]);
            	int size=0;
            	/*for (int i=0; Integer.parseInt(pat_id[i][0].toString())!=-1; i++)
            	{
            		System.out.println("pumasok sa loop");
            		size++;
            	}*/
                System.out.println("hoi sa search controller size ay" + size);
                return pat_id;
        }
}
