package sample.com.imagesearch.service;

import io.reactivex.Maybe;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepoService {

    @GET("/services/rest/")
    Maybe<Photos> getSearch(@Query("method") String method,
                            @Query("api_key") String API_KEY,
                            @Query("format") String format,
                            @Query("nojsoncallback") String set,
                            @Query("safe_search") String safeSearch,
                            @Query("text") String searchText);
}
