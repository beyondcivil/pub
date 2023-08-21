package com.beyondcivil.pub.helidon20.handler;

import io.helidon.nima.webserver.http.ServerRequest;
import io.helidon.nima.webserver.http.ServerResponse;

public class GreetingHandler {


    public static void getWellDone(ServerRequest request, ServerResponse response) {
        response.send("Well done!");
    }
}
