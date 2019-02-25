package com.example.daggermvp.di.component;

import com.example.daggermvp.di.module.MyModule;
import com.example.daggermvp.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {
    void injectPresenter(MainActivity mainActivity);
}
