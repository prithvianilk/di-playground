package com.prithvianilk.guice;

import com.google.inject.AbstractModule;
import com.prithvianilk.logger.Logger;
import com.prithvianilk.logger.NoOpLogger;
import com.prithvianilk.logger.StdoutLogger;

public class LoggerModule extends AbstractModule {
    private boolean doNothing;

    public LoggerModule(boolean doNothing) {
        this.doNothing = doNothing;
    }

    @Override
    protected void configure() {
        if (doNothing) {
            bind(Logger.class).to(NoOpLogger.class);
        } else {
            bind(Logger.class).to(StdoutLogger.class);
        }
    }
}
