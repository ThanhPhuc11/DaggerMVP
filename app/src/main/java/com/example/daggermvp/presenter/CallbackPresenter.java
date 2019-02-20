package com.example.daggermvp.presenter;

import com.example.daggermvp.model.Person;

import java.util.List;

public interface CallbackPresenter {
    List<Person> getList();
    void onSuccess();
}
