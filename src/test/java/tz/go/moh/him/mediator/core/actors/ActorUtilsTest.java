package tz.go.moh.him.mediator.core.actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openhim.mediator.engine.messages.AddOrchestrationToCoreResponse;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPResponse;
import scala.concurrent.duration.Duration;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ActorUtilsTest {
    private static ActorSystem system;


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
        new JavaTestKit(system) {{
            ActorRef actor = system.actorOf(Props.create(TestActor.class));
            String orchestrationName = "unit-test-orchestration";


            MediatorHTTPRequest request = buildTestRequest(actor);
            MediatorHTTPResponse response = buildTestResponse();
            ActorUtils.addOrchestrationResponse(orchestrationName, request, response, getRef(), actor);


            AddOrchestrationToCoreResponse result = expectMsgClass(Duration.create(60, TimeUnit.SECONDS), AddOrchestrationToCoreResponse.class);
            assertEquals(orchestrationName, result.getOrchestration().getName());
            assertEquals(request.getBody(), result.getOrchestration().getRequest().getBody());
            assertEquals(request.getHeaders(), result.getOrchestration().getRequest().getHeaders());
            assertEquals(request.getHost(), result.getOrchestration().getRequest().getHost());
            assertEquals(request.getMethod(), result.getOrchestration().getRequest().getMethod());
            assertEquals(request.getPath(), result.getOrchestration().getRequest().getPath());

            assertEquals(response.getBody(), result.getOrchestration().getResponse().getBody());
            assertEquals(response.getStatusCode(), result.getOrchestration().getResponse().getStatus());
            assertEquals(response.getHeaders(), result.getOrchestration().getResponse().getHeaders());
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