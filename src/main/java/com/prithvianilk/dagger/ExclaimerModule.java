package com.prithvianilk.dagger;

import com.prithvianilk.Exclaimer;
import com.prithvianilk.LoggingExclaimer;
import com.prithvianilk.logger.Logger;
import dagger.Module;
import dagger.Provides;

@Module
public class ExclaimerModule {
    @Provides
    public Exclaimer getExclaimer(Logger logger) {
        return new LoggingExclaimer(logger);
    }
}
