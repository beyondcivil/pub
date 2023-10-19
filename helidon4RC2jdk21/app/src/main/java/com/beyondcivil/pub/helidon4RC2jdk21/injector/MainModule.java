package com.beyondcivil.pub.helidon4RC2jdk21.injector;


import com.beyondcivil.pub.helidon4RC2jdk21.ServiceContext;
import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

    private ServiceContext serviceContext;

    public MainModule(ServiceContext serviceContext) {
        this.serviceContext = serviceContext;
    }

    protected void configure() {
        bind(ServiceContext.class).toInstance(serviceContext);
    }
}
