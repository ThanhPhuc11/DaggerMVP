package com.example.daggermvp.interactor;

import com.example.daggermvp.model.Person;
import com.example.daggermvp.presenter.CallbackPresenter;

public class MainInteractor implements IMainInteractor {
    private CallbackPresenter presenter;

    public MainInteractor(CallbackPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void add(String name, int age) {
        Person p = new Person(name, age);
        presenter.getList().add(p);
        presenter.onSuccess();

    }
}
