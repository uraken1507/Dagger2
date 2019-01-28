package com.example.nguyenthanhnam.dagger2retrofit.Modules;
import com.example.nguyenthanhnam.dagger2retrofit.adapter.RecyclerViewAdapter;
import com.example.nguyenthanhnam.dagger2retrofit.scopes.ActivityScope;
import com.example.nguyenthanhnam.dagger2retrofit.MainActivity;

import dagger.Module;
import dagger.Provides;
@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {
    @Provides
    @ActivityScope
    public RecyclerViewAdapter getStarWarsPeopleLIst(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter((RecyclerViewAdapter.ViewHolder.ClickListener) clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }

}
