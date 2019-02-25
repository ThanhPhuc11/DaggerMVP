package com.example.daggermvp.interactor;

import com.example.daggermvp.model.Person;
import com.example.daggermvp.presenter.CallbackPresenter;
import com.example.daggermvp.presenter.IMainPresenter;

import javax.inject.Inject;

public class MainInteractor implements IMainInteractor {
    private CallbackPresenter callbackPresenter;
    @Inject
    public MainInteractor() {
    }


    @Override
    public void onAttach(CallbackPresenter callbackPresenter) {
        this.callbackPresenter= callbackPresenter;
    }

    @Override
    public void add(String name, int age) {
        Person p = new Person(name, age);
        callbackPresenter.getList().add(p);
        callbackPresenter.onSuccess();

//        callbackPresenter.getList().add(p);
//        callbackPresenter.onSuccess();

    }
}
