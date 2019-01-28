package com.example.nguyenthanhnam.dagger2retrofit.Components;
import android.content.Context;

import com.example.nguyenthanhnam.dagger2retrofit.Modules.AdapterModule;
import com.example.nguyenthanhnam.dagger2retrofit.qualifiers.ActivityContext;
import com.example.nguyenthanhnam.dagger2retrofit.scopes.ActivityScope;
import com.example.nguyenthanhnam.dagger2retrofit.MainActivity;

import dagger.Component;


@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    @ActivityContext
    Context getContext() ;


    void injectMainActivity(MainActivity mainActivity);
}
