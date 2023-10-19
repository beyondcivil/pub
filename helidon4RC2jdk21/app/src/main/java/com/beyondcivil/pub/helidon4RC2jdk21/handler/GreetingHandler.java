package com.beyondcivil.pub.helidon4RC2jdk21.handler;

import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;

public class GreetingHandler {


    public static void getWellDone(ServerRequest request, ServerResponse response) {
        response.send("Well done!");
    }
}
