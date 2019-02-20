package com.example.daggermvp.di.module;

import android.content.Context;

import com.example.daggermvp.adapter.MyAdapter;
import com.example.daggermvp.interactor.IMainInteractor;
import com.example.daggermvp.interactor.MainInteractor;
import com.example.daggermvp.model.Person;
import com.example.daggermvp.presenter.CallbackPresenter;
import com.example.daggermvp.presenter.IMainPresenter;
import com.example.daggermvp.presenter.MainPresenter;
import com.example.daggermvp.view.IMainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    IMainActivity iMainActivity;
    CallbackPresenter iMainPresenter;

    public MyModule(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
    }

    public MyModule(CallbackPresenter iMainPresenter) {
        this.iMainPresenter = iMainPresenter;
    }

    @Provides
    @Singleton
    IMainPresenter providePresenter() {
        return new MainPresenter(iMainActivity);
    }

    @Provides
    @Singleton
    IMainInteractor provideInteractor() {
        return new MainInteractor(iMainPresenter);
    }

    @Provides
    @Singleton
    List<Person> provideList() {
        return new ArrayList<Person>();
    }

}
