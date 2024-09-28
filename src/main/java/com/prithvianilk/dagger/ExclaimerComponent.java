package com.prithvianilk.dagger;

import com.prithvianilk.Exclaimer;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {LoggerModule.class, ExclaimerModule.class})
public interface ExclaimerComponent {
    Exclaimer getExclaimer();
}
