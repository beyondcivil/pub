/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.beyondcivil.pub.helidon4M1jdk20;

import com.beyondcivil.pub.helidon4M1jdk20.handler.GreetingHandler;
import com.beyondcivil.pub.helidon4M1jdk20.injector.MainModule;
import com.google.common.base.Stopwatch;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.helidon.nima.webserver.WebServer;
import io.helidon.nima.webserver.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceMain {

    private final static Logger logger = LoggerFactory.getLogger(ServiceMain.class);

    public static void main(String[] args) {

        WebServer webServer = WebServer.builder()
                .routing(ServiceMain::routing)
                .port(9710)
                .build();

        ServiceContext serviceContext = new ServiceContext(webServer);
        Injector injector = Guice.createInjector(new MainModule(serviceContext));

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                webServer.stop();
            }
        } );

        webServer.start();
    }

    static void routing(HttpRouting.Builder rules) {
        rules.addFilter(new Filter() {
            @Override
            public void filter(FilterChain chain, RoutingRequest req, RoutingResponse res) {
                Stopwatch stopwatch = Stopwatch.createStarted();
                try {
                    chain.proceed();
                } finally {
                    stopwatch.stop();
                    logger.info("{} serviced in {} ms by thread {}.", req.path(), stopwatch.elapsed().toMillis(), Thread.currentThread());
                }
            }
        }).get("/greeting", GreetingHandler::getWellDone);
    }
 }