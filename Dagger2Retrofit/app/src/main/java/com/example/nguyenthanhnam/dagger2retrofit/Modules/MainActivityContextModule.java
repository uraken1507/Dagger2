package com.example.nguyenthanhnam.dagger2retrofit.Modules;
import android.content.Context;

import com.example.nguyenthanhnam.dagger2retrofit.qualifiers.ActivityContext;
import com.example.nguyenthanhnam.dagger2retrofit.scopes.ActivityScope;
import com.example.nguyenthanhnam.dagger2retrofit.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}
