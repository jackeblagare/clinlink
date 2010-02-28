package clinlink.appointment;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;

public class PatientController extends GenericForwardComposer{
	static final long serialVersionUID = 1L;
	public PatientController(){
		
	}
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	/*public void getDoctorNames(DoctorManager dm){
		dm.getAllDoctors();
	}*/
	
	public static void getPatientNames(PatientManager pm){
		pm.getAllPatients();
	}
	
	public static String getPatientName(PatientManager pm, int p_id){
		return pm.getName(p_id);
	}
}