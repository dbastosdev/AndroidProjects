/*
* Tem a função de dividir uma mesma Activity em diversos fragmentos.
* Permite o reuso de código. Ajuda a criar interfaces dinâmicas.
* Podemos criar vários fragments dentro de uma mesma interface.
* Utiliza-se a estrutura FrameLayout para adicionar os fragments em seu interior.
*
* 0- Cria o layout com botões e o FrameLayout
* 1- Cria packges para armazenar activities e fragments dentro do diretório "java"
* 2- Cria os Fragments indenpendentes na pasta correspondente a partir do click do botão direito.
* 3- Configura os elementos do layout do Fragment dentro do Fragment.java: Views, id's e lógica do Fragment.
* 4- Insere os id's dos botões conversas e contatos - Layout MainActivity;
* 5- Cria os atributos dos botões e configura os id's no onCreate - MainActivity;
* 6- Configura chamada dos fragments - MainActivity;
* 7- Instancia os Fragments dentro de onCreate (necessário declarar o atributo também);
* 8- Configura um objeto para o fragmento;
* 9- Faz as configurações de 6 a 8 dentro dos botões.
*
* */

package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a009_fragments.R;

import fragments.ContatosFragment;
import fragments.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button conversas;
    private Button contatos;

    //Declaração atributos fragmentos
    private ConversasFragment conversasFragment; // Mesmo nome da classe Java do fragmento.
    private ContatosFragment contatosFragment;   // Mesmo nome da classe Java do fragmento.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remover sombra do elemento da ActionBar:
        getSupportActionBar().setElevation(2);

        conversas = findViewById(R.id.buttonConversas);
        contatos = findViewById(R.id.buttonContatos);

        // Instancia os fragmentos:
        conversasFragment = new ConversasFragment();
        contatosFragment = new ContatosFragment();


        // Chama os Fragmentos:

        conversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Configuração de um objeto para o fragmento:

                //Transaction - o begin indica que quer realizar uma transação.
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //Declaração do local em que será exibido o conteúdo e do conteúdo em si
                transaction.replace(R.id.frameConteudo, conversasFragment); // abre a transação
                transaction.commit(); //Encerra a transação. É possível fazer várias transações de fragmentos antes de encerrar.

            }
        });

        contatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Configuração de um objeto para o fragmento:

                //Transaction - o begin indica que quer realizar uma transação.
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //Declaração do local em que será exibido o conteúdo e do conteúdo em si
                transaction.replace(R.id.frameConteudo, contatosFragment); // abre a transação
                transaction.commit(); //Encerra a transação. É possível fazer várias transações de fragmentos antes de encerrar.

            }
        });



    }
}