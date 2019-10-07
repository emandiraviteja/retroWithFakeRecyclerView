package oboulo.e.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecordsAdapter recordsAdapter;
    private RecyclerView recyclerView;
    Context context;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutManager = new LinearLayoutManager(this);

        final ApiClient apiClient = RetrofitInstance.getRetrofitInstance().create(ApiClient.class);

        Call<List<ModelDatum>> modelDatumCall = apiClient.getCall();

        Log.e("dsdsdsd", modelDatumCall.request().url() + "");

        modelDatumCall.enqueue(new Callback<List<ModelDatum>>() {
            @Override
            public void onResponse(Call<List<ModelDatum>> call, Response<List<ModelDatum>> response) {

                Log.e("data", new Gson().toJson(response.body()));

                generateLayout(response.body());
            }

            @Override
            public void onFailure(Call<List<ModelDatum>> call, Throwable t) {

            }
        });
    }

    private void generateLayout(List<ModelDatum> modelData){

        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);

        recyclerView.setLayoutManager(linearLayoutManager);

        recordsAdapter = new RecordsAdapter(modelData);

        recyclerView.setAdapter(recordsAdapter);
    }
}
