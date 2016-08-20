package com.consumodamotoka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        /** recuperar as informações passada pela activity que chamou */
        Intent intent = getIntent();
        /** recuperar a informação de dentro da intent */
        String litros_de_combustivel = intent.getStringExtra(MainActivity.LITROS_DE_COMBUSTIVEL);
        String preco_do_litro_de_combustivel = intent.getStringExtra(MainActivity.PRECO_DO_LITRO_DE_COMBUSTIVEL);
        String quilometros_rodados = intent.getStringExtra(MainActivity.QUILOMETROS_RODADOS);
        /** aqui estamos gerando uma textView dinamicamente em tempo de execução, talvez o ideal seja criar no xml de layout */
        TextView dados_de_entrada = (TextView)findViewById(R.id.dados_de_entrada);
        dados_de_entrada.setText(String.format("Você colocou: %s litros" +
                                       "\nO preço do litro foi: R$ %s" +
                                       "\nE você rodou: %s " + " quilômetros",
                                       litros_de_combustivel,
                                       preco_do_litro_de_combustivel,
                                       quilometros_rodados));
        /** vou tentar gerar uma nova textView e adicionar ela com os resultados do calculo de KM/l, KM/dia, total a pagar */
        Float litros = Float.parseFloat(litros_de_combustivel);
        Float preco = Float.parseFloat(preco_do_litro_de_combustivel);
        Float quilometros = Float.parseFloat(quilometros_rodados);

        Float totalAPagar = litros * preco;
        Float quilometrosPorLitro = quilometros / litros;

        TextView resultados = (TextView)findViewById(R.id.resultados);
        /** resultados.setTextSize(26); */
        resultados.setText(String.format("O valor total a pagar é: R$%s" +
                                         "\nA quilometragem média por litro foi de: %s quilometros",
                                         totalAPagar,
                                         quilometrosPorLitro));

        /** layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(resultados); */

    }
}
