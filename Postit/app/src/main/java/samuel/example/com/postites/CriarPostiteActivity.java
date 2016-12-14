package samuel.example.com.postites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
public class CriarPostiteActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_postite);
    }

    public void onClicBtSalvarPostite(View view) {
        Postite postite = new Postite();

        EditText eNome = (EditText) findViewById(R.id.eNome);
        String nome = eNome.getText().toString();

        EditText eAssunto = (EditText) findViewById(R.id.eAssunto);
        String assunto = eAssunto.getText().toString();

        EditText eSeveridade = (EditText) findViewById(R.id.eSeveridade);
        String severidade = eSeveridade.getText().toString();

        EditText eDescricao = (EditText) findViewById(R.id.eDescricao);
        String descricao = eDescricao.getText().toString();

        postite.setNome(nome);
        postite.setAssunto(assunto);
        postite.setDescricao(descricao);
        postite.setSeveridade(severidade);
        //Debug
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.30.221:8090/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        PostiteService service = retrofit.create(PostiteService.class);

        Call<Postite> call = service.createPostite(postite);

        call.enqueue(new Callback<Postite>() {
            @Override
            public void onResponse(Call<Postite> call, Response<Postite> response) {

            }

            @Override
            public void onFailure(Call<Postite> call, Throwable t) {

            }
        });

        finish();

    }

}
