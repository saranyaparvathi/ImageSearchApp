package sample.com.imagesearch.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import sample.com.imagesearch.MainActivity;

@Module
public abstract class MainAndroidViewModule {

    @ContributesAndroidInjector
    abstract MainActivity provideMainActivity();
}
