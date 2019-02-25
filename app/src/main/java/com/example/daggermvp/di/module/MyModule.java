package com.example.daggermvp.di.module;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

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
    private Context mContext;

    public MyModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    IMainInteractor provideInteractor(MainInteractor mainInteractor) {
        return mainInteractor;
    }


    @Provides
    @Singleton
    IMainPresenter providePresenter(MainPresenter mainPresenter) {
        return mainPresenter;
    }

    @Provides
    @Singleton
    List<Person> provideList() {
        return new ArrayList<Person>();
    }

    @Provides
    @Singleton
    MyAdapter provideAdapter(IMainPresenter presenter) {
        return new MyAdapter(presenter.getmList());
    }

    @Provides
    @Singleton
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(mContext);
    }

}
