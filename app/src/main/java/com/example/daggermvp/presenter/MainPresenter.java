package com.example.daggermvp.presenter;

import com.example.daggermvp.interactor.IMainInteractor;
import com.example.daggermvp.model.Person;
import com.example.daggermvp.view.IMainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements IMainPresenter, CallbackPresenter {
    private IMainActivity iMainActivity;
    private IMainInteractor interactor;
    private List<Person> mList;

    @Inject
    public MainPresenter(IMainInteractor interactor, List<Person> list) {
        this.interactor = interactor;
        this.mList = list;
        interactor.onAttach(this);
    }

    public List<Person> getmList() {
        return mList;
    }

    @Override
    public void onAttach(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
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
