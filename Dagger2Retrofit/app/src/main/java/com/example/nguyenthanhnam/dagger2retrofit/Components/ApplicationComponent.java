package com.example.nguyenthanhnam.dagger2retrofit.Components;
import android.content.Context;

import com.example.nguyenthanhnam.dagger2retrofit.MyApplication;
import com.example.nguyenthanhnam.dagger2retrofit.Modules.ContextModule;
import com.example.nguyenthanhnam.dagger2retrofit.Modules.RetrofitModule;
import com.example.nguyenthanhnam.dagger2retrofit.qualifiers.ApplicationContext;
import com.example.nguyenthanhnam.dagger2retrofit.scopes.ApplicationScope;
import com.example.nguyenthanhnam.dagger2retrofit.retrofit.APIInterface;

import dagger.Component;
@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface  ApplicationComponent {
    public APIInterface getApiInterface();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication) ;
}

