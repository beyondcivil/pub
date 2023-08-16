package com.beyondcivil.pub.helidon20.handler;

import com.google.common.base.Stopwatch;
import io.helidon.nima.webserver.http.ServerRequest;
import io.helidon.nima.webserver.http.ServerResponse;

public class GreetingHandler {


    public static void getWellDone(ServerRequest request, ServerResponse response) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        response.send("Well done!");
    }
}
