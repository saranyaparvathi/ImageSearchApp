package sample.com.imagesearch.service;

import io.reactivex.Maybe;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepoService {

    @GET("/services/rest/")
    Maybe<Photos> getSearch(@Query("method") String method,
                            @Query("api_key") String API_KEY,
                            @Query("extras") String EXTRA_SMALL_URL,
                            @Query("format") String format,
                            @Query("nojsoncallback") String set,
                            @Query("safe_search") int safeSearch,
                            @Query("text") String searchText);
}
