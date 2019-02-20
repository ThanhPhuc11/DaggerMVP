package com.example.daggermvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.daggermvp.R;
import com.example.daggermvp.adapter.MyAdapter;
import com.example.daggermvp.di.component.DaggerMyComponent;
import com.example.daggermvp.di.module.MyModule;
import com.example.daggermvp.presenter.IMainPresenter;



import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IMainActivity {
    private RecyclerView rv;
    private EditText edtName;
    private EditText edtAge;
    private MyAdapter adapter;
    @Inject
    public IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        DaggerMyComponent.builder().myModule(new MyModule(this)).build().injectPresenter(this);
        initData();
    }

    private void initData() {
        adapter = new MyAdapter(presenter.getmList(), this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }

    private void initView() {
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        rv = findViewById(R.id.rv);
    }

    public void add(View view) {
        String name = edtName.getText().toString();
        int age = Integer.parseInt(edtAge.getText().toString());
        presenter.add(name, age);
    }

    @Override
    public void onSuccess() {
        adapter.notifyDataSetChanged();
    }
}
