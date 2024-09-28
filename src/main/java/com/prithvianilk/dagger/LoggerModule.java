package com.prithvianilk.dagger;

import com.prithvianilk.logger.Logger;
import com.prithvianilk.logger.NoOpLogger;
import com.prithvianilk.logger.StdoutLogger;
import dagger.Module;
import dagger.Provides;

@Module
public class LoggerModule {
    private final boolean doNothing;

    public LoggerModule(boolean doNothing) {
        this.doNothing = doNothing;
    }

    @Provides
    public Logger provideLogger() {
        if (doNothing) {
            return new NoOpLogger();
        } else {
            return new StdoutLogger();
        }
    }
}
