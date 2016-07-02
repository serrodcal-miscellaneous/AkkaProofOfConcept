package com.serrodcal.akkaProofOfConcept.actors;

import akka.actor.UntypedActor;
import com.serrodcal.akkaProofOfConcept.messages.ValueMessage;

/**
 * Created by serrodcal on 2/7/16.
 */
public class CounterActor extends UntypedActor {

    private int count = 0;

    public void onReceive(Object message) throws Exception {
        if(message instanceof ValueMessage){
            int valueFromMessage = ((ValueMessage) message).value();
            this.count += valueFromMessage;
            System.out.println("Recived message with value: " + String.valueOf(valueFromMessage) +
                    ", and counter value is: " + String.valueOf(this.count));
        }else{
            unhandled(message);
        }
    }

}
