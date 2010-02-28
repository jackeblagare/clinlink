package clinlink.appointment;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;


public class DoctorController extends GenericForwardComposer{
	static final long serialVersionUID = 1L;
	public DoctorController(){
		
	}
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public void getDoctorNames(DoctorManager dm){
		dm.getAllDoctors();
	}
	
	public void getDoctorNames(DoctorManager dm, int pid){
		dm.getAllDoctors(pid);
	}
	
	public static String getDoctorName(DoctorManager dm, int d_id){
		return dm.getName(d_id);
	}
}