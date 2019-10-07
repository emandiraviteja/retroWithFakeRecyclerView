package oboulo.e.sample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    //https://jsonplaceholder.typicode.com/comments?postId=1

    @GET("comments?postId=1")
    Call<List<ModelDatum>> getCall();
}
