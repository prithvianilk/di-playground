package com.prithvianilk.logger;

public class StdoutLogger implements Logger {
    @Override
    public void log(String format, Object... args) {
        System.out.printf(format, args);
    }
}
