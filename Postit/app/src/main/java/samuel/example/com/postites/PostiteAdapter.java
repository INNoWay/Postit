package samuel.example.com.postites;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import samuel.example.com.postites.domain.Postite;

/**
 * Created by Gomes on 30/11/2016.
 */
public class PostiteAdapter extends RecyclerView.Adapter<PostiteAdapter.PostiteViewHolder> {
    private final List<Postite> postites;
    private final Context context;

    public PostiteAdapter(Context context, List<Postite> postites) {
        this.context = context;
        this.postites = postites;
    }

    @Override
    public PostiteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Cria uma subclasse de RecyclerView.ViewHolder
        //Infla a view
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_postite, parent, false);

        //Cria a subclasse do ViewHolder
        PostiteViewHolder holder = new PostiteViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(PostiteViewHolder holder, int position) {
        //Recebe o índice do elemento e atualiza as views dentro do holder
        Postite postite = postites.get(position);

        //Atualiza os valores nas views
        holder.tNomePostite.setText(postite.getNome());
        holder.tAssuntoPostite.setText(postite.getAssunto());
        holder.tDescricaoPostite.setText(postite.getDescricao());
        holder.tSeveridadePostite.setText(postite.getSeveridade());
    }

    @Override
    public int getItemCount() {
        return this.postites != null ? this.postites.size() : 0;
    }

    //Subclasse de RecyclerView.ViewHolder. Contém todas as views
    public static class PostiteViewHolder extends RecyclerView.ViewHolder {
        public TextView tNomePostite;
        public TextView tAssuntoPostite;
        public TextView tDescricaoPostite;
        public TextView tSeveridadePostite;
        private View view;

        public PostiteViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;

            tNomePostite = (TextView) itemView.findViewById(R.id.tNomePostite);
            tAssuntoPostite = (TextView) itemView.findViewById(R.id.tAssuntoPostite);
            tDescricaoPostite = (TextView) itemView.findViewById(R.id.tDescricaoPostite);
            tSeveridadePostite = (TextView) itemView.findViewById(R.id.tSeveridadePostite);
        }
    }
}
