package test;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import test.agentcom.FirstAgent;
import test.agentcom.SecondAgent;

public class MainContainerStarter {
	/** 
	*/
	private static final long serialVersionUID = 1L;

public static void main(String[] args) {

		/**
		 * Start main container and instantiate the first agent inside it
		 */
		Properties pp = new Properties();
	    pp.setProperty(Profile.GUI, Boolean.TRUE.toString());
	    Profile p = new ProfileImpl(pp);
	    AgentContainer ac = jade.core.Runtime.instance().createMainContainer(p);
	    try {
	        ac.acceptNewAgent("firstagent", new FirstAgent()).start();
	    } catch (StaleProxyException e) {
	        throw new Error(e);
	    }

	    
	    
	    
	





}
}