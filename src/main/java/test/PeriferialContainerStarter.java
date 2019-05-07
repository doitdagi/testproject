package test;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import test.agentcom.SecondAgent;

public class PeriferialContainerStarter {

	public static void main(String[] args) {
		try {

			/**
			 * Start the second container and incited the agent inside it
			 */
			Profile pf = new ProfileImpl();
			pf.setParameter(Profile.MAIN_HOST, "172.17.0.1");
			pf.setParameter(Profile.MAIN_PORT, "1099");
			AgentContainer ac1 = jade.core.Runtime.instance().createAgentContainer(pf);
			ac1.acceptNewAgent("secondagent", new SecondAgent()).start();
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
