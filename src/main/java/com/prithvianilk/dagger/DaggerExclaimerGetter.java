package com.prithvianilk.dagger;

import com.prithvianilk.Exclaimer;

public class DaggerExclaimerGetter {
    private final boolean doNothing;

    public DaggerExclaimerGetter(boolean doNothing) {
        this.doNothing = doNothing;
    }

    public Exclaimer getExclaimer() {
        ExclaimerComponent component = DaggerExclaimerComponent
                .builder()
                .loggerModule(new LoggerModule(doNothing))
                .build();

        return component.getExclaimer();
    }
}
