package com.example.nguyenthanhnam.dagger2retrofit;
import android.app.Activity;
import android.app.Application;

import com.example.nguyenthanhnam.dagger2retrofit.Components.ApplicationComponent;
import com.example.nguyenthanhnam.dagger2retrofit.Components.DaggerApplicationComponent;
import com.example.nguyenthanhnam.dagger2retrofit.Modules.ContextModule;
public class MyApplication extends Application{
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);

    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
