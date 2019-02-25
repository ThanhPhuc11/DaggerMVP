package com.example.daggermvp.interactor;

import com.example.daggermvp.presenter.CallbackPresenter;
import com.example.daggermvp.presenter.IMainPresenter;

public interface IMainInteractor {
    void onAttach(CallbackPresenter callbackPresenter);
    void add(String name, int age);
}
