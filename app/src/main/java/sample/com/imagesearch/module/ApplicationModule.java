package sample.com.imagesearch.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import sample.com.imagesearch.service.PhotoProvider;
import sample.com.imagesearch.service.RepoService;

@Module
public class ApplicationModule {

    private Context application;
    private static final String BASE_URL = "https://api.flickr.com";

    public ApplicationModule(Context context) {
        this.application = context;
    }

    @Provides
    @ForApplication
    Context provideContext() {
        return application;
    }

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static RepoService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(RepoService.class);
    }

    @Singleton
    @Provides
    static PhotoProvider providePhotoProvider(RepoService repoService) {
        return new PhotoProvider(repoService);
    }
}
