package com.example.daggermvp.presenter;

import com.example.daggermvp.model.Person;
import com.example.daggermvp.view.IMainActivity;

import java.util.List;

public interface IMainPresenter {
    void onAttach(IMainActivity iMainActivity);
    void add(String name, int age);

    List<Person> getmList();
}
