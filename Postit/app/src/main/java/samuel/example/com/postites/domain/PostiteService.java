package samuel.example.com.postites.domain;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostiteService {
    @GET("postite/list")
    Call<List<Postite>> listPostite();

    @POST("postite/new")
    Call<Postite> createPostite(@Body Postite postite);
}
