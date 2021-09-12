/*
Tutorial Google
https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=pt-br

Etapas para implementar o RecyclerView
Se você quiser usar o RecyclerView, é necessário realizar algumas ações. Elas serão discutidas em detalhes nas seções a seguir.

Em primeiro lugar, decida como será a lista ou a grade. Em geral, você poderá usar um dos gerenciadores de layout padrão da biblioteca RecyclerView.

Crie a aparência e o comportamento de cada elemento da lista. Com base nisso, estenda a classe ViewHolder. A versão do ViewHolder fornece toda a funcionalidade para os
itens da lista. O fixador de visualização é um wrapper em torno de uma View, e essa visualização é gerenciada por RecyclerView.

Defina o Adapter que associa seus dados às visualizações ViewHolder.

Há também as opções avançadas de personalização, que permitem adaptar o RecyclerView de acordo com suas necessidades.


*/

package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.FileObserver;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.a007_recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import adapter.Adapter;

import model.Filme;

public class MainActivity extends AppCompatActivity {
    //Etapa 00: Inserir o componente RecyclerView no layout XNL.

    //Etapa 01: Declarar o atributo recyclerView
    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Recebe XML e o transforma em uma View

        //Etapa 02: Recuperar elemento de layout RecyclerView a partir do id do componente
        recyclerView = findViewById(R.id.recyclerView);

        //Etapa 03:Configurar Layout manager
        // Há várias opções de visualização do layoutManager. Configura e gerencia o modo de exibição.
        RecyclerView.LayoutManager layoutManagerCreated = new LinearLayoutManager(getApplicationContext());

        //Etapa 04: utiliza o layout configurado no atributo recyclerview declarado
        recyclerView.setLayoutManager(layoutManagerCreated);


        /* (EXTRA) - LISTAGEM DE FILMES:
        * Chama o método de criação de filmes definido após fechar as chaves do onCreate.
        * */
        this.criarFilmes();

        //Etapa 05: Cria um Adapter para o RecyclerView - Função de adaptar a visualização das informações no RecyclerView
        //São criados pacotes dentro de com.example.007_recyclerView para iniciar a separação e organização do código.
        //Um package para activities: Todas as Activities do projeto para dentro dessa pasta.
        //Um package para o Adapter: para inserir a classe que vai modelar o Adapter
        //Um package para o model: São inseridas as classes de modelos "entities"
        // Cria a classe adapter dentro do package e este extende o Recycerview.adapter

        /* Etapa 05.1: Configura um View Holder que será utilizado no adpater. Tem a função de renderizar apenas uma quantidade limitada de itens na tela.
        Guarda os itens a serem exibidos na tela em objetos antes de eles serem exibidos. Ligado ao método setHasFixed (abaixo). Com isso, renderizando somente
        a quantidade de elementos visíveis na tela. Cria o que o usuário consegue visualizar.
        É uma classe interna a classe do Adapter. Uma inner class */

        /* Etapa 05.2: Configura o layout XML que será exibido dentro do RecyclerView para o usuário
        * Esse layout é criado dentro de res > layout > New layout Resource file
        * Altera o layout de constraint para outro se for o caso - configuração de como serão exibidos os itens do RecyclerView
        * Edita o layout da forma desejada com os atributos que foram declarados na inner classe MyViewHolder
        * Configura os id's de cada campo do novo layout */

        /* Etapa 05.3: Configurar o método onCreateViewHolder na Classe Adapter
        *  - Converter o XML em um objeto do tipo View, como é feito na MaianActivity.
        *  - Instancia o MyViewHolder e passa como argumento a ele o XML convertido
        *  - Configura os Ids do do Layout XML na inner Classe MyViewHolder.
        * */

        /* Etapa 05.4: Configurar o método onBindViewHolder na Classe Adapter
         *  - Converter o XML em um objeto do tipo View, como é feito na MaianActivity.
         *  - Com a holder, chama os atributos do MyViewHolder e os configura para exibição na tela.
         * */

        /* Etapa 05.5: Configurar o método getItemCount na Classe Adapter
         *  - Retorna a quantidade de itens que o onBindViewHolder deve exibir na tela.
         * */

        /* Etapa 05.6: Finalmente configura o Adapter aqui no MainActivity
        *  - Deve ser o mesmo Adapter criado. */
        Adapter adapter = new Adapter(listaFilmes);



        //Etapa 06: Utiliza o Adapter criado em conjunto com o ViewHolder
        // para o passar como parâmetro e configurar o recyclerView
        recyclerView.setAdapter(adapter);

        //Etapa 07: Otimiza o RecyclerView de acordo com diretrizes do Google
        //Essa linha de código configura um tamanho fixo para o RecyclerView
        recyclerView.setHasFixedSize(true);

        //(EXTRA2)
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));

        //(EXTRA3)
        recyclerView.addOnItemTouchListener(
                // É utilizada uma classe, recomendada pelo próprio google para implementar o evento de click
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Toast Comum
                                //Toast.makeText(getApplicationContext(), "Item pressionado", Toast.LENGTH_SHORT).show();

                                //Toast que retorna nome do filme:
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(getApplicationContext(), "item clicado " + filme.getTituloFilme() ,Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Click longo", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )

                );

    }

    // Método
    public void criarFilmes(){
        // Instancia a classe filme com o construtor personalizado e completo
        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        //Adiciona ao final da lista do tipo filme, os dados do filme instanciado
        this.listaFilmes.add(filme);

        //Popula a lista com outros filmes
        filme = new Filme("Mulher maravilha", "Fantasia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da justiça", "Ficção", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Capitão América - Guerra civil", "Aventura/Ficção", "2016");
        this.listaFilmes.add(filme);

        filme = new Filme("IT: A coisa - Guerra civil", "Drama/Terror", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Pica-pau: O filme", "Comédia/Animação", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A múmia", "Terror", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Meu malvado favorito 3", "Comédia", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Carros 3", "Animação", "2017");
        this.listaFilmes.add(filme);

    }

}

/*
* Etapa 08 (EXTRA) Configurando uma lista fake de itens para exibição de dados diferentes no RecyclerView:
* - Devem ser modificados em onBindViewHolder os itens que estão fixos.
* - basta para isso passar em adapter uma lista de Arrays
* - Será usado a pasta model para guardar a classe que contém esas informações: Título, ano e gênero (Classe filme)
* - Cria um atributo do tipo List<> do tipo filme que foi criado em model
* - Insere antes do Adapter uma listagem para que seja passado ao Adapter e exibido na tela.
* - Cria um método fora de oncreate para popular a classe de filmes.
* - Chama o método criar filmes antes da configuração do adapter.
* - passa como parâmetro ao Adapter a lista de filmes.
* - Configurar o adapter para receber a lista criada. Para isso é criado um construtor com parâmetro do tipo filme.
* - passa como parâmetro list para o Adapter, configura o getItemCount como listaFilmes.size();
* - Reconfigura o onBindViewHolder para exibir os elementos da lista, passando para lista criada o position do método.
* */

/*
 * Etapa 09 (EXTRA2) Configurando uma lista fake de itens para exibição de dados diferentes no RecyclerView:
  * - Configurar uma linha entre os itens do RecyclerView
  * - Abaixo do último método em OnCreate insere um método de estilização do recyclerView
 * */

/*
 * Etapa 10 (EXTRA3) Adicionando eventos de click
 * - Em main Activity, após o método recyclerView.addItemDecoration será colocada a configuração para eventos de click
 * - É utilizada uma classe, recomendada pelo próprio Google para implementar o evento de click, copiada.
 * - É criada a classe dentro da pasta activity, não esquecer de incluir o package para que faça o link interno entre os arquivos.
 * - Ela que fará a implementação dos eventos de click.
 * - São usados apenas os dois primeiros métodos para tratar os eventos de click: onItemClick e onLongItemClick
 * - Ao usar um Toast, pode-se averiguar que o item foi clicado.
 * - No próximo passo, é incluido no toast curto o nome do item clicado usando position.
 * */