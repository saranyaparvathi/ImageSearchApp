package sample.com.imagesearch.module;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ApplicationModule.class, MainAndroidViewModule.class})
public interface ApplicationComponent extends AndroidInjector<BaseApplication>{

    void inject(BaseApplication baseApplication);
}
