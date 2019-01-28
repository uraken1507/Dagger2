package com.example.nguyenthanhnam.dagger2retrofit.Components;
import com.example.nguyenthanhnam.dagger2retrofit.scopes.ActivityScope;
import com.example.nguyenthanhnam.dagger2retrofit.DetailActivity;
import dagger.Component;

@Component(dependencies = ApplicationComponent.class)
@ActivityScope
public interface DetailActivityComponent {
    void inject(DetailActivity detailActivity);
}
