package samuel.example.com.postites;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import samuel.example.com.postites.domain.Postite;
import samuel.example.com.postites.domain.PostiteService;

/**
 * Created by Gomes on 30/11/2016.
 */
public class PostiteTask extends AsyncTask<Void, Void, List<Postite>> {
    private final RecyclerView recyclerView;
    private final Context context;

    public PostiteTask(Context context, RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.context = context;
    }

    @Override
    protected List<Postite> doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.30.221:8090/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostiteService service = retrofit.create(PostiteService.class);
        Call<List<Postite>> call = service.listPostite();

        try {
            Response<List<Postite>> response = call.execute();
            List<Postite> list = response.body();
            for(Postite postite : list){
                Log.d("Saida", postite.getNome());
                Log.d("Saida", postite.getAssunto());
                Log.d("Saida", postite.getDescricao());
                Log.d("Saida", postite.getSeveridade());
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(List<Postite> postite) {

        if(postite != null){
            recyclerView.setAdapter(new PostiteAdapter(context, postite));
            Log.d("Saida", "" + postite.size());
        }
    }
}
