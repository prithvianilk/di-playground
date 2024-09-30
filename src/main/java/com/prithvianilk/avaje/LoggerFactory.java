package com.prithvianilk.avaje;

import com.prithvianilk.logger.NoOpLogger;
import com.prithvianilk.logger.StdoutLogger;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.avaje.inject.RequiresProperty;

@Factory
public class LoggerFactory {
    @Bean
    @RequiresProperty(value = "doNothing", equalTo = "true")
    public NoOpLogger noOpLogger() {
        return new NoOpLogger();
    }

    @Bean
    @RequiresProperty(value = "doNothing", equalTo = "false")
    public StdoutLogger stdoutLogger() {
        return new StdoutLogger();
    }
}
