package clinlink.auth;

import java.util.Date;
//import java.sql.*;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;

//import MedicalRecord.Medical_record;

//import MedicalRecord.Medical_record;
//import MedicalRecord.Patient;


import clinlink.auth.User2;

public class EditMedRecController extends GenericForwardComposer{
        
		public Object[][] pat_id;
		public Object[][] doc_id;
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
        
        
        public Object[][] doSearchDoctor(String user){
    		
            User2 u= new User2();
            this.user=user; 
            u.setUser(user);
            pat_id = u.searchDoctor();

        	return pat_id;
    }

        
        public MedicalRecord doSearchRecord(int userid){
        	MedicalRecord mr= new MedicalRecord();
        	mr=mr.getMedicalRecord(userid);
        	return mr;
        	}																												//classname1,date_admin1, date_rel1,time_adm1, discharge_time1, bday1 );
        public int doUpdateRecord(int record_id, int patient_id, int doctor_id, String height, String weight,String diagnosis,int age, String classname, Date date_admin, Date date_rel, String time_adm, String discharge_time, Date bday)
        	{
    		MedicalRecord mm= new MedicalRecord();
    		int status;
    		status=mm.updateMedicalRecord(record_id, patient_id, doctor_id, height, weight, diagnosis, age, classname, date_admin, date_rel, time_adm, discharge_time, bday);
    		return status;
    		}
        	
}
