/*
* Tutorial para montagem de um listview
* Etapa 01: Configurar o elemento no XML para que seja resposível;
* Etapa 02: Definir um id para o compoenente;
* Etapa 03: Fazer a inclusão do listView na Activity;
* Etapa 04: Cria um array de strings para ser carregado no listView
* Etapa 05: Define e configura um adapter
* Etapa 06: Adicionar o adaptador na
* Etapa 07: Adicionar listener nos elementos da lista
* */

package com.example.a008_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //A: Declara o atributo
    private ListView listLocais;

    //B: Array do tipo strings com elementos já declarados dentro dele, delimitado por chaves
    private String[] itens =
            {
                    "Angra dos Reis", "Caldas Novas", "Campos do Jordão", "Costa do Sauípe",
                    "Ilhéus", "Porto Seguro", "Tiradentes", "Praga", "Santiago", "Zurique",
                    "Caribe", "Buenos Aires", "Budapeste", "Cancún", "Aruba"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //C: Faz o link com o elemento XML pelo id
        listLocais = findViewById(R.id.listLocais);

        //D: Configura um adaptador - para organizar os dados a serem exibidos
        // Esses dados podem ser de tipos diferentes

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                //Parametro 1 - contexto da aplicação;
                getApplicationContext(),

                //Parãmetro 2 - layout utilizado
                //Será utilizado um layout padrão criado pelo Android
                android.R.layout.simple_list_item_1,

                //Parãmetro 3 - Lugar em que será exibido os itens da lista
                android.R.id.text1,
                //Parâmetro 4 - itens a serem exibidos
                itens
        );

        //E: Usando o adaptador na lista
        listLocais.setAdapter(adaptador);

        //F: Adiciona click na lista
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String valorSelecionado = listLocais.getItemAtPosition(position).toString();

                Toast.makeText(getApplicationContext(), "Local: " + valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });


    }
}