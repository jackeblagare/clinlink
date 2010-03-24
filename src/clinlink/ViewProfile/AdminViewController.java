package clinlink.ViewProfile;


import org.zkoss.zk.ui.Executions;

public class AdminViewController {

	
	public void redirect()
	{
		Executions.sendRedirect("searchmed.zul");
	}
}
