package test;

import jade.core.Agent;
 import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.behaviours.CyclicBehaviour;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

public class HelloAgent extends Agent {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		  Properties pp = new Properties();
		    pp.setProperty(Profile.GUI, Boolean.TRUE.toString());
		    Profile p = new ProfileImpl(pp);
		    AgentContainer ac = jade.core.Runtime.instance().createMainContainer(p);
		    try {
		        ac.acceptNewAgent("Hello", new HelloAgent()).start();
		        ac.acceptNewAgent("Hi", new HelloAgent()).start();
		    } catch (StaleProxyException e) {
		        throw new Error(e);
		    }
	}
	
	@Override
	protected void setup() {
		addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {

				System.out.println("My name is:"+ getName());
				
			}
		});
	
	}
}
