package com.prithvianilk.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceInstanceGetter {
    private final boolean doNothing;

    public GuiceInstanceGetter(boolean doNothing) {
        this.doNothing = doNothing;
    }

    public Injector getInjector() {
        return Guice.createInjector(new LoggerModule(doNothing), new ExclaimerModule());
    }
}
