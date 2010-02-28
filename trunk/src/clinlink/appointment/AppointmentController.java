package clinlink.appointment;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;


public class AppointmentController extends GenericForwardComposer{
	static final long serialVersionUID = 1L;
	
	public AppointmentController(){
		
	}
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public void getScheduledAppointment(Appointment app, ConsultationHour ch, int doc){
		ch.getSchedule(doc);
		app.getAppointment(doc);
		//displayAppointment();
	}
	
	public boolean makeAppointment(Appointment app, String patname, int p_id, int d_id, String date, String time, String reason){
		return app.setAppointment(patname, p_id, d_id, date, time, reason);
	}
}