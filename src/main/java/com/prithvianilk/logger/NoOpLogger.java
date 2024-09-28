package com.prithvianilk.logger;

public class NoOpLogger implements Logger {
    @Override
    public void log(String format, Object... args) {
    }
}
