package tz.go.moh.him.mediator.core.actors;

import akka.actor.ActorRef;
import org.openhim.mediator.engine.CoreResponse;
import org.openhim.mediator.engine.messages.AddOrchestrationToCoreResponse;
import org.openhim.mediator.engine.messages.MediatorHTTPRequest;
import org.openhim.mediator.engine.messages.MediatorHTTPResponse;

public class ActorUtils {


    public static void addOrchestrationResponse(String orchestrationName, MediatorHTTPRequest request, MediatorHTTPResponse response, ActorRef requestHandler, ActorRef senderActor) {
        CoreResponse.Orchestration orchestration = new CoreResponse.Orchestration();
        orchestration.setName(orchestrationName);

        CoreResponse.Request coreRequest = new CoreResponse.Request();
        if (request != null)
            coreRequest = convertMediatorHTTPRequestToCoreRequest(request);

        orchestration.setRequest(coreRequest);

        CoreResponse.Response coreResponse = new CoreResponse.Response();
        if (response != null)
            coreResponse = convertMediatorHTTPResponseToCoreResponse(response);

        orchestration.setResponse(coreResponse);
        requestHandler.tell(new AddOrchestrationToCoreResponse(orchestration), senderActor);
    }

    public static CoreResponse.Request convertMediatorHTTPRequestToCoreRequest(MediatorHTTPRequest request) {
        CoreResponse.Request coreRequest = new CoreResponse.Request();

        coreRequest.setBody(request.getBody());
        coreRequest.setHeaders(request.getHeaders());
        coreRequest.setHost(request.getHost());
        coreRequest.setMethod(request.getMethod());
        coreRequest.setPath(request.getPath());
        coreRequest.setPort(String.valueOf(request.getPort()));

        return coreRequest;

    }

    public static CoreResponse.Response convertMediatorHTTPResponseToCoreResponse(MediatorHTTPResponse response) {
        CoreResponse.Response coreResponse = new CoreResponse.Response();

        coreResponse.setBody(response.getBody());
        coreResponse.setHeaders(response.getHeaders());
        coreResponse.setStatus(response.getStatusCode());

        return coreResponse;

    }
}
