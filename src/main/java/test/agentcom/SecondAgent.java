package test.agentcom;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class SecondAgent extends Agent {

	private AID firstAgent = new AID("firstagent", AID.ISLOCALNAME);

/* * 
	 */
	private static final long serialVersionUID = 1L;
	int counter =10;

	@Override
	protected void setup() {

	addBehaviour(new CyclicBehaviour() {
		
		@Override
		public void action() {
 
			MessageTemplate Mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
			ACLMessage msg = myAgent.receive();
			
			if(msg!=null) {
  			try {
				counter =  Integer.parseInt(msg.getContent());
 			    if(counter>0) {
 			 		System.out.println(getName()+"...."+counter);
						counter--;
						//send counter here
						Thread.sleep(1000);
					   ACLMessage msg_send = new ACLMessage(ACLMessage.INFORM);
					   msg_send.addReceiver(firstAgent);
					   msg_send.setContent(String.valueOf(counter));
					   myAgent.send(msg_send);
  					}else {
						block();
					}
					}
 		  catch (Exception e) {
				e.printStackTrace();
			}	
	}
		}
		});
	}
}
