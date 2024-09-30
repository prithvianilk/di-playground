package com.prithvianilk.avaje;

import io.avaje.inject.BeanScope;

public class AvajeExclaimerGetter {
    private final boolean doNothing;

    public AvajeExclaimerGetter(boolean doNothing) {
        this.doNothing = doNothing;
    }

    public BeanScope getBeanScope() {
        System.setProperty("doNothing", doNothing ? "true" : "false");
        return BeanScope.builder().build();
    }
}
