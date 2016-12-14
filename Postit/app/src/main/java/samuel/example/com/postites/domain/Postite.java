package samuel.example.com.postites.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Gomes on 30/11/2016.
 */
public class Postite {

    @SerializedName("nome")
    private String nome;

    @SerializedName("assunto")
    private String assunto;

    @SerializedName("descricao")
    private String descricao;

    @SerializedName("severidade")
    private String severidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSeveridade() { return severidade; }

    public void setSeveridade(String severidade) { this.severidade = severidade; }

}
