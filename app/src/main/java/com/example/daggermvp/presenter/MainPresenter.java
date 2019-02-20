package com.example.daggermvp.presenter;

import com.example.daggermvp.di.component.DaggerMyComponent;
import com.example.daggermvp.di.module.MyModule;
import com.example.daggermvp.interactor.IMainInteractor;
import com.example.daggermvp.interactor.MainInteractor;
import com.example.daggermvp.model.Person;
import com.example.daggermvp.view.IMainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements IMainPresenter, CallbackPresenter {
    private IMainActivity iMainActivity;

    @Inject
    public IMainInteractor interactor;

    @Inject
    public List<Person> mList;

    public MainPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        DaggerMyComponent.builder().myModule(new MyModule(this)).build().injectInteractor(this);
    }

    public List<Person> getmList() {
        return mList;
    }

    @Override
    public void add(String name, int age) {
        interactor.add(name, age);
    }

    @Override
    public void onSuccess() {
        iMainActivity.onSuccess();
    }

    @Override
    public List<Person> getList() {
        return mList;
    }
}
