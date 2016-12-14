package samuel.example.com.postites;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import samuel.example.com.postites.domain.Postite;
import samuel.example.com.postites.domain.PostiteService;

/**
 * Created by Gomes on 30/11/2016.
 */
public class ListarPostiteActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Postite> postites;
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_postite);

        //RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);

        taskPostite();
    }

    private void taskPostite(){
        new PostiteTask(this, mRecyclerView).execute();
    }

    private void listPostite(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.30.221:8090/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostiteService service = retrofit.create(PostiteService.class);

        Call<List<Postite>> call = service.listPostite();

        call.enqueue(new Callback<List<Postite>>() {
            @Override
            public void onResponse(Call<List<Postite>> call, Response<List<Postite>> response) {
                List<Postite> list = response.body();

                mRecyclerView.setAdapter(new PostiteAdapter(context, list));
            }

            @Override
            public void onFailure(Call<List<Postite>> call, Throwable t) {

            }
        });
    }
}