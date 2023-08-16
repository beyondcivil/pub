package com.beyondcivil.pub.helidon20;

import io.helidon.nima.webserver.WebServer;

import java.time.LocalDateTime;

public record ServiceContext(WebServer webServer, LocalDateTime created) {

    public ServiceContext(WebServer webServer) {
        this(webServer, LocalDateTime.now());
    }
}
