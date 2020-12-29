/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package tz.go.moh.him.mediator.core.actors;

import akka.actor.UntypedActor;

/**
 * Test actor class used for tests
 */
public class TestActor extends UntypedActor {

    public TestActor() {
    }

    @Override
    public void onReceive(Object msg) throws Exception {
        //Empty body because it is not required for the test.
    }
}
