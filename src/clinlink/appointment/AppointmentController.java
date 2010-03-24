package clinlink.appointment;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;

public class AppointmentController extends GenericForwardComposer{
	static final long serialVersionUID = 1L;
	
	public AppointmentController(){
		
	}
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public void getScheduledAppointment(Appointment app, ConsultationHour ch, int doc, String sun, String sat){
		ch.getSchedule(doc);
		app.getAppointment(doc,sun,sat);
		//displayAppointment();
	}
	
	public int makeAppointment(Appointment app, String patname, int p_id, int d_id, String date, String time, String reason){
		return app.setAppointment(patname, p_id, d_id, date, time, reason);
	}
	
	public int cancelAppointment(Appointment app, int appID){
		return app.deleteAppointment(appID);
	}
	public boolean isValid(String patname, int selected, String d_id, String date, String time, String reason){
		if(selected != -1){
			if((patname!=null)&&(d_id!=null)&&(date!=null)&&(time!=null)&&(reason!=null)&&(patname!="")&&(d_id!="")&&(date!="")&&(time!="")){
				return true;
			}
		}else{
			if((patname!=null)&&(d_id!=null)&&(date!=null)&&(time!=null)&&(reason!=null)&&(d_id!="")&&(date!="")&&(time!="")&&(reason!="")){
				return true;
			}
		}
		return false;
	}
	
	public void getPatientAppointment(Appointment a, int doc, int pat){
		a.getPatApp(doc, pat);
	}
	
	public void redirect(){
		Executions.sendRedirect("appointmentView.zul");
	}
}