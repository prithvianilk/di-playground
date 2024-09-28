package com.prithvianilk.guice;

import com.google.inject.AbstractModule;
import com.prithvianilk.Exclaimer;
import com.prithvianilk.LoggingExclaimer;

public class ExclaimerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Exclaimer.class).to(LoggingExclaimer.class);
    }
}
