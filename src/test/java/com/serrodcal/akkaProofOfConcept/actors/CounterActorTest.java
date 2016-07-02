package com.serrodcal.akkaProofOfConcept.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import com.serrodcal.akkaProofOfConcept.messages.ValueMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.concurrent.duration.Duration;

/**
 * Created by serrodcal on 2/7/16.
 */
public class CounterActorTest {

    private static ActorSystem actorSystem;

    @Before
    public void setUp(){
        this.actorSystem = ActorSystem.create("CounterSystem");
    }

    @Test
    public void CounterActorTest(){
        final ActorRef actorRef = this.actorSystem.actorOf(Props.create(CounterActor.class));

        ValueMessage valueMessage1 = ImmutableValueMessage.builder()
                .value(new Integer(7))
                .build();

        ValueMessage valueMessage2 = ImmutableValueMessage.builder()
                .value(new Integer(3))
                .build();

        ValueMessage valueMessage3 = ImmutableValueMessage.builder()
                .value(new Integer(0))
                .build();

        ValueMessage valueMessage4 = ImmutableValueMessage.builder()
                .value(new Integer(-3))
                .build();

        actorRef.tell(valueMessage1, actorRef);
        actorRef.tell(valueMessage2, actorRef);
        actorRef.tell(valueMessage3, actorRef);
        actorRef.tell(valueMessage4, actorRef);

    }

    @After
    public void teardown() {
        JavaTestKit.shutdownActorSystem(actorSystem);
        this.actorSystem = null;
    }

}
