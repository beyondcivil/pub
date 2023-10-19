package com.beyondcivil.pub.helidon4RC2jdk21;

import io.helidon.webserver.WebServer;

import java.time.LocalDateTime;

public record ServiceContext(WebServer webServer, LocalDateTime created) {

    public ServiceContext(WebServer webServer) {
        this(webServer, LocalDateTime.now());
    }
}
