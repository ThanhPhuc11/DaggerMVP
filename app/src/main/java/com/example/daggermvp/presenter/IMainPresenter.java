package com.example.daggermvp.presenter;

import com.example.daggermvp.model.Person;

import java.util.List;

public interface IMainPresenter {
    void add(String name, int age);
    void onSuccess();
    List<Person> getmList();
}
