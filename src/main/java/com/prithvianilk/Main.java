package com.prithvianilk;

import com.prithvianilk.avaje.AvajeExclaimerGetter;
import com.prithvianilk.dagger.DaggerExclaimerGetter;
import com.prithvianilk.guice.GuiceInstanceGetter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Config config = parseArgs(args);
            Exclaimer exclaimer = getExclaimer(config);
            exclaimer.exclaim("Hello", "World");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Config parseArgs(String[] args) {
        boolean doNothing = Arrays.asList(args).contains("doNothing");

        DiType diType = Arrays.stream(args)
                .map(Main::toDiType)
                .findFirst()
                .orElseThrow();

        return new Config(doNothing, diType);
    }

    private static DiType toDiType(String argumentValue) {
        try {
            return DiType.valueOf(argumentValue);
        } catch (Exception e) {
            throw new RuntimeException("No valid DiType: " + argumentValue);
        }
    }

    private static Exclaimer getExclaimer(Config config) {
        return switch (config.diType()) {
            case GUICE -> new GuiceInstanceGetter(config.doNothing()).getInjector().getInstance(Exclaimer.class);
            case DAGGER_2 -> new DaggerExclaimerGetter(config.doNothing()).getExclaimer();
            case AVAJE -> new AvajeExclaimerGetter(config.doNothing()).getBeanScope().get(Exclaimer.class);
        };
    }
}