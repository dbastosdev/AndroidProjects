package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a007_recyclerview.R;

import java.util.List;

import model.Filme;

//1- Declaração da classe do adapter extendendo de recyclerView e com uma inner classe que é o ViewHolder.
//3- Link do MyViewHolder no adpter
public class Adapter extends RecyclerView.Adapter <Adapter.MyViewHolder>{

    //(EXTRA)
    //Cria o objeto list do tipo filme
    private List<Filme> listaFilmes;

    //Cria um construtor que recebe como parâmetro uma lista
    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    //4- Três Métodos gerados automáticamente pelo Android
    @NonNull
    @Override
    //5- Chamado para criar as visualizações para o usuário.
    // Retorna os dados da inner Class MyViewHolder
    // Chamado somente até a quantidade inicial definida para visualização. Após isso, os itens serão apenas reciclados na tela.
    //a partir do onBindViewHolder.
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Convertendo View
        // Usa classe LayoutInflater converte o XML em visualização
        // Pega o contexto baseado no componente da itemLista está dentro. MainActivity.
        // Usa o método inflate para direcionar ao XML criado para o ListView
        //Usa o R do referente ao projeto, dentre aos vários R's disponíveis e seleciona o XML criado
        // parent e false como padrão.

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list, parent, false);

        //prossegue instanciando a classe:
        // Passa o itemLista que contém o XML convertido em View para o ViewHolder que configurar exibição
        return new MyViewHolder(itemLista);
    }

    @Override
    // 7- A partir do momento que a visualização foi criada, usa-se esse método exibir cada um dos elementos, apenas trocando os dados de cada item.
    // Esse é efetivamente o responsável por exibir as views com os dados. Chama os dados do MyViewHolder
    // Para textos fixos, apenas utilizar o setText() com strings dentro.
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //(EXTRA) Configura o list para ser exibido pelo position
        Filme filme = listaFilmes.get(position);

        //(EXTRA) Faz a exibição de cada item filme da lista na tela
        //Busca os itens através dos métodos do objeto filme.
        holder.titulo.setText(filme.getTituloFilme());
        holder.ano.setText(filme.getAno());
        holder.genero.setText(filme.getGenero());


    }

    @Override
    // 8- Configura a quantidade de itens que deverão ser exibidos na tela. Para itens fixos, apenas colocar um número após return.
    public int getItemCount() {

        return listaFilmes.size();
    }

    //2- Inner class View Holder
    class MyViewHolder extends RecyclerView.ViewHolder {

        //Atributos de classe (guardam os elementos do que será exibido na tela. Nesse exemplo, dados de filmes.
        // Título, ano e gênero

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //6- Localiza e configura os componentes de tela a partir dos id's:
            // conforme declaração feita em 2.
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);

        }
    }

}
