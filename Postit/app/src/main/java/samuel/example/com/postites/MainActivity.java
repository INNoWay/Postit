package samuel.example.com.postites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtListarPostite(View view) {
        Intent intent = new Intent(this, ListarPostiteActivity.class);

        startActivity(intent);
    }

    public void onClickBtCriarPostite(View view) {
        Intent intent = new Intent(this, CriarPostiteActivity.class);

        startActivity(intent);
    }
}
