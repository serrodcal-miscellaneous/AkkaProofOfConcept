package com.serrodcal.akkaProofOfConcept.actors;

import akka.actor.UntypedActor;

/**
 * Created by serrodcal on 2/7/16.
 */
public class CounterActor extends UntypedActor {

    private int count = 0;

    public void onReceive(Object message) throws Exception {
        if(message instanceof CounterMessage){
            int valueFromMessage = ((CounterMessage) message).getValue();
            this.count += valueFromMessage;
            System.out.println("Mensaje recibido con valor " + String.valueOf(valueFromMessage) +
                    ", y contador con valor " + String.valueOf(this.count));
        }else{
            unhandled(message);
        }
    }

}
