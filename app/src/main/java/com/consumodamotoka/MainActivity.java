package com.consumodamotoka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String LITROS_DE_COMBUSTIVEL = "com.consumodamotoka.LITROS_DE_COMBUSTIVEL";
    public final static String PRECO_DO_LITRO_DE_COMBUSTIVEL = "com.consumodamotoka.PRECO_DO_LITRO_DE_COMBUSTIVEL";
    public final static String QUILOMETROS_RODADOS = "com.consumodamotoka.QUILOMETROS_RODADOS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**Chamada para o método que cálcula as informações relevantes de consumo da Motoka*/
    public void calcularInformacao(View view){
        /** criar nova Inteção de fazer algo: */
        Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
        /** aqui a gente cria uma variavel para o editText */
        EditText editText_litros_de_combustivel = (EditText)findViewById(R.id.litros_de_combustivel);
        /** recuperar o texto que está contido no editText */
        String litros_de_combustivel = editText_litros_de_combustivel.getText().toString();
        /** atribui a variavel que será passada pelo intent*/
        intent.putExtra(LITROS_DE_COMBUSTIVEL, litros_de_combustivel);
        /** repete o que fizemos para o litros, só que agora para o preço do combustível */
        EditText editText_preco_do_litro_de_combustivel = (EditText)findViewById(R.id.preco_do_litro_de_combustivel);
        String preco_do_litro_de_combustivel = editText_preco_do_litro_de_combustivel.getText().toString();
        intent.putExtra(PRECO_DO_LITRO_DE_COMBUSTIVEL,preco_do_litro_de_combustivel);
        /** repete o que fizemos para os quilometros rodados */
        EditText editText_quilometros_rodados = (EditText)findViewById(R.id.quilometros_rodados);
        String quilometros_rodados = editText_quilometros_rodados.getText().toString();
        intent.putExtra(QUILOMETROS_RODADOS,quilometros_rodados);
        /** inicializa a nova Activity passando tudo que foi colocado no intent */
        startActivity(intent);
    }
}
