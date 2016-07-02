package com.serrodcal.akkaProofOfConcept.messages;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by serrodcal on 2/7/16.
 */
public class ValueMessageTest {

    @Test
    public void testImmutableMessage(){
        ValueMessage valueMessage = ImmutableValueMessage.builder()
                .value(new Integer(0))
                .build();
        assertEquals(valueMessage.value(), new Integer(0));
    }


}
