package com.example.nguyenthanhnam.dagger2retrofit.Modules;
import android.content.Context;
import com.example.nguyenthanhnam.dagger2retrofit.qualifiers.ApplicationContext;
import com.example.nguyenthanhnam.dagger2retrofit.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
