package com.serrodcal.akkaProofOfConcept.messages;

import org.immutables.value.Value;

/**
 * Created by serrodcal on 2/7/16.
 */
@Value.Immutable
public interface ValueMessage {

    Integer value();

}
