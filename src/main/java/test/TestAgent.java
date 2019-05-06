package test;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class TestAgent extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void setup() {

	addBehaviour(new CyclicBehaviour() {
		
		@Override
		public void action() {
			System.out.println("Hello test java how the fuckin are you!");
		}
	});
	}
	
}
