package tz.go.moh.him.mediator.core.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openhim.mediator.engine.messages.AddOrchestrationToCoreResponse;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPResponse;
import scala.concurrent.duration.Duration;

import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class ActorUtilsTest {
    private static ActorSystem system;
    private final String orchestrationName = "unit-test-orchestration";


    @BeforeClass
    public static void before() {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void teardown() {
        JavaTestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void addOrchestrationResponse() {
        Assert.assertNotNull(orchestrationName);

        new JavaTestKit(system) {{
            ActorRef actor = system.actorOf(Props.create(TestActor.class));


            MediatorHTTPRequest request = buildTestRequest(actor);
            MediatorHTTPResponse response = buildTestResponse();
            ActorUtils.addOrchestrationResponse(orchestrationName, request, response, getRef(), actor);


            AddOrchestrationToCoreResponse result = expectMsgClass(Duration.create(60, TimeUnit.SECONDS), AddOrchestrationToCoreResponse.class);
            Assert.assertEquals(orchestrationName, result.getOrchestration().getName());
            Assert.assertEquals(request.getBody(), result.getOrchestration().getRequest().getBody());
            Assert.assertEquals(request.getHeaders(), result.getOrchestration().getRequest().getHeaders());
            Assert.assertEquals(request.getHost(), result.getOrchestration().getRequest().getHost());
            Assert.assertEquals(request.getMethod(), result.getOrchestration().getRequest().getMethod());
            Assert.assertEquals(request.getPath(), result.getOrchestration().getRequest().getPath());

            Assert.assertEquals(response.getBody(), result.getOrchestration().getResponse().getBody());
            Assert.assertEquals(response.getStatusCode(), result.getOrchestration().getResponse().getStatus());
            Assert.assertEquals(response.getHeaders(), result.getOrchestration().getResponse().getHeaders());
        }};
    }

    private MediatorHTTPRequest buildTestRequest(ActorRef ref) {
        return new MediatorHTTPRequest(
                ref, ref, "unit-test", "POST", "http", null, null, "/test_path", "body", Collections.<String, String>emptyMap(), null
        );
    }

    private MediatorHTTPResponse buildTestResponse() {
        return new MediatorHTTPResponse("unit-test", 200, Collections.<String, String>emptyMap()
        );
    }
}