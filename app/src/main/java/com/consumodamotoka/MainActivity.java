package com.consumodamotoka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.consumodamotoka.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**Chamada para o método que cálcula as informações relevantes de consumo da Motoka*/
    public void calcularInformacao(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.litros_de_combustivel);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
