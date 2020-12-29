/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package tz.go.moh.him.mediator.core.actors;

import akka.actor.UntypedActor;
import org.openhim.mediator.engine.MediatorConfig;

/**
 * Parses XDS.b Provide and Register Document Set transactions.
 * <br/><br/>
 * Messages supported:
 * <ul>
 *     <li>SimpleMediatorRequest<String> - responds with SimpleMediatorResponse<ProvideAndRegisterDocumentSetRequestType></li>
 * </ul>
 */
public class TestActor extends UntypedActor {

    private MediatorConfig config;

    public TestActor() {
    }

    public TestActor(MediatorConfig config) {
        this.config = config;
    }


    @Override
    public void onReceive(Object msg) throws Exception {

    }
}
