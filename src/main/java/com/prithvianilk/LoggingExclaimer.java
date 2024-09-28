package com.prithvianilk;

import com.prithvianilk.logger.Logger;

import javax.inject.Inject;

public class LoggingExclaimer implements Exclaimer {
    Logger logger;

    @Inject
    public LoggingExclaimer(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void exclaim(String word1, String word2) {
        logger.log("%s %s!", word1, word2);
    }
}
