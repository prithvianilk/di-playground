package com.prithvianilk;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.prithvianilk.guice.ExclaimerModule;
import com.prithvianilk.guice.LoggerModule;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        boolean doNothing = parseArgs(args);
        LoggingExclaimer exclaimer = getExclaimer(doNothing);
        exclaimer.exclaim("Hello", "World");
    }

    private static boolean parseArgs(String[] args) {
        return args.length > 0 && Objects.equals(args[0], "doNothing");
    }

    private static LoggingExclaimer getExclaimer(boolean doNothing) {
        Injector injector = Guice.createInjector(new LoggerModule(doNothing), new ExclaimerModule());
        return injector.getInstance(LoggingExclaimer.class);
    }
}